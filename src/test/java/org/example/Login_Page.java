package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.Assert;
import org.openqa.selenium.support.Color;

import java.util.List;

import static dev.failsafe.internal.util.Assert.*;
import static org.junit.Assert.*;

public class Login_Page {

    public static WebDriver driver;
    static String val;
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\ChromeStandaloneSetup64.exe");
//        driver = new ChromeDriver();
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.shipyaari.com/orders/add-order/pickup");
        driver.manage().window().maximize();
        Thread.sleep(6000);

         WebElement email =  driver.findElement(By.xpath(".//input[@type=\"email\"]"));
         email.click();
        email.sendKeys("keerthana.angamuthu@gmail.com");
        WebElement password = driver.findElement(By.xpath(".//input[@type=\"password\"]"));
        password.click();
        password.sendKeys("baargav30@K");
        driver.findElement(By.xpath(".//p[text()=\"Log In\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//p[text()=\"Skip For Now\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//p[text()=\"Add Order\"]")).click();
      WebElement scroll =   driver.findElement(By.id("selectDropdown"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scroll);
       scroll.click();
          List<WebElement> drop =  driver.findElements(By.tagName("option"));
          for(WebElement ele : drop)
          {
              if(ele.getText().equals("Bihar"))
              {
                  js.executeScript("arguments[0].setAttribute('style','border.2px solid red; background:yellow')",ele);

                  ele.click();
                 val =  ele.getText();
                break;

              }
          }
          Assert.assertEquals("Bihar", val);
        WebElement wareHouse =  driver.findElement(By.xpath(".//div[@id='shopkeeper']//p"));
        js.executeScript("arguments[0].scrollIntoView(true);",wareHouse);

        if(wareHouse.getText().equals("Office"))
        {
            wareHouse.click();
        }
       String res = wareHouse.getText();
       String c = wareHouse.getCssValue("color");
      String textCol = Color.fromString(c).asHex();
      Assert.assertEquals("#004EFF", textCol.toUpperCase());
      WebElement border = driver.findElement(By.id("shopkeeper"));
        String c1 = border.getCssValue("border-color");
        String BoarderCol = Color.fromString(c1).asHex();
        Assert.assertEquals("#004EFF", BoarderCol.toUpperCase());

        String[] str = {"Monday","Tuesday","Wednesday", "Thursday", "Friday" };

       List<WebElement> days = driver.findElements(By.xpath(".//p[@class=\"bg-white lg:font-semibold lg:font-Open lg:text-sm \"]"));

           for (WebElement day : days) {
               for(String str1 : str) {

               if (day.getText().equals(str1)) ;
               {
                   driver.findElement(By.xpath(".//input[@title =\"Checkbox\"]")).isSelected();
                   break;
               }
           }
       }

    }




}
