package org.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BaseClass{
	public LoginPage() {           
		PageFactory.initElements(driver, this);}
@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
private WebElement mobno;
@FindBy(xpath="//input[@type='password']")
private WebElement password;
@FindBy(xpath="(//button[@type='submit'])[2]")
private WebElement login;
public WebElement getMobno() {
	return mobno;
}
public WebElement getPassword() {
	return password;
}
public WebElement getLogin() {
	return login;
}

}
