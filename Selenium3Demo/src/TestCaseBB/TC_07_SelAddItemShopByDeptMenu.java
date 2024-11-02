package TestCaseBB;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import BaseBB.BaseBestBuy;
import PagesBB.CartPageBB;
import PagesBB.HomePageBB;
import PagesBB.LocationPageBB;
import PagesBB.ProductPageBB;

public class TC_07_SelAddItemShopByDeptMenu extends BaseBestBuy {

	@BeforeTest
	public void setup() {

		testName = "tc_07_selAddItemShopByDeptMenu";
		testDescription = "Search a Item by Department in Menu and add it in cart";
		testCategory = "Regression";
		testAuthor = "Sruthi";
	}

	@Test(priority=8)
	public void tc_07_selAddItemShopByDeptMenu() throws Exception {
		LocationPageBB lp = new LocationPageBB();
		lp.deliveryAtUSA();
		HomePageBB hp = new HomePageBB();
		hp.selectTvMenuInHomePage();
		ProductPageBB pp = new ProductPageBB();
		String sony75TitleAtProdPage = pp.addSony75InchTVInProdPageM2();// pp.addSony75InchTVInProdPage()
		hp.goToCartPage();
		CartPageBB cp = new CartPageBB();
		String sony75TitleAtCartPage = cp.validateSonyTvInCart();
		softAssert(sony75TitleAtCartPage, sony75TitleAtProdPage);
		if (sony75TitleAtCartPage.equals(sony75TitleAtProdPage)) {
			reportStep("Validating Product Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Product Title - Fail", "Fail", testName);
		}
	}
}
