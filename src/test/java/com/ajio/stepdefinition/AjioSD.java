package com.ajio.stepdefinition;

import com.ajio.locator.AjioAddToBagLocator;
import com.ajio.locator.AjioGotoBagLocator;
import com.ajio.locator.AjioHomePageLocator;
import com.ajio.locator.AjioProceedPageLocator;
import com.ajio.locator.AjioServeWareLocator;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AjioSD extends AjioProceedPageLocator{
String text1=null;
String text2=null;
@Given("Open the Browser")
public void open_the_Browser() {
	browserOpen();
}
@Given("Launch the AJIO URL")
public void launch_the_AJIO_URL() {
	launchUrl("https://www.ajio.com/");
	maximizeScreen();
}

@When("MouseOver to Home and Kitchen")
public void mouseover_to_Home_and_Kitchen() {
	mouseHover(new AjioHomePageLocator().getHome());
	mouseHover(new AjioHomePageLocator().getServeware());
	clickElement(new AjioHomePageLocator().getServeware());
}

@When("MouseOver to Serveware and Drinkware")
public void mouseover_to_Serveware_and_Drinkware() throws InterruptedException {
	sleep(3000);
	jsScrollClick(new AjioServeWareLocator().getProduct());
}

@When("Choose any Product and Add it to Bag")
public void choose_any_Product_and_Add_it_to_Bag() throws InterruptedException {
	getWindowHandlesClickButton(3000, new AjioAddToBagLocator().getAddToBag());
	text1 = getText(new AjioAddToBagLocator().getNameOfProduct());
	System.out.println(text1);
	}


@When("Click Go to Bag")
public void click_Go_to_Bag() throws InterruptedException {
	sleep(3000);
    clickElement(new AjioGotoBagLocator().getGoToBag());
}

@Then("Validate the Product name")
public void validate_the_Product_name() {
	 String text2 = getText(new AjioProceedPageLocator().getProceed());
	 System.out.println(text2);
	 System.out.println(text2);
	 boolean validate = text2.contains(text1);
	 System.out.println(validate);
}


}
