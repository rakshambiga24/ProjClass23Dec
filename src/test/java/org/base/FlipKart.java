package org.base;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlipKart extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
		chromeLaunch();	
urlLaunch("https://www.flipkart.com/");
Thread.sleep(1000);
System.out.println(getTitle());
System.out.println(getCurrentUrl());
LoginPage f=new LoginPage();
sendKeys(f.getMobno(),"9442489448");
sendKeys(f.getPassword(),"A@123456");
click(f.getLogin());
ProductPage p=new ProductPage ();
Thread.sleep(1000);
sendKeys(p.getSearch(),"AppleWatch");
javaclick(p.getSelect());
List<WebElement> product = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
//List<WebElement> rupee = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
for(int i=0;i<22;i++) {
	System.out.println(product.get(i).getText());
}
//for(int j=1;j<rupee.size();j++) {
	//System.out.println(rupee.get(j).getText());
//}
	
}
}
