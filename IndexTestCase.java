package testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import appfunction.AppFunc;
import utilities.Constants;

public class IndexTestCase extends RootTest
{

	AppFunc ap=new AppFunc(gf);
	
    @Test
    public void indexpage() throws FileNotFoundException, IOException
    {
    	gf.startchromeBrowser("C:\\Users\\ASTR-34\\Desktop\\files\\chromedriver_win32\\chromedriver.exe","https://dev.monetrewards.com/diy_beta_1/#/auth");
	    gf.maximixeBrowser();
	    ap.Loadpropfile();
    	gf.sleep(3000);
    	ap.login(Constants.Uname,Constants.pword);
    	ap.indexpage();
    	gf.closeBrowser();
    }
	
	
	
}
