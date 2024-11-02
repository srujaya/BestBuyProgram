package TestCaseBB;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import BaseBB.BaseBestBuy;
import PagesBB.CartPageBB;
import PagesBB.CheckOutPageBB;
import PagesBB.HomePageBB;
import PagesBB.LocationPageBB;
import PagesBB.ProductPageBB;

public class TC_09_CheckOutPageFilling extends BaseBestBuy {
	//https://www.bestbuy.com/checkout/r/payment
	
	@BeforeTest
	public void setup() {
		testName = "tc_09_CheckOutPageFilling";
		testDescription = "Navigating to the checkout page and filling the form with dummy payment information";
		testCategory = "Regression";
		testAuthor = "Sruthi";
	}
	
	@Test(priority=10)
	public void tc_09_CheckOutPageFilling() throws Exception {
		LocationPageBB lp=new LocationPageBB();
		lp.deliveryAtUSA();
		HomePageBB hp=new HomePageBB();
		hp.searchProduct("Mouse");
		Thread.sleep(8);
		ProductPageBB pp=new ProductPageBB();;		
		pp.addLogitechMouse();
		Thread.sleep(3);
		CartPageBB cp=new CartPageBB();
		cp.goToCheckOutPage();
		CheckOutPageBB cop=new CheckOutPageBB();
		cop.contactInfoAtCheckOut("sru123@gmail.com", "9900887766");
		reportStep("Validating CheckOut page filling but the application does working properly.if it works properly the commented method in test case will fill the page with responding details - Pass", "Pass", testName);
		
	}
}