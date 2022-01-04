package org.base;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
		System.out.println("Products with price available in the first page");
		List<WebElement> search = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> rupee = driver.findElements(By.xpath("//span[@class='a-price']"));
		List<String>li=new ArrayList<String>();
		for (int i=0;i<search.size();i++) {
			String name=search.get(i).getText();
			li.add(name);
		}
		List <Integer>lp=new ArrayList<Integer>();
            for(int i=0;i<rupee.size();i++) {
			String price=rupee.get(i).getText();
			String s=price;
			String rp="";
			if (s.contains("₹")) {
				rp=s.replace("₹", "");
				System.out.println(rp);
			}
			if(rp.contains(",")) {
				rp=rp.replace(",", "");
				System.out.println(rp);
				int k=Integer.parseInt(rp);
				lp.add(k);
				System.out.println();
			}
        }
            System.out.println(li.size());
            System.out.println(lp.size());
            Map<String,Integer> mp=new LinkedHashMap<String,Integer>();
            for(int i=0;i<li.size();i++) {
            	mp.put(li.get(i), lp.get(i));
            }
            Set<Entry<String,Integer>> et=mp.entrySet();
            for(Entry<String,Integer>entry:et) {
            	System.out.println(entry);
            }
            
            Collections.sort(lp);
            System.out.println(lp);
            
            System.out.println(Collections.min(lp));
            System.out.println(Collections.max(lp));

}
}
