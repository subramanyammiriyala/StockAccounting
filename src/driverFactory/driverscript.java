package driverFactory;

import CommonFunLibrary.ERP_Functions;
import Utilities.ExcelFileUtil;

public class driverscript {

	public static void main(String[] args) throws Throwable {
		ExcelFileUtil exl=new ExcelFileUtil();
		ERP_Functions erp=new ERP_Functions();
		int rc=exl.rowcount("supplier");
		for(int i= 0;i<=rc;i++)
		{
			String sname=exl.getdata("supplier", i, 0);
			String address=exl.getdata("Supplier", i, 1);
			String city=exl.getdata("Supplier", i, 2);
			String country=exl.getdata("Supplier", i, 3);
			String pnumber=exl.getdata("Supplier", i, 5);
			String cperson=exl.getdata("Supplier", i, 4);
			String mail=exl.getdata("Supplier", i, 6);
			String mnumber=exl.getdata("Supplier", i, 7);
			String note=exl.getdata("Supplier", i, 8);
			
			erp.lanchAPP("http://webapp.qedge.com");
			erp.login("admin", "master");
			String result=erp.supplier(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
			erp.closerbrw();
			exl.setdata("Supplier", i, 9, result);	
		}

	}

}
