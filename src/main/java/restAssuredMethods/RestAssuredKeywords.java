package restAssuredMethods;


import org.json.simple.JSONObject;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RestAssuredKeywords {
	
	/*
	 * public static void main(String[] args) {
	 * postRequest("https://postman-echo.com/post",
	 * "hand:wave;hand1:wave2;hand3:wave3");
	 * //getRequest("https://postman-echo.com/get");
	 * 
	 * }
	 */
	
	
	public static void getRequest(String url) {
	RequestSpecification req = RestAssured.given();
	Response resp = req.get(url);
	String msgBody = resp.getBody().asString();
	System.out.println(msgBody);
	int respCode = resp.getStatusCode();
	System.out.println("Code: "+respCode);
	Assert.assertEquals(respCode, 200);
	
	}
	
	public static void postRequest(String url, String params) {
		RequestSpecification req = RestAssured.given();
		JSONObject inputParameters = new JSONObject();
		inputParameters = bodyForPost(params);
		req.header("Content-Type", "application/json");
		req.body(inputParameters.toJSONString());
		Response resp = req.post(url);
		int respCode = resp.getStatusCode();
		System.out.println("Code: "+respCode);
		//Assert.assertEquals(respCode, 201);
	}
	
	public static void putRequest(String url, String params) {
		RequestSpecification req = RestAssured.given();
		JSONObject inputParameters = new JSONObject();
		inputParameters = bodyForPost(params);
		req.header("Content-Type", "application/json");
		req.body(inputParameters.toJSONString());
		Response resp = req.post(url);
		int respCode = resp.getStatusCode();
		System.out.println("Code: "+respCode);
		//Assert.assertEquals(respCode, 200);
	}
	
	public static JSONObject bodyForPost(String param) {
		JSONObject inputParameters = new JSONObject();
		String [] splitstr = param.split(";");
		for(int i = 0; i<=splitstr.length-1; i++) {
			String currentP = splitstr[i];
			String[] splisplit = currentP.split(":");
			inputParameters.put(splisplit[0], splisplit[1]);
		}
		
		return inputParameters;
	}
	
	public static void deleteRequest(String url) {
	RequestSpecification req = RestAssured.given();
	Response resp = req.delete(url);
	String msgBody = resp.getBody().asString();
	System.out.println(msgBody);
	int respCode = resp.getStatusCode();
	System.out.println(respCode);
	Assert.assertEquals(respCode, 200);
	}

}
