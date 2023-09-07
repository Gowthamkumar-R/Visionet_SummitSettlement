package Test.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class AppTest  {

@SuppressWarnings("unchecked")
public String POSTCucumber() {
	
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
public void AmeriSaveOrder() {
	
	String inputfile = "C://Users//Gowthamkumar.R//eclipse-workspace//Test//Data//AmeriSave.json";
	File file = new File(inputfile);
	
	given().
	header("Authorization", "Bearer  "+ POSTCucumber())
	.header("Content-Type", "application/json").body(file).
	when().post("https://qagtx.greenlight-connect.com/api/ams/CreatePlaceOrder").
	then().log().all();
	
/*(
	Response res1 = given()
	                .header("Authorization", "Bearer " + POSTCucumber())
	                .header("Content-Type", "application/json").accept(ContentType.JSON).
	                 body(file).
	                 when().post("https://qagtx.greenlight-connect.com/api/ams/CreatePlaceOrder").
	                 then().extract().response();
	
	  String resbody = res1.prettyPrint();
	  
	  System.out.println("AmeriSave Order Response status is" + res1.statusCode());
	  System.out.println("AmeriSave Order Response body is " + resbody);
	*/
}

public void GTXAPI() {
String inputpath = "C://Users//Gowthamkumar.R//eclipse-workspace//Test//Data//GTXApi.json";	
File file = new File(inputpath);

	given().
	header("Authorization", "Bearer " + POSTCucumber()).
	header("Content-Type", "application/json").
	body(file).
	when().post("https://qagtx.greenlight-connect.com/GtxAPI/CreatePlaceOrder").
	then().statusCode(200).log().all();
	
}

public void GTXOrder() {
	
	String inputpath = "C://Users//Gowthamkumar.R//eclipse-workspace//Test//Data//GTXOrder.json";
	File file = new File(inputpath);
	
	
	given().
	header("Authorization", "Bearer " + POSTCucumber()).
	header("Content-Type", "application/json").
	body(file).
	when().post("https://qagtxres.greenlight-connect.com/PlaceOrderToReware").
	then().statusCode(200).log().all();
	
}

public static void main( String[] args) throws InterruptedException, IOException {
	
	AppTest API = new AppTest();
	
	//API.AmeriSaveOrder();
	//API.GTXAPI();
	
	API.GTXOrder();

}
}
