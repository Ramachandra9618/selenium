package com.ecommerce.utitlity;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtility {

        public static List<Map> loadExcelData(String filePath, String sheetName) throws IOException {
            List<Map> data = new ArrayList<>();
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            // Get the first row as the header row (keys)
            Row headerRow = sheet.getRow(0);
            List<String> headers = new ArrayList<>();

            for (Cell headerCell : headerRow) {
                headers.add(headerCell.getStringCellValue());
            }

            // Iterate over the rows and map the data
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Map rowData = new LinkedHashMap();
                for (int j = 0; j < headers.size(); j++) {
                    Cell cell = row.getCell(j);
                    String cellValue = cell == null ? "" : cell.toString();
                    rowData.put(headers.get(j), cellValue);
                }
                data.add(rowData);
            }

            workbook.close();
            fis.close();
            return data;
        }
    }

