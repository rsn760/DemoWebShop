package commonLib;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentListener implements ITestListener {
	ExtentSparkReporter reporter;
	ExtentReports report;
	private static ThreadLocal<ExtentTest> eTest = new ThreadLocal<ExtentTest>();
	String root = System.getProperty("user.dir");
	
	@Override
	public void onStart(ITestContext context) {
		String extent_file_name = "selenium_test_reports/extent_test_report_"
				+ new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS").format(new Date()) + ".html";
		
		// @ start repoter
		reporter = new ExtentSparkReporter(extent_file_name);
		// @ repoter config
		reporter.config().setReportName("Selenium Test report");
		reporter.config().setDocumentTitle("Automation report");
		reporter.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(reporter);

		// @ system details
		report.setSystemInfo("User", System.getProperty("user.name"));
		report.setSystemInfo("OS Name", System.getProperty("os.name"));
		report.setSystemInfo("Java version", System.getProperty("java.version"));
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String browserName = Utilities.get_browser_details().get("browserName");
		String testName = (result.getParameters().length > 0 ? " - " + Arrays.toString(result.getParameters()) : "");
		
		ExtentTest extent_test = report.createTest(browserName +"-> "+testName);
		eTest.set(extent_test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			String ss_path = root+"/screenshots/ss" + result.getName() + "_"
					+ new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS").format(new Date()) + ".png";
			eTest.get().pass("PASSED: "+ result.getName()).addScreenCaptureFromPath(Utilities.take_screenshot(ss_path));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			String ss_path = root+"/screenshots/ss" + result.getName() + "_"
					+ new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS").format(new Date()) + ".png";
			eTest.get().fail("FAILED: "+ result.getName());
			eTest.get().log(Status.FAIL, result.getThrowable()).addScreenCaptureFromPath(Utilities.take_screenshot(ss_path));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		try {
			String ss_path = root+"/screenshots/ss" + result.getName() + "_"
					+ new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS").format(new Date()) + ".png";
			eTest.get().skip("SKIPPED: "+ result.getName()).addScreenCaptureFromPath(Utilities.take_screenshot(ss_path));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ExtentTest eTest() {
		return eTest.get();
	}
	
}