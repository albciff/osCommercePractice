package org.albciff.oscommerce.screens;

import java.util.List;

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
public class PaymentInformation {

	public enum PaymentMethod {
		cod,paypal_express		
	}
	
	private WebDriver driver;

	@FindBy(id = "tdb6")
	private WebElement continueBtn;
	
	@FindBy(name = "payment")
	private List<WebElement> paymentMethodsRadioBtn;
	
 
	
	public PaymentInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void selectPaymentMethodAndContinue(WebDriverWait wait, PaymentMethod paymentMethod) {
		
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		
		WebElement paymentMethodSelected= paymentMethodsRadioBtn.stream()
											.filter(it -> it.getAttribute("value").equals(paymentMethod.toString()))
											.findFirst()
											.get();
		
		paymentMethodSelected.click();
		
		continueBtn.click();
		
	}
	
}
