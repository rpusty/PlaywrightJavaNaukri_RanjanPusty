package base;

import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {
	
	protected Playwright playwright;
	protected Browser browser;
	protected BrowserContext context;
	protected Page page;
	
	@BeforeMethod
	public void setUp() { 
		System.out.println("test1");
		playwright= Playwright.create();
		browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		//create new,isolated browsercontext
		context= browser.newContext();
		//open a new page(tab ) within that context
		context.newPage();
		
		page= context.newPage();
		

}
}
