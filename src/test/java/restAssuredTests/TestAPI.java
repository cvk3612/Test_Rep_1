package restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestAPI {
	
	public String name = "";
	
	private TestAPI(){
		
	}
	
	public TestAPI(String str) {
		name = str;
	}
	public static void main(String[] args) {
		
		String url = "https://reqres.in/api";
		RestAssured.baseURI = url;
		
		RequestSpecification reqSpec = RestAssured.given();
		
		Response resp = reqSpec.request(Method.GET, "/users?page=2");
		
		String respBody = resp.getBody().asString();
		
		System.out.println(respBody);
	}

}
