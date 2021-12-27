package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	// 1.chromeLaunch
	public static void chromeLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// 2.edgeLaunch
	public static void edgeLaunch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	// 3.firefoxLaunch
	public static void firefoxLaunch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	// 4.urlLaunch
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	// 5.impWait
	public static void impWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	// 6.getTitle
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 7.getCurrentUrl
	public static String getCurrentUrl() {
		String title = driver.getCurrentUrl();
		return title;

	}

	// 8.quit
	public static void quit() {
		driver.quit();
	}

	// 9.sendKeys
	public static void sendKeys(WebElement e,String data) {
		e.sendKeys(data);
	}

	// 10.click
	public static void click(WebElement e) {
		e.click();
	}

	// 11.getText
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}

	// 12.getAttribute
	public static String getAttribute(WebElement e) {
		String text = e.getAttribute("value");
		return text;
	}

	// 13.dragAndDrop
	public static void dragAndDrop(WebElement from, WebElement to) {
		Actions a = new Actions(driver);
		a.dragAndDrop(from, to).perform();
	}

	// 14.moveToElement
	public static void moveToElement(WebElement to) {
		Actions a = new Actions(driver);
		a.moveToElement(to).perform();
	}

	// 15.contextClick
	public static void contextClick(WebElement text) {
		Actions a = new Actions(driver);
		a.contextClick(text).perform();
	}

	// 16.doubleClick
	public static void doubleClick(WebElement text) {
		Actions a = new Actions(driver);
		a.doubleClick(text).perform();
	}

	// 17.moveToMany
	private void movetoMany(WebElement target1, WebElement target2, WebElement target3) {
		Actions a = new Actions(driver);
		a.moveToElement(target1).moveToElement(target2).click(target3).build().perform();
	}

	// 18.clickAndHold
	public static void clickAndHold(WebElement target, WebElement target1) {
		Actions a = new Actions(driver);
		a.clickAndHold(target).release(target1).perform();
	}

	// 19.copyKeyboard
	public static void copy() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
	}

	// 20.cutKeyboard
	public static void cut() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_X);
	}

	// 21.pasteKeyboard
	public static void paste() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
	}

	// 22.EnterKeyboard
	public static void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	// 23.DownKeyboard
	public static void down() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	// 24.alert
	public static void alert() {
		Alert first = driver.switchTo().alert();
	}

	// 25.selectByIndex
	public static void select(WebElement drp, int index) {
		Select s = new Select(drp);
		s.selectByIndex(index);
	}

	// 26.selectByValue
	public static void select1(WebElement drp, String data) {
		Select s = new Select(drp);
		s.selectByValue(data);
	}

	// 26.selectByVisibleText
	public static void select2(WebElement drp, String data) {
		Select s = new Select(drp);
		s.selectByVisibleText(data);
	}

	// 27.isMultiple
	public static boolean isMultiple(WebElement drp) {
		Select s = new Select(drp);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	// 28.getFirstSelectedOption
	public static String getFirstSelectedOption(WebElement drp) {
		Select s = new Select(drp);
		WebElement e = s.getFirstSelectedOption();
		String text = e.getText();
		return text;
	}

	// 29.deselectAll
	public static void deselectAll(WebElement drp) {
		Select s = new Select(drp);
		s.deselectAll();
	}

	// 30.deselectByIndex
	public static void deselectByIndex(WebElement drp, int index) {
		Select s = new Select(drp);
		s.deselectByIndex(index);
	}

	// 31.deselectByValue
	public static void deselectByValue(WebElement drp, String text) {
		Select s = new Select(drp);
		s.deselectByValue(text);
	}

	// 32.deselectByVisibleText
	public static void deselectByVisibleText(WebElement drp, String text) {
		Select s = new Select(drp);
		s.deselectByVisibleText(text);
	}

	// 33.screenShot
	public static void screenShot(String file) throws IOException, InterruptedException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File from = tk.getScreenshotAs(OutputType.FILE);
		Thread.sleep(1000);
		File to = new File("D:\\MavenDec\\ScreenShot\\" + file + ".png");
		FileUtils.copyFile(from, to);
	}

	// 34.javaScript
	public static void javaScriptinsert(WebElement e,String a) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','a')", e);
	}

	// 35.javaclick
	public static void javaclick(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e); 
	}

	// 36.ScrollDown
	public static void scrolldown(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView('true')", e);
	}

	// 37.ScrollUp
	public static void scrollup(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView('false')", e);
	}

	// 38.printText
	public static String printText(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object text = js.executeScript("return arguments[0].getAttribute('value')", e);
		String d = text.toString();
		return d;
	}

	// 39.frameIndex
	public static void frameIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 40.frameid
	public static void frameid(String Name) {
		driver.switchTo().frame(Name);
	}

	// 41.framename
	public static void framename(String Name) {
		driver.switchTo().frame(Name);
	}

	// 42.parentframe
	public static void parentframe() {
		driver.switchTo().parentFrame();
	}

	// 43.windowhandling
	public static void windowhandling() {
		String oneid = driver.getWindowHandle();
	//44.allwindowid
		Set<String> allid = driver.getWindowHandles();
		List<String>li=new ArrayList<String>();
		li.addAll(allid);
		driver.switchTo().window(li.get(1));
	}

	


}


