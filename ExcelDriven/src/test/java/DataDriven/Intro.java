package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Intro {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Identify  Testcases column by scanning the entire 1st row 
		//Once column is identified then scan entire testcase column to identify purchase testcase row
		//after you grap purchase testcases row = pull all the data of that row and feed into test
		
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\OneDrive\\Documents\\demoData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				//Identify  Testcases column by scanning the entire 1st row 
				Iterator <Row> row = sheet.iterator(); //sheet is collection of row
				
				Row firstRow = row.next();   
				
				Iterator <Cell> ce = firstRow.cellIterator();    //row is collection of cell
				int k=0;
				int column=0;
				
				while(ce.hasNext()) {
					Cell value = ce.next();
					
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						//desire column
						column=k;
						
					}
					k++;
				}
				System.out.println(column);
				//once column is identified scan the entire column to get purchase row
				
				
				
				
				
				
			}
		}

	}

}
