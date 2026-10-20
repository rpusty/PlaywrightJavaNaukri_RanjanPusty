package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

import base.ApiBaseTest;

public class BasicApiTest extends ApiBaseTest {

	JsonObject jsonResponse;

	@Test(priority = 1)
	void testGetEndpoint() {
		APIResponse response = request.get("/students");
		assertEquals(200, response.status());
		assertTrue(response.ok());
		// parse and check response body text
		String body = response.text();
		assertTrue(body.contains("Arya"));

	}

	@Test(priority = 2)
	void testPostEndpoint() {

		JsonObject userPayload = new JsonObject();
		userPayload.addProperty("name", "John Doe");
		userPayload.addProperty("job", "QA Engineer");
		APIResponse response = request.post("/students", RequestOptions.create().setData(userPayload.toString()));
		assertEquals(201, response.status());
		jsonResponse = com.google.gson.JsonParser.parseString(response.text()).getAsJsonObject();
		assertEquals("John Doe", jsonResponse.get("name").getAsString());
	}

	@Test(priority = 3)
	void testPutEndpoint() {
		JsonObject userPayload = new JsonObject();
		userPayload.addProperty("name", "John Doe");
		userPayload.addProperty("job", "DEV Engineer");
		APIResponse response = request.put("/students/" + jsonResponse.get("id").getAsString(),
				RequestOptions.create().setData(userPayload.toString()));
		assertEquals(200, response.status());
		jsonResponse = com.google.gson.JsonParser.parseString(response.text()).getAsJsonObject();
		assertEquals("John Doe", jsonResponse.get("name").getAsString());
	}

	@Test(priority = 4)
	void testDeleteEndpoint() {
		APIResponse response = request.delete("/students/" + jsonResponse.get("id").getAsString());
		assertEquals(200, response.status());
		JsonObject jsonResponse = com.google.gson.JsonParser.parseString(response.text()).getAsJsonObject();
		assertEquals("John Doe", jsonResponse.get("name").getAsString());
	}

}
