package com.springboot.api.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.api.model.Product;

public class ProductExcelHelper {
	// File Is of Excel type or not
	public static Boolean checkFileFormat(MultipartFile file) {
		
			String contentType = file.getContentType();
			if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
				return true;
			}
			else {
				return false;
			}
	}
	
	// Convert Excel to list 
	public static List<Product> convert(InputStream inputStream){
		List<Product> list = new ArrayList<>();
		try {
		 XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
		 XSSFSheet sheet = xssfWorkbook.getSheet("Data");
		 int rowNumber = 0;
		 Iterator<Row> iterator = sheet.iterator();
		 while(iterator.hasNext()) {
			 Row row = iterator.next();
			 if(rowNumber==0) {
				 rowNumber++;
				 continue;
			 }
			 Iterator<Cell> cells = row.iterator();
			 int cId = 0;
			 Product product = new Product();
			 while(cells.hasNext()) {
				 Cell cell = cells.next();
				 switch (cId) {
				case 0: {
					product.setProductID((int)cell.getNumericCellValue());
					break;
				}
				case 1 : {
					product.setProductCategory(cell.getStringCellValue());
					break;
				}
				case 2 : {
					product.setProduct(cell.getStringCellValue());
					break;
				}
				case 3 : {
					product.setProductSales((int)cell.getNumericCellValue());
					break;
				}
				case 4 : {
					product.setProductQuater(cell.getStringCellValue());
					break;
				}
				default:
					break;
				}
				 cId++;
			 }
			 list.add(product);
		 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
