package reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import configuration.Config;
import methods.Keywords;

public class ExtentReporter {

	public static ExtentHtmlReporter htmlReporter;

	public static ExtentReports extent;

	public static ExtentTest test;

	public static File reportFolder;

	public static String folderPath;

	public static int snapNO = 0;

	public static Keywords keywordActions;

	public static void extReportSetup() {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss");
			Date d = new Date();
			String strDate = df.format(d);
			folderPath = "TestReports//" + strDate;
			String filePath = folderPath + "//ExtReport.html";
			reportFolder = new File(filePath);
			reportFolder.getParentFile().mkdir();
			reportFolder.createNewFile();
			htmlReporter = new ExtentHtmlReporter(filePath);

			// create ExtentReports and attach reporter(s)
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/*
	 * public static void extReportStatusInfo(String info) {
	 * 
	 * snapNO++;
	 * 
	 * 
	 * // log(Status, details) test.log(Status.INFO,
	 * "This step shows usage of log(status, details)");
	 * 
	 * // info(details) // test.info(info);
	 * 
	 * try { // log with snapshot test.fail("details",
	 * 
	 * String snapFilePath =
	 * folderPath+"//"+Integer.toString(snapNO)+"screenshot.png"; File file = new
	 * File(snapFilePath); file.createNewFile();
	 * 
	 * MediaEntityModelProvider mediaModel =
	 * MediaEntityBuilder.createScreenCaptureFromPath("."+snapFilePath).build();
	 * test.pass(info).addScreenCaptureFromPath(snapFilePath);
	 * 
	 * //test with snapshot //test.addScreenCaptureFromPath(snapFilePath); }
	 * catch(Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * }
	 */

	public static void extReportTestDesc(String testName, String testDesc) {

		// creates a toggle for the given test, adds all log events under it
		test = extent.createTest(testName, testDesc);

	}

	public static void extReportFlusher() {
		extent.flush();
	}

	public static void testTearDown(ITestResult result) {
		//String snapFilePath = folderPath + "//screenshot.png";
		/*
		 * File file = new File(snapFilePath); try { file.createNewFile(); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName() + " : Fail");
			test.log(Status.FAIL, "Reason: "+result.getThrowable());
			//keywordActions.takeSnapShotOfStep(snapFilePath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " : Pass");
			//keywordActions.takeSnapShotOfStep(snapFilePath);
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getName() + " : Skipped");
			//keywordActions.takeSnapShotOfStep(snapFilePath);
		}
		else
		{
			test.log(Status.FAIL, result.getName()+" : Aborted");
			test.log(Status.FAIL, "Reason: "+result.getThrowable());
			//keywordActions.takeSnapShotOfStep(snapFilePath);
		}
	}
	
	public static void testLog(String desc) {
		
		test.log(Status.INFO, desc);
		
	}
	
	public static void testValidationResult(int valResult) {
		
		if (valResult == ITestResult.FAILURE) {
			test.log(Status.FAIL,"Test : Fail");
			
			//keywordActions.takeSnapShotOfStep(snapFilePath);
		}
		else if (valResult == ITestResult.SUCCESS) {
			test.log(Status.PASS,"Test : Pass");
			//test.log(Status.PASS, "Reason: "+result.getThrowable());
			//keywordActions.takeSnapShotOfStep(snapFilePath);
		}
		
		
	}

}
