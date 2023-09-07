package datadriven;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;


public class GTXOrderDataDriven {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public  GTXOrderDataDriven(String excelpath, String Sheetname) throws IOException {
			
		 workbook = new XSSFWorkbook(excelpath);
		 sheet = workbook.getSheet("Test");
		
	}
	
	@SuppressWarnings("unchecked")
	public static String exceldata() {
		
		DataFormatter format = new DataFormatter();
		
		Object Transaction = format.formatCellValue(sheet.getRow(1).getCell(0));
		Object Client = format.formatCellValue(sheet.getRow(1).getCell(1));
		Object gtX_PartnerId = format.formatCellValue(sheet.getRow(1).getCell(2));
		Object gtX_RequestType = format.formatCellValue(sheet.getRow(1).getCell(3));
		Object gtX_SessionId = format.formatCellValue(sheet.getRow(1).getCell(4));
		Object queue_Name = format.formatCellValue(sheet.getRow(1).getCell(5));
		Object client_Name = format.formatCellValue(sheet.getRow(1).getCell(6));
		
//		int Dynamicvalue = sheet.getPhysicalNumberOfRows();
//		System.out.println("Dynamic value of the sheet is " + (Dynamicvalue-1));
		
		System.out.println("Value of the Transaction is " + Transaction);
		System.out.println("Value of the Client id is " + Client);
		System.out.println("Value of the gtX_PartnerId is " + gtX_PartnerId);
		System.out.println("Value of the gtX_RequestType is " + gtX_RequestType);
		System.out.println("Value of the gtX_SessionId is " + gtX_SessionId);
		System.out.println("Value of the queue_Name is " + queue_Name);
		System.out.println("Value of the client_Name is " + client_Name);
		
		
		
		
       JSONObject body = new JSONObject();
		
		body.put("gtX_TransactionId", Transaction);
		body.put("gtX_ClientId", Client);
		body.put("gtX_PartnerId", gtX_PartnerId );
		body.put("gtX_RequestType", gtX_RequestType);
		body.put("gtX_SessionId", gtX_SessionId);
		body.put("queue_Name", queue_Name);
		body.put("client_Name", client_Name);
		
		System.out.println(body.toJSONString());
		
		String resbody = body.toJSONString();
		
		System.out.println("Response Body is " + resbody);	
		
		return resbody;
		
	}
	
	

}
