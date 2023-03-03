package org.albciff.oscommerce.processes;

import org.albciff.oscommerce.screens.PaymentInformation.PaymentMethod;
import org.openqa.selenium.WebDriver;

public class PurchaseProcess extends Process {

	private String url;
	private String product;
	private int quantity;
	private PaymentMethod paymentMethod;
	
	public PurchaseProcess(WebDriver driver, String url, String product, int quantity, PaymentMethod paymentMethod) {
		super(driver);
		this.url = url;
		this.product = product;
		this.quantity = quantity;
		this.paymentMethod = paymentMethod;
		
	}
		
	private void enterSite (String url) {
		driver.get(url);
	}
	
	private void selectProduct(String product) {
		catalog.findAndSelect(wait, product);
	}
	
	private void addProductToCard() {
		productSheet.addProductToCart(wait);
	}
	
	private void pruchaseProduct(int quantity) {
		shoppingCart.purchaseSpecificQuantity(wait, quantity);
	}
	
	private void signin() {
		signinPage.signin(wait);
	}
	
	private void deliveryInformation() {
		deliveryInformation.continueToPaymentInformation(wait);
	}
	 
	private void paymentByMethod(PaymentMethod paymentMethod) {
		paymentInformation.selectPaymentMethodAndContinue(wait,paymentMethod );
	}

	private void confirmOrder() {
		orderConfirmation.confirmOrder(wait);
	}
	
	private void checkOrderProcessed() {
		orderProcessed.checkOrderIsProcessed(wait);
	}


	@Override
	public void executeProcess() {
		enterSite(url);
		selectProduct(product);
		addProductToCard();
		pruchaseProduct(quantity);
		signin();
		deliveryInformation();
		paymentByMethod(paymentMethod); // passar com a variable del purchase ?? 
		confirmOrder();
		checkOrderProcessed();
	}

}
