package com.pru.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage 
{
	final WebDriver driver;
	 
	@FindBy(how = How.XPATH, using = "//img[@src='/themes/openweathermap/assets/vendor/owm/img/logo_OpenWeatherMap_orange.svg']")
	public WebElement title_OpenWeatherMap;
	
	@FindBy(how = How.ID, using = "weather-widget")
	public WebElement weather_Widget;
 
	@FindBy(how = How.XPATH, using = ".//*[@id='weather-widget']/h2")
	public WebElement weather_City_Name;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='weather-widget']/h3")
	public WebElement weather_City_Temp;
	
	//------Weather Wind
	@FindBy(how = How.XPATH, using = "//div[@id='weather-widget']/table/tbody/tr[1]/td[1]")
	public WebElement weather_Wind;
 
	//------Weather Wind Value
	@FindBy(how = How.ID, using = "weather-widget-wind")
	public WebElement weather_Wind_Value;
	
	//------Weather Cloudiness
	@FindBy(how = How.XPATH, using = "//*[@id='weather-widget']/table/tbody/tr[2]/td[1]")
	public WebElement weather_Cloudiness;
 
	//------Weather Cloudiness Value
	@FindBy(how = How.ID, using = "weather-widget-cloudiness")
	public WebElement weather_Cloudiness_Value;

	//------Weather Pressure
	@FindBy(how = How.XPATH, using = "//*[@id='weather-widget']/table/tbody/tr[3]/td[1]")
	public WebElement weather_Pressure;
	 
	//------Weather Pressure Value
	@FindBy(how = How.XPATH, using = "//*[@id='weather-widget']/table/tbody/tr[3]/td[2]")
	public WebElement weather_Pressure_Value;
	
	//------Weather Humidity
	@FindBy(how = How.XPATH, using = "//*[@id='weather-widget']/table/tbody/tr[4]/td[1]")
	public WebElement weather_Humidity;
		 
	//------Weather Humidity Value
	@FindBy(how = How.XPATH, using = "//*[@id='weather-widget']/table/tbody/tr[4]/td[2]")
	public WebElement weather_Humidity_Value;
		
	//------Weather Sunrise
	@FindBy(how = How.XPATH, using = "//*[@id='weather-widget']/table/tbody/tr[5]/td[1]")
	public WebElement weather_Sunrise;
			 
	//------Weather Sunrise Value
	@FindBy(how = How.XPATH, using = "//*[@id='weather-widget']/table/tbody/tr[5]/td[2]")
	public WebElement weather_Sunrise_Value;
	
	//------Weather Sunset
	@FindBy(how = How.XPATH, using = "//*[@id='weather-widget']/table/tbody/tr[6]/td[1]")
	public WebElement weather_Sunset;
				 
	//------Weather Sunset Value
	@FindBy(how = How.XPATH, using = "//*[@id='weather-widget']/table/tbody/tr[6]/td[2]")
	public WebElement weather_Sunset_Value;
	
	//------Weather GeoCord
	@FindBy(how = How.XPATH, using = "//*[@id='weather-widget']/table/tbody/tr[7]/td[1]")
	public WebElement weather_GeoCord;
				 
	//------Weather GeoCord Value
	@FindBy(how = How.XPATH, using = "//*[@id='weather-widget']/table/tbody/tr[7]/td[2]")
	public WebElement weather_GeoCord_Value;
	
	//------City Search Textbox
	@FindBy(how = How.XPATH, using = "//input[@id='q' and @placeholder='Your city name']")
	public WebElement city_Search;
		
	//------City Search Button
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-orange']")
	public WebElement city_Search_Button;
	
	//------No record found alert
	@FindBy(how = How.XPATH, using = "//a[@class='close']")
	public WebElement no_Record_Found;
	
	//------Record found alert
	@FindBy(how = How.XPATH, using = ".//*[@id='forecast_list_ul']/table/tbody/tr")
	public WebElement record_Found;
	
	//------Record Details0
	@FindBy(how = How.XPATH, using = ".//*[@id='forecast_list_ul']/table/tbody/tr/td[2]/b[1]/a")
	public WebElement record_details0;
	
	//------Record Details1
	@FindBy(how = How.XPATH, using = ".//*[@id='forecast_list_ul']/table/tbody/tr/td[2]/p[1]")
	public WebElement record_details1;

	//------Record Details2
	@FindBy(how = How.XPATH, using = ".//*[@id='forecast_list_ul']/table/tbody/tr/td[2]/p[2]")
	public WebElement record_details2;
	
	//------Your City Link
	@FindBy(how = How.XPATH, using = "//button[@class='btn search-cities__lnk']")
	public WebElement your_City_Link;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;	
	}
 
// This method will take one arguments "Param", parameters of weather.
 
	public void weatherCheck(WebElement Param) throws InterruptedException
	{
 
		if(Param.getText().equalsIgnoreCase("Wind"))
		{
			Assert.assertTrue(weather_Wind.isDisplayed());
			System.out.println("Wind is: "+weather_Wind_Value.getText());	
		}
		
		else if(Param.getText().equalsIgnoreCase("Cloudiness"))
		{
			Assert.assertTrue(weather_Cloudiness.isDisplayed());
			System.out.println("Cloudiness is: "+weather_Cloudiness_Value.getText());
		}
		
		else if(Param.getText().equalsIgnoreCase("Pressure"))
		{
			Assert.assertTrue(weather_Pressure.isDisplayed());
			System.out.println("Pressure is: "+weather_Pressure_Value.getText());
		}
		
		else if(Param.getText().equalsIgnoreCase("Humidity"))
		{
			Assert.assertTrue(weather_Humidity.isDisplayed());
			System.out.println("Humidity is: "+weather_Humidity_Value.getText());
		}
		
		else if(Param.getText().equalsIgnoreCase("Sunrise"))
		{
			Assert.assertTrue(weather_Sunrise.isDisplayed());
			System.out.println("Sunrise is: "+weather_Sunrise_Value.getText());
		}
		
		else if(Param.getText().equalsIgnoreCase("Sunset"))
		{
			Assert.assertTrue(weather_Sunset.isDisplayed());
			System.out.println("Sunset is: "+weather_Sunset_Value.getText());
		}
		
		else if(Param.getText().equalsIgnoreCase("Geo Coords"))
		{
			Assert.assertTrue(weather_GeoCord.isDisplayed());
			System.out.println("Geo Co-ordinates are : "+weather_GeoCord_Value.getText());
		}
		else
		{
			System.out.println("Your location is out of this world...");
		}
	}
	
//This method will take Valid City name as input to search for weather
	public void search_Valid_City(String city) throws InterruptedException
	{
		city_Search.sendKeys(city);
		Thread.sleep(2000);
		city_Search_Button.click();
		Thread.sleep(2000);

		if(record_Found.isDisplayed())
		{
			System.out.println("Result: Valid Record Found");
			System.out.println("--------------------------------------------------");
			System.out.println(record_details0.getText());
			System.out.println("--------------------------------------------------");
			System.out.println(record_details1.getText());
			System.out.println(record_details2.getText());	
		}
		else
		{
			System.out.println("Something is WRONG for Valid City!!!");
		}
	}

//This method will take Invalid City name as input to search for weather
	public void search_InValid_City(String city) throws InterruptedException
	{
		city_Search.sendKeys(city);
		Thread.sleep(2000);
		city_Search_Button.click();
		Thread.sleep(2000);
		
		if(no_Record_Found.isDisplayed())
		{
			System.out.println("Result: Not Found");
		}
		else
		{
			System.out.println("Something is WRONG for Invalid City!!!");
		}
	}
	
//This method will get your Current located City weather
	public void get_Your_City_Weather() throws InterruptedException
	{
		your_City_Link.click();
		Thread.sleep(4000);
	}
}
