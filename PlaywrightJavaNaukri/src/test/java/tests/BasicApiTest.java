package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

import base.ApiBaseTest;

public class BasicApiTest extends ApiBaseTest{
	
	@Test
	void testGetEndpoint() {
		System.out.println("test request2");
		APIResponse response =request.get("/students");
		assertEquals(200,response.status());
		assertTrue(response.ok());
		//parse and check response body text
		String body=response.text();
		assertTrue(body.contains("Arya"));
		
	}
	
	@Test
	void testPostEndpoint() {
		JsonObject userPayload=new JsonObject();
		userPayload.addProperty("name", "John Doe");
		userPayload.addProperty("job", "QA Engineer");
		APIResponse response = request.post("/students", RequestOptions.create().setData(userPayload.toString()));
		assertEquals(201, response.status());
		JsonObject jsonResponse = com.google.gson.JsonParser.parseString(response.text()).getAsJsonObject();
		assertEquals("John Doe",jsonResponse.get("name").getAsString());
	}

}
