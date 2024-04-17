package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		try
		{
			WebDriver driver = new ChromeDriver();

			driver.get("https://demo.automationtesting.in/Frames.html");
			Thread.sleep(5000);
			WebElement frame1 = driver.findElement(By.id("singleframe"));
			driver.switchTo().frame(frame1);
			driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Hello");
			Thread.sleep(4000);

			driver.switchTo().defaultContent();
			
			driver.switchTo().frame(frame1);
			driver.findElement(By.xpath("/html/body/section/div/div/div/input")).clear();
			driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("How are u");
			
			driver.switchTo().defaultContent();


			
		
		}
		catch(Exception e)
		{

		}
	}

}
