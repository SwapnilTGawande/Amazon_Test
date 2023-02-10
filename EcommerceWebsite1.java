package com.invest.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
      
    
       
       
           //Launch the Chrome browser
		
       public class EcommerceWebsite1 {
    	   WebDriver driver;
    	   
    	   @BeforeTest  
           public void setup() {
    		    driver = new ChromeDriver();
   		        driver.manage().window().maximize();
   			   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   			  //  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
   		  
   			// Navigate to the website
		      driver.get("https://www.amazon.in/");
   		 
    	   }
    	   
    	   @Test
    	   public void VerifySearchResult() throws InterruptedException{
		   
    		
    		   
		    // Locate the search bar and enter the product name
		    WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		    searchBar.sendKeys("iphone 13 pro");
		     
		    // Submit the search query
		   searchBar.submit();
		     
		   Thread.sleep(5);
		    // Verify that the search results are displayed
		  WebElement searchResults = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]"));
		    if (!searchResults.isDisplayed()) {
		      System.out.println("Search results not displayed");
		     driver.quit();
		     return;
		    }
		    
		    // Validate that the desired product is present in the search results
		     WebElement product = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div"));
		      if (!product.isDisplayed()) {
		      System.out.println("Desired product not found in search results");
		       driver.quit();
		      return;
		    }
		    
    	   }
    	   
    	     @Test
    	     public void filterByPriceRange() {
    	       // locate the price range filter
    	       WebElement priceFilter = driver.findElement(By.xpath("//*[@id=\"p_36/1318507031\"]/span/a/span"));
    	       priceFilter.click();
    	       
    	       // select the desired price range
    	       WebElement priceRange = driver.findElement(By.xpath("//*[@id=\"p_36/1318507031\"]/span/a/span"));
    	       priceRange.click();
    	       
    	       // apply the filter
    	       WebElement applyFilterBtn = driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[2]"));
    	       applyFilterBtn.click();
    	       
    	       // verify that the filtered results are displayed correctly
    	       WebElement resultList = driver.findElement(By.id("//*[@id=\\\"p_36/1318507031\\\"]/span/a/span"));
    	       String resultText = resultList.getText();
    	       Assert.assertTrue(resultText.contains("$100 - $200"), "Incorrect filtered results");
    	     }
    	     
    	    
    	     
    	   

       @Test
       public void addProductToCart() {
         // navigate to a product page
         WebElement productLink = driver.findElement(By.xpath("//a[text()='Product 1']"));
         productLink.click();
         
         // select the desired options (size or color)
         WebElement sizeDropdown = driver.findElement(By.id("size-dropdown"));
         sizeDropdown.click();
         WebElement sizeOption = driver.findElement(By.xpath("//option[text()='Large']"));
         sizeOption.click();
         
         // add the product to the shopping cart
         WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-btn"));
         addToCartBtn.click();
         
         // verify that the product is added to the cart
         WebElement cartCount = driver.findElement(By.id("cart-count"));
         String count = cartCount.getText();
         Assert.assertEquals(count, "1", "Product not added to cart");
       }
       
       
       }
     
     





		
       
       
       
	

       
      
       
       

