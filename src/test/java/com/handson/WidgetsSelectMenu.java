package com.handson;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class WidgetsSelectMenu {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

        //in select we have 3 functions:
        //Select by value
        //Select by index
        //Select by visible text

        WebElement w = driver.findElement(By.id("oldSelectMenu"));
        Select s = new Select(w);
        s.selectByValue("2");
        Thread.sleep(2000);
        s.selectByVisibleText("Yellow");
        Thread.sleep(2000);
        s.selectByIndex(8);


        //Scroll to the end of page
        JavascriptExecutor script= (JavascriptExecutor) driver;
        script.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //Scroll back to the top of the page
        //JavascriptExecutor script= (JavascriptExecutor) driver;
        script.executeScript("window.scrollBy(0,-(document.body.scrollHeight))");

        driver.quit();
    }
}
