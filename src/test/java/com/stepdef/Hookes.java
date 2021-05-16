package com.stepdef;

import java.util.concurrent.TimeUnit;

import org.base.Baseclass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hookes extends Baseclass {
	@Before
	public void beforeScenario() {
		getDriver();
		loadUrl("https://www.amazon.in/");
		max();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	}

	@After
	public void afterScenerio() {

		driver.quit();

	}

}
