package com.edts.tdlib.helper;

import com.edts.tdlib.bean.contact.TelegramUserBean;
import com.edts.tdlib.model.contact.TelegramUser;
import com.edts.tdlib.util.CommonUtil;
import com.edts.tdlib.util.SecurityUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class TelegramUserExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"Phone", "FirstName", "LastName"};
    static String SHEET = "BulkUserTelegram";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }


    public static Map<String, Object> excelToObject(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<TelegramUserBean> telegramUserBeansOk = new ArrayList<>();
            List<TelegramUserBean> telegramUserBeansFail = new ArrayList<>();

            TelegramUserBean telegramUserBeanOk = null;
            TelegramUserBean telegramUserBeanFail = null;

            int rowNumber = 0;
            boolean isCheck = false;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    if (cellIdx == 0) {
                        isCheck = CommonUtil.checkPhoneNumberFormatAndDigit(currentCell.getStringCellValue(), 0);

                        if (isCheck) {
                            telegramUserBeanOk = new TelegramUserBean();
                            telegramUserBeanOk.setCreatedBy(SecurityUtil.getEmail().get());
                        } else {
                            telegramUserBeanFail = new TelegramUserBean();
                        }
                    }


                    if (isCheck) {
                        switch (cellIdx) {
                            case 0:
                                telegramUserBeanOk.setPhoneNumber(currentCell.getStringCellValue());
                                break;

                            case 1:
                                telegramUserBeanOk.setFirstName(currentCell.getStringCellValue() == null ? "" : currentCell.getStringCellValue());
                                break;

                            case 2:
                                telegramUserBeanOk.setLastName(currentCell.getStringCellValue() == null ? "" : currentCell.getStringCellValue());
                                break;

                            default:
                                break;
                        }

                    } else {

                        switch (cellIdx) {
                            case 0:
                                telegramUserBeanFail.setPhoneNumber(currentCell.getStringCellValue());
                                break;

                            case 1:
                                telegramUserBeanFail.setFirstName(currentCell.getStringCellValue() == null ? "" : currentCell.getStringCellValue());
                                break;

                            case 2:
                                telegramUserBeanFail.setLastName(currentCell.getStringCellValue() == null ? "" : currentCell.getStringCellValue());
                                break;

                            default:
                                break;
                        }

                    }
                    cellIdx++;
                }
                if (isCheck) {
                    telegramUserBeansOk.add(telegramUserBeanOk);
                } else {
                    telegramUserBeansFail.add(telegramUserBeanFail);
                }

            }

            workbook.close();

            List<Map<String, Object>> mapList = new ArrayList<>();
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("confirmData", telegramUserBeansOk);
            objectMap.put("confirmCount", telegramUserBeansOk.size());
            objectMap.put("failData", telegramUserBeansFail);
            objectMap.put("failCount", telegramUserBeansFail.size());


            mapList.add(objectMap);

            return objectMap;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }


    public static ByteArrayInputStream telegramUsersToExcel(List<TelegramUser> telegramUserList) {
        String[] HEADERS_DOWNLOAD = {"Chat Id", "First Name", "Last Name", "Group Join", "Telegram Number"};
        String SHEET_DOWNLOAD = "BulkUserTelegram";


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
            for (TelegramUser telegramUser : telegramUserList) {
                Row row = sheet.createRow(rowIdx++);

                String lastName;
                if (telegramUser.getLastName() == null || telegramUser.getLastName().isEmpty() || telegramUser.getLastName().isBlank()) {
                    lastName = "-";
                } else {
                    lastName = telegramUser.getLastName();
                }

                row.createCell(0).setCellValue(telegramUser.getChatId());
                row.createCell(1).setCellValue(telegramUser.getFirstName());
                row.createCell(2).setCellValue(lastName);
                row.createCell(3).setCellValue(telegramUser.getGroupJoined());
                row.createCell(4).setCellValue(telegramUser.getPhoneNumber());

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
