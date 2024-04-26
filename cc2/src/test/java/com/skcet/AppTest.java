package com.skcet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    WebDriver driver;
    ExtentReports extent;
    ExtentSparkReporter spark;
    String keyWord;
    Logger log;


    @BeforeMethod
    public void BeforeMethodMethod() throws IOException
    {
        FileInputStream file = new FileInputStream("D:\\Software Testing\\cc2\\src\\ExcelSheet\\myExcelSheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        keyWord = row.getCell(0).getStringCellValue();
        workbook.close();
    }

    @BeforeTest
    public void beforeTestMethod() throws InterruptedException
    {

        log = LogManager.getLogger(getClass());
        driver=new ChromeDriver();

        extent = new ExtentReports();
        spark = new ExtentSparkReporter("D:\\Software Testing\\cc2\\src\\Reports\\reports.html");
        extent.attachReporter(spark);

        spark.config().setDocumentTitle("CC2 Report");
        spark.config().setTheme(Theme.DARK);
      
    }
    
    @Test
    public void testMethod1() throws InterruptedException
    {
        driver.get("https://www.barnesandnoble.com");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/a")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[2]/div/input[1]")).sendKeys(keyWord);
        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/span/button")).click();
        Thread.sleep(5000);

        String name = driver.findElement(By.xpath("//*[@id=\"searchGrid\"]/div/section[1]/section[1]/div/div[1]/div[1]/h1")).getText();
        if(name.contains("Chetan Bhagat")) 
        {
            log.info("The text contains Chetan Bhagat");
        }
        else 
        {
            log.error("The text doesnot contains Chetan Bhagat");
        }

        ExtentTest test1 = extent.createTest("test case 1");
        test1.log(Status.PASS,"Search Success");

    }

    @Test
    public void testMethod2() throws InterruptedException
    {
        driver.get("https://www.barnesandnoble.com");
        WebElement audioBook = driver.findElement(By.xpath("//*[@id='rhfCategoryFlyout_Audiobooks']"));

        Actions action = new Actions(driver);
        action.moveToElement(audioBook).perform();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/div/ul/li[5]/div/div/div[1]/div/div[2]/div[1]/dd/a[1]")).click();
        Thread.sleep(5000);

        ExtentTest test2 = extent.createTest("test case 2");
        test2.log(Status.PASS,"Success");

    }

    @Test
    public void testMethod3() throws InterruptedException,IOException
    {
        driver.get("https://www.barnesandnoble.com/");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
        Thread.sleep(2000);

        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "D:\\Software Testing\\cc2\\src\\Images\\screenshot.png";
        FileUtils.copyFile(screen, new File(path));

        ExtentTest test3 = extent.createTest("test case 3");
        test3.log(Status.PASS,"Success");

    }


    @AfterTest
    public void afterTestMethod()
    {
        extent.flush();
        driver.close();
    }
}