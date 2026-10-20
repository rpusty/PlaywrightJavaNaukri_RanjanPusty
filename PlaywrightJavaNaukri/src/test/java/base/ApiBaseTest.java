package base;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

public class ApiBaseTest {

	protected static Playwright playwright;
	protected static APIRequestContext request;

	@BeforeMethod
	public void setupAPI() {
		playwright = Playwright.create();
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		// headers.put("Authorization", "");
		request = playwright.request().newContext(
				new APIRequest.NewContextOptions().setBaseURL("http://localhost:3000").setExtraHTTPHeaders(headers));
	}

	@AfterMethod
	static void tearDown() {
		if (request != null)
			request.dispose();
		if (playwright != null)
			playwright.close();
	}

}
