package tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test
	void loginTest() {
		System.out.println("test2");
		//placeholder="Enter Email ID / Username"
		page.navigate("https://www.naukri.com/");
		page.locator("#login_Layer").click();
		page.getByPlaceholder("Enter your active Email ID / Username").fill("testranjankumarpusty@gmail.com");
		page.getByPlaceholder("Enter your password").fill("Ranjan1!");
		page.locator("button[type='submit']").click();
		
		System.out.println(page.title());
		assertThat(page).hasTitle("Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");
		page.locator("img[alt='naukri user profile image']").click();
		page.getByTitle("Logout").click();
		
	}

}
