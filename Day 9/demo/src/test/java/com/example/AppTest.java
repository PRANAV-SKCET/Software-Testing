package com.example;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
public class AppTest {
    /**
     * Rigorous Test :-)
     * 
     * 
     */

    String username="";
    String password="";

    @BeforeMethod
    public void before() throws IOException {

        FileInputStream fs = new FileInputStream("D:\\Software Testing\\Day 9\\demo\\src\\excelSheet\\Myxl.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        // workbook.createSheet("Sheet 3");
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        username = row.getCell(0).getStringCellValue();
        password = row.getCell(1).getStringCellValue();
        FileOutputStream fos = new FileOutputStream("D:\\Software Testing\\Day 9\\demo\\src\\excelSheet\\Myxl.xlsx") ;
        workbook.write(fos);

        
    }

    @Test
    public void getReport()
    {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("D:\\Software Testing\\Day 9\\demo\\src\\Reports\\reports.html");
        extent.attachReporter(spark);
        spark.config().setDocumentTitle("PM");
        spark.config().setTheme(Theme.DARK);
        ExtentTest test1 = extent.createTest("test 1");


        
        if(username.equals("Prana"))
        {
            test1.log(Status.PASS, "Success");
        }
        else{
            test1.log(Status.FAIL, "Failed");
        }



        ExtentTest test2 = extent.createTest("test @");
        if(username.equals("Pranav A"))
        {
            test2.log(Status.PASS, "Success");
            
        }
        else{
            test2.log(Status.FAIL, "Failed");
        }


        extent.flush();
    }

    @Test
    public void shouldAnswerWithTrue() {
        System.out.println(username);
    }
    @Test
    public void should() {
        System.out.println(password);
    }
}
