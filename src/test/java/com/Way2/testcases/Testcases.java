package com.Way2.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Way2.base.Testbase;

public class Testcases extends Testbase {
	
	@Test(priority = 2)
	public void loginApp() throws Throwable
	{
		driver.findElement(By.xpath("//button[text()='Customer Login']")).click();
		//Thread.sleep(5000);
		WebElement 	dropdown	=driver.findElement(By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-valid']"));
		Select select=new Select(dropdown);
		select.selectByVisibleText("Harry Potter");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		//Thread.sleep(3000);
		String  expected	=driver.findElement(By.xpath("//span[contains(text(),'Harry Potter')]")).getText();
		String actual="Harry Potter";	
		Assert.assertEquals(actual, expected);
		System.out.println("Successfuly Logined Application");
		Thread.sleep(4000);
	}
	
	@Test(priority = 3)
	public void DepositAmt()
	{
		driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
		driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("500");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String msg =	driver.findElement(By.xpath("//span[normalize-space()='Deposit Successful']")).getText();
		String actualMsg ="Deposit Successful";
		Assert.assertEquals(actualMsg, msg);
		System.out.println("Amount Deposited Successful");
	}
	
	@Test(priority = 4)
	public void withdrawlAmt() throws InterruptedException
	{	
		try {
	
		driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("300");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2500);
		  String actual =driver.findElement(By.xpath("//span[normalize-space()='Transaction successful']")).getText();
		  Thread.sleep(2500);
		  String expt="Transaction successful";
		  Assert.assertEquals(actual, expt);
	}catch(StaleElementReferenceException e){	
	}
	}
	
	@Test(priority = 5)
	public void logoutApp()
	{
		driver.findElement(By.xpath("//button[normalize-space()='Logout']")).click();
		String   expect  =	driver.findElement(By.xpath("//strong[normalize-space()='XYZ Bank']")).getText();
		String actual="XYZ Bank";
		Assert.assertEquals(expect, actual);
		System.out.println("Successfuly Logout the application");
	}

}
