package Demo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LearningAdvanceReport {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create the SparkReport
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report/html");

		// configure the sparkReport Information
		spark.config().setDocumentTitle("Regression Testing for Swag Labs");
		spark.config().setReportName("RegressionSuite");
		spark.config().setTheme(Theme.STANDARD);

		// create the Extent Report
		ExtentReports report = new ExtentReports();

		// Attach the SparkReport and ExtentReport
		report.attachReporter(spark);

		// Configure the System Information in Extent Report
		report.setSystemInfo("DeviceName", "manohar");
		report.setSystemInfo("OperatingSystem", "Windows 11");
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("BrowserVersion", "");

		// flush the report information
		report.flush();

		System.out.println("Execution Done");

	}

}
