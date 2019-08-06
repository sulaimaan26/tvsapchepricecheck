package com.test.apache;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.elements.Tvsapache;
import com.tvsapache.Testbase;
import com.util.Excel_inputs;
import com.util.Xls_Reader;

public class Getprice extends Testbase {
	Tvsapache product;

	public Getprice() {
		// TODO Auto-generated constructor stub
		super();

	}

	@BeforeTest
	public void browserstart() {

		try {
			File srcfile = new File(System.getProperty("user.dir") + "/Priceupdate.xlsx");
			File destdir = new File(System.getProperty("user.dir") + "/result");
			FileUtils.copyFileToDirectory(srcfile, destdir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		intialization();
		System.out.println("started");
	}

	@DataProvider
	public Iterator<Object[]> testdata() {
		ArrayList<Object[]> testdata = Excel_inputs.getdatafrmexcel();
		return testdata.iterator();
	}

	@Test(dataProvider="testdata")
	public void test(String state, String expectedprice, int productcount, int row_num) throws InterruptedException {
		product = new Tvsapache(productcount);
	 	String test=Integer.toString(productcount);
		if(reject.indexOf(test)==-1) {
			result_row_num = row_num; // assigning value for result sheet
			col_num = product.getproductindex(); // assigning value for result sheet
			System.out.println(ANSI_YELLOW + "##################################################");
			System.out.println("            Data From Source Sheet               ");
			System.out.println("STATE:" + state);
			System.out.println("Expected Price:" + expectedprice);
			System.out.println("Product name:" + product.productname());
			System.out.println(ANSI_YELLOW + "##################################################");
			product.selectstate(product.alterstate(state));
			Thread.sleep(1000);
			product.selectcity(1);
			product.selectmodel();
			product.submit();
			Thread.sleep(1000);
			String siteresult = product.getmodeloneprice() + ".0";
			System.out.println("");
			System.out.println(ANSI_CYAN + "**************************************************");
			System.out.println("            Data From Website               ");
			System.out.println("Actual Price:" + siteresult);
			Assert.assertEquals(expectedprice, siteresult);

		
		}else {
			System.out.println("Stopped"+product.productname());
		}
		
	}

	public void tests(String state, String price, int index) throws InterruptedException {
		product = new Tvsapache();
		System.out.println("state from sheet" + state + price + index);
		// System.out.println(product.alterstate(state));
		// product.selectstate(product.alterstate(state));
		// Thread.sleep(1000);
	}

	public void test(String state) throws InterruptedException {
		product = new Tvsapache();
		System.out.println("state from sheet" + state);
		System.out.println(product.alterstate(state));
		product.selectstate(product.alterstate(state));
		// Thread.sleep(1000);
	}

	@AfterTest
	public void teardown() {
		System.out.println("Test has been completed");
		System.out.println("Please verify the sheet under the result folder");
		driver.close();
	}

}
