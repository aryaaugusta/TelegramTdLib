package com.edts.tdlib.helper;

import com.edts.tdlib.TdApi;
import com.edts.tdlib.bean.contact.ChatRoomUploadBean;
import com.edts.tdlib.bean.contact.TelegramUserBean;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.model.contact.ChatRoom;
import com.edts.tdlib.model.contact.TelegramUser;
import com.edts.tdlib.repository.ChatRoomRepo;
import com.edts.tdlib.repository.TelegramUserRepo;
import com.edts.tdlib.util.CommonUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Component
public class ChatRoomExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"UserId"};
    static String SHEET = "BulkChatRoom";


    @Autowired
    private TelegramUserRepo telegramUserRepo;

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }


    public Map<String, Object> excelToObject(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<ChatRoomUploadBean> chatRoomBeansOk = new ArrayList<>();
            List<ChatRoomUploadBean> chatRoomBeansFail = new ArrayList<>();

            ChatRoomUploadBean chatRoomBeanOk = null;
            ChatRoomUploadBean chatRoomBeanFail = null;

            int rowNumber = 0;
            boolean isCheck = false;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Optional<TelegramUser> telegramUser = null;
                Iterator<Cell> cellsInRow = currentRow.iterator();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    if (cellIdx == 0) {
                        isCheck = CommonUtil.checkPhoneNumberFormatAndDigit(currentCell.getStringCellValue(), 0);

                        String tempPhoneNumber = currentCell.getStringCellValue();
                        String phone = tempPhoneNumber.substring(1, tempPhoneNumber.length());
                        if (tempPhoneNumber.startsWith("0")) {
                            phone = "62" + phone;
                        } else {
                            phone = tempPhoneNumber;
                        }
                        telegramUser = telegramUserRepo.findByPhoneNumber(phone);

                        if (telegramUser.isEmpty()) {
                            isCheck = false;
                        }

                        if (telegramUser.isPresent()) {
                            isCheck = true;
                        }

                        if (isCheck) {
                            chatRoomBeanOk = new ChatRoomUploadBean();
                        } else {
                            chatRoomBeanFail = new ChatRoomUploadBean();
                        }
                    }


                    if (isCheck) {
                        switch (cellIdx) {
                            case 0:
                                chatRoomBeanOk.setContactId((long) telegramUser.get().getUserTelegramId());
                                chatRoomBeanOk.setChatId(Long.parseLong(telegramUser.get().getChatId()));
                                chatRoomBeanOk.setPhoneNumber(telegramUser.get().getPhoneNumber());
                                chatRoomBeanOk.setUserType("User");
                                chatRoomBeanOk.setUsername(telegramUser.get().getUsername());
                                break;
                            case 1:
                                chatRoomBeanOk.setFirstName(currentCell.getStringCellValue());
                                break;
                            case 2:
                                chatRoomBeanOk.setLastName(currentCell.getStringCellValue());
                                break;
                            default:
                                break;
                        }

                    } else {

                        switch (cellIdx) {
                            case 0:
                                chatRoomBeanFail.setPhoneNumber(currentCell.getStringCellValue());
                                break;
                            case 1:
                                chatRoomBeanFail.setFirstName(currentCell.getStringCellValue());
                                break;
                            case 2:
                                chatRoomBeanFail.setLastName(currentCell.getStringCellValue());
                                break;
                            default:
                                break;
                        }

                    }
                    cellIdx++;
                }
                if (isCheck) {
                    chatRoomBeansOk.add(chatRoomBeanOk);
                } else {
                    chatRoomBeansFail.add(chatRoomBeanFail);
                }

            }

            Map<String, Object> bots = excelBotToObject(workbook);

            List<ChatRoomUploadBean> botsOk = (List<ChatRoomUploadBean>) bots.get("oks");
            chatRoomBeansOk.addAll(botsOk);
            List<ChatRoomUploadBean> botsFail = (List<ChatRoomUploadBean>) bots.get("fails");
            chatRoomBeansOk.addAll(botsFail);

            workbook.close();


            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("confirmData", chatRoomBeansOk.toArray());
            objectMap.put("confirmCount", chatRoomBeansOk.size());
            objectMap.put("failData", chatRoomBeansFail);
            objectMap.put("failCount", chatRoomBeansFail.size());


            return objectMap;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

    Map<String, Object> excelBotToObject(Workbook workbook) {
        Sheet sheet = workbook.getSheet(GeneralConstant.USER_TYPE_BOT);
        Iterator<Row> rows = sheet.iterator();

        List<ChatRoomUploadBean> chatRoomBeansOk = new ArrayList<>();
        List<ChatRoomUploadBean> chatRoomBeansFail = new ArrayList<>();

        ChatRoomUploadBean chatRoomBeanOk = null;
        ChatRoomUploadBean chatRoomBeanFail = null;

        int rowNumber = 0;
        boolean isCheck = false;
        while (rows.hasNext()) {
            Row currentRow = rows.next();

            // skip header
            if (rowNumber == 0) {
                rowNumber++;
                continue;
            }

            Optional<TelegramUser> telegramUser = null;
            Iterator<Cell> cellsInRow = currentRow.iterator();

            int cellIdx = 0;
            while (cellsInRow.hasNext()) {
                Cell currentCell = cellsInRow.next();

                if (cellIdx == 0) {

                    telegramUser = telegramUserRepo.findByUserTelegramId((int) currentCell.getNumericCellValue());

                    if (telegramUser.isEmpty()) {
                        isCheck = false;
                    }

                    if (telegramUser.isPresent()) {
                        isCheck = true;
                    }

                    if (isCheck) {
                        chatRoomBeanOk = new ChatRoomUploadBean();
                    } else {
                        chatRoomBeanFail = new ChatRoomUploadBean();
                    }
                }


                if (isCheck) {
                    switch (cellIdx) {
                        case 0:
                            chatRoomBeanOk.setContactId((long) telegramUser.get().getUserTelegramId());
                            chatRoomBeanOk.setChatId(Long.parseLong(telegramUser.get().getChatId()));
                            chatRoomBeanOk.setPhoneNumber(telegramUser.get().getPhoneNumber());
                            chatRoomBeanOk.setUserType(GeneralConstant.USER_TYPE_BOT);
                            chatRoomBeanOk.setUsername(telegramUser.get().getUsername());
                            break;
                        case 1:
                            chatRoomBeanOk.setFirstName(currentCell.getStringCellValue());
                            break;
                        case 2:
                            chatRoomBeanOk.setLastName(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }

                } else {

                    switch (cellIdx) {
                        case 0:
                            chatRoomBeanFail.setPhoneNumber(currentCell.getStringCellValue());
                            break;
                        case 1:
                            chatRoomBeanFail.setFirstName(currentCell.getStringCellValue());
                            break;
                        case 2:
                            chatRoomBeanFail.setLastName(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }

                }
                cellIdx++;
            }
            if (isCheck) {
                chatRoomBeansOk.add(chatRoomBeanOk);
            } else {
                chatRoomBeansFail.add(chatRoomBeanFail);
            }

        }
        Map<String, Object> result = new HashMap<>();
        result.put("oks", chatRoomBeansOk);
        result.put("fails", chatRoomBeansFail);

        return result;

    }

    public List<Integer> excelToObjectForSave(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<Integer> chatRoomBeansOk = new ArrayList<>();
            List<ChatRoomUploadBean> chatRoomBeansFail = new ArrayList<>();

            Integer chatRoomBeanOk = null;
            ChatRoomUploadBean chatRoomBeanFail = null;

            int rowNumber = 0;
            boolean isCheck = false;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Optional<TelegramUser> telegramUser = null;
                Iterator<Cell> cellsInRow = currentRow.iterator();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    if (cellIdx == 0) {
                        isCheck = CommonUtil.checkPhoneNumberFormatAndDigit(currentCell.getStringCellValue(), 0);

                        String tempPhoneNumber = currentCell.getStringCellValue();
                        String phone = tempPhoneNumber.substring(1, tempPhoneNumber.length());
                        if (tempPhoneNumber.startsWith("0")) {
                            phone = "62" + phone;
                        } else {
                            phone = tempPhoneNumber;
                        }
                        telegramUser = telegramUserRepo.findByPhoneNumber(phone);

                        if (telegramUser.isEmpty()) {
                            isCheck = false;
                        }

                        if (telegramUser.isPresent()) {
                            isCheck = true;
                        }

                        if (!isCheck) {
                            chatRoomBeanFail = new ChatRoomUploadBean();
                        }
                    }


                    if (isCheck) {
                        switch (cellIdx) {
                            case 0:
                                chatRoomBeanOk = telegramUser.get().getUserTelegramId();
                                break;
                            default:
                                break;
                        }

                    }
                    cellIdx++;
                }
                if (isCheck) {
                    chatRoomBeansOk.add(chatRoomBeanOk);
                } else {
                    chatRoomBeansFail.add(chatRoomBeanFail);
                }

            }

            List<Integer> bots = excelBotToObjectForSave(workbook);
            chatRoomBeansOk.addAll(bots);

            workbook.close();


            return chatRoomBeansOk;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

    private List<Integer> excelBotToObjectForSave(Workbook workbook) {

        Sheet sheet = workbook.getSheet(GeneralConstant.USER_TYPE_BOT);
        Iterator<Row> rows = sheet.iterator();

        List<Integer> chatRoomBeansOk = new ArrayList<>();
        List<ChatRoomUploadBean> chatRoomBeansFail = new ArrayList<>();

        Integer chatRoomBeanOk = null;
        ChatRoomUploadBean chatRoomBeanFail = null;

        int rowNumber = 0;
        boolean isCheck = false;
        while (rows.hasNext()) {
            Row currentRow = rows.next();

            // skip header
            if (rowNumber == 0) {
                rowNumber++;
                continue;
            }

            Optional<TelegramUser> telegramUser = null;
            Iterator<Cell> cellsInRow = currentRow.iterator();

            int cellIdx = 0;
            while (cellsInRow.hasNext()) {
                Cell currentCell = cellsInRow.next();

                if (cellIdx == 0) {
/*
                    isCheck = CommonUtil.checkPhoneNumberFormatAndDigit(currentCell.getStringCellValue(), 0);

                    String tempPhoneNumber = currentCell.getStringCellValue();
                    String phone = tempPhoneNumber.substring(1, tempPhoneNumber.length());
                    if (tempPhoneNumber.startsWith("0")) {
                        phone = "62" + phone;
                    } else {
                        phone = tempPhoneNumber;
                    }
*/
                    telegramUser = telegramUserRepo.findByUserTelegramId((int) currentCell.getNumericCellValue());

                    if (telegramUser.isEmpty()) {
                        isCheck = false;
                    }

                    if (telegramUser.isPresent()) {
                        isCheck = true;
                    }

                    if (!isCheck) {
                        chatRoomBeanFail = new ChatRoomUploadBean();
                    }
                }


                if (isCheck) {
                    switch (cellIdx) {
                        case 0:
                            chatRoomBeanOk = telegramUser.get().getUserTelegramId();
                            break;
                        default:
                            break;
                    }

                }
                cellIdx++;
            }
            if (isCheck) {
                chatRoomBeansOk.add(chatRoomBeanOk);
            } else {
                chatRoomBeansFail.add(chatRoomBeanFail);
            }

        }
        return chatRoomBeansOk;
    }


    public static ByteArrayInputStream chatroomsToExcel(List<ChatRoom> chatRoomList) {
        String[] HEADERS_DOWNLOAD = {"Chatroom Id", "Chatroom Name", "User"};
        String SHEET_DOWNLOAD = "Chatroom";


        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {
            Sheet sheet = workbook.createSheet(SHEET_DOWNLOAD);


            // Header
            /*CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);*/

            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERS_DOWNLOAD.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERS_DOWNLOAD[col]);
                //cell.setCellStyle(style);
            }


            int rowIdx = 1;
            for (ChatRoom chatRoom : chatRoomList) {
                Row row = sheet.createRow(rowIdx++);


                row.createCell(0).setCellValue(chatRoom.getChatId());
                row.createCell(1).setCellValue(chatRoom.getName());
                row.createCell(2).setCellValue(chatRoom.getCountMember());

            }

            /*for (int col = 0; col < HEADERS_DOWNLOAD.length; col++) {
                sheet.autoSizeColumn(col);
            }*/

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }

    }

}
