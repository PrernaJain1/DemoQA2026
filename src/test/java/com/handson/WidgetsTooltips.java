package com.handson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WidgetsTooltips {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/tool-tips");

        Thread.sleep(5000);

        //To stop the screen -> goto sources in inspect element -> ctrl+\(Keep ctrl pressed and then press slash 2-3 times)
        WebElement tooltip = driver.findElement(By.id("toolTipButton"));
        Actions a = new Actions(driver);
        a.moveToElement(tooltip).build().perform();

        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//div[@class='tooltip-inner']")).getText());

        driver.quit();
    }
}
