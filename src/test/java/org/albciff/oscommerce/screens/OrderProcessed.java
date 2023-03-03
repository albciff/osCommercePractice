package org.albciff.oscommerce.screens;

import static org.junit.Assert.assertTrue;

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
public class OrderProcessed {
	
	private WebDriver driver;

	@FindBy(id = "bodyContent")
	private WebElement orderProcessedElement;
	
	private String orderProcessedText = "Your Order Has Been Processed!";
	
	public OrderProcessed(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void checkOrderIsProcessed(WebDriverWait wait) {
		
		// amb això ja tindriem la comprovació... pq sinó és així fallarà per TO
		wait.until(ExpectedConditions.textToBePresentInElement(orderProcessedElement,orderProcessedText));
		// anyway fem assert explicit :)
		assertTrue(orderProcessedElement.getText().contains(orderProcessedText));
		
		System.out.println("SALUT I REPUBLICA");
	
	}
	
}
