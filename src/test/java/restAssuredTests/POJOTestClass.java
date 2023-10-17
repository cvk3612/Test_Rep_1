package restAssuredTests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class POJOTestClass {

	public static void main(String[] args) {


		String url = "https://reqres.in/api";
		RestAssured.baseURI = url;
		
		DeListPojo objPojo = new DeListPojo();
		
		objPojo = RestAssured.given().when().get("/users?page=2").as(DeListPojo.class);
		
		//System.out.println(objPojo);
		
		Map<String, String> dataMap = new HashMap<String, String>();
		
		List<DeDataPojo> DataPojo = objPojo.getData();
		
		/*
		 * for(int i = 0; i<DataPojo.size(); i++) {
		 * //System.out.println(DataPojo.get(i));
		 * if(DataPojo.get(i).toString().contains("id=4")) {
		 * System.out.println(DataPojo.get(i));
		 * 
		 * } }
		 */
		
		for(int i = 0; i<DataPojo.size(); i++) {
			String currentList = DataPojo.get(i).toString();
			System.out.println(currentList);
		}

	}

}
