package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	
	public  String[][] exceldata(String fileName) throws IOException {
		//XSSFWorkbook excel = new XSSFWorkbook("C:\\vinotha\\eclipse\\Weekend\\src\\main\\java\\data\\selenium1.xlsx");
		
		XSSFWorkbook excel = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet ws = excel.getSheet("Sheet1");
		XSSFRow row = ws.getRow(1);
		XSSFCell cell =row.getCell(0);
		
		// rowcount
		int rowcount = ws.getLastRowNum();
		
		//cell count
		int cellcount = ws.getRow(0).getLastCellNum();
		String data[][] = new String[rowcount][cellcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			row = ws.getRow(i);
			for(int j=0;j<cellcount;j++)
			{
	//	String text = cell.getStringCellValue();
				String text = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=text;
			//System.out.println(	row.getCell(j).getStringCellValue());
		System.out.println(text);
		}
		}
		excel.close();
		return data;
	}

}
