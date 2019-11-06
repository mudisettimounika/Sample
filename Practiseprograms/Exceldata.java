package Practiseprograms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Exceldata {
	
	
	public static void main(String[] args) throws IOException {
		
		String Filepath = "/home/mounika/Desktop/Example.xlsx";
		FileInputStream file = new FileInputStream(Filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sh = workbook.getSheet("Example");
		XSSFRow row = sh.getRow(0);
		XSSFCell cell = row.getCell(0);
		
		int countrow = sh.getLastRowNum();
		int countcol = row.getLastCellNum();
		
		
		System.out.println("No.of row  "   + countrow);
		System.out.println("No.of col  "   + countcol);
		

		for(int i=1; i<sh.getLastRowNum()+1; i++) {
			for(int j=0; j< row.getLastCellNum(); j++) {
				System.out.println("values of " +i+" "+j);

		System.out.println(sh.getRow(i).getCell(j).getStringCellValue());

	}
		}
	}
	
}
