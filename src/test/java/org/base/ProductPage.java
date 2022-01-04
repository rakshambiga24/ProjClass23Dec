package org.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseClass{
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='q']")
	private WebElement AppleWatch;
	@FindBy(xpath="//button[@class='L0Z3Pu']")
	private WebElement select;
	@FindBy(xpath="(//div[@class='_4rR01T'])[2]")
	private WebElement product;

	public WebElement getSearch() {
		return AppleWatch;
	}
	public WebElement getSelect() {
		return select;
	}
	public WebElement getProduct() {
		return product;
	}
}
