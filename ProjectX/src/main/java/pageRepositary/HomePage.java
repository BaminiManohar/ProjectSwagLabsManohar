package pageRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "//div[text()='Sauce Labs Onesie']")
	private WebElement fifthproduct;

	@FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']")
	private WebElement fourthproduct;

	@FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
	private WebElement thirdproduct;

	@FindBy(id = "add-to-cart")

	private WebElement addtocartbutton1;
	@FindBy(id = "add-to-cart")

	private WebElement addtocartbutton2;
	@FindBy(id = "add-to-cart")

	private WebElement addtocartbutton3;

	@FindBy(id = "back-to-products")

	private WebElement backtoproducts1;
	@FindBy(id = "back-to-products")

	private WebElement backtoproducts2;

	@FindBy(className = "title")
	private WebElement Products;

	// webelement intialization
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// WebElement utilization

	public WebElement getfifthproduct() {
		return fifthproduct;
	}

	public WebElement getfourthproduct() {
		return fourthproduct;
	}

	public WebElement getthirdproduct() {
		return thirdproduct;
	}

	public WebElement getaddtocartbutton1() {
		return addtocartbutton1;
	}

	public WebElement getaddtocartbutton2() {
		return addtocartbutton2;
	}

	public WebElement getaddtocartbutton3() {
		return addtocartbutton3;
	}

	public WebElement getbacktoproducts1() {
		return backtoproducts1;
	}

	public WebElement getbacktoproducts2() {
		return backtoproducts2;

	}

	public WebElement getproducts() {
		return Products;
	}

}
