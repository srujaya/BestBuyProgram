package TestCaseBB;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import BaseBB.BaseBestBuy;
import PagesBB.CreatAccountPageBB;
import PagesBB.HomePageBB;
import PagesBB.LocationPageBB;

public class TC_03_SignUpAndLogin extends BaseBestBuy {
	
	@BeforeTest
	public void setup() {
		testName = "tc_03_SignUpAndLogin";
		testDescription = "SignUpAndLogin Functionality";
		testCategory = "Regression";
		testAuthor = "Sruthi";
		sheetName="loginTestData";
	}
	
	@Test(dataProvider="getFromExcel", priority=3)
	public void tc_03_validateCreatAccountFunctionality(String fname, String lname, String emailId,
			String pass, String repass, String mob, String xpathText, String expMsg) throws Exception {
		LocationPageBB lp=new LocationPageBB();
		lp.deliveryAtUSA();
		HomePageBB hp=new HomePageBB();
		hp.goToCreatAccount();
		CreatAccountPageBB ca=new CreatAccountPageBB();
		String actMsg = ca.creatAccountFunctionality(fname, lname, emailId, pass, repass, mob, xpathText);
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			reportStep("Validating CreatAccount Functionality - Pass", "Pass", testName);
		} else {
			reportStep("Validating CreatAccount Functionality - Fail", "Fail", testName);
		}
	}
}