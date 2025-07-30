package pageRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//webelement identification and declaration
	@FindBy(id="user-name")
	private WebElement usernametextfield;
	
	
	@FindBy(id="password")
	private WebElement passwordtextfield;
	
	@FindBy(id="login-button")
	private WebElement loginbutton;
	
	@FindBy(className="login_logo")
	private WebElement loginlogo;

	
	
	//webelement intialization
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	//WebElement utilization
	public WebElement getUsernameText() {
		return usernametextfield;
	}
	public WebElement getPasswordText() {
		return passwordtextfield;
	}
	public WebElement getLoginButton() {
		return loginbutton;
	}
	public WebElement getLoginLogo() {
		return loginlogo;
	}
	

}
