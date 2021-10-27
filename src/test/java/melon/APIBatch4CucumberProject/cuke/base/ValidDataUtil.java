package melon.APIBatch4CucumberProject.cuke.base;

import org.json.JSONObject;

import melon.APIBatch4CucumberProject.cuke.base.BaseTest;

import io.restassured.response.Response;


	public class ValidDataUtil extends BaseTest{
		
		public static boolean jsonHasKey(Response response, String key)
		{
			JSONObject jsonObject=new JSONObject(response.asString());
			return jsonObject.has(key);	
		}

		public static boolean jsonKeyIs(Response response, String key, String keyValue)
		{
			JSONObject jsonObject=new JSONObject(response.asString());
			return (jsonObject.get(key)).equals(keyValue);
		}
		
		public static String getJSONKeyValue(Response response, String key)
		{
			JSONObject jsonObject=new JSONObject(response.asString());
			return (jsonObject.get(key)).toString();
		}
	}


