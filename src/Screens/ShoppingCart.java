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
public class ShoppingCart {

	public WebDriver driver;

	@FindBy(name = "cart_quantity[]")
	private WebElement quantityInput;
	
	@FindBy(id = "tdb4")
	private WebElement updateQuantityBtn;
	
	@FindBy(id = "tdb5")
	private WebElement checkoutBtn;
	
 
	
	public ShoppingCart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void purchaseSpecificQuantity(WebDriverWait wait, int quantity) {
		
		wait.until(ExpectedConditions.elementToBeClickable(updateQuantityBtn));

		// netejem l'input i insertem la quantitat
		quantityInput.clear();
		quantityInput.sendKeys(String.valueOf(quantity));

		// afegim i fem el checkout del producte
		updateQuantityBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
		checkoutBtn.click();
		
	}
	
}
