package com.symphony.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.symphony.base.TestBase;
import com.symphony.page.ProductByPrice;

public class ProductPriceTest extends TestBase {
	
	
	
	ProductByPrice price=new ProductByPrice();
	
		public ProductPriceTest() {
			super();
		}
		
		@BeforeMethod
		public void setUp()
		{
			initialization();
			 
		}

		@Test(priority=1)
		  
		  public void verifyProductPrice() {
		  
		  String S10[]=price.productPriceAsceOrder();
		  Assert.assertEquals(S10[0],S10[1],"Product price by ascending Order not matched");
		  Reporter.log("Product price by ascending order matched",true);
		  
		  
		  
		  String S11[]=price.productPriceDescOrder();
		  Assert.assertEquals(S11[0],S11[1],"Product price by descending Order not matched");
		  Reporter.log("Product price by descending order matched",true);
		  
		  
		  
		  
		  
		  }
		 




}
