package productTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseConfig;
import genericLibrary.WebDriverLibrary;
import pageRepositary.CartPage;
import pageRepositary.CheckoutPage;
import pageRepositary.HomePage;
import pageRepositary.PaymentPage;
import pageRepositary.ProductPage;
import pageRepositary.ThankyouPage;

public class TeamXTest extends BaseConfig {

	@Test(groups = "RT", priority = 1, enabled = true, invocationCount = 1, dataProvider = "checkOutInfo")
	public void Addproduct(String FirstName, String LastName, String PostalCode) throws InterruptedException {

		// wait method
		WebDriverLibrary.waitStatment();

		// addproducts
		HomePage homeobj = new HomePage(driver);

		Assert.assertTrue(homeobj.getfifthproduct().isDisplayed());
		Assert.assertTrue(homeobj.getfifthproduct().isEnabled());

		// click on 5th product
		WebDriverLibrary.elementClick(homeobj.getfifthproduct());
		Reporter.log("clicked on the element", true);
		

		// click on add to cart button
		Assert.assertTrue(homeobj.getaddtocartbutton1().isDisplayed());
		Assert.assertTrue(homeobj.getaddtocartbutton1().isEnabled());
		WebDriverLibrary.elementClick(homeobj.getaddtocartbutton1());
		Reporter.log("clicked on the add to cart Button", true);

		// click on back to products button
		Assert.assertTrue(homeobj.getbacktoproducts1().isDisplayed());
		Assert.assertTrue(homeobj.getbacktoproducts1().isEnabled());
		WebDriverLibrary.elementClick(homeobj.getbacktoproducts1());
		Reporter.log("clicked on back to products button", true);

		// click on 4th product
		WebDriverLibrary.elementClick(homeobj.getfourthproduct());
		Assert.assertTrue(homeobj.getfourthproduct().isDisplayed());
		Assert.assertTrue(homeobj.getfourthproduct().isEnabled());

		// click on add to cart button
		Assert.assertTrue(homeobj.getaddtocartbutton2().isDisplayed());
		Assert.assertTrue(homeobj.getaddtocartbutton2().isEnabled());
		WebDriverLibrary.elementClick(homeobj.getaddtocartbutton2());

		// click on back to products button
		Assert.assertTrue(homeobj.getbacktoproducts2().isDisplayed());
		Assert.assertTrue(homeobj.getbacktoproducts2().isEnabled());
		WebDriverLibrary.elementClick(homeobj.getbacktoproducts2());

		// click on 3rd product
		WebDriverLibrary.elementClick(homeobj.getthirdproduct());
		Assert.assertTrue(homeobj.getthirdproduct().isDisplayed());
		Assert.assertTrue(homeobj.getthirdproduct().isEnabled());

		// click on add to cart button
		Assert.assertTrue(homeobj.getaddtocartbutton3().isDisplayed());
		Assert.assertTrue(homeobj.getaddtocartbutton3().isEnabled());
		WebDriverLibrary.elementClick(homeobj.getaddtocartbutton3());

		// click on back to products button
		Assert.assertTrue(homeobj.getbacktoproducts2().isDisplayed());
		Assert.assertTrue(homeobj.getbacktoproducts2().isEnabled());
		WebDriverLibrary.elementClick(homeobj.getbacktoproducts2());

		String product = homeobj.getproducts().getText();
		System.out.println(product);
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		Thread.sleep(5000);

		// create productpage object
		ProductPage productpageobj = new ProductPage(driver);

		Assert.assertTrue(productpageobj.getcarticon().isDisplayed());
		Assert.assertTrue(productpageobj.getcarticon().isEnabled());
		WebDriverLibrary.elementClick(productpageobj.getcarticon());

		// create cartpage object
		CartPage cartpageobj = new CartPage(driver);

		Assert.assertTrue(cartpageobj.getcheckoutbutton().isDisplayed());
		Assert.assertTrue(cartpageobj.getcheckoutbutton().isEnabled());
		WebDriverLibrary.elementClick(cartpageobj.getcheckoutbutton());

		String cart = cartpageobj.getcart().getText();
		System.out.println(cart);
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		// create checkoutpage object
		CheckoutPage ckobj = new CheckoutPage(driver);

		ckobj.getfirstname().sendKeys(FirstName);
		ckobj.getlastname().sendKeys(LastName);
		ckobj.getpostalcode().sendKeys(PostalCode);

		Assert.assertTrue(ckobj.getcontinuebutton().isDisplayed());
		Assert.assertTrue(ckobj.getcontinuebutton().isEnabled());
		WebDriverLibrary.elementClick(ckobj.getcontinuebutton());

		String CheckoutYourInformation = ckobj.getCheckoutYourInformation().getText();
		System.out.println(CheckoutYourInformation);
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		// create paymentpage object
		PaymentPage paymentpageobj = new PaymentPage(driver);

		Assert.assertTrue(paymentpageobj.getfinishbutton().isDisplayed());
		Assert.assertTrue(paymentpageobj.getfinishbutton().isEnabled());
		WebDriverLibrary.elementClick(paymentpageobj.getfinishbutton());
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		// create thankyou object
		ThankyouPage thankyouobj = new ThankyouPage(driver);
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		Assert.assertTrue(thankyouobj.getbackhomebutton().isDisplayed());
		Assert.assertTrue(thankyouobj.getbackhomebutton().isEnabled());
		WebDriverLibrary.elementClick(thankyouobj.getbackhomebutton());
	}
}
