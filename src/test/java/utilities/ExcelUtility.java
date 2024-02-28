package utilities;



import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public static String path;
	
		public ExcelUtility(String path) {
			this.path=path;
		}
	
	public void setCellData(String sheetName, int rownum, int colunm, String data) throws IOException {
		try {
		File xfile=new File(path);
		
		if (!xfile.exists()) {
			//this if file does not exist so we will directly make a new file 
			workbook =new XSSFWorkbook();

		}
		else {
			fi=new FileInputStream(path);
			workbook =new XSSFWorkbook(fi);
			fi.close();
		}
		System.out.println(workbook.getSheetIndex(sheetName)+".................");
		if (workbook.getSheetIndex(sheetName)==-1) {
			//when sheet is not present in the workbook
			System.out.println(workbook.getSheetIndex(sheetName)+".................");
			workbook.createSheet(sheetName);
		}
		sheet=workbook.getSheet(sheetName);
		System.out.println(sheet.getRow(rownum)+".................");
		if (sheet.getRow(rownum)==null) {
			//if row does not exist
			System.out.println(sheet.getRow(rownum)+".................");
			sheet.createRow(rownum);
		}
		
		row=sheet.getRow(rownum);
		
		cell=row.createCell(colunm);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
//		fi.close();
		fo.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
}