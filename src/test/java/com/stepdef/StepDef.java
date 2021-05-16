package com.stepdef;

import java.io.IOException;

import org.base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef extends Baseclass {
	@Given("User is on Amazon site")
	public void userIsOnAmazonSite() throws IOException {
		Sendkeys(driver.findElement(By.id("twotabsearchtextbox")),
				getDatafromExcel("F:\\Flipkart\\excel\\amazon.xlsx", "Sheet1", 0, 1) + Keys.ENTER);

	}

	@When("User enters an product name in the search text box and press enter key")
	public void userEntersAnProductNameInTheSearchTextBoxAndPressEnterKey() {
		WebElement riceflourbtnclick = driver.findElement(
				By.xpath("(//span[text()='Eastern Jackfruit365 Green Jackfruit Flour - 400g (2 Packs of 200g)'])[2]"));
		btnclick(riceflourbtnclick);

	}

	@When("Add the product to the cart")
	public void addTheProductToTheCart() {
		WebElement addToCartBtnClick = driver.findElement(By.id("add-to-cart-button"));
		btnclick(addToCartBtnClick);

	}

	@When("Go the cart select the product")
	public void goTheCartSelectTheProduct() {
		WebElement cartBtn = driver.findElement(By.id("hlb-view-cart-announce"));
		btnclick(cartBtn);
	}

	@Then("User should remove or delete the product from the cart")
	public void userShouldRemoveOrDeleteTheProductFromTheCart() {
		WebElement deleteBtnClick = driver.findElement(By.xpath("(//input[@type='submit'])[3]"));
		btnclick(deleteBtnClick);
	}
}