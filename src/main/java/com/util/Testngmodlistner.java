package com.util;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.tvsapache.Testbase;
import com.util.Xls_Reader;


public class Testngmodlistner extends TestListenerAdapter{
	String col_name=new String();
	String status=new String();
	
	
	
	 @Override
	  public void onTestFailure(ITestResult tr) {
		 Xls_Reader reader=new Xls_Reader(System.getProperty("user.dir")+"/result/Priceupdate.xlsx");
			col_name="result"+Testbase.col_num;
		 
		 	if(reader.setCellData("price",col_name.trim(), Testbase.result_row_num,"Failed")){
				status=Testbase.ANSI_RED+"Failed"+Testbase.ANSI_RESET;
		 		
			}else {
				status="Report Generation Failed for failed case";
				
			}
		 	System.out.println("Test Result:"+status);
		 	System.out.println(Testbase.ANSI_CYAN+"**************************************************");
			
			
	  
	 }
	 
	 @Override
	  public void onTestSuccess(ITestResult tr) {
		Xls_Reader reader=new Xls_Reader(System.getProperty("user.dir")+"/result/Priceupdate.xlsx");
			
		col_name="result"+Testbase.col_num;
		if(reader.setCellData("price",col_name.trim(),Testbase.result_row_num,"Passed")) {
			status=Testbase.ANSI_GREEN+"Passed"+Testbase.ANSI_RESET;
			
		}else {
			status="Report Generation Failed for passed case";
		}
		System.out.println("Test Result:"+status);
		System.out.println(Testbase.ANSI_CYAN+"**************************************************");
		
	  }

	 
	
	 
	  
	 
	  


}
