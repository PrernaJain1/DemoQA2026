package com.handson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WidgetsTabs {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/tabs");

        Thread.sleep(5000);

        driver.findElement(By.id("demo-tab-use")).click();
        String text = driver.findElement(By.xpath("//div[@id='demo-tabpane-use']/p")).getText();
        System.out.println("Text is: "+ text);

        driver.quit();
    }
}
