package com.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AppExtentReport {
    
    public void getReport()
    {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("D:\\Software Testing\\Day 9\\demo\\src\\Reports\\reports.html");
        extent.attachReporter(spark);


        spark.config().setDocumentTitle("PM");
        spark.config().setTheme(Theme.DARK);
    }
}
