package pageRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(id = "continue-shopping")
	private WebElement continueshoppingbutton;

	@FindBy(id = "checkout")
	private WebElement checkoutbutton;

	@FindBy(className = "title")
	private WebElement cart;

	// intialisation
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getcontinueshoppingbutton() {

		return continueshoppingbutton;

	}

	public WebElement getcheckoutbutton() {

		return checkoutbutton;
	}

	public WebElement getcart() {
		return cart;

	}

}
