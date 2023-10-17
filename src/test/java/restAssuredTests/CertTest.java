package restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CertTest {

	public static void main(String[] args) {
		//RestAssured.baseURI = "https://client.badssl.com/";
		
		
		RestAssured.config().sslConfig(
				SSLConfig.sslConfig().with().trustStore("trustsore", "test@123")
				.trustStoreType("PKCS12")
				.keyStore("", "test@123")
				.keystoreType("PKCS12")
				);
		
		RequestSpecification req = RestAssured.given();
		
		Response resp = req.request(Method.GET, "https://client.badssl.com/");
		
		int statusCode = resp.getStatusCode();
		String statusLine = resp.getStatusLine();
		
		System.out.println("Status code: "+statusCode+", Status Line : "+statusLine);
		

	}

}
