package TestCaseBB;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import BaseBB.BaseBestBuy;
import PagesBB.HomePageBB;
import PagesBB.LocationPageBB;

public class TC_05_ValidateLinkInBottomOfHomePage extends BaseBestBuy {
	
	@BeforeTest
	public void setup() {
		testName = "tc_05_validateLinkInBottomOfHomePage";
		testDescription = "Link in HomePage bottom is broken or not";
		testCategory = "Regression";
		testAuthor = "Sruthi";
	}
	
	@Test(priority=6)
	public void tc_05_validateLinkInBottomOfHomePage() throws Exception {
		LocationPageBB lp=new LocationPageBB();
		lp.deliveryAtUSA();
		HomePageBB hp=new HomePageBB();
		String actTitle = hp.validateTermsAndCondtionLink();
		String expTitle="BestBuy.com Terms and Conditions";
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			reportStep("Validating the Title of link in bottom of Home Page - Pass", "Pass", testName);
		} else {
			reportStep("Validating the Title of link in bottom of Home Page - Fail", "Fail", testName);
		}
	}
}