package com.instawork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class instagsearch {

    @Test
    public void gsearchinsta() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys("instawork");
        WebElement textbox = driver.findElement(By.cssSelector("input[name='q']"));
        textbox.sendKeys(Keys.ENTER);
        // driver.findElement(By.cssSelector("input[name='btnK']")).click();

        WebElement search = driver.findElement(By.xpath("//div[@id='search']"));
        List<WebElement> webLinks = search.findElements(By.xpath("//div[@class='rc']/div/a"));

        String expectedWebsite = "https://www.instawork.com/";
        Map<String, Integer> storemap = new HashMap<String, Integer>();
        int count = 1;
        for (WebElement ele : webLinks) {
            storemap.put(ele.getAttribute("href"), count);
            ++count;
        }

        int position = 0;
        for (String key : storemap.keySet()) {
            //    System.out.println("The link : " + key + " is in position : " + storemap.get(key));
            if (key.equals(expectedWebsite)) {
                position = storemap.get(key);
                if (position == 1) {
                    System.out.println("The " + expectedWebsite + " is present in " + storemap.get(key) + " position and tops the google search");
                } else {
                    System.out.println("The " + expectedWebsite + " is present in " + storemap.get(key) + " position");
                    Assert.assertEquals(position, 1);

                }
            }
        }
    }
}

