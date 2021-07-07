package June10;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoReport {
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void  setup() {
		//generate reports
		reports=new ExtentReports("./Report/Demo.html");
		
	}
	@Test
	public void passtest() {
		test=reports.startTest("test case pass");
		test.assignAuthor("vasu");
		test.log(LogStatus.PASS, "my test pass");
	}
	@Test
	public void failtest() {
		test=reports.startTest("test case fail");
		test.assignAuthor("vasu");
		test.log(LogStatus.FAIL, "my test fail");
	}
	@Test
	public void skiptest() {
		test=reports.startTest("test case skip");
		test.assignAuthor("vasu");
		test.log(LogStatus.SKIP, "my test skip");
	}
	@AfterTest
	public void teardown() {
		reports.endTest(test);
		reports.flush();
	}

}
