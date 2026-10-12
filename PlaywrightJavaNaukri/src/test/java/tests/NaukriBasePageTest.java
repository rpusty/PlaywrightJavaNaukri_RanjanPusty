package tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;

public class NaukriBasePageTest extends BaseTest{
	
	@Test
	void verifyTitle() {
		page.navigate("https://www.naukri.com/");
		System.out.println("Page title is: " + page.title());
		assertEquals(page.title(), "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");
		assertThat(page).hasTitle("Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");
		assertThat(page.locator("#register_Layer")).isEnabled();
		assertEquals("Register",page.getByTitle("Jobseeker Register").textContent());
		assertThat(page).hasURL("https://www.naukri.com/");
		assertThat(page.locator("#register_Layer")).hasAttribute("href", "https://www.naukri.com/registration/createAccount?othersrcp=22636");
		assertThat(page.locator("//*[@id=\"register_Layer\"]")).isEnabled();
	
	}

}
