package org.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day1 extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		chromeLaunch();
		urlLaunch("https://www.amazon.in/");
		impWait(10);
		System.out.println(getTitle());
		System.out.println(getCurrentUrl());
		LoginAmazon l=new LoginAmazon();
		click(l.getSignin());
		sendKeys(l.getUsername(), "meenashe1969@gmail.com");
		click(l.getCont());
		sendKeys(l.getPwd(), "Sastha@06");
		click(l.getSigin());
		Thread.sleep(10);
			
		WebElement insert = driver.findElement(By.id("twotabsearchtextbox"));
		sendKeys(insert, "fridge");
		WebElement sel = driver.findElement(By.id("nav-search-submit-button"));
		click(sel);
		List<WebElement> search = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        			for(int i=0;i<search.size();i++) {
		  				System.out.println(search.get(i).getText());
			}
        			
		List<WebElement> rupee = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		for (int j=0;j<rupee.size();j++) {
			System.out.println(rupee.get(j).getText());
		}
        
        
		WebElement scr = driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base s-line-clamp-2'])[1]"));
		scrolldown(scr);
        }

}
