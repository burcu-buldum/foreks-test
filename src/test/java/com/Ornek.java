package com;


import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.management.BufferPoolMXBean;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Ornek {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws Exception {

        //N11 e giriş
        driver.get("http://www.n11.com/");

        /*
        // giriş butonuna basıyoruz
        driver.findElement(By.cssSelector(".btnSignIn")).click();

        // facebook butonuna basıyoruz.
        driver.findElement(By.cssSelector(".facebookBtn")).click();

        // açılan popup a geçiyoruz
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        // facebook kullanıcıadı ve şifreyi giriyoruz
        driver.findElement(By.id("email")).sendKeys("foreksdeneme@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("foreks909090");

        // giriş yap butonuna tıklıyoruz
        driver.findElement(By.id("u_0_2")).click();
        */

        // ürün arama alanı
        driver.findElement(By.id("searchData")).sendKeys("iphone 7");

        // ara
        driver.findElement(By.cssSelector(".searchBtn")).click();

        // ürünün adını alıyoruz
        String urunAdi = driver.findElement(By.xpath("//*[@id=\"p-140890072\"]/div[1]/a/h3")).getText();

        // ürüne tıklıyoruz
        driver.findElement(By.xpath("//*[@id=\"p-140890072\"]/div[1]/a")).click();

        Thread.sleep(1000);

        String detayAdi = driver.findElement(By.xpath("//*[@id=\"contentProDetail\"]/div/div[3]/div[2]/div[1]/div/h1")).getText();

        assert urunAdi.equals(detayAdi);

        Shutterbug.shootPage(driver).save(System.getProperty("user.dir") + "/src/ekrangoruntuleri");


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
