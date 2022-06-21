package narcissus21a;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.narcissus.keywords.Keyword;
import com.narcissus.util.Locator;
import com.narcissus.util.PropUtil;
import com.narcissus.util.Waits;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {
	
	
	@Test
	public void VerifyTitleOfHomePage() {
		
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://testingshastra.com/");
	String expcetedTitle ="Testing Shastra | Training | Placement";
	String actualTitle =driver.getTitle();
	
	Assert.assertEquals(actualTitle, expcetedTitle);

	}
	@Test(description ="with Fremwork")
	public void verifyTitleOfHomePage() {
		String expcetedTitle="Testing Shastra | Training | Placement";
		Keyword.OpenBrowser("firefox");
		Keyword.launchUrl("https://testingshastra.com/");
		String actualTitle= Keyword.getTitle();
		Keyword.closeEindow("");
		Assert.assertEquals(actualTitle, expcetedTitle);		
	}
	
	@Test
	public  void verifySearchResultsForShoes() throws IOException ,InterruptedException{
		Keyword.OpenBrowser("chrome");
		Keyword.launchUrl("https://www.myntra.com");
		Keyword.enterText(Locator.searchForProducts,"Shoes");
		Keyword.clickOn(Locator.magnifier);
		Keyword.wait.forDuration(6);
		List<String> titles=Keyword.getTextOfElements(Locator.productTitles);
		System.out.println("There are "+titles.size()+"products");
		SoftAssert softly = new SoftAssert();
		for(String title : titles) {
			softly.assertTrue(title.contains("Shoes") ||title.contains("Sneakers"),"Titles doesn't contains");
		}
		softly.assertAll();
	}
	
	
		
	}
	
	




