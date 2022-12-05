package com.ajio.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.bc.BaseClass;

public class AjioHomePageLocator extends BaseClass{
	public AjioHomePageLocator()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//*[text()='HOME AND KITCHEN']")
	private WebElement home;
	@FindBy (xpath="//*[text()='Serveware & Drinkware']")
	private WebElement serveware;
	public WebElement getHome() {
		return home;
	}
	public WebElement getServeware() {
		return serveware;
	}
}
