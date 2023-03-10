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
public class Signin {

	private WebDriver driver;

	@FindBy(name = "email_address")
	private WebElement emailAdressInput;
	
	@FindBy(name = "password")
	private WebElement passwordInput;
	
	@FindBy(id = "tdb1")
	private WebElement signinBtn;
	
	
	public Signin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void signin(WebDriverWait wait, String userEmail, String userPwd) {
		
		wait.until(ExpectedConditions.elementToBeClickable(signinBtn));

		// omplim les credencials i fem login
		emailAdressInput.sendKeys(userEmail);
		passwordInput.sendKeys(userPwd);
		signinBtn.click();
		
	}
	
}
