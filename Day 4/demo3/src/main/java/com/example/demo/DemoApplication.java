package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		WebDriver driver2 = new EdgeDriver();
		driver2.get("https://www.google.com");
		
		WebDriver driver3 = new FirefoxDriver();
		driver3.get("https://www.google.com");

		WebDriver driver4 = new InternetExplorerDriver();
		driver4.get("https://www.shoppersstop.com");

		driver.close();
		driver2.close();
		driver3.close();
		driver4.close();

		SpringApplication.run(DemoApplication.class, args);
	}

}
