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
public class ProductSheet {

	public WebDriver driver;

	@FindBy(id = "tdb4")
	private WebElement addToCartBtn;
 
	
	public ProductSheet(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToCart(WebDriverWait wait) {
		
		//driver.findElement(By.xpath("//form/input[name='keywords']"));

		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
		addToCartBtn.click();
		
	}
	
}
