package com.ajio.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjioAddToBagLocator extends AjioServeWareLocator{
	public AjioAddToBagLocator()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//*[@class='prod-name']")
	private WebElement nameOfProduct;
	@FindBy (xpath="//*[text()='ADD TO BAG']")
	private WebElement addToBag;
	public WebElement getAddToBag() {
		return addToBag;
	}
	public WebElement getNameOfProduct() {
		return nameOfProduct;
	}
	
}
