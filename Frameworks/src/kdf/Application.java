package kdf;

import java.io.IOException;

import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {
	
	@Test
	public void applicationLoginTest() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelMay8\\TestData.xlsx", "Sheet2");
		for(int i = 1; i<data.length;i++) {
			switch(data[i][3]) {
			
			case "openBrowser":
				Methods.openBrowser();
				break;
			
			case "maxBrowser":
				Methods.maximizeBrowser();
				break;
			
			case "impWait":
				Methods.implicitWait();
				break;
			case "navToApplication":
				Methods.navigateToApplication(data[i][6]);
				break;
			case "enterUserID":
				Methods.enterUserID(data[i][4],data[i][5], data[i][6]);
				break;
			case "enterPassword":
				Methods.enterPassword(data[i][4],data[i][5], data[i][6]);
				break;
			case "ClickLogin":
				Methods.clickSignIn(data[i][4],data[i][5]);
				break;
			case "verifyErrMsg":
				Methods.verifyErrorMessage(data[i][5], data[i][6]);
				break;
			case "closeBrowser":
				Methods.closeApplication();
				break;
				
				
			
			}
			
		}
	}

}
