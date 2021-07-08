package com.edts.tdlib.helper;

import com.edts.tdlib.bean.contact.TelegramUserBean;
import com.edts.tdlib.model.contact.MemberTelegramUserGroup;
import com.edts.tdlib.model.contact.TelegramUser;
import com.edts.tdlib.model.contact.TelegramUserGroup;
import com.edts.tdlib.repository.TelegramUserRepo;
import com.edts.tdlib.util.CommonUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Component
public class TelegramUserGroupExcelHelper {


    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"Phone", "FirstName", "LastName"};
    static String SHEET = "BulkUserGroupTelegram";


    private final TelegramUserRepo telegramUserRepo;

    public TelegramUserGroupExcelHelper(TelegramUserRepo telegramUserRepo) {
        this.telegramUserRepo = telegramUserRepo;
    }

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
                            telegramUserBeanOk = new TelegramUserBean();
                        } else {
                            telegramUserBeanFail = new TelegramUserBean();
                        }
                    }


                    if (isCheck) {
                        switch (cellIdx) {
                            case 0:
                                telegramUserBeanOk.setPhoneNumber(currentCell.getStringCellValue());
                                telegramUserBeanOk.setId(telegramUser.get().getId());
                                telegramUserBeanOk.setChatId(telegramUser.get().getUserTelegramId());
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


    public List<MemberTelegramUserGroup> excelToObjectForSave(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<TelegramUserBean> telegramUserBeansFail = new ArrayList<>();
            List<MemberTelegramUserGroup> memberTelegramUserGroupList = new ArrayList<>();

            MemberTelegramUserGroup memberTelegramUserGroup = null;
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
                            telegramUserBeanFail = new TelegramUserBean();
                        } else {
                            memberTelegramUserGroup = new MemberTelegramUserGroup();
                        }
                    }


                    if (isCheck) {
                        switch (cellIdx) {
                            case 0:
                                memberTelegramUserGroup.setEnable(true);
                                memberTelegramUserGroup.setTelegramUser(telegramUser.get());
                                break;
                            default:
                                break;
                        }

                    }
                    cellIdx++;
                }
                if (isCheck) {
                    memberTelegramUserGroupList.add(memberTelegramUserGroup);
                } else {
                    telegramUserBeansFail.add(telegramUserBeanFail);
                }

            }

            workbook.close();


            return memberTelegramUserGroupList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }


    public static ByteArrayInputStream telegramUserGroupToExcel(List<TelegramUserGroup> telegramUserGroupList) {
        String[] HEADERS_DOWNLOAD = {"Group Name", "Member"};
        String SHEET_DOWNLOAD = "TelegramUserGroup";


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
            for (TelegramUserGroup telegramUserGroup : telegramUserGroupList) {
                Row row = sheet.createRow(rowIdx++);


                row.createCell(0).setCellValue(telegramUserGroup.getName());
                row.createCell(1).setCellValue(telegramUserGroup.getCountMember() + " Users");

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
