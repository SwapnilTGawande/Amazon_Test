package com.invest.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException {
    	
   
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://www.amazon.in/");
    	
        // Search for a product
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys("SweetShirt");
        searchBar.submit();
        WebElement result = driver.findElement(By.xpath("//span[text()='SweetShirt']"));
        assert result.isDisplayed();
        
        // Filter the search results
        WebElement priceFilter = driver.findElement(By.xpath("//*[@id=\"p_36-title\"]/span"));
        priceFilter.click();
        WebElement minPrice = driver.findElement(By.id("low-price"));
        minPrice.sendKeys("300");
        WebElement maxPrice = driver.findElement(By.id("high-price"));
        maxPrice.sendKeys("3000");
        WebElement goButton = driver.findElement(By.xpath("//input[@value='Go']"));
        goButton.click();
        result = driver.findElement(By.xpath("//span[text()='SweetShirt']"));
        assert result.isDisplayed();
         
        Thread.sleep(50);
        // Add a product to the shopping cart
        result.click();
    
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"CardInstanceBm9aMV2LhBF3hvSYNGTZ4g\"]/div[1]/div[2]/div[1]/div/div[1]/a/div/img"));
        addToCart.click();
        WebElement cart = driver.findElement(By.id("nav-cart-count"));
        assert cart.getText().equals("1");
        
        // Proceed to checkout
        cart.click();
        WebElement productName = driver.findElement(By.xpath("//a[text()='SweetShirt']"));
        assert productName.isDisplayed();
        
        // Fill out the checkout form
        WebElement proceedToCheckout = driver.findElement(By.xpath("//input[@value='Proceed to checkout']"));
        proceedToCheckout.click();
        WebElement name = driver.findElement(By.id("enterAddressFullName"));
        name.sendKeys("Swapnil Tukaram Gawande");
        WebElement phone = driver.findElement(By.id("enterAddressPhoneNumber"));
        phone.sendKeys("8999291767");
        WebElement address = driver.findElement(By.id("enterAddressAddressLine1"));
        address.sendKeys("Shivaji Nagar,Pune Maharashtra");
        WebElement city = driver.findElement(By.id("enterAddressCity"));
        city.sendKeys("Pune");
        WebElement state = driver.findElement(By.id("enterAddressStateOrRegion"));
        state.sendKeys("Maharshtra");
    }
}
