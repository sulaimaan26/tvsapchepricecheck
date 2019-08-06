package com.tvsapache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.util.UtilTvsapache;


public class Testbase {
	Properties prop;
	public static WebDriver driver;
	public static int result_row_num;
	public static int col_num=0;
	public static String temp=new String();
	public List<String> reject;
	public static String ANSI_RED="\u001b[31m";
	public static String ANSI_GREEN="\u001b[32m";
	public static String ANSI_RESET="\u001b[0m";
	public static String ANSI_BLUE="\u001b[34m";
	public static String ANSI_YELLOW="\u001b[33;1m";
	public static String ANSI_CYAN="\u001b[36;1m";
	String encryp;	
	public Testbase() {
		// TODO Auto-generated constructor stub
	FileInputStream file;
	
		try {
			prop=new Properties();
			file = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
			prop.load(file);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void intialization() {
		if(prop.getProperty("browser").contentEquals("chrome")) {
			File file = new File(System.getProperty("user.dir")+"/drivers/Chromedrivers/chromedriver");
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			driver=new ChromeDriver();
			System.out.println("Starting chrome GUI mode");
		}else if(prop.getProperty("browser").contentEquals("headless")){
			File file = new File(System.getProperty("user.dir")+"/drivers/Chromedrivers/chromedriver");
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			ChromeOptions options = new ChromeOptions();  
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");  
			driver = new ChromeDriver(options);  
			System.out.println("Starting chrome headless mode");
		}else {
		
			System.out.println("Failed");
		}
		
		try {
			temp=prop.getProperty("reject_product").trim();
			reject=new ArrayList<String>();
			encryp=new String();
			for(int i=0;i<temp.length();i++) {
				encryp=Character.toString((char)(temp.charAt(i)));
				reject.add(encryp);
			}
			driver.manage().timeouts().pageLoadTimeout(UtilTvsapache.pageloadtimeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(UtilTvsapache.implicitlyWait, TimeUnit.SECONDS);
			driver.manage().window().maximize();;
			driver.get(prop.getProperty("url"));
		
		}catch(TimeoutException e) {
			System.out.println("Alert Site seems very slow!!!! Please increase the page load time out in util class");
			driver.close();
			System.exit(0);
			
		}
		
	}

	
	

}
