package org.albciff.oscommerce.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogSearch {
	
	private WebDriver driver;

//  No és resilent... el /catalog canvia de forma aleatoria i moltes vegades no apareix l'element samsung.
//  Podem optar per diferents estrategies, per triar-ne una (podriem anar a saco via url i query parameters) però
//  per seguir una mica la idea de la pràctica prefereixo seleccionar el finder i buscar "samsung galaxy tab"-
	
	@FindBy(xpath = "//form/input[@name='keywords']")
	private WebElement finder;
	
	@FindBy(xpath = "//input[@title=' Quick Find ']")
	private WebElement finderBtn;
 
	
	public CatalogSearch (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void findAndSelect(WebDriverWait wait, String elementText) {
		
		wait.until(ExpectedConditions.elementToBeClickable(finder));
		finder.clear();
		finder.sendKeys(elementText);
		// finder.click(); el click sobre el finder falla en algunes execucions
		finderBtn.click();
		
		String selectedElementXpath = "//img[@title='" + elementText + "']";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectedElementXpath)));
		WebElement elementToSelect = driver.findElement(By.xpath(selectedElementXpath));
		elementToSelect.click();
	}
	
}
