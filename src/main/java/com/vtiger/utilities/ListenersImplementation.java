package com.vtiger.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener Interface of TestNG
 * 
 * @author Yogesh Pahadiya
 *
 */
public class ListenersImplementation implements ITestListener {

	PropertyFileUtilities pUtil = new PropertyFileUtilities();
	WebDriverUtilities wUtil = new WebDriverUtilities();
	JavaUtilities jUtil = new JavaUtilities();

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();// name of the @Test method
		System.out.println(methodName + "**********Test Execution started**********");

		// @Test execution started
		test = reports.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "**********Test PASS**********");

		test.log(Status.PASS, methodName + "**********Test PASS**********");

	}

	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "**********Test FAIL**********");
		System.out.println(result.getThrowable());

		test.log(Status.FAIL, methodName + "**********Test FAIL**********");
		test.log(Status.INFO, result.getThrowable());

		String screenshotName = methodName + jUtil.getSystemDateInFormat();

		try {

			String path = wUtil.captureScreenShot(BaseClass.driver, screenshotName);

			test.addScreenCaptureFromPath(path);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "*********Test SKIP**********");
		System.out.println(result.getThrowable());

		test.log(Status.SKIP, methodName + "**********Test SKIP**********");
		test.log(Status.INFO, result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

		System.out.println("*********Suite Execution Started**********");

		// Extent Report configuration

//		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
//		String reportName = "VtigerTestReport" + timeStamp + ".html";
//		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);

		htmlReporter = new ExtentSparkReporter(
				".\\ExtentReports\\Reports-" + new JavaUtilities().getSystemDateInFormat() + ".html");
		htmlReporter.config().setDocumentTitle("Execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Vtiger Execution Report");

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("Base Browser", pUtil.getBrowser());
		reports.setSystemInfo("Base PlatForm", "Windows 11");
		reports.setSystemInfo("Base Env", "Testing");
		reports.setSystemInfo("Base URL", "http://localhost:8888");
		reports.setSystemInfo("Reporter Name", "Yogesh");

	}

	public void onFinish(ITestContext context) {

		System.out.println("**********Suite Execution Finished**********");

		// generate the report
		reports.flush();

	}

}
