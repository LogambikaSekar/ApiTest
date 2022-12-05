package com.ajio.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjioGotoBagLocator extends AjioAddToBagLocator{
	
	public AjioGotoBagLocator()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//*[text()='GO TO BAG']")
	private WebElement goToBag;
	public WebElement getGoToBag() {
		return goToBag;
	}
}
