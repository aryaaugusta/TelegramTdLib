package com.edts.tdlib.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.edts.tdlib.Client;
import com.edts.tdlib.TdApi;
import com.edts.tdlib.bean.CDNFileBean;
import com.edts.tdlib.bean.TelegramMessageBean;
import com.edts.tdlib.bean.contact.TelegramUserBean;
import com.edts.tdlib.bean.message.MessageFileBean;
import com.edts.tdlib.constant.CDNConstant;
import com.edts.tdlib.constant.ImageTypeConstant;
import com.edts.tdlib.engine.GlobalVariable;
import com.edts.tdlib.engine.MainTelegram;
import com.edts.tdlib.engine.handler.UpdatesHandler;
import com.edts.tdlib.mapper.ImageMapper;
import com.edts.tdlib.mapper.MessageFileMapper;
import com.edts.tdlib.model.message.MessageFile;
import com.edts.tdlib.repository.MessageFileRepo;
import com.edts.tdlib.util.FileUtil;
import com.edts.tdlib.util.GeneralUtil;
import com.edts.tdlib.util.SecurityUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MessageService {

    private final Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${temp.file.message}")
    private String tempFileMessage;

    @Value("${services.aws.s3.public.bucket-name}")
    private String imageBucket;

    @Value("${services.aws.s3.public.region}")
    private String region;
    private final AmazonS3 amazonS3;
    private final ImageMapper imageMapper;
    private final MessageFileMapper messageFileMapper;
    private final MessageFileRepo messageFileRepo;

    public static Client client;
    public static MainTelegram mainTelegram;
    public static final String newLine = System.getProperty("line.separator");
    public static TdApi.AuthorizationState authorizationState;

    public MessageService(AmazonS3 amazonS3, ImageMapper imageMapper, MessageFileRepo messageFileRepo, MessageFileMapper messageFileMapper) {
        this.amazonS3 = amazonS3;
        this.imageMapper = imageMapper;
        this.messageFileRepo = messageFileRepo;
        this.messageFileMapper = messageFileMapper;
    }

    public void sendText(TelegramMessageBean telegramMessageBean) {
        TdApi.InlineKeyboardButton[] row = {new TdApi.InlineKeyboardButton("https://telegram.org?1", new TdApi.InlineKeyboardButtonTypeUrl()), new TdApi.InlineKeyboardButton("https://telegram.org?2", new TdApi.InlineKeyboardButtonTypeUrl()), new TdApi.InlineKeyboardButton("https://telegram.org?3", new TdApi.InlineKeyboardButtonTypeUrl())};
        TdApi.ReplyMarkup replyMarkup = new TdApi.ReplyMarkupInlineKeyboard(new TdApi.InlineKeyboardButton[][]{row, row, row});

        //GlobalVariable.mainTelegram.client.send(new TdApi.CreatePrivateChat((int) telegramMessageBean.getChatId(), true), new UpdatesHandler());

        TdApi.InputMessageContent content = new TdApi.InputMessageText(new TdApi.FormattedText(telegramMessageBean.getMessage(), null), false, true);
        mainTelegram.client.send(new TdApi.SendMessage(telegramMessageBean.getChatId(), 0, null, replyMarkup, content), mainTelegram.defaultHandler);
    }

    public void sendTelegram(TelegramMessageBean telegramMessageBean) {
        TdApi.InlineKeyboardButton[] row = {new TdApi.InlineKeyboardButton("https://telegram.org?1", new TdApi.InlineKeyboardButtonTypeUrl()), new TdApi.InlineKeyboardButton("https://telegram.org?2", new TdApi.InlineKeyboardButtonTypeUrl()), new TdApi.InlineKeyboardButton("https://telegram.org?3", new TdApi.InlineKeyboardButtonTypeUrl())};
        TdApi.ReplyMarkup replyMarkup = new TdApi.ReplyMarkupInlineKeyboard(new TdApi.InlineKeyboardButton[][]{row, row, row});

        int fileType = 0;
        TdApi.InputFile fileloc = null;
        String localPath = null;
        if (telegramMessageBean.getKeyName() != null) {
            String fileTypeStr = FileUtil.getExtensionByStringHandling(telegramMessageBean.getKeyName()).get();

            localPath = downloadFile(telegramMessageBean.getKeyName());
            if (fileTypeStr.equals("JPG") || fileTypeStr.equals("jpg") || fileTypeStr.equals("JPEG") || fileTypeStr.equals("jpeg") || fileTypeStr.equals("PNG") || fileTypeStr.equals("png")) {
                fileType = 2;
            } else if (fileTypeStr.equals("xlsx") || fileTypeStr.equals("docx") || fileTypeStr.equals("pdf") || fileTypeStr.equals("pptx")) {
                fileType = 1;
            }

        }

        TdApi.InputMessageContent content = null;
        switch (fileType) {
            case 0:
                boolean isBold = telegramMessageBean.getMessage().contains("**");
                boolean isItalic = telegramMessageBean.getMessage().contains("_");


                if (isBold && isItalic) {
                    try {
                        TdApi.TextEntity[] textEntitiesBold = generateTextEntityBold(telegramMessageBean.getMessage().replaceAll("_", ""));
                        TdApi.TextEntity[] textEntitiesItalic = generateTextEntityItalic(telegramMessageBean.getMessage().replaceAll("\\*", ""));

                        TdApi.TextEntity[] textEntities = new TdApi.TextEntity[textEntitiesBold.length + textEntitiesItalic.length];

                        AtomicInteger lei = new AtomicInteger();
                        Arrays.stream(textEntitiesItalic).forEach(b -> {
                            textEntities[lei.get()] = b;
                            lei.getAndIncrement();
                        });

                        AtomicInteger leb = new AtomicInteger(textEntitiesItalic.length);
                        Arrays.stream(textEntitiesBold).forEach(b -> {
                            textEntities[leb.get()] = b;
                            leb.getAndIncrement();
                        });


                        String msg = telegramMessageBean.getMessage().replaceAll("\\*", "");
                        msg = msg.replaceAll("_", "");


                        content = new TdApi.InputMessageText(new TdApi.FormattedText(msg, textEntities), false, true);
                    } catch (Exception e) {
                        content = new TdApi.InputMessageText(new TdApi.FormattedText(telegramMessageBean.getMessage(), null), false, true);
                    }

                } else if (isBold) {
                    try {
                        TdApi.TextEntity[] textEntities = generateTextEntityBold(telegramMessageBean.getMessage().replaceAll("_", ""));

                        String msg = telegramMessageBean.getMessage().replaceAll("\\*", "");
                        msg = msg.replaceAll("_", "");


                        content = new TdApi.InputMessageText(new TdApi.FormattedText(msg, textEntities), false, true);
                    } catch (Exception e) {
                        content = new TdApi.InputMessageText(new TdApi.FormattedText(telegramMessageBean.getMessage(), null), false, true);
                    }
                } else if (isItalic) {
                    try {
                        TdApi.TextEntity[] textEntities = generateTextEntityItalic(telegramMessageBean.getMessage().replaceAll("\\*", ""));

                        String msg = telegramMessageBean.getMessage().replaceAll("\\*", "");
                        msg = msg.replaceAll("_", "");


                        content = new TdApi.InputMessageText(new TdApi.FormattedText(msg, textEntities), false, true);
                    } catch (Exception e) {
                        content = new TdApi.InputMessageText(new TdApi.FormattedText(telegramMessageBean.getMessage(), null), false, true);
                    }
                } else {
                    content = new TdApi.InputMessageText(new TdApi.FormattedText(telegramMessageBean.getMessage(), null), false, true);
                }

                break;
            case 1:
                fileloc = new TdApi.InputFileLocal(localPath);
                content = new TdApi.InputMessageDocument(fileloc, null, new TdApi.FormattedText(telegramMessageBean.getMessage(), null));
                break;
            case 2:
                fileloc = new TdApi.InputFileLocal(localPath);
                content = new TdApi.InputMessagePhoto(fileloc, null, null, 100, 100, new TdApi.FormattedText(telegramMessageBean.getMessage(), null), 0);
                break;
            default:
                break;
        }

        mainTelegram.client.send(new TdApi.SendMessage(telegramMessageBean.getChatId(), 0, null, replyMarkup, content), new UpdatesHandler());
    }


    public MessageFileBean uploadMessageFile(MultipartFile file, String fileType) throws IOException {
        String fileName = "";
        byte fileData[] = file.getBytes();
        String folderName = "";
        if (fileType.equals(ImageTypeConstant.GIF) || fileType.equals(ImageTypeConstant.JPEG) || fileType.equals(ImageTypeConstant.PNG)) {
            folderName = CDNConstant.MESSAGE_IMAGE;
            fileName = FileUtil.generateImageFileName(fileType);
        } else {
            String fileExt = FileUtil.getExtensionByStringHandling(file.getOriginalFilename()).orElseThrow();
            folderName = CDNConstant.MESSAGE_DOCUMENT;
            fileName = FileUtil.generateDocumentFileName(fileExt);
        }

        CDNFileBean cdnFileBean = uploadToS3(folderName, fileName, fileData);

        MessageFile messageFile = messageFileRepo.save(messageFileMapper.toMessageFile(SecurityUtil.getEmail().orElseThrow(), cdnFileBean.getFileId(), cdnFileBean.getUrl()));

        return messageFileMapper.toBean(messageFile);
    }

    public String downloadFile(final String keyName) {
        byte[] content = null;
        logger.info("Downloading an object with key= " + keyName);
        final S3Object s3Object = amazonS3.getObject(new GetObjectRequest(imageBucket, keyName));
        final S3ObjectInputStream stream = s3Object.getObjectContent();
        String path = "";
        try {
            content = IOUtils.toByteArray(stream);
            logger.info("File downloaded successfully.");
            path = tempFileMessage + keyName.split("/")[1].toString();
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(content);
            fileOutputStream.close();
            s3Object.close();
        } catch (final IOException ex) {
            logger.info("IO Error Message= " + ex.getMessage());
        }
        return path;
    }


    public void deleteFile(String path) {
        try {
            Path fileToDeletePath = Paths.get(path);
            Files.delete(fileToDeletePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * ================= PRIVATE
     */

    private TdApi.TextEntity[] generateTextEntityItalic(String content) {
        List<Integer> integerList = new ArrayList<>();
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicInteger h = new AtomicInteger();

        AtomicInteger a = new AtomicInteger();

        List<Map<Integer, Integer>> maps = new ArrayList<>();


        content.codePoints().mapToObj(Character::toString).forEach(k -> {
            atomicInteger.getAndIncrement();
            if (k.equals("_")) {
                a.getAndIncrement();
                int ll = a.get() % 2;

                h.getAndIncrement();
                if (h.get() == 2) {
                    int s = atomicInteger.get() - 2;

                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(s, a.get() - 2);
                    maps.add(map);

                    integerList.add(s);
                    h.set(0);
                }

            }
        });

        AtomicInteger g = new AtomicInteger();
        AtomicInteger oo = new AtomicInteger(0);

        StringBuilder stringBuilder = new StringBuilder();

        AtomicInteger end = new AtomicInteger();
        integerList.forEach(s -> {
            end.getAndIncrement();
            g.getAndIncrement();
            int ll = g.get() % 2;
            if (ll != 0) {

                Map<Integer, Integer> map = maps.get(end.get() - 1);
                int dec = map.get(s);

                stringBuilder.append(s - dec + ",");
                oo.getAndSet(s + 2);
            }
            if (ll == 0) {
                int u = s - oo.get();
                stringBuilder.append(u);
                if (end.get() < integerList.size()) {
                    stringBuilder.append("#");
                }
            }
        });


        String toEntities[] = stringBuilder.toString().split("#");
        TdApi.TextEntity[] textEntities = new TdApi.TextEntity[toEntities.length];

        int num = 0;
        for (String item : toEntities) {

            String offsetLength[] = item.split(",");
            TdApi.TextEntityType textEntityTypeItalic = new TdApi.TextEntityTypeItalic();
            TdApi.TextEntity textEntity = new TdApi.TextEntity(Integer.parseInt(offsetLength[0]), Integer.parseInt(offsetLength[1]), textEntityTypeItalic);
            textEntities[num] = textEntity;
            num++;
        }

        return textEntities;
    }


    private TdApi.TextEntity[] generateTextEntityBold(String content) {
        List<Integer> integerList = new ArrayList<>();
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicInteger h = new AtomicInteger();

        AtomicInteger a = new AtomicInteger();

        List<Map<Integer, Integer>> maps = new ArrayList<>();


        content.codePoints().mapToObj(Character::toString).forEach(k -> {
            atomicInteger.getAndIncrement();
            if (k.equals("*")) {
                a.getAndIncrement();
                int ll = a.get() % 2;

                h.getAndIncrement();
                if (h.get() == 2) {
                    int s = atomicInteger.get() - 2;

                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(s, a.get() - 2);
                    maps.add(map);

                    integerList.add(s);
                    h.set(0);
                }

            }
        });

        AtomicInteger g = new AtomicInteger();
        AtomicInteger oo = new AtomicInteger(0);

        StringBuilder stringBuilder = new StringBuilder();

        AtomicInteger end = new AtomicInteger();
        integerList.forEach(s -> {
            end.getAndIncrement();
            g.getAndIncrement();
            int ll = g.get() % 2;
            if (ll != 0) {

                Map<Integer, Integer> map = maps.get(end.get() - 1);
                int dec = map.get(s);

                stringBuilder.append(s - dec + ",");
                oo.getAndSet(s + 2);
            }
            if (ll == 0) {
                int u = s - oo.get();
                stringBuilder.append(u);
                if (end.get() < integerList.size()) {
                    stringBuilder.append("#");
                }
            }
        });


        String toEntities[] = stringBuilder.toString().split("#");
        TdApi.TextEntity[] textEntities = new TdApi.TextEntity[toEntities.length];

        int num = 0;
        for (String item : toEntities) {

            String offsetLength[] = item.split(",");
            TdApi.TextEntityType textEntityTypeBold = new TdApi.TextEntityTypeBold();
            TdApi.TextEntity textEntity = new TdApi.TextEntity(Integer.parseInt(offsetLength[0]), Integer.parseInt(offsetLength[1]), textEntityTypeBold);
            textEntities[num] = textEntity;
            num++;
        }

        return textEntities;
    }


    /**
     * Upload image data to S3.
     *
     * @param folder   folder name
     * @param fileName file name
     * @return CDN file data
     */
    private CDNFileBean uploadToS3(String folder, String fileName, byte[] data) {
        try {
            String key = String.format("%s/%s", folder, fileName);
            String url = String.format("https://%s.s3.%s.amazonaws.com/%s", imageBucket, region, key);

            logger.info("URL ::: " + url);

            File file = new File(fileName);
            FileCopyUtils.copy(data, file);
            amazonS3.putObject(imageBucket, key, file);
            file.delete();

            return imageMapper.toCDNFileBEAN(key, url);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload to S3" + e.getMessage(), e);
        }
    }


}
