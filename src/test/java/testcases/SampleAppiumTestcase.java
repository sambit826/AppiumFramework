package testcases;

import org.testng.annotations.Test;

import base.BaseTest;

public class SampleAppiumTestcase extends BaseTest{
	
	@Test
	public void sampleTestcaseRun() {
		System.out.println(driver.getClass().descriptorString());
	}

}
