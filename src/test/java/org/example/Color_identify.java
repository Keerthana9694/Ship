package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Color_identify {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.shipyaari.com/orders/add-order/pickup");
        driver.manage().window().maximize();
        Thread.sleep(6000);
        WebElement wareHouse =  driver.findElement(By.xpath(".//div[@id='shopkeeper']//p"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",wareHouse);

             if(wareHouse.getText().equals("Office"))
             {
                 wareHouse.click();
             }
      wareHouse.getCssValue("color");

    }
}

