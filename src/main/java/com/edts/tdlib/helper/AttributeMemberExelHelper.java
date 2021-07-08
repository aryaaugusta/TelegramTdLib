package com.edts.tdlib.helper;

import com.edts.tdlib.bean.contact.ChatroomAttributeBulkBean;
import com.edts.tdlib.bean.contact.UserAttributeBulkBean;
import com.edts.tdlib.constant.GeneralConstant;
import com.edts.tdlib.model.contact.ChatRoom;
import com.edts.tdlib.model.contact.MemberAttribute;
import com.edts.tdlib.model.contact.TelegramUser;
import com.edts.tdlib.repository.ChatRoomRepo;
import com.edts.tdlib.repository.TelegramUserRepo;
import com.edts.tdlib.util.CommonUtil;
import com.edts.tdlib.util.GeneralUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.*;

@Component
public class AttributeMemberExelHelper {


    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"Phone", "FirstName", "LastName", "Attribute"};
    static String SHEET_USER = "BulkAttributeUserMember";
    static String SHEET_CHATROOM = "BulkAttributeChatroomMember";
    static String dataTypeNotEquals = "Tipe Data tidak sama antara file dan aplikasi";


    private final TelegramUserRepo telegramUserRepo;
    private final ChatRoomRepo chatRoomRepo;

    public AttributeMemberExelHelper(TelegramUserRepo telegramUserRepo, ChatRoomRepo chatRoomRepo) {
        this.telegramUserRepo = telegramUserRepo;
        this.chatRoomRepo = chatRoomRepo;
    }


    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }


    public Map<String, Object> excelToObject(InputStream is, String dataType) {
        Map<String, Object> objUser = excelUserToObject(is, dataType);
        Map<String, Object> objChatroom = excelChatroomMemberToObject((Workbook) objUser.get("woorkbook"), dataType);
        Map<String, Object> objectMap = new HashMap<>();

        int ccUser = (int) objUser.get("confirmCount");
        int ccChatroom = (int) objChatroom.get("confirmCount");

        int fcUser = (int) objUser.get("failCount");
        int fcChatroom = (int) objChatroom.get("failCount");


        objectMap.put("confirmUserData", objUser.get("confirmData"));
        objectMap.put("confirmChatroomData", objChatroom.get("confirmData"));
        objectMap.put("confirmCount", ccUser + ccChatroom);
        objectMap.put("failUserData", objUser.get("failData"));
        objectMap.put("failChatroomData", objChatroom.get("failData"));
        objectMap.put("failCount", fcUser + fcChatroom);
        return objectMap;

    }

    public Map<String, Object> excelChatroomMemberToObject(Workbook workbook, String dataTypeParam) {

        try {
            Sheet sheet = workbook.getSheet(SHEET_CHATROOM);
            Iterator<Row> rows = sheet.iterator();

            List<ChatroomAttributeBulkBean> attributesOk = new ArrayList<>();
            List<ChatroomAttributeBulkBean> attributesFail = new ArrayList<>();

            ChatroomAttributeBulkBean attributeOk = null;
            ChatroomAttributeBulkBean attributeFail = null;

            int rowNumber = 0;
            boolean isCheck = false;

            String dataType = null;

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 1) {
                    rowNumber++;
                    continue;
                }

                // get data type
                if (rowNumber == 0) {
                    Iterator<Cell> cellsInRowDDataType = currentRow.iterator();
                    int cellIdxD = 0;
                    while (cellsInRowDDataType.hasNext()) {
                        Cell currentCellDT = cellsInRowDDataType.next();
                        if (cellIdxD == 0) {
                            cellIdxD++;
                            continue;
                        }

                        if (cellIdxD == 1) {
                            dataType = currentCellDT.getStringCellValue();
                        }
                    }
                    rowNumber++;
                    continue;
                }

                if (dataType.equals(dataTypeParam)) {
                    //process data member
                    if (rowNumber > 1) {
                        Optional<ChatRoom> chatRoom = null;
                        Iterator<Cell> cellsInRow = currentRow.iterator();

                        int cellIdx = 0;
                        while (cellsInRow.hasNext()) {
                            Cell currentCell = cellsInRow.next();

                            if (cellIdx == 0) {
                                long chatId = (long) currentCell.getNumericCellValue();

                                chatRoom = chatRoomRepo.findByChatId(chatId);

                                if (chatRoom.isEmpty()) {
                                    isCheck = false;
                                }

                                if (chatRoom.isPresent()) {
                                    isCheck = true;
                                }

                                if (isCheck) {
                                    attributeOk = new ChatroomAttributeBulkBean();
                                } else {
                                    attributeFail = new ChatroomAttributeBulkBean();
                                }
                            }


                            if (isCheck) {
                                switch (cellIdx) {
                                    case 0:
                                        attributeOk.setContactId(chatRoom.get().getGroupId());
                                        attributeOk.setChatId((long) currentCell.getNumericCellValue());
                                        break;

                                    case 1:
                                        attributeOk.setName(currentCell.getStringCellValue() == null ? "" : currentCell.getStringCellValue());
                                        break;


                                    case 2:
                                        String attributeValue = null;
                                        CellType cellType = currentCell.getCellType();
                                        String manCellType = cellType.name().equals("NUMERIC") ? "DATE" : "STRING";
                                        if (dataType.toUpperCase(Locale.ROOT).equals(manCellType)) {
                                            if (dataType.equals("Date")) {
                                                try {
                                                    attributeValue = GeneralUtil.dateToStr(currentCell.getDateCellValue(), "yyyy-MM-dd");
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                            } else {
                                                attributeValue = currentCell.getStringCellValue();
                                            }
                                        } else {
                                            isCheck = false;
                                            attributeFail = new ChatroomAttributeBulkBean();
                                        }


                                        if (isCheck) {
                                            attributeOk.setAttributeValue(attributeValue);
                                        }
                                        break;


                                    default:
                                        break;
                                }

                            } else {

                                switch (cellIdx) {
                                    case 0:
                                        attributeFail.setChatId((long) currentCell.getNumericCellValue());
                                        break;

                                    case 1:
                                        attributeFail.setName(currentCell.getStringCellValue() == null ? "" : currentCell.getStringCellValue());
                                        break;


                                    default:
                                        break;
                                }

                            }
                            cellIdx++;
                        }
                    }

                    if (isCheck) {
                        attributesOk.add(attributeOk);
                    } else {
                        attributesFail.add(attributeFail);
                    }
                } else {
                    throw new RuntimeException(dataTypeNotEquals);
                }


            }
            workbook.close();

            List<Map<String, Object>> mapList = new ArrayList<>();
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("confirmData", attributesOk);
            objectMap.put("confirmCount", attributesOk.size());
            objectMap.put("failData", attributesFail);
            objectMap.put("failCount", attributesFail.size());


            mapList.add(objectMap);
            return objectMap;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }


    }

    public Map<String, Object> excelUserToObject(InputStream is, String dataTypeParam) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET_USER);
            Iterator<Row> rows = sheet.iterator();

            List<UserAttributeBulkBean> attributesOk = new ArrayList<>();
            List<UserAttributeBulkBean> attributesFail = new ArrayList<>();

            UserAttributeBulkBean attributeOk = null;
            UserAttributeBulkBean attributeFail = null;

            int rowNumber = 0;
            boolean isCheck = false;

            String dataType = null;

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                String name = "";

                // skip header
                if (rowNumber == 0 || rowNumber == 1 || rowNumber == 3) {
                    rowNumber++;
                    continue;
                }


                // get data type
                if (rowNumber == 2) {
                    Iterator<Cell> cellsInRowDDataType = currentRow.iterator();
                    int cellIdxD = 0;
                    while (cellsInRowDDataType.hasNext()) {
                        Cell currentCellDT = cellsInRowDDataType.next();
                        if (cellIdxD == 0) {
                            cellIdxD++;
                            continue;
                        }

                        if (cellIdxD == 1) {
                            dataType = currentCellDT.getStringCellValue();
                        }
                    }
                    rowNumber++;
                    continue;
                }

                if (dataType.equals(dataTypeParam)) {
                    //process data member
                    if (rowNumber > 3) {
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
                                    attributeOk = new UserAttributeBulkBean();
                                } else {
                                    attributeFail = new UserAttributeBulkBean();
                                }
                            }


                            if (isCheck) {
                                switch (cellIdx) {
                                    case 0:
                                        attributeOk.setContactId((long) telegramUser.get().getUserTelegramId());
                                        attributeOk.setChatId((long) telegramUser.get().getUserTelegramId());
                                        attributeOk.setPhoneNumber(currentCell.getStringCellValue());
                                        break;

                                    case 1:
                                        name = currentCell.getStringCellValue() == null ? "" : currentCell.getStringCellValue();
                                        break;

                                    case 2:
                                        String fullName = name.concat(currentCell.getStringCellValue().equals("-") ? "" : currentCell.getStringCellValue());
                                        attributeOk.setName(fullName);
                                        break;

                                    case 3:
                                        String attributeValue = null;
                                        CellType cellType = currentCell.getCellType();
                                        String manCellType = cellType.name().equals("NUMERIC") ? "DATE" : "STRING";
                                        if (dataType.toUpperCase(Locale.ROOT).equals(manCellType)) {
                                            if (dataType.equals("Date")) {
                                                try {
                                                    attributeValue = GeneralUtil.dateToStr(currentCell.getDateCellValue(), "yyyy-MM-dd");
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                            } else {
                                                attributeValue = currentCell.getStringCellValue();
                                            }
                                        } else {
                                            isCheck = false;
                                            attributeFail = new UserAttributeBulkBean();
                                        }


                                        if (isCheck) {
                                            attributeOk.setAttributeValue(attributeValue);
                                        }

                                        break;


                                    default:
                                        break;
                                }

                            }


                            if (!isCheck) {

                                if (telegramUser.isEmpty()) {
                                    switch (cellIdx) {
                                        case 0:
                                            attributeFail.setPhoneNumber(currentCell.getStringCellValue());
                                            break;


                                        case 1:
                                            name = currentCell.getStringCellValue() == null ? "" : currentCell.getStringCellValue();

                                            break;

                                        case 2:
                                            String fullName = name.concat(currentCell.getStringCellValue().equals("-") ? "" : currentCell.getStringCellValue());
                                            attributeFail.setName(fullName);
                                            break;


                                        default:
                                            break;
                                    }
                                } else {
                                    attributeFail.setContactId(attributeOk.getContactId());
                                    attributeFail.setChatId(attributeOk.getChatId());
                                    attributeFail.setPhoneNumber(attributeOk.getPhoneNumber());
                                    attributeFail.setName(attributeOk.getName());
                                }


                            }
                            cellIdx++;
                        }
                    }


                    if (isCheck) {
                        attributesOk.add(attributeOk);
                    } else {
                        attributesFail.add(attributeFail);
                    }
                } else {
                    throw new RuntimeException("Tipe Data tidak sama antara file dan aplikasi");
                }


            }


            //workbook.close();

            List<Map<String, Object>> mapList = new ArrayList<>();
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("confirmData", attributesOk);
            objectMap.put("confirmCount", attributesOk.size());
            objectMap.put("failData", attributesFail);
            objectMap.put("failCount", attributesFail.size());
            objectMap.put("woorkbook", workbook);


            mapList.add(objectMap);

            return objectMap;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }


    public List<MemberAttribute> excelChatroomToObjectForSave(Workbook workbook, String dataTypeParam) {
        Sheet sheet = workbook.getSheet(SHEET_CHATROOM);
        Iterator<Row> rows = sheet.iterator();

        List<MemberAttribute> attributesOk = new ArrayList<>();
        List<UserAttributeBulkBean> attributesFail = new ArrayList<>();

        MemberAttribute attributeOk = null;

        int rowNumber = 0;
        boolean isCheck = false;

        String dataType = null;

        while (rows.hasNext()) {
            Row currentRow = rows.next();

            // skip header
            if (rowNumber == 1) {
                rowNumber++;
                continue;
            }

            // get data type
            if (rowNumber == 0) {
                Iterator<Cell> cellsInRowDDataType = currentRow.iterator();
                int cellIdxD = 0;
                while (cellsInRowDDataType.hasNext()) {
                    Cell currentCellDT = cellsInRowDDataType.next();
                    if (cellIdxD == 0) {
                        cellIdxD++;
                        continue;
                    }

                    if (cellIdxD == 1) {
                        dataType = currentCellDT.getStringCellValue();
                    }
                }
                rowNumber++;
                continue;
            }

            if (dataType.equals(dataTypeParam)) {
                //process data member
                if (rowNumber > 1) {
                    Optional<ChatRoom> chatRoom = null;
                    Iterator<Cell> cellsInRow = currentRow.iterator();

                    int cellIdx = 0;
                    while (cellsInRow.hasNext()) {
                        Cell currentCell = cellsInRow.next();

                        if (cellIdx == 0) {
                            long chatId = (long) currentCell.getNumericCellValue();
                            chatRoom = chatRoomRepo.findByChatId(chatId);

                            if (chatRoom.isEmpty()) {
                                isCheck = false;
                            }

                            if (chatRoom.isPresent()) {
                                isCheck = true;
                            }

                            if (isCheck) {
                                attributeOk = new MemberAttribute();
                            }
                        }


                        if (isCheck) {
                            switch (cellIdx) {
                                case 0:
                                    attributeOk.setIdRefContact(chatRoom.get().getId());
                                    attributeOk.setContactType(GeneralConstant.ATTRIBUTE_CONTACT_TYPE_CHATROOM);
                                    break;

                                case 1:
                                    break;


                                case 2:
                                    String attributeValue = null;
                                    CellType cellType = currentCell.getCellType();
                                    String manCellType = cellType.name().equals("NUMERIC") ? "DATE" : "STRING";
                                    if (dataType.toUpperCase(Locale.ROOT).equals(manCellType)) {
                                        if (dataType.equals("Date")) {
                                            try {
                                                attributeValue = GeneralUtil.dateToStr(currentCell.getDateCellValue(), "dd-MM-yyyy");
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                            }
                                        } else {
                                            attributeValue = currentCell.getStringCellValue();
                                        }
                                    } else {
                                        isCheck = false;
                                    }


                                    if (isCheck) {
                                        attributeOk.setAttributeValue(attributeValue);
                                    }
                                    break;


                                default:
                                    break;
                            }

                        }
                        cellIdx++;
                    }
                }
            } else {
                throw new RuntimeException(dataTypeNotEquals);
            }


            if (isCheck) {
                attributesOk.add(attributeOk);
            }

        }
        return attributesOk;
    }

    public List<MemberAttribute> excelToObjectForSave(InputStream is, String dataTypeParam) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET_USER);
            Iterator<Row> rows = sheet.iterator();

            List<MemberAttribute> attributesOk = new ArrayList<>();
            List<UserAttributeBulkBean> attributesFail = new ArrayList<>();

            MemberAttribute attributeOk = null;

            int rowNumber = 0;
            boolean isCheck = false;

            String dataType = null;

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0 || rowNumber == 1 || rowNumber == 3) {
                    rowNumber++;
                    continue;
                }


                // get data type
                if (rowNumber == 2) {
                    Iterator<Cell> cellsInRowDDataType = currentRow.iterator();
                    int cellIdxD = 0;
                    while (cellsInRowDDataType.hasNext()) {
                        Cell currentCellDT = cellsInRowDDataType.next();
                        if (cellIdxD == 0) {
                            cellIdxD++;
                            continue;
                        }

                        if (cellIdxD == 1) {
                            dataType = currentCellDT.getStringCellValue();
                        }
                    }
                    rowNumber++;
                    continue;
                }

                if (dataType.equals(dataTypeParam)) {
                    //process data member
                    if (rowNumber > 3) {
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
                                    attributeOk = new MemberAttribute();
                                }
                            }


                            if (isCheck) {
                                switch (cellIdx) {
                                    case 0:
                                        attributeOk.setIdRefContact(telegramUser.get().getId());
                                        attributeOk.setContactType(GeneralConstant.ATTRIBUTE_CONTACT_TYPE_USER);
                                        break;


                                    case 1:
                                        break;

                                    case 2:

                                        break;

                                    case 3:
                                        String attributeValue = null;
                                        CellType cellType = currentCell.getCellType();
                                        String manCellType = cellType.name().equals("NUMERIC") ? "DATE" : "STRING";
                                        if (dataType.toUpperCase(Locale.ROOT).equals(manCellType)) {
                                            if (dataType.equals("Date")) {
                                                try {
                                                    attributeValue = GeneralUtil.dateToStr(currentCell.getDateCellValue(), "dd-MM-yyyy");
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                }
                                            } else {
                                                attributeValue = currentCell.getStringCellValue();
                                            }
                                        } else {
                                            isCheck = false;
                                        }


                                        if (isCheck) {
                                            attributeOk.setAttributeValue(attributeValue);
                                        }
                                        break;

                                    default:
                                        break;
                                }

                            }
                            cellIdx++;
                        }
                    }
                } else {
                    throw new RuntimeException(dataTypeNotEquals);
                }


                if (isCheck) {
                    attributesOk.add(attributeOk);
                }

            }

            List<MemberAttribute> memberChatroomAttributes = excelChatroomToObjectForSave(workbook, dataTypeParam);
            attributesOk.addAll(memberChatroomAttributes);

            workbook.close();


            return attributesOk;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

}
