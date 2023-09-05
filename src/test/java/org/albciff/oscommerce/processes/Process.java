package org.albciff.oscommerce.processes;

import org.albciff.oscommerce.screens.CatalogSearch;
import org.albciff.oscommerce.screens.DeliveryInformation;
import org.albciff.oscommerce.screens.OrderConfirmation;
import org.albciff.oscommerce.screens.OrderProcessed;
import org.albciff.oscommerce.screens.PaymentInformation;
import org.albciff.oscommerce.screens.ProductSheet;
import org.albciff.oscommerce.screens.ShoppingCart;
import org.albciff.oscommerce.screens.Signin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Process {
	
	private static final int ESPERA = 10;
	
	protected WebDriverWait wait;
	protected WebDriver driver;
	
	protected CatalogSearch catalog;
	protected ProductSheet productSheet;
	protected ShoppingCart shoppingCart;
	protected Signin signinPage;
	protected DeliveryInformation deliveryInformation;
	protected PaymentInformation paymentInformation;
	protected OrderConfirmation orderConfirmation;
	protected OrderProcessed orderProcessed;
	
	protected Process(WebDriver driver) {
		processInitialization(driver);
	}

	public abstract void executeProcess();
		
	private void processInitialization(WebDriver driver) {
		this.driver=driver;
		catalog = new CatalogSearch(driver);
		productSheet = new ProductSheet(driver);
		shoppingCart = new ShoppingCart(driver);
		signinPage = new Signin(driver);
		deliveryInformation = new DeliveryInformation(driver);
		paymentInformation = new PaymentInformation(driver);
		orderConfirmation = new OrderConfirmation(driver);
		orderProcessed = new OrderProcessed(driver);
		wait = new WebDriverWait(driver, ESPERA);
	}

}
