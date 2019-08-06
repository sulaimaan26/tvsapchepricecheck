package com.elements;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tvsapache.Testbase;

public class Tvsapache extends Testbase  {

	
	
	@FindBy(xpath="//select[@name=\"ddlState\"]")
	WebElement statedropdown;
	
	@FindBy(xpath="//select[@name=\"ddlCity\"]")
	WebElement citydropdown;
	
	@FindBy(xpath="//select[@name=\"ddlModel\"]")
	WebElement modeldropdown;
	
	@FindBy(xpath="//input[@type=\"submit\" and @onclick=\"showDealers()\"]")
	WebElement submit;
							/*First Model*/
	@FindBy(xpath="//div[@id=\"apachertr_200_4v_abs\"]//div[@class=\"bikeprice\"]")
	WebElement productone;   //Apache RTR 200 4V Carb ABS R 2.0		1

	@FindBy(xpath="//div[@id=\"apachertr_200_4v_fi\"]//div[@class=\"bikeprice\"]")
	WebElement producttwo;  //Apache RTR 200 FI 4V R 2.0		2
	
	@FindBy(xpath="//div[@id=\"apachertr_200_4v_non_abs\"]//div[@class=\"bikeprice\"]")
	WebElement productthree; //Apache RTR 200 4V Carb R 2.0		3
	
							/*Second Model*/
	
	@FindBy(xpath="//div[@id=\"apachertr_160_4v_efi_abs\"]//div[@class=\"bikeprice\"]")
	WebElement productfour;  //Apache RTR 160 4V EFI ABS		4
	
	@FindBy(xpath="//div[@id=\"apachertr_160_4v_disc_abs\"]//div[@class=\"bikeprice\"]")
	WebElement productfive; //Apache RTR 160 4V ABS Disc		5
	
	@FindBy(xpath="//div[@id=\"apachertr_160_4v_drum_abs\"]//div[@class=\"bikeprice\"]")
	WebElement productsix;  //Apache RTR 160 4V ABS Drum		6
	
	@FindBy(xpath="//div[@id=\"apachertr_160_4v_efi_non_abs\"]//div[@class=\"bikeprice\"]")
	WebElement productseven; //Apache RTR 160 4V EFI			7
	
	@FindBy(xpath="//div[@id=\"apachertr_160_4v_disc_non_abs\"]//div[@class=\"bikeprice\"]")
	WebElement producteight; //Apache RTR 160 4V Disc			8
	
	@FindBy(xpath="//div[@id=\"apachertr_160_4v_drum_non_abs\"]//div[@class=\"bikeprice\"]")
	WebElement productnine;  //Apache RTR 160 4V Drum			9
	
	
							/*Third Model*/
	
	@FindBy(xpath="//div[@id=\"apachertr_160_2v_rear_disc_abs\"]//div[@class=\"bikeprice\"]")
	WebElement productten;  //Apache RTR 160 ABS Rear Disc		10
	
	@FindBy(xpath="//div[@id=\"apachertr_160_2v_front_disc_abs\"]//div[@class=\"bikeprice\"]")
	WebElement producteleven; //Apache RTR 160 ABS Front Disc	11
	
	@FindBy(xpath="//div[@id=\"apachertr_160_2v_rear_disc_non_abs\"]//div[@class=\"bikeprice\"]")
	WebElement producttwelve;   //Apache RTR 160 Rear Disc		12
	
	@FindBy(xpath="//div[@id=\"apachertr_160_2v_front_disc_non_abs\"]//div[@class=\"bikeprice\"]")
	WebElement productthirteen; //Apache RTR 160 Front Disc		13
	
	
								/*Fourth Model*/
	@FindBy(xpath="//div[@id=\"apachertr_180_abs\"]//div[@class=\"bikeprice\"]")
	WebElement productfourteen; //Apache RTR 180 1. Ch ABS		14	
	
	@FindBy(xpath="//div[@id=\"apachertr_180_non_abs\"]//div[@class=\"bikeprice\"]")
	WebElement productfifteen; //Apache RTR 180					15
	
	
	
	
	
	//row index is used to handle the result cell(blank cell) so that there is no need to change the function condition
	static int row_index=0;
	
	//product index represent actual product number in source sheet it is placed in the alternative cell with the help of row index value actual product index value obtained
	int productindex=0;
	
	
	
	
	public  Tvsapache() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public Tvsapache(int productindex){
		PageFactory.initElements(driver, this);
		this.productindex=productindex;
		if(productindex==1) {
			row_index=0;
		}else if(productindex>1) {
			row_index++;
		}
		this.productindex=productindex-row_index;
		
	}
	
	public int getproductindex() {
		return productindex;
	}

	public String productname() {
		
		String op=new String();
		switch(productindex) {
		case 1 :op="Apache RTR 200 4V Carb ABS R 2.0"; break;
		   case 2 :op="Apache RTR 200 FI 4V R 2.0"; break;
		   case 3 :op="Apache RTR 200 4V Carb R 2.0"; break;
		   case 4 :op="Apache RTR 160 4V EFI ABS"; break;
		   case 5 :op="Apache RTR 160 4V ABS Disc"; break;
		   case 6 :op="Apache RTR 160 4V ABS Drum"; break;
		   case 7 :op="Apache RTR 160 4V EFI"; break;
		   case 8 :op="Apache RTR 160 4V Disc"; break;
		   case 9 :op="Apache RTR 160 4V Drum"; break;
		   case 10 :op="Apache RTR 160 ABS Rear Disc"; break;
		   case 11 :op="Apache RTR 160 ABS Front Disc"; break;
		   case 12 :op="Apache RTR 160 Rear Disc"; break;
		   case 13 :op="Apache RTR 160 Front Disc"; break;
		   case 14 :op="Apache RTR 180 1. Ch ABS"; break;
		   case 15 :op="Apache RTR 180"; break;
		   default :System.out.println("Please enter valid product");
		}
		return op;
	}
	
	public void selectstate(String State) {
		Select states = new Select(statedropdown);
		states.selectByVisibleText(State);
		
	}
	
	public void selectcity(int index) {
		Select city = new Select(citydropdown);
		city.selectByIndex(index);
	}
	
	
	
	
	public void selectmodel() {
		Select category = new Select(modeldropdown);
		//System.out.println("ROW_INDEX:"+row_index);
		//System.out.println("Product index:"+productindex);
		if(productindex<=3) {
			//System.out.println("1st Model");
			category.selectByVisibleText("APACHE RTR 200 4V");;
		}else if(productindex>=4&&productindex<=9) {
			//System.out.println("2nd model");
			category.selectByVisibleText("APACHE RTR 160 4V");;
		}else if(productindex>=10&&productindex<=13) {
			//System.out.println("3rd model");
			category.selectByVisibleText("APACHE RTR 160");;
		}else if(productindex>=14&&productindex<=15) {
			//System.out.println("4th model");
			category.selectByVisibleText("APACHE RTR 180");;
		}
		
		
	}
	public void submit() {
		submit.click();
	}
	
	
	
	
	
	public String getmodeloneprice(){
		String op=new String();
		
		//producttype=producttype-row_index;
		
			switch(productindex) {
			case 1 :op=productone.getText(); break;
			   case 2 :op=producttwo.getText(); break;
			   case 3 :op=productthree.getText(); break;
			   case 4 :op=productfour.getText(); break;
			   case 5 :op=productfive.getText(); break;
			   case 6 :op=productsix.getText(); break;
			   case 7 :op=productseven.getText(); break;
			   case 8 :op=producteight.getText(); break;
			   case 9 :op=productnine.getText(); break;
			   case 10 :op=productten.getText(); break;
			   case 11 :op=producteleven.getText(); break;
			   case 12 :op=producttwelve.getText(); break;
			   case 13 :op=productthirteen.getText(); break;
			   case 14 :op=productfourteen.getText(); break;
			   case 15 :op=productfifteen.getText(); break;
			   default :System.out.println("Please enter valid product"); 
			}
		
			op =op.replace("₹ " , "");
			//op =op.replace(" " , "");
		
		return op;
	}
	
	
	
	//debug method eclipse debug not working with testng
		public void selectmodels() {
			//Select category = new Select(modeldropdown);
			System.out.println("ROW_INDEX:"+row_index);
			//productindex=productindex-row_index;
			System.out.println("Product index:"+productindex);
			if(productindex<=3) {
				System.out.println("1st Model");
				//category.selectByVisibleText("APACHE RTR 200 4V");;
			}else if(productindex>=4&&productindex<=9) {
				System.out.println("2nd model");
				//category.selectByVisibleText("APACHE RTR 160 4V");;
			}else if(productindex>=10&&productindex<=13) {
				System.out.println("3rd model");
				//category.selectByVisibleText("APACHE RTR 160");;
			}else if(productindex>=14&&productindex<=15) {
				System.out.println("4th model");
				//category.selectByVisibleText("APACHE RTR 180");;
			}
			
			
		}
	
		public String alterstate(String inputstate) {
		inputstate =inputstate.replace(" " , "");
		inputstate=inputstate.toLowerCase();
		String temp=new String();
		if(inputstate.contentEquals("andaman")){temp="Andaman Nicobar";}
		else if(inputstate.contentEquals("andhrapradesh")){temp="Andhra Pradesh";}
		else if(inputstate.contentEquals("northeast-arunachalpradesh")){temp="Arunachal Pradesh";}
		else if(inputstate.contentEquals("assam")){temp="Assam";}
		else if(inputstate.contentEquals("bihar")){temp="Bihar";}
		else if(inputstate.contentEquals("chandigarh")){temp="Chandigarh";}
		else if(inputstate.contentEquals("chattisgarh")){temp="Chattisgarh";}
		else if(inputstate.contentEquals("megalaya")){temp="Meghalaya";}
		else if(inputstate.contentEquals("goa")){temp="Goa";}
		else if(inputstate.contentEquals("gujarat")){temp="Gujarat";}
		else if(inputstate.contentEquals("haryana")){temp="Haryana";}
		else if(inputstate.contentEquals("himachalpradesh")){temp="Himachal Pradesh";}
		else if(inputstate.contentEquals("jammu&kashmir")){temp="Jammu & Kashmir";}
		else if(inputstate.contentEquals("jarkhand")){temp="Jharkhand";}
		else if(inputstate.contentEquals("karnataka")){temp="Karnataka";}
		else if(inputstate.contentEquals("kerala")){temp="Kerala";}
		else if(inputstate.contentEquals("madhyapradesh")){temp="Madhya Pradesh";}
		else if(inputstate.contentEquals("maharashtra")){temp="Maharashtra";}
		else if(inputstate.contentEquals("northeast-manipur")){temp="Manipur";}
		else if(inputstate.contentEquals("silvasa")){temp="Dadar & Nagar Haveli";}
		else if(inputstate.contentEquals("northeast-mizoram")){temp="Mizoram";}
		else if(inputstate.contentEquals("northeast-nagaland")){temp="Nagaland";}
		else if(inputstate.contentEquals("orissa")){temp="Odisha";}
		else if(inputstate.contentEquals("pondicherry")){temp="Pondicherry";}
		else if(inputstate.contentEquals("punjab")){temp="Punjab";}
		else if(inputstate.contentEquals("rajasthan")){temp="Rajasthan";}
		else if(inputstate.contentEquals("tamilnadu")){temp="Tamil Nadu";}
		else if(inputstate.contentEquals("telangana")){temp="Telangana";}
		else if(inputstate.contentEquals("northeast-tripura") ){temp="Tripura";}
		else if(inputstate.contentEquals("uttarpradesh")){temp="Uttar Pradesh";}
		else if(inputstate.contentEquals("uttarkhand")){temp="Uttarakhand";}
		else if(inputstate.contentEquals("westbengal")){temp="West Bengal";}
		else if(inputstate.contentEquals("delhi")){temp="Delhi";}
		else {
			temp="invalid"+inputstate;
			
					};
		return temp;
			
	}

}
