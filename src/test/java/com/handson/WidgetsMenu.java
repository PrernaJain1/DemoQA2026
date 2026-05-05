package com.handson;

import org.apache.xmlbeans.impl.store.CharUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class WidgetsMenu {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/menu");

        Thread.sleep(5000);

        WebElement mainItem= driver.findElement(By.xpath("//li//a[text()='Main Item 2']"));
        WebElement subList = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        WebElement item = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));
        Actions a = new Actions(driver);
        a.moveToElement(mainItem).build().perform();
        a.moveToElement(subList).build().perform();
        a.moveToElement(item).build().perform();

        Thread.sleep(5000);

        driver.quit();
    }
}
