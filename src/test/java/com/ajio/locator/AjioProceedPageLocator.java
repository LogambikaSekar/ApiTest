package com.ajio.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjioProceedPageLocator extends AjioGotoBagLocator{
	
	public AjioProceedPageLocator()
	{
		PageFactory.initElements(driver, this);
	}
//	@FindBy (xpath="(//*[@href=\"/noritake-floral-print-lodi-s-morning-mug/p/463814483001\"])[2]")
	@FindBy (xpath = "//*[@class='product-name']")
//	@FindBy (xpath="//*[@id=\"dCartWrapper\"]/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[1]/a/text()")
	private WebElement proceed;
	public WebElement getProceed() {
		return proceed;
	}
}
