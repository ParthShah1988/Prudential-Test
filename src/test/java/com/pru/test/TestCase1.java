  package com.pru.test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCase1
{

	static WebDriver driver;
	HomePage newHomePage;
	Properties prop=new Properties();
 
  @BeforeMethod 
  public void beforeMethod() throws IOException 
  {
	  FirefoxProfile geoDisabled = new FirefoxProfile();
	  geoDisabled.setPreference("geo.enabled", true);
	  geoDisabled.setPreference("geo.provider.use_corelocation", true);
	  geoDisabled.setPreference("geo.prompt.testing", true);
	  geoDisabled.setPreference("geo.prompt.testing.allow", true);
 
	  prop.load(getClass().getResourceAsStream("Data.properties"));
	  
	  driver = new FirefoxDriver(geoDisabled);
 
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 
      driver.get(prop.getProperty("URL"));
 
      newHomePage = PageFactory.initElements(driver, HomePage.class);
 
  }
 
  @Test(priority=1)
  public void test1() throws InterruptedException 
  {
	  System.out.println("------------Test1 is starting-------------------");
	  System.out.println("------------------------------------------------");
	  
      Assert.assertTrue(newHomePage.title_OpenWeatherMap.isDisplayed());
      
      Assert.assertTrue(newHomePage.weather_City_Name.isDisplayed());
      System.out.println("City Name: "+newHomePage.weather_City_Name.getText());
      
      Assert.assertTrue(newHomePage.weather_City_Temp.isDisplayed());
      System.out.println("City Temperature: "+newHomePage.weather_City_Temp.getText());
      
      System.out.println("------------------------------------------------");
      
      newHomePage.weatherCheck(newHomePage.weather_Wind);
      newHomePage.weatherCheck(newHomePage.weather_Cloudiness);
      newHomePage.weatherCheck(newHomePage.weather_Pressure);
      newHomePage.weatherCheck(newHomePage.weather_Humidity);
      newHomePage.weatherCheck(newHomePage.weather_Sunrise);
      newHomePage.weatherCheck(newHomePage.weather_Sunset);
      newHomePage.weatherCheck(newHomePage.weather_GeoCord);
      System.out.println("------------Test1 is completed successfully------------");
  }
 
  @Test(priority=2)
  public void test2() throws InterruptedException 
  {
	  System.out.println("------------Test2 is starting-------------------");
	  newHomePage.search_InValid_City(prop.getProperty("Invalid_City"));
	  System.out.println("------------Test2 is completed successfully------------");
  }
  
  @Test(priority=3)
  public void test3() throws InterruptedException 
  {
	  System.out.println("------------Test3 is starting-------------------");
	  newHomePage.search_Valid_City(prop.getProperty("Valid_City"));     
	  System.out.println("------------Test3 is completed successfully------------");
  }
  
  @Test(priority=4)
  public void test4() throws InterruptedException 
  {
	  
	  System.out.println("------------Test4 is starting-------------------");
	  newHomePage.get_Your_City_Weather();
	  
	  System.out.println("------------------------------------------------");
	  
      Assert.assertTrue(newHomePage.title_OpenWeatherMap.isDisplayed());
      
      Assert.assertTrue(newHomePage.weather_City_Name.isDisplayed());
      System.out.println("City Name: "+newHomePage.weather_City_Name.getText());
      
      Assert.assertTrue(newHomePage.weather_City_Temp.isDisplayed());
      System.out.println("City Temperature: "+newHomePage.weather_City_Temp.getText());
      
      System.out.println("------------------------------------------------");
      
      newHomePage.weatherCheck(newHomePage.weather_Wind);
      newHomePage.weatherCheck(newHomePage.weather_Cloudiness);
      newHomePage.weatherCheck(newHomePage.weather_Pressure);
      newHomePage.weatherCheck(newHomePage.weather_Humidity);
      newHomePage.weatherCheck(newHomePage.weather_Sunrise);
      newHomePage.weatherCheck(newHomePage.weather_Sunset);
      newHomePage.weatherCheck(newHomePage.weather_GeoCord);
      System.out.println("------------Test4 is completed successfully------------");
  }
 
  
  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
	  driver.quit();
  }

}
