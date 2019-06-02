package com.demoaut.newtours.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demoaut.newtours.Pages.Login;
import com.demoaut.newtours.Pages.SignOn;

import utils.GenericMethods;

public class ValidateInvalidCredentialsTest {
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser) {
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("IE")) {
			System.setProperty("wedriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com");
	}



	@Test
	public void verifyInvalidCredentials() throws IOException {
		Login lp = new Login(driver);
		SignOn so = new SignOn(driver);

		String[][] data = GenericMethods.getData("D:\\SelMay8\\TestData.xlsx", "Sheet1");

		for(int i =1;i<data.length;i++) {

			lp.ApplicationLogin(data[i][0], data[i][1]);
			boolean signOnVisible = so.signOnVisible().isDisplayed();
			Assert.assertTrue(signOnVisible);
			driver.navigate().back();
		}
	}


	@AfterTest

	public void closeApplication() {
		driver.close();
	}
}
