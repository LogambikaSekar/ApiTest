package com.ajio.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjioServeWareLocator extends AjioHomePageLocator{
	
	public AjioServeWareLocator()
	{
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy (xpath="(//*[@class='brand'])[2]")
//	private WebElement name;
	@FindBy (xpath="(//*[@class='rilrtl-lazy-img  rilrtl-lazy-img-loaded'])[2]")
//	@FindBy (xpath="//*[text()='Glass Water Bottle with Pouch']")
	private WebElement product;
	
//	public WebElement getName() {
//		return name;
//	}

	public WebElement getProduct() {
		return product;
	}
	
}
