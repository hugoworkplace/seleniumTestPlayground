package com.herokuapp.the_internet.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class theInternetTests {
    WebDriver driver;

    @BeforeEach
    public void Startup(){
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
    }

    @AfterEach
    public void close(){
       // if(driver != null)
        //    driver.quit();
    }

    @Test
    public void addRemoveTest(){
        driver.findElement(By.cssSelector("[href='/add_remove_elements/']")).click();

        driver.findElement(By.cssSelector("[onclick='addElement()']")).click();
        driver.findElement(By.cssSelector("[onclick='addElement()']")).click();
        driver.findElement(By.cssSelector("[onclick='addElement()']")).click();


        //Assertions.assertEquals(3, driver.findElements(By.className("added-manually")).size());

        for(WebElement remove : driver.findElements(By.className("added-manually"))) {
            if(driver.findElements(By.className("added-manually")).size() > 1 )
                remove.click();
        }

        Assertions.assertEquals(1, driver.findElements(By.className("added-manually")).size());
    }

    

}



