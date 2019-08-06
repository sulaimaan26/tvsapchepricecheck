package com.util;

import java.util.ArrayList;


public class Excel_inputs {
	public static int i;
	public static int a=1;
	
	

	public static ArrayList<Object[]> getdatafrmexcel() {
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		Xls_Reader reader = new Xls_Reader(
		System.getProperty("user.dir") + "/Priceupdate.xlsx");
		for (i = 2; i <=reader.getRowCount("price") ;i++) {
			
			String statename = reader.getCellData("price", "State", i);
			
			for(int j=1;j<reader.getColumnCount("price")-1;j=j+2) { 
				  String price=reader.getCellData("price", j, i); 
				  price = reader.getCellData("price", j, i);
				  mydata.add(new Object[] {statename,price,j,i}); 
				  
			}
			
			 }
		
		return mydata;
	}

}
