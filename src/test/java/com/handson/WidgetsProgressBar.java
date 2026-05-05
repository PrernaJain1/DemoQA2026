package com.handson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WidgetsProgressBar {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/progress-bar");

        driver.findElement(By.id("startStopButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(1));
        WebElement progressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("progressBar")));

        while(true){
            if(progressBar.getText().equals("30%")){
                driver.findElement(By.id("startStopButton")).click();
                break;
            }
        }
        Thread.sleep(5000);
        driver.quit();
    }

}
