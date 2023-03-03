package org.albciff.oscommerce.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author aciffone
 *
 */
public class OrderConfirmation {
	
	public WebDriver driver;

	@FindBy(id = "tdb5")
	private WebElement confirmOrderBtn;
	
	public OrderConfirmation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void confirmOrder(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn));		
		confirmOrderBtn.click();		
	}
	
}
