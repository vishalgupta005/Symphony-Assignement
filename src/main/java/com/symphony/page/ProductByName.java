package com.symphony.page;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.symphony.base.TestBase;

public class ProductByName extends TestBase {
	
	
	public ProductByName() {
		PageFactory.initElements(driver,this);
	}
	
	int nameArrayAscSize,nameArrayDescSize;
	String actStringNameAsc="",expStringNameAsc="",actStringNameDesc="",expStringNameDesc="";
	List<WebElement> productNameDesc,nameList;
	boolean staleElement=true;
	
	public String[] productNameByAsceOrder()
	{
		
			     
			  
		    WebElement clickDropDown = driver.findElement(By.id("sorter"));
		  
		    Select sel=new Select(clickDropDown);
		    sel.selectByVisibleText("Product Name");
		
		    nameList = driver.findElements(By.xpath("//a[@class='product-item-link']"));
	                     
			  
			  
			  
		    
	                     nameArrayAscSize=nameList.size();
		                 String arr1[]=new String[nameArrayAscSize];
		                 String copyArray1[]=new String[nameArrayAscSize];
	                     Iterator<WebElement> itrName=nameList.iterator();
	  
		           for(int a=0;a<nameArrayAscSize;a++)
			         {
		              WebElement productNameAsce = itrName.next();
		              String actProductName = productNameAsce.getText();
		              
		              arr1[a]=actProductName;
		              actStringNameAsc=actStringNameAsc+actProductName;
		            }
		           
		           //System.out.println(actStringNameAsc);
		
		copyArray1=arr1;
		Arrays.sort(copyArray1);
		
		System.out.println("");
		for(int b=0;b<copyArray1.length;b++)
		{
			 expStringNameAsc = expStringNameAsc+copyArray1[b];
		}
		
		//System.out.println(expStringNameAsc);
		
		
		
		
		
		
		return new String[]{actStringNameAsc,expStringNameAsc} ;
	}
	
	
	public String[] productNameByDescOrder()
	{
		while(staleElement){
			  try{	
	
		WebElement clickDropDown = driver.findElement(By.id("sorter"));
		
		Select sel=new Select(clickDropDown);
		sel.selectByVisibleText("Product Name");
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[5]/div[3]/a")).click();
		 productNameDesc = driver.findElements(By.xpath("//a[@class='product-item-link']"));
		 
		 staleElement = false;
			  }
			  
			  catch(StaleElementReferenceException e){
				    staleElement = true;
					}
		}
		 
		  nameArrayDescSize=productNameDesc.size();
			 String arr2[]=new String[nameArrayDescSize];
			String copyArray2[]=new String[nameArrayDescSize];
		  Iterator<WebElement> itrName=productNameDesc.iterator();
		  
			           for(int i=0;i<nameArrayDescSize;i++)
				       {
			            WebElement actProductNameDesc = itrName.next();
			            String actProductName = actProductNameDesc.getText();
			            
			            
			            copyArray2[i]=actProductName;
			            actStringNameDesc=actStringNameDesc+actProductName;
			           }
			           
			//System.out.println(actStringNameDesc);
			
			Arrays.sort(copyArray2,Collections.reverseOrder());
			
			System.out.println("");
			
			for(int j=0;j<arr2.length;j++)
			{
				expStringNameDesc=expStringNameDesc+copyArray2[j];
			}
		
			//System.out.println(expStringNameDesc);
	
	
		return new String[]{actStringNameDesc,expStringNameDesc};
	}
	
	

}
