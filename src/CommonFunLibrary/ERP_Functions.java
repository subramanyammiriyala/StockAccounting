package CommonFunLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ERP_Functions {
	
	WebDriver driver;
	String res;
	
	public String lanchAPP(String url){
	    System.setProperty("webdriver.chrome.driver","E:\\subramanyam\\Stockaccounting_DDF\\drivers\\chromedriver.exe");
	    driver= new ChromeDriver();
	    driver.get(url);
	    driver.manage().window().maximize();
	    
	    if(driver.findElement(By.id("btnsubmit")).isDisplayed()){
	    	res="pass";
	    }
	    else{
	    	res="fail";
	    }
	    return res;
	}
	
    public String login(String username,String password) throws Throwable { 
    	driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(username);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("btnsubmit")).click();
	    Thread.sleep(5000);
	    
		    if(driver.findElement(By.id("logout")).isDisplayed()){
		    	res="pass";
		    }
		    else{
		    	res="fail";
		    }
		    return res; 
    }
  public String supplier(String sname,String address,String city,String country,String cpreson,
		  String ppnumber,String mail,String mnumber,String note) throws Exception{
	  driver.findElement(By.linkText("Suppliers")).click();
	  driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
	  
	  String extdata=driver.findElement(By.xpath("//*[@id='x_Supplier_Number']")).getAttribute("value");
	  
	  driver.findElement(By.name("x_Supplier_Name")).sendKeys(sname);
	  driver.findElement(By.name("x_Address")).sendKeys(address);
	  driver.findElement(By.name("x_City")).sendKeys(city);
	  driver.findElement(By.name("x_Country")).sendKeys(country);
	  driver.findElement(By.name("x_Contact_Person")).sendKeys(cpreson);
	  driver.findElement(By.name("x_Phone_Number")).sendKeys(ppnumber);
	  driver.findElement(By.name("x__Email")).sendKeys(mail);
	  driver.findElement(By.name("x_Mobile_Number")).sendKeys(mnumber);
	  driver.findElement(By.name("x_Notes")).sendKeys(note);
	  
	  driver.findElement(By.name("btnAction")).sendKeys(Keys.ENTER);
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[text()='OK!']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button/span")).click();
	  driver.findElement(By.name("psearch")).sendKeys(extdata);
	  driver.findElement(By.name("btnsubmit")).click();
		  if(driver.findElement(By.xpath("//*[@id='psearch']")).isDisplayed())
		  {
			  driver.findElement(By.xpath("//*[@id='psearch']")).clear();
			  driver.findElement(By.xpath("//*[@id='psearch']")).sendKeys(extdata);
			  driver.findElement(By.name("btnsubmit")).click();
		  }
		  else
		  {
			  driver.findElement(By.xpath("*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
			  driver.findElement(By.xpath("//*[@id='psearch]")).clear();
			  driver.findElement(By.xpath("//*[@id='psearch]")).sendKeys(extdata);
			  driver.findElement(By.name("btnsubmit")).click();
		  }
	    String actdata=driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();
		  if(extdata.equals(actdata))
		  {
			res="pass";  
		  }
		  else
		  {
			  res="fail";
		  }
		  return res;
  }
  public String logout() throws Exception
  {
	  driver.findElement(By.linkText("Logout")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
	  Thread.sleep(5000);
		  if(driver.findElement(By.xpath("//*[@id='btnsubmit']")).isDisplayed())
		  {
			 res="pass";
		  }
		  else
		  {
			res="fail";  
		  }
		  return res;
  }
  public void closerbrw()
  {
	  driver.close();
  }
}
  
    
