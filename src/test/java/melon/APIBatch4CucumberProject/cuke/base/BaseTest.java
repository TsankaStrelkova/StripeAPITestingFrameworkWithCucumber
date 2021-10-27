package melon.APIBatch4CucumberProject.cuke.base;

import java.io.FileInputStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	public static Properties config= new Properties();
	public static FileInputStream fis;
	public static String validUserSecretKey;
	public static String invalidUserSecretKey;
	public static String customeEndPoint;
	
	public static RequestSpecification requestSpecs;
	public static Response response;
	
	public static void init() {
	
		try {
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
	    } catch (Exception e) {System.out.println(e);}
		try {
			config.load(fis);
		} catch (Exception e) {System.out.println(e);}
		
		RestAssured.baseURI=config.getProperty("baseURI");
		RestAssured.basePath=config.getProperty("basePath");
		
		validUserSecretKey = config.getProperty("validSecretKey");
        System.out.println("validUserSecretKey is :"+validUserSecretKey);
        invalidUserSecretKey = config.getProperty("invalidSecretKey");
        System.out.println("invalidUserSecretKey is  :"+invalidUserSecretKey);
        customeEndPoint =config.getProperty("customerAPIEndPoint");
}


}
