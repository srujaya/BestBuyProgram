package TestCaseBB;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import BaseBB.BaseBestBuy;
import PagesBB.CartPageBB;
import PagesBB.HomePageBB;
import PagesBB.LocationPageBB;
import PagesBB.ProductPageBB;

public class TC_08_SelAddItemShopByBrandMenu extends BaseBestBuy {

	@BeforeTest
	public void setup() {

		testName = "tc_08_selAddItemShopByBrandMenu";
		testDescription = "Search a Item by Brands in Menu and add it in cart";
		testCategory = "Regression";
		testAuthor = "Sruthi";
	}

	@Test(priority=9)
	public void tc_08_selAddItemShopByBrandMenu() throws Exception {
		LocationPageBB lp = new LocationPageBB();
		lp.deliveryAtUSA();
		HomePageBB hp = new HomePageBB();
		hp.selectLenovoBrand();
		ProductPageBB pp = new ProductPageBB();
		String lenovoThinkPadTitleAtProdPage = pp.addLenovoThinkPadInProdPage();
		hp.goToCartPage();
		CartPageBB cp = new CartPageBB();
		String lenovoThinkPadTitleAtCartPage = cp.validateLenovoThinkPadInCart();
		softAssert(lenovoThinkPadTitleAtCartPage, lenovoThinkPadTitleAtProdPage);
		if (lenovoThinkPadTitleAtCartPage.equals(lenovoThinkPadTitleAtProdPage)) {
			reportStep("Validating Product Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Product Title - Fail", "Fail", testName);
		}
	}
}