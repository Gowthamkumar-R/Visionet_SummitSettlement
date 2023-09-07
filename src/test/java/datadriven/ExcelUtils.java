package datadriven;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExcelUtils {

	public static void main(String[] args) throws IOException {
		
		/*
		String excelpath = "./Data/TestData.xlsx";
		String Sheetname = "Test";
		
		GTXOrderDataDriven object = new GTXOrderDataDriven(excelpath, Sheetname);
		String value1 = object.exceldata();
		
		System.out.println("Value Returned from the Code is " + value1);
		
		given().
		header("Authorization", "Bearer " + POSTCucumber()).
		header("Content-Type", "application/json").body(value1)
		.when().post("https://qagtxres.greenlight-connect.com/PlaceOrderToReware")
		.then().statusCode(200).log().all();
		*/
		String ExcelPathAmer ="./Data/TestData.xlsx";
		String SheetNameAmer = "AmeriSaveOrder";
		AmeriSaveOrderDataDriven AmerObject = new AmeriSaveOrderDataDriven(ExcelPathAmer, SheetNameAmer);
		
		String AmerJSONBody = AmerObject.AmerExcel();
		
		System.out.println(AmerJSONBody);
		/*
		given().
		header("Authorization", "Bearer " + POSTCucumber()).
		header("Content-Type", "application/json").body(AmerJSONBody)
		.when().post("https://qagtx.greenlight-connect.com/api/ams/CreatePlaceOrder")
		.then().statusCode(200).log().all();
		*/
		
		//System.out.println("Output in final class " + AmerJSONBody);
		
}
	@SuppressWarnings("unchecked")
	public static String POSTCucumber() {
		
		JSONObject body = new JSONObject();
			
			body.put("userName", "user2");
			body.put("password", "1234");
			body.put("titleCompanyID", "1");
			
			System.out.println(body);
			System.out.println(body.toJSONString());
			
			 Response res  = given().header("Content-Type", "application/json").
			               contentType(ContentType.JSON).
			               body(body.toJSONString()).
			               when().post("https://qagtx.greenlight-connect.com/GtxToken").  
			               then().extract().response();
			 
			 String resbody = res.asString();
			 
			System.out.println("GTX Token  is " + resbody);
			return resbody;
}   

}
