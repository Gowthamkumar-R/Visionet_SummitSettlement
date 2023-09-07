package datadriven;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongodb.util.JSON;

public class ExcelDataExtraction {

	
     @SuppressWarnings({ "resource", "unchecked" })
	public static void main(String[] args) throws IOException {
    	 
		XSSFWorkbook workbook = new XSSFWorkbook("./Data/TestData.xlsx");
		XSSFSheet sheet = workbook.getSheet("AmeriSaveOrder");
		
		DataFormatter format = new DataFormatter();
		JSONObject mainBody = new JSONObject();
		JSONObject loanbody = new JSONObject();
		JSONArray loansArray = new JSONArray();
		JSONObject propertiesbody = new JSONObject();
		JSONArray propertiesArray = new JSONArray();
		JSONObject contactsbody = new JSONObject();
		JSONArray contactsArray = new JSONArray();
		JSONObject lastbody = new JSONObject();
		
		int totalrows = sheet.getPhysicalNumberOfRows();
		int totalcol = sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println("Total column count" +totalcol );
		
		System.out.println("Total Rows count " +totalrows);
		
		for (int r=1 ; r<totalrows; r++) {
					
			for (int c=0; c<totalcol; c++) {
				
				Object head, result;
				
				if(1<c && c<11) {
					
					head = format.formatCellValue(sheet.getRow(0).getCell(c));
					
					result = format.formatCellValue(sheet.getRow(r).getCell(c));
					
					loanbody.put(head, result);
					
					loansArray.add(loanbody);
				
					
				}
				
				else if(11<c && c<22) {

					head = format.formatCellValue(sheet.getRow(0).getCell(c));
					
					result = format.formatCellValue(sheet.getRow(r).getCell(c));
					
					propertiesbody.put(head, result);
					
					propertiesArray.add(propertiesbody);
					
					
				}
				
				else if (21<c && c<36) {
					
                    head = format.formatCellValue(sheet.getRow(0).getCell(c));
					
					result = format.formatCellValue(sheet.getRow(r).getCell(c));
					
					contactsbody.put(head, result);
					
					contactsArray.add(contactsbody);
					
				}
				
				else if(35<c && c<53) {
					
                    head = format.formatCellValue(sheet.getRow(0).getCell(c));
					
					result = format.formatCellValue(sheet.getRow(r).getCell(c));
					
					lastbody.put(head, result);
					
					contactsArray.add(lastbody);
					
				}
				else {
				
				head = format.formatCellValue(sheet.getRow(0).getCell(c));
				
				result = format.formatCellValue(sheet.getRow(r).getCell(c));
				
				//System.out.print("Result is " +result);
				
				
				mainBody.put(head, result);				
								
//				System.out.print(" ");
				
			}						
	} 
			mainBody.put("loans", loansArray);
			mainBody.put("Properties", propertiesArray);
			mainBody.put("contacts", contactsArray);
			
			String finalAPI = mainBody.toJSONString();
	       System.out.println("FinalPayloadis " + finalAPI);
	       break;
     }
}
}
