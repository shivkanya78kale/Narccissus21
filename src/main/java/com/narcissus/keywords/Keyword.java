package com.narcissus.keywords;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.narcissus.util.Waits;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {
	 public static WebDriver driver = null;
	public  static Waits wait=null;
	 /**
	  * This keyword can be used to launch specified browser
	  * @param browserName
	  */
	 
	public static void OpenBrowser(String browserName) {
		 if(browserName.equalsIgnoreCase("chrome")) {
			 
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }else if(browserName.equalsIgnoreCase("Firefox")){
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		 }else {
			 System.err.println("Invalid browser name:"+browserName);
			  }
		 wait =new Waits();
	}
	
	/**
	 * this keyword can be specified url
	 * @param Url
	 */
	
	public static void launchUrl(String Url) {
		driver.get(Url);

	}
	/**
	 * This keyword can be used to return representation of the title of current page
	 * @return
	 */
	
	public static String getTitle() {
		return driver.getTitle();
	}

	/**
	 * 
	 * @param element
	 */
	
	public static void clickOn(WebElement element) {
		element.click();
	}
	/**
	 * 
	 * @param elementText
	 */
	public  static void clickOn(String locator) {
		WebElement element = getWebElement(locator);
		 element.click();
	}
	/**
	 * 
	 * @param element
	 */
	public static void clickOn(By element) {
		driver.findElement(element).click();

	}
	public static void closeEindow(String title) {
		Set<String>allWindows = driver.getWindowHandles();
		for(String window: allWindows) {
			driver.switchTo().window(window);
			if(driver.getTitle().equalsIgnoreCase(title)) {
				driver.close();
			}
		}
	}
	public static  void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public static  void quitAllWindows() {
		driver.quit();
	}

	

	public static void enterText(String locator ,String text) {
		 WebElement element = getWebElement(locator);
		 
		 element.sendKeys(text);
	}

	private static WebElement getWebElement(String locator) {
		String locatorType=locator.split("##")[0];
		 String locatorValue = locator.split("##")[1];
		 WebElement element = null;
		 if(locatorType.equalsIgnoreCase("xpath")) 
			element= driver.findElement(By.xpath(locatorValue));
		 else if(locatorType.equalsIgnoreCase("css")) 
		 element= driver.findElement(By.cssSelector(locatorValue));
		 else if(locatorType.equalsIgnoreCase("id"))
		 element = driver.findElement(By.id(locatorValue));
		 else if(locatorType.equalsIgnoreCase("name"))
		 element = driver.findElement(By.name(locatorValue));
		 else if(locatorType.equalsIgnoreCase("class"))
		 element = driver.findElement(By.className(locatorValue));
		 else if(locatorType.equalsIgnoreCase("tagname"))
		 element = driver.findElement(By.tagName(locatorValue));
		 else if(locatorType.equalsIgnoreCase("linktext"))
		 element = driver.findElement(By.linkText(locatorValue));
		 else if(locatorType.equalsIgnoreCase("partiallinktext"))
		 element = driver.findElement(By.partialLinkText(locatorValue));
		return element;
	}
	private static  List<WebElement> getWebElements(String locator) {
		String locatorType=locator.split("##")[0];
		 String locatorValue = locator.split("##")[1];
		 List<WebElement> elements = new ArrayList<>();
		 if(locatorType.equalsIgnoreCase("xpath")) 
			elements= driver.findElements(By.xpath(locatorValue));
		 else if(locatorType.equalsIgnoreCase("css")) 
		 elements= driver.findElements(By.cssSelector(locatorValue));
		 else if(locatorType.equalsIgnoreCase("id"))
		 elements = driver.findElements(By.id(locatorValue));
		 else if(locatorType.equalsIgnoreCase("name"))
		 elements = driver.findElements(By.name(locatorValue));
		 else if(locatorType.equalsIgnoreCase("class"))
		 elements = driver.findElements(By.className(locatorValue));
		 else if(locatorType.equalsIgnoreCase("tagname"))
		 elements = driver.findElements(By.tagName(locatorValue));
		 else if(locatorType.equalsIgnoreCase("linktext"))
		 elements = driver.findElements(By.linkText(locatorValue));
		 else if(locatorType.equalsIgnoreCase("partiallinktext"))
		 elements = driver.findElements(By.partialLinkText(locatorValue));
		return elements;
	}
	

	public static List<String> getTextOfElements(By cssSelector) {
		
		List<String> productTexts = new ArrayList<>();
		List<WebElement> productTitles = driver.findElements(cssSelector);
		for(WebElement productTitle: productTitles) {
			productTexts.add(productTitle.getText());
		}
		
		return productTexts;
	}
	
	public static List<String>  getTextOfElements(String locator) {
		List<WebElement> elements = getWebElements(locator);
		List<String> elementsTexts=new ArrayList<>();
		for(WebElement element: elements) {
			elementsTexts.add(element.getText());
		}
		return elementsTexts;
	}
	
}