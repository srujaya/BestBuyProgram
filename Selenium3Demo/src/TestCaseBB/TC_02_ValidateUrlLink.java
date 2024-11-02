package TestCaseBB;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;

import BaseBB.BaseBestBuy;
import PagesBB.LocationPageBB;

public class TC_02_ValidateUrlLink extends BaseBestBuy {
	
	@BeforeTest
	public void setup() {
		testName = "tc_02_ValidateUrlLink";
		testDescription = "Given URL Link is broken or not";
		testCategory = "Regression";
		testAuthor = "Sruthi";
	}
	

	@Test(priority=2)
	public void tc_02_ValidateUrlLink() throws Exception {
		LocationPageBB lp=new LocationPageBB();
		if (lp.urlResponseCode()==200) {
			reportStep("Validating Best Buy page URL is broken or not - Pass", "Pass", testName);
		} else {
			reportStep("Validating Best Buy page URL is broken or not - Fail", "Fail", testName);
		}
		AssertJUnit.assertTrue(lp.urlResponseCode()==200);
	}
}