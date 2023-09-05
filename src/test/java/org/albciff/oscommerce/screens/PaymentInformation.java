package org.albciff.oscommerce.screens;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

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
        CASH("cod"), PAYPAL("paypal_express");
        private String paymentMethodText;
        private PaymentMethod(String paymentMethodText) {
            this.paymentMethodText = paymentMethodText;
        }
       
        @Override
        public String toString(){
            return paymentMethodText;
        }		
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
		
		Optional<WebElement> paymentMethodSelected = paymentMethodsRadioBtn.stream()
			.filter(it -> it.getAttribute("value").equals(paymentMethod.toString()))
			.findFirst();
		
		if(paymentMethodSelected.isPresent()) {
			paymentMethodSelected.get().click();
			continueBtn.click();
		} else {
			// si arribem aqui, hem fracasat, fem doncs fallar el test
			assertTrue(false);	
		}

	}
	
}
