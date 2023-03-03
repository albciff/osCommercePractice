package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Deprecated
public class Catalog {
	
	public WebDriver driver;

//  No és resilent... el /catalog canvia de forma aleatoria i moltes vegades no apareix l'element samsung.
//  Podem optar per diferents estrategies, per triar-ne una (podriem anar a saco via url i query parameters) però
//  per seguir una mica la idea sude la pràctica prefereixo seleccionar el finder i buscar "samsung galaxy tab"-
	
	@FindBy(xpath = "//form/input[@name='keywords']")
	private WebElement finder;
	
	@FindBy(xpath = "//img[@title='Samsung Galaxy Tab']")
	private WebElement samsungGalaxyTab;
	private final String samsungGalaxyTabFindText = "Samsung Galaxy Tab";
	
	@FindBy(xpath = "//img[@title='Beloved']")
	private WebElement beloved;
 
	
	public Catalog (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickSamsungGalaxyTab(WebDriverWait wait) {
		
		//driver.findElement(By.xpath("//form/input[name='keywords']"));

		wait.until(ExpectedConditions.elementToBeClickable(finder));
		finder.clear();
		finder.sendKeys(samsungGalaxyTabFindText);
		finder.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(samsungGalaxyTab));
		samsungGalaxyTab.click();
		
	}
	
	public void ClickBeloved(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(beloved));
		beloved.click();
	}

}
