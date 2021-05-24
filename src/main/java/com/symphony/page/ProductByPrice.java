package com.symphony.page;


import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;


import com.symphony.base.TestBase;

public class ProductByPrice extends TestBase {
	
	
	int priceArrayAscSize,priceArrayDescSize;
	String actStringAscPrice="",expStringAscPrice="",actStringDescPrice="",expStringDescPrice="";
	boolean staleElement=true;
	List<WebElement> priceList2,productPriceAsce;
	public ProductByPrice() {
		PageFactory.initElements(driver,this);
	}
	

	
	
	
	public String[] productPriceAsceOrder()
	    {
	
		
	 		
	        	productPriceAsce = driver.findElements(By.xpath("//span[@class='special-price']//span[@class='price']"));
	        	  
		
		priceArrayAscSize=productPriceAsce.size();
	    int arr1[]=new int[priceArrayAscSize];
	    int copyArray[]=new int[priceArrayAscSize];
	    Iterator<WebElement> itrPrice=productPriceAsce.iterator();
	     for(int k=0;k<priceArrayAscSize;k++)
	      {
		    WebElement priceTxt=itrPrice.next();
	        String actPrice = priceTxt.getText();
	        String value = actPrice.substring(1);
	        String actValue = value.replace(",","");
	        String act=actValue.replace(".00","");
	        Integer realPrice=Integer.parseInt(act);
	        arr1[k]=realPrice;
	        actStringAscPrice=actStringAscPrice+realPrice;
	    
	}
	
	//System.out.println(actStringAscPrice);
	copyArray=arr1;
	
	Arrays.sort(copyArray);
	System.out.println("");
	for(int l=0;l<arr1.length;l++)
	{
	
	expStringAscPrice=expStringAscPrice+copyArray[l];
    }
	//System.out.println(expStringAscPrice);
	
	
	return new String[]{ actStringAscPrice,expStringAscPrice };
	}
	
	
	public String[] productPriceDescOrder()
	{

  while(staleElement){
        try{
 		
		 driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[5]/div[3]/a")).click();
		 priceList2 = driver.findElements(By.xpath("//span[@class='special-price']//span[@class='price']"));
	     staleElement = false;
	  } 
		 
		
		catch(StaleElementReferenceException e){
		    staleElement = true;
		  }
  }
		
		priceArrayDescSize=priceList2.size();
		   int arr2[]=new int[priceArrayDescSize];
		   Iterator<WebElement> itrPrice2=priceList2.iterator();
		      for(int m=0;m<priceArrayDescSize;m++)
		        {
			       WebElement priceTxt2=itrPrice2.next();
		           String actPrice2 = priceTxt2.getText();
		           String value2 = actPrice2.substring(1);
		           String actValue2 = value2.replace(",","");
		           String act2=actValue2.replace(".00","");
		           Integer realPrice2=Integer.parseInt(act2);
		           arr2[m]=realPrice2;
		           actStringDescPrice=actStringDescPrice+realPrice2;
		   }
		//System.out.println(actStringDescPrice);
		
		
		Integer[] objectArray = new Integer[priceArrayDescSize];

		for(int obj = 0; obj < priceArrayDescSize; obj++) {
		    objectArray[obj] = Integer.valueOf(arr2[obj]); // returns Integer value
		}
		
		
		Arrays.sort(objectArray,Collections.reverseOrder());
		
		System.out.println("");
		
		
		
		for(int k=0;k<objectArray.length;k++)
		{
		
		expStringDescPrice=expStringDescPrice+objectArray[k];
	    }
		
		//System.out.println(expStringDescPrice);
		
		
		return new String[]{actStringDescPrice,expStringDescPrice} ;
	
		
		}
		
	
	}
	

