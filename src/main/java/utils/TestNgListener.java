package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.internal.IResultListener;

public class TestNgListener implements IResultListener {

	@Override
	public void onTestStart(ITestResult result) {
		Log.info("++++++++++++++++++++++++++++++++++++++++");
		Log.info("Started test case :" + result.getMethod().getMethodName());
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("Start time :" + timeStamp);
		Log.info("++++++++++++++++++++++++++++++++++++++++");

	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("++++++++++++++++++++++++++++++++++++++++");
		Log.info("Passed test case :" + result.getMethod().getMethodName());
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("End time :" + timeStamp);
		Log.info("++++++++++++++++++++++++++++++++++++++++");	
		}

	@Override
	public void onTestFailure(ITestResult result) {
		Log.error("+++++++++++++++++++++++++++++++++++++++++");
		Log.error("Failed test case :" + result.getMethod().getMethodName());
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.error("Failed time :" + timeStamp);
		Log.error(result.getThrowable());
		Log.error("+++++++++++++++++++++++++++++++++++++++++");

	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Log.info("++++++++++++++++++++++++++++++++++++++++");
		Log.info("Skipped test case :" + result.getMethod().getMethodName());
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("Skip time :" + timeStamp);
		Log.info("++++++++++++++++++++++++++++++++++++++++");		}


	
}
