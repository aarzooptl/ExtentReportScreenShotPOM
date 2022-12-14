package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReporterNg {

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"//reports//extent-index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("web automation");
		reporter.config().setDocumentTitle("Tests");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Hello");
		return extent;
	}
}
