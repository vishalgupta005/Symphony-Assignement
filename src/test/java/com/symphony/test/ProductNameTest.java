package com.symphony.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.symphony.base.TestBase;
import com.symphony.page.ProductByName;




public class ProductNameTest extends TestBase  {
	
	
	ProductByName name=new ProductByName();
	
	
	public ProductNameTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		 
	}

	
	  @Test(priority=1)
	  
	  public void verifyProductName() {
	  
	  String S3[]=name.productNameByAsceOrder();
	  
	  Assert.assertEquals(S3[0],S3[1],"Product Name By Ascending Orde not Matched");
	  Reporter.log("Product Name By Ascending Order Matched",true);
	  
	  
      String S6[]=name.productNameByDescOrder();
	  
	  Assert.assertEquals(S6[0],S6[1],"Product Name By Descending Order not Matched");
	  Reporter.log("Product Name By Descending Order Matched",true);
	  
	  
	  
	  
	  }
	 
	 
	  
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
	
	

}
