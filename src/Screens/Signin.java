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
public class Signin {

	public WebDriver driver;

	@FindBy(name = "email_address")
	private WebElement emailAdressInput;
	
	@FindBy(name = "password")
	private WebElement passwordInput;
	
	@FindBy(id = "tdb1")
	private WebElement signinBtn;
	
	
	public Signin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void signin(WebDriverWait wait) {
		
		wait.until(ExpectedConditions.elementToBeClickable(signinBtn));

		// omplim les credencials i fem login
		emailAdressInput.sendKeys("albert.ciffone@gmail.com");
		passwordInput.sendKeys("albert_oscommerce");
		signinBtn.click();
		
	}
	
}
