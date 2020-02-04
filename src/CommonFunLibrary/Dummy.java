package CommonFunLibrary;

public class Dummy {

	public static void main(String[] args) throws Throwable {
		ERP_Functions erp=new ERP_Functions();
		
		String resultoflanchapp =erp.lanchAPP("http://webapp.qedge.com/login.php");
	    String resultoflogin=erp.login("admin", "master");
	    
	    String resultofsupplier = erp.supplier("subbu","subbu","subbu", "subbu", "subbu", "1234", "subbu", "1234", "subbu");
        System.out.println(resultofsupplier);
        String resultoflogout = erp.logout();
        System.out.println(resultoflogout);
        erp.closerbrw();
	}

}
