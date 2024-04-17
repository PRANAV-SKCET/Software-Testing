package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.joran.action.Action;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		try
		{
			WebDriver driver = new ChromeDriver();
			Actions actions = new Actions(driver);

			// driver.get("https://economictimes.indiatimes.com/et-now/results");
			// Thread.sleep(20000);
			// driver.findElement(By.xpath("//*[@id='topnav']/div[10]/a")).click();

			driver.get("https://economictimes.indiatimes.com/mutual-funds");
			Thread.sleep(30000);
			WebElement first = driver.findElement(By.id("amcSelection"));
			actions.scrollToElement(first).perform();
			first.click();
			Thread.sleep(5000);
			Select select = new Select(first);
			select.selectByIndex(9);
			// driver.findElement(By.xpath("//*[@id='amcSelection']/option[10]")).click();

			Thread.sleep(10000);
			WebElement second = driver.findElement(By.id("schemenm"));
			second.click();
			Thread.sleep(5000);
			Select select2 = new Select(second);
			select2.selectByIndex(5);
			driver.findElement(By.id("getDetails")).click();

			SpringApplication.run(DemoApplication.class, args);
		}
		catch(Exception e)
		{

		}
	}

}
