package genericLibrary;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageRepositary.LoginPage;
import pageRepositary.LogoutPage;

public class BaseConfig {

	public static WebDriver staticdriver;
	public WebDriver driver;
	public SoftAssert saobj;
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public ExtentTest test;

	@BeforeTest
	public void ReportSetUp() {

		// create the SparkReport
		 spark = new ExtentSparkReporter("./AdvanceReports/report/html");

		// configure the sparkReport Information
		spark.config().setDocumentTitle("Regression Testing for Swag Labs");
		spark.config().setReportName("RegressionSuite");
		spark.config().setTheme(Theme.STANDARD);

		// create the Extent Report
		report = new ExtentReports();

		// Attach the SparkReport and ExtentReport
		report.attachReporter(spark);

		// Configure the System Information in Extent Report
		report.setSystemInfo("DeviceName", "manohar");
		report.setSystemInfo("OperatingSystem", "Windows 11");
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("BrowserVersion", "");
	}

	@AfterTest
	public void ReportTerminate() {

		// flush the report information
		report.flush();
	}

	@Parameters("browsername")
	@BeforeClass
	public void Browsersetup() {

		String browser = "chrome";
		saobj = new SoftAssert();

		// open the browser
		driver = WebDriverLibrary.openBrowser(browser);

		// maximize
		WebDriverLibrary.maximizeBrowser();

		// Wait statement
		WebDriverLibrary.waitStatment();

		// navigate to the application
		WebDriverLibrary.navToApp(PropertiesLibrary.fetchData("url"));

		// verify the page
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		Reporter.log("browser set up done", true);
	}

	@BeforeMethod
	public void login() throws InterruptedException {

		// Wait statement
		WebDriverLibrary.waitStatment();

		// create an object for login page
		LoginPage loginobj = new LoginPage(driver);

		// validate the username textfiled
		Assert.assertTrue(loginobj.getUsernameText().isDisplayed());

		// enter the username in the username textfield
		WebDriverLibrary.enterData(loginobj.getUsernameText(), PropertiesLibrary.fetchData("username"));
		System.out.println(" username entered successfully");

		// validate the password textfiled
		Assert.assertTrue(loginobj.getPasswordText().isDisplayed());

		// enter the password in the password textfield
		WebDriverLibrary.enterData(loginobj.getPasswordText(), PropertiesLibrary.fetchData("password"));
		System.out.println("password entered successfully");

		// validate login
		Assert.assertTrue(loginobj.getLoginButton().isDisplayed());
		// click on login
		WebDriverLibrary.elementClick(loginobj.getLoginButton());

		Thread.sleep(4000);

	}

	@AfterMethod
	public void logout() {

		// Wait statement
		WebDriverLibrary.waitStatment();

		// create logout object
		LogoutPage lgobj = new LogoutPage(driver);

		// click on menubar
		WebDriverLibrary.elementClick(lgobj.getMenu());

		// validate the logoutlink
		Assert.assertTrue(lgobj.getlogoutbutton().isEnabled());
		saobj.assertEquals(lgobj.getlogoutbutton().isDisplayed(), true);
		// click on login button
		WebDriverLibrary.elementClick(lgobj.getlogoutbutton());

		Reporter.log("logout", true);
	}

	@AfterClass
	public void BrowserTerminate() {
		// close the browser
		WebDriverLibrary.closeWindow();

		Reporter.log("browser terminate done", true);

	}

	@DataProvider
	public Object[][] checkOutInfo() {
		Object[][] data = new Object[1][3];
		data[0][0] = ExcelLibrary.readSingleData("CheckOut_Details", 1, 0);
		data[0][1] = ExcelLibrary.readSingleData("CheckOut_Details", 1, 1);
		data[0][2] = ExcelLibrary.readSingleData("CheckOut_Details", 1, 2);

		return data;
	}
}
