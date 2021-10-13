package testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import appfunction.AppFunc;
import utilities.Constants;

public class DashboardTestCase extends RootTest 
{

	AppFunc ap=new AppFunc(gf);
	@Test
	public void dashboard() throws FileNotFoundException, IOException
	{
		gf.startchromeBrowser("C:\\Users\\ASTR-34\\Desktop\\MonetFramework\\Drivers\\chromedriver.exe","https://dev.monetrewards.com/diy_beta_1/#/auth");
	    gf.maximixeBrowser();
	    ap.Loadpropfile();
		ap.login(Constants.Uname,Constants.pword);
		ap.dashboard();
		gf.closeBrowser();
	}
	
}
