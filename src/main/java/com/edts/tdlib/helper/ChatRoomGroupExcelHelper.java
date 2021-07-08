package com.edts.tdlib.helper;

import com.edts.tdlib.bean.contact.ChatroomBulkBean;
import com.edts.tdlib.bean.contact.TelegramUserBean;
import com.edts.tdlib.model.contact.*;
import com.edts.tdlib.repository.ChatRoomRepo;
import com.edts.tdlib.util.CommonUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Component
public class ChatRoomGroupExcelHelper {

    private final ChatRoomRepo chatRoomRepo;


    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"Chat Id", "Chatroom Name"};
    static String SHEET = "ChatroomGroup";

    public ChatRoomGroupExcelHelper(ChatRoomRepo chatRoomRepo) {
        this.chatRoomRepo = chatRoomRepo;
    }

    public Map<String, Object> excelToObject(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<ChatroomBulkBean> chatroomBulkBeansOk = new ArrayList<>();
            List<ChatroomBulkBean> chatroomBulkBeansFail = new ArrayList<>();

            ChatroomBulkBean chatroomBulkBeanOk = null;
            ChatroomBulkBean chatroomBulkBeanFail = null;

            int rowNumber = 0;
            boolean isCheck = false;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
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
                            chatroomBulkBeanOk = new ChatroomBulkBean();
                        } else {
                            chatroomBulkBeanFail = new ChatroomBulkBean();
                        }
                    }


                    if (isCheck) {
                        switch (cellIdx) {
                            case 0:
                                chatroomBulkBeanOk.setChatId(chatRoom.get().getChatId());
                                chatroomBulkBeanOk.setName(chatRoom.get().getName());
                                chatroomBulkBeanOk.setCountMember(chatRoom.get().getCountMember());
                                break;

                            default:
                                break;
                        }

                    } else {

                        switch (cellIdx) {
                            case 0:
                                chatroomBulkBeanFail.setChatId((long) currentCell.getNumericCellValue());
                                break;
                            case 1:
                                chatroomBulkBeanFail.setName(currentCell.getStringCellValue());
                                break;

                            default:
                                break;
                        }

                    }
                    cellIdx++;
                }
                if (isCheck) {
                    chatroomBulkBeansOk.add(chatroomBulkBeanOk);
                } else {
                    chatroomBulkBeansFail.add(chatroomBulkBeanFail);
                }

            }

            workbook.close();

            List<Map<String, Object>> mapList = new ArrayList<>();
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("confirmData", chatroomBulkBeansOk);
            objectMap.put("confirmCount", chatroomBulkBeansOk.size());
            objectMap.put("failData", chatroomBulkBeansFail);
            objectMap.put("failCount", chatroomBulkBeansFail.size());


            mapList.add(objectMap);

            return objectMap;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }


    public List<ChatRoomGroupMember> excelToObjectForSave(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<ChatRoomGroupMember> chatRoomGroupMemberList = new ArrayList<>();

            ChatRoomGroupMember chatRoomGroupMember = null;

            int rowNumber = 0;
            boolean isCheck = false;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

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
                            chatRoomGroupMember = new ChatRoomGroupMember();
                        }

                    }


                    if (isCheck) {
                        switch (cellIdx) {
                            case 0:
                                chatRoomGroupMember.setChatRoom(chatRoom.get());
                                break;
                            default:
                                break;
                        }

                    }
                    cellIdx++;
                }
                if (isCheck) {
                    chatRoomGroupMemberList.add(chatRoomGroupMember);
                }

            }

            workbook.close();


            return chatRoomGroupMemberList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }


    public static ByteArrayInputStream chatroomsGroupToExcel(List<ChatRoomGroup> chatRoomGroupList) {
        String[] HEADERS_DOWNLOAD = {"Grouping Name", "Chatroom"};
        String SHEET_DOWNLOAD = "Chatroom Group";


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
            for (ChatRoomGroup chatRoomGroup : chatRoomGroupList) {
                Row row = sheet.createRow(rowIdx++);


                row.createCell(0).setCellValue(chatRoomGroup.getName());
                row.createCell(1).setCellValue(chatRoomGroup.getCountMember() + " Chatroom");

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
