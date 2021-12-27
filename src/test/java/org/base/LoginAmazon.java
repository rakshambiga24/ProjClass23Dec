package org.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAmazon extends BaseClass {
	public LoginAmazon() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//span[@class='nav-action-inner'])[2]")
	private WebElement signin;
	@FindBy(id="ap_email")
	private WebElement username;
	@FindBy(id="continue")
	private WebElement cont;
	@FindBy(id="ap_password")
	private WebElement pwd;
	@FindBy(id="signInSubmit")
	private WebElement sigin;
	public WebElement getSignin() {
		return signin;
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getCont() {
		return cont;
	}
	public WebElement getPwd() {
		return pwd;
	}
	public WebElement getSigin() {
		return sigin;
	}
}
