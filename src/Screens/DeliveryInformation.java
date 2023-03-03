package Screens;

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
public class DeliveryInformation {

	public WebDriver driver;

	@FindBy(id = "tdb6")
	private WebElement continueBtn;
	
 
	
	public DeliveryInformation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void continueToPaymentInformation(WebDriverWait wait) {
		
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		continueBtn.click();
		
	}
	
}
