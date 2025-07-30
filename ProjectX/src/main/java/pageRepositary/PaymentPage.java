package pageRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	// identification and declaration
	@FindBy(id = "finish")
	private WebElement finishbutton;

	// intializtion
	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// utilisation
	public WebElement getfinishbutton() {
		return finishbutton;
	}

}
