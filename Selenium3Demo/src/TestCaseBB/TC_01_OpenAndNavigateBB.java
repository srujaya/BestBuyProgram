package TestCaseBB;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import BaseBB.BaseBestBuy;
import PagesBB.LocationPageBB;

public class TC_01_OpenAndNavigateBB extends BaseBestBuy {
	
	@BeforeTest
	public void setup() {
		testName = "tc_01_OpenAndNavigateBB";
		testDescription = "Navigating to the Best Buy e-commerce website";
		testCategory = "Regression";
		testAuthor = "Sruthi";
	}
	
	@Test(priority=1)
	public void tc_01_OpenAndNavigateBB() throws Exception {
		LocationPageBB lp=new LocationPageBB();
		String actTitle = lp.bestBuyPageTitle();
		String expTitle="Best Buy International: Select your Country - Best Buy";
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			reportStep("Validating Best Buy Page Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Best Buy Page Title - Fail", "Fail", testName);
		}
	}
}