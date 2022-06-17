package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;

	

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	public WebElement findElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
	//Alerts

	public void acceptAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();

	}
	public void dismissAlert() {
		Alert al=driver.switchTo().alert();
		al.dismiss();	
	}
	//Prompt Alert
	public void sendKeyToAlert(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	public void moveToElement(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();;
	}

	public void doubleclick(WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void keyDown() throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	public void keyEnter() throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void keyTab() throws AWTException {

		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void keyShift() throws AWTException {

		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}

	public void sendKeysEnter(WebElement element,String attributeValue) {
		element.sendKeys(attributeValue,Keys.ENTER);	
	}

	public void getJs(WebElement element) {

		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("return arguments[0].getAttribute('value')",element);
	}

	public void clickJs(WebElement element) {

		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("argument[0].click()",element);	
	}

	public void scrollUp(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("argument[0].scrollIntoView(true)",element);	
	}

	public void scrollDown(WebElement element) {

		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("argument[0].scrollIntoView(false)",element);
	}

	public void deselectAll(WebElement element) {

		Select select=new Select(element);
		select.deselectAll();
	}

	public void deselectByIndex(WebElement element,int index) {
		Select select=new Select(element);
		select.deselectByIndex(index);
	}

	public void deselectByValue(WebElement element,String attributeValue ) {
		Select select=new Select(element);
		select.deselectByValue(attributeValue);	
	}

	public void deselectByVisibleText(WebElement element,String text) {
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}

	public void frameById(int index) {
		driver.switchTo().frame(index);
	}

	public void frameByName(String text) {
		driver.switchTo().frame(text);	
	}

	public void frameElement(WebElement element) {
		driver.switchTo().frame(element);	
	}

	public void defaultContent() {
		driver.switchTo().defaultContent();
	}

	public String parentWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public void waits() throws InterruptedException {
		Thread.sleep(20);
	}
	public void navigateForward() {
		driver.navigate().forward();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateRefresh() {
		driver.navigate().refresh();;
	}
	public void navigateUrl(String url) {
		driver.navigate().to(url);
	}









}
