package com.Product.App.Utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.compress.archivers.zip.X0015_CertificateIdForFile;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Product.App.Entity.Product;
import com.Product.App.Exception.ExcelDownloadFailed;

public class ExcelUtility {

	public static String[] Header = { "productId", "productName", "description", "amount" };

	public static String SHEET_NAME = "ProductSheet";

	public static ByteArrayInputStream excelDownload(List<Product> productList) throws IOException, ExcelDownloadFailed {
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

        try {
            Sheet sheet = workbook.createSheet(SHEET_NAME);
            Row row = sheet.createRow(0);

            // Create header row
            for (int i = 0; i < Header.length; i++) {
                row.createCell(i).setCellValue(Header[i]);
            }

            int rowIndex = 1; // Start populating data from the second row

            for (Product p : productList) {
                Row row1 = sheet.createRow(rowIndex++);
                row1.createCell(0).setCellValue(p.getProductId());
                row1.createCell(1).setCellValue(p.getProductName());
                row1.createCell(2).setCellValue(p.getDescription());
                row1.createCell(3).setCellValue(p.getAmount()); // Ensure we're using the correct property for the amount
            }

            workbook.write(arrayOutputStream);
            return new ByteArrayInputStream(arrayOutputStream.toByteArray());

        } catch (IOException e) {
            throw new ExcelDownloadFailed("Failed to generate Excel file: " + e.getMessage());
        } finally {
            workbook.close();  // Ensure the workbook is closed in the finally block
            arrayOutputStream.close(); // Ensure the output stream is also closed
        }
    }
}
