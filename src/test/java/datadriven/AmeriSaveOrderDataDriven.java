package datadriven;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.cucumber.messages.internal.com.google.common.base.CharMatcher;

public class AmeriSaveOrderDataDriven {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public AmeriSaveOrderDataDriven(String ExcelPathAmer, String SheetNameAmer) throws IOException {
		
		 workbook = new XSSFWorkbook(ExcelPathAmer);
		 sheet = workbook.getSheet(SheetNameAmer);
		
		
	}
	@SuppressWarnings({ "unchecked", "unused" })
	public String AmerExcel() {
		
		
		DataFormatter format = new DataFormatter();
		//format.formatCellValue(cell)
		
		Object loanReason = format.formatCellValue(sheet.getRow(1).getCell(0));
		Object languagePreference = format.formatCellValue(sheet.getRow(1).getCell(1));
		//Loans:
		Object loanIdentifier = format.formatCellValue(sheet.getRow(1).getCell(3));
		Object lenderName = format.formatCellValue(sheet.getRow(1).getCell(4));
		Object loanNumber = format.formatCellValue(sheet.getRow(1).getCell(5));
		
		//Object loanAmount = format.formatCellValue(sheet.getRow(1).getCell(6));
		double loanAmountdouble = sheet.getRow(1).getCell(6).getNumericCellValue();
	    int loanAmount = (int) Math.round(loanAmountdouble);
	
		
		//Object purchasePrice = format.formatCellValue(sheet.getRow(1).getCell(7));
		double purchasePricedouble = sheet.getRow(1).getCell(7).getNumericCellValue();
	    int purchasePrice = (int) Math.round(purchasePricedouble);
	    
		Object loanType = format.formatCellValue(sheet.getRow(1).getCell(8));
		
		//Object lienPosition = format.formatCellValue(sheet.getRow(1).getCell(9));
		double lienPositiondouble = sheet.getRow(1).getCell(6).getNumericCellValue();
	    int lienPosition = (int) Math.round(lienPositiondouble);
	    
		//Object rate = format.formatCellValue(sheet.getRow(1).getCell(10));
	    double ratedouble = sheet.getRow(1).getCell(6).getNumericCellValue();
	    int rate	 = (int) Math.round(ratedouble);
	    
		//Object term = format.formatCellValue(sheet.getRow(1).getCell(11));
	    double termdouble = sheet.getRow(1).getCell(6).getNumericCellValue();
	    int term = (int) Math.round(termdouble);
	    
		Object PriorPolicyDate = format.formatCellValue(sheet.getRow(1).getCell(12));
		//Properties:
		Object propertyId = format.formatCellValue(sheet.getRow(1).getCell(14));
		//address:
		Object address1Prop = format.formatCellValue(sheet.getRow(1).getCell(16));
		Object address2Prop = format.formatCellValue(sheet.getRow(1).getCell(17));
		Object cityProp = format.formatCellValue(sheet.getRow(1).getCell(18));
		Object stateProp = format.formatCellValue(sheet.getRow(1).getCell(19));
		Object fipsProp = format.formatCellValue(sheet.getRow(1).getCell(20));
		Object zipCodeProp = format.formatCellValue(sheet.getRow(1).getCell(21));
		Object countyProp = format.formatCellValue(sheet.getRow(1).getCell(22));
		Object propertyUsageTypeProp = format.formatCellValue(sheet.getRow(1).getCell(23));
		Object propertyTypeProp = format.formatCellValue(sheet.getRow(1).getCell(24));
		//contacts:
		Object contactTypeCont = format.formatCellValue(sheet.getRow(1).getCell(26));
		Object contactIdCont = format.formatCellValue(sheet.getRow(1).getCell(27));
		Object firstNameCont = format.formatCellValue(sheet.getRow(1).getCell(28));
		Object lastNameCont = format.formatCellValue(sheet.getRow(1).getCell(29));
		Object companyNameCont = format.formatCellValue(sheet.getRow(1).getCell(30));
		Object phoneCont = format.formatCellValue(sheet.getRow(1).getCell(31));
		//address:
		Object address1 = format.formatCellValue(sheet.getRow(1).getCell(33));
		Object address2 = format.formatCellValue(sheet.getRow(1).getCell(34));
		Object city = format.formatCellValue(sheet.getRow(1).getCell(35));
		Object state = format.formatCellValue(sheet.getRow(1).getCell(36));
		Object fips = format.formatCellValue(sheet.getRow(1).getCell(37));
		Object zipCode = format.formatCellValue(sheet.getRow(1).getCell(38));
		Object county = format.formatCellValue(sheet.getRow(1).getCell(39));
		Object email = format.formatCellValue(sheet.getRow(1).getCell(40));
		Object contacttype = format.formatCellValue(sheet.getRow(1).getCell(41));
		Object contactId = format.formatCellValue(sheet.getRow(1).getCell(42));
		Object firstName = format.formatCellValue(sheet.getRow(1).getCell(43));
		Object middleName = format.formatCellValue(sheet.getRow(1).getCell(44));
		Object lastName = format.formatCellValue(sheet.getRow(1).getCell(45));
		
		//Object suffix = format.formatCellValue(sheet.getRow(1).getCell(46));
		String result = sheet.getRow(1).getCell(46).getStringCellValue();
		String suffix = CharMatcher.is('\"').trimFrom(result);
		//System.out.println(result);
		
		Object ssn = format.formatCellValue(sheet.getRow(1).getCell(47));
		Object companyname = format.formatCellValue(sheet.getRow(1).getCell(48));
		//address:
		Object address1IND = format.formatCellValue(sheet.getRow(1).getCell(50));
		Object address2IND = format.formatCellValue(sheet.getRow(1).getCell(51));
		Object cityIND = format.formatCellValue(sheet.getRow(1).getCell(52));
		Object stateIND = format.formatCellValue(sheet.getRow(1).getCell(53));
		Object fipsIND = format.formatCellValue(sheet.getRow(1).getCell(54));
		Object zipCodeIND = format.formatCellValue(sheet.getRow(1).getCell(55));
		Object countyIND = format.formatCellValue(sheet.getRow(1).getCell(56));
		Object phoneIND = format.formatCellValue(sheet.getRow(1).getCell(57));
		Object emailIND = format.formatCellValue(sheet.getRow(1).getCell(58));
		
/*********************************************************************************************************/
		JSONObject mainBody = new JSONObject();
        mainBody.put("loanReason", loanReason);
		mainBody.put("languagePreference", languagePreference);

		JSONObject loansBody = new JSONObject();
		loansBody.put("loanIdentifier",loanIdentifier);
		loansBody.put("lenderName",lenderName);
		loansBody.put("loanNumber",loanNumber);
		loansBody.put("loanAmount",loanAmount);
		loansBody.put("purchasePrice",purchasePrice);
		loansBody.put("loanType",loanType);
		loansBody.put("lienPosition",lienPosition);
		loansBody.put("rate",rate);
		loansBody.put("term",term);
		loansBody.put("PriorPolicyDate",PriorPolicyDate);

		JSONArray loansArray = new JSONArray();
        loansArray.add(loansBody);
        
        
/*********************************************************************************************************/
		JSONObject propertiesbody = new JSONObject();
		propertiesbody.put("propertyId",0);
		propertiesbody.put("propertyUsageType", propertyUsageTypeProp);
		propertiesbody.put("propertyType", propertyTypeProp);
		
		JSONObject addressprop = new JSONObject();
		addressprop.put("address1", address1Prop);
		addressprop.put("address2", address2Prop);
		addressprop.put("city", cityProp);
		addressprop.put("state", stateProp);
		addressprop.put("fips", fipsProp);
		addressprop.put("zipcode", zipCodeProp);
		addressprop.put("county", countyProp);
		
		propertiesbody.put("address", addressprop);
		
		JSONArray propertiesArray = new JSONArray();
		propertiesArray.add(propertiesbody);
/*********************************************************************************************************/
		JSONObject contactsbody = new JSONObject();
		contactsbody.put("contactType", contactTypeCont);
		contactsbody.put("contactId", contactIdCont);
		contactsbody.put("firstName", firstNameCont);
		contactsbody.put("lastName", lastNameCont);
		contactsbody.put("companyName", companyNameCont);
		contactsbody.put("phone", phoneCont);
		contactsbody.put("email", email);
		
		JSONObject addresscon = new JSONObject();
		addresscon.put("address1", address1);
		addresscon.put("address2", address2);
		addresscon.put("city", city);
		addresscon.put("state", state);
		addresscon.put("fips", fips);
		addresscon.put("zipcode", zipCode);
		addresscon.put("county", county);
		
        contactsbody.put("address", addresscon);		
		
		
/*********************************************************************************************************/		
		JSONObject lastbody = new JSONObject();
		lastbody.put("contacttype", contacttype);
		lastbody.put("contactId", contactId);
		lastbody.put("firstName", firstName);
		lastbody.put("middleName", middleName);
		lastbody.put("lastName", lastName);
		lastbody.put("suffix",suffix);
		lastbody.put("ssn", ssn);
		lastbody.put("companyname", companyname);
		lastbody.put("phone", phoneIND);
		lastbody.put("email", emailIND);
		
		JSONObject addresslastbody = new JSONObject();
		addresslastbody.put("address1", address1IND);
		addresslastbody.put("address2", address2IND);
		addresslastbody.put("city", cityIND);
		addresslastbody.put("state", stateIND);
		addresslastbody.put("fips", fipsIND);
		addresslastbody.put("zipcode", zipCodeIND);
		addresslastbody.put("county", countyIND);
		
		lastbody.put("address", addresslastbody);

/*********************************************************************************************************/	
		
		JSONArray contactsArray = new JSONArray();
		contactsArray.add(contactsbody);
		contactsArray.add(lastbody);
		
/*********************************************************************************************************/	
		
		mainBody.put("loans", loansArray);
		mainBody.put("properties", propertiesArray);
		mainBody.put("contacts", contactsArray);
		
		String jsonString = mainBody.toJSONString();
		
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonElement jsonElement = JsonParser.parseString(jsonString);
        
        String prettyJson = gson.toJson(jsonElement);
        
        System.out.println(prettyJson);
		
		return jsonString;

	}
}
