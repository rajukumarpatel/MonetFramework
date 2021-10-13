package generalMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
public class GeneralFunc
{     WebDriver driver;
	  Actions action;
	  Alert a;
	  Robot rb;
	  WebElement e;
	  ArrayList<String> tabs;
      JavascriptExecutor jse;
	 public void startBrowserFirefox(String url)
	 {
		 driver=new FirefoxDriver();
		 driver.navigate().to(url);
		  
		 }
	 public void startchromeBrowser(String driverpath,String url )
	 {
		 System.setProperty("webdriver.chrome.driver",driverpath);
		 driver=new ChromeDriver();
		 driver.get(url);
		 
	 }
	 public void startoperabrowser(String operadriver,String url)
	 {

         System.setProperty("webdriver.opera.driver",operadriver);
         driver=new OperaDriver();
         driver.get(url);
        
	 }
	 public void startieBrowser(String iedriverpath,String url)
	 {
		 
	  System.setProperty("webdriver.ie.driver",iedriverpath);
		 driver=new InternetExplorerDriver();
		 driver.get(url);
		 
	 }
	 public void maximixeBrowser()
	 {
		 driver.manage().window().maximize();
	 }
	 public void opennewTab(String urls)
	 {
		 jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.open()");
		 tabs = new ArrayList<String>(driver.getWindowHandles());
		 System.out.println(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get(urls);
			
			
	 }	
	 public void BacktoOldTab()
	 {
		 
		 
		    driver.switchTo().window(tabs.get(0));
			
	 }
	 public int locatorType(String identifier)
	 {
		 int id=1;
		 if(identifier=="id")
		 {
			 id=1;
			 }
		 else if(identifier=="className")
		 {
			 id=2;
		 }
		 else if(identifier=="cssSelector")
		 {
		   id=3;	 
			 }
		 else if(identifier=="tagName")
			 {
				id=4; 
			 }
		 else if(identifier=="partialLinkText")
			 {
				 id=5;
			      }
			 else if(identifier=="name")
			 {
				 id=6;
			 }
			 else if(identifier=="linkText")
			 {
				 id=7;
		         		 }
			 else if(identifier=="xpath")
			 {
				 id=8;
			 } else {
				  id=0;
				 System.out.println("ocator type invaLlid");
			       
			     }
			 
				 return id;
		           }
	 public WebElement webelementId(String identifier,String locator)
	         { 
	        	 int id=locatorType(identifier);
	        	 
	        	 WebElement e=null;
	        	 switch(id)
	        	 {
	        	 case 1:
	        		e=driver.findElement(By.id(locator));
	        		break;
	        		
	        	 case 2:
	        		 
	        	 e=driver.findElement(By.className(locator));
	        	 break;
	        	 
	        	 case 3:
	        	e=driver.findElement(By.cssSelector(locator));
	        	 break;
	        	  
	        	 case 4:
	        	 e=driver.findElement(By.tagName(locator));
	        	  break;
	        	  
	        	 case 5:
	        	 e=driver.findElement(By.partialLinkText(locator));
	        	  
	        	 break ;
	        	 
	        	 case 6:
	        	e=driver.findElement(By.name(locator));
	        	 
	        	 break;
	        	 
	        	 case 7:
	          e=driver.findElement(By.linkText(locator));
	           break;
	           
	        	 case 8:
	         e=driver.findElement(By.xpath(locator));
	            break ;
	            default:
	           System.out.println("locator not found");
	            
	            break;
	        	 }
	        	 
	        	 return e;
				}
	 public void sendKeys(String identifier,String locator,String content)
	         {
	        	 e=webelementId(identifier, locator);
	        	 e.sendKeys(content);
	        	 
	        	  }
	 public void click(String identifier,String locator)
	         {
	        	 e=webelementId(identifier, locator);
	        	 e.click();
	         }
	 public void selectByValue(String identifier,String locator,String value)
	       {
	    	  e=webelementId(identifier, locator);
	    	  Select osSelect=new Select(e);
	    	  
	    	   osSelect.selectByValue(value);
	      }
	 public void selectByIndex(String identifier,String locator,int index)
	      {
	   	  e=webelementId(identifier, locator);
	   	  Select osSelect=new Select(e);
	   	    osSelect.selectByIndex(index);
	     }
	 public void selectByVisibletext(String identifier,String locator,String utext)
	      {
	    	  e=webelementId(identifier, locator);
	    	  Select osSelect=new Select(e);
	    	  osSelect.selectByVisibleText(utext); 
	    	   }
	 public void VerifyTitle(String title)
	      {
	    	  if(driver.getTitle().equals(title))
	    	  {
	    		  System.out.println(title+"displayed");
	    		  }
	    	  else
	    	  {
	    		  System.out.println("failed to display"+title);
	    	  }
	    	    }
	 public void getTitle()
	 {
		System.out.println(driver.getTitle()); 
	 }
	 public void verifyText(String identifier,String locator,String text )
	      {
	    	   e=webelementId(identifier, locator);
	    	   if(e.isDisplayed())
	    	   {
	    		   System.out.println("text is present");
	    		   System.out.println(e.getText());
	    	   }  
	    	   else
	    	   {
	    		   System.out.println("text is not found");
	    	   }
	    		    }
	 public void gettextofwebelement(String indentifiers,String locators)
	      {
	    	  e=webelementId(indentifiers, locators);
	    	  System.out.println(e.getText());
	    	  
	      }
	 public void getwebelementtextvalu(String id,String lo)
	      {
	    	  e=webelementId(id, lo);
	    	  if(e.getText().equals("Please enter the valid OTP!"))
	    	  {
	    		  System.out.println(e.getText());
	    	  }
	    	  else
	    	  {
	    		System.out.println("Error message is not appeared");  
	    	  } 
	    	  
	      }
	 public void VerifyElementPresent(String Identifier,String locator)
	      {
	    	 e=webelementId(Identifier, locator);
	    	 if(e.isDisplayed())
	    	 {
	    		 System.out.println("Webelement name is "+e.getText());
	    		 //System.out.println(e.getText());
	    	 }
	    	 else
	    	 {
	    		 System.out.println("element is ot found");
	    	 }
	      }
	 public void gettext(String ident,String locpath)
	      {
	    	  e=webelementId(ident, locpath);
	    	  System.out.println(e.getText());
	    	   if(e.getText().equals("Verification link has been sent to your email"))
	    	   {
	    		  System.out.println("Sign-Up test case pass Successfully");
	    		   closeBrowser();  
	    	   }
	    	   else
	    	   {
	    		 System.out.println("Sign-Up test case failed");  
	    		   
	    	   }
	      }
	 public void selectalert()
	      {  
		    
	    	Alert a=driver.switchTo().alert();
	    	 a.accept(); 
	             }
	 public void selectalertdis()
	      {
	
	    	driver.switchTo().alert().dismiss();
	    	 
	    	  
	      }
	 public void switchtowebelement()
	 {
		 driver.switchTo().alert();
	 }
	 public void waitforFindElement(long waittime)
	      {
	    	  try{
	    		  driver.wait(waittime);
	    	      }
	    	  catch(Exception e)
	    	  {
	    		  e.printStackTrace();
	    	  }
	    	    }
     public void waitforPageToLoad()
	       {
	    	 
	    	  try{
	    		  for(int i=0; i<50;)
	    		  {
	    			  if(driver.getTitle().length()!=0)
	    			  {
	    				  System.out.println("page load");
	    				   i=51;
	    				   break;
	    			  }
	    			  else
	    			  {
	    				  Thread.sleep(3000);
	    			  }
	    		  }
	    	  }
	    		  catch (Exception e)
	    		  {
					System.out.println(e);
				 }
	    	  }
	 public void sleep(long time)
	      {
	    	  try{
	    		  Thread.sleep(time);
	    	  }
	    	  catch(Exception e)
	    	  {
	    		  System.out.println(e);
	    	  }
	    	  }
	 public void closeBrowser()
	      {
	    	  driver.close();
	      }
	 public void quitBrowser()
	      {
	    	  
	    	   driver.quit(); 
	    	      
	      }
	 public void robotclssenterfunctionality(String id,String loc) throws AWTException
	      {
	    	  
	    	     e=webelementId(id,loc);
	    	     rb=new Robot();
	    	     rb.keyPress(KeyEvent.VK_TAB);
	    		 rb.keyRelease(KeyEvent.VK_TAB);
	    		 rb.keyPress(KeyEvent.VK_ENTER);
	    		 rb.keyRelease(KeyEvent.VK_ENTER);
	    		 rb.keyPress(KeyEvent.VK_UP);
	    		 rb.keyRelease(KeyEvent.VK_UP);
	    		 rb.keyPress(KeyEvent.VK_UP);
	    		 rb.keyRelease(KeyEvent.VK_UP);
	    		 
	    		 rb.keyPress(KeyEvent.VK_ENTER);
	    		 rb.keyRelease(KeyEvent.VK_ENTER);
	    		 
	      }
	 public void robotsleep(int time)
	      {
	    	  rb.delay(time);
	    	  
	    	  
	      }
	 public void refreshBrowser()
	      {
	    	  driver.navigate().refresh();
	    	  
	      }
	 public void otpverification(String id,String lopath)
	      {
	    	  e=webelementId(id, lopath);
	        
	    	   if(e.getText().equals("OTP for forget password has been sent to your email"))
	    	   {
	    		   System.out.println(e.getText());
	    		   
	    	   }
	    	   else
	    	   {
	    		 System.out.println("Otp has not been sent to your mail ");  
	    	   } }
	 public void getTextmsg(String ide,String locpaths,String textmsg)
	      {
	    	  
	    	  e=webelementId(ide, locpaths);
		        
	    	   if(e.getText().equals(textmsg))
	    	   {
	    		   System.out.println(e.getText());
	    		}
	    	   else
	    	   {
	    		  System.out.println("Message is not appeared"); 
	    		   
	    	   }
	    	  
	    	  
	      }
	 public void implicitwait(long times)
	      {
	    	driver.manage().timeouts().implicitlyWait(times,TimeUnit.SECONDS);
	      }
	 public void back()
     {
     driver.navigate().back(); 
    	 
     }
	 public void forword()
	 {
	 driver.navigate().forward();
	 }
	 public void currentpageUrl()
     {
     String currentpage=driver.getCurrentUrl();
     System.out.println(currentpage);
    	 
     }
     public void scrollpageDown()
     {
         jse=(JavascriptExecutor)driver;
         jse.executeScript("window.scrollBy(0,1000)");
     }
     public void scrollpgeUp()
     {
    	 jse=(JavascriptExecutor)driver;
         jse.executeScript("window.scrollBy(0,-1000)");
          
     }
     public void cleartext(String id,String loc)
     {
    	e=webelementId(id, loc);
    	e.clear();
  
     }
     public void uploadfile(String compilepath) throws IOException
     {
    	Runtime.getRuntime().exec(compilepath); 
    	 
     }
     public void keyboardtab(int n) throws AWTException
     {
    	 rb=new Robot();
    	 for(int i=1; i<=n; i++)
    	 { 
    	 rb.keyPress(KeyEvent.VK_TAB);
    	 rb.keyRelease(KeyEvent.VK_TAB);
    	 }
     }
     public void keyboardDown(int n) throws AWTException
     {
    	 rb=new Robot();
    	 for(int i=1; i<=n; i++)
    	 {
    	 rb.keyPress(KeyEvent.VK_DOWN);
    	 rb.keyRelease(KeyEvent.VK_DOWN);
    	 }
     }
     public void keyboardUp(int n) throws AWTException
     {
    	 rb=new Robot();
    	 for(int i=1; i<=n; i++)
    	 {
    	 rb.keyPress(KeyEvent.VK_UP);
    	 rb.keyRelease(KeyEvent.VK_UP);
    	 }
     

      }
     public void KeyboardEnter(int n) throws AWTException
     {
    	rb=new Robot(); 
    	for(int i=1; i<=n; i++)
    	{
    	rb.keyPress(KeyEvent.VK_ENTER);
    	rb.keyRelease(KeyEvent.VK_ENTER);
    	}
     }
     public void Deletecookies()
     {
       driver.manage().deleteAllCookies();
    	 
      }
     public void getcookies()
     {
    	Set<Cookie> cookies=driver.manage().getCookies();
    	System.out.println("Cookies Name ="+cookies); 
     }
     public void keyboardBackSpace(String identifier,String locator, Keys k,int n)
     {
    	 e=webelementId(identifier, locator);
    	 for(int i=1; i<=n; i++)
    	 {
    	 e.sendKeys(k);
    	 }
     }
     public void keyboardSpace(int n) throws AWTException
     {
    	 rb=new Robot();
    	 for(int i=1; i<=n; i++)
    	 {
    	 rb.keyPress(KeyEvent.VK_SPACE);
    	 rb.keyRelease(KeyEvent.VK_SPACE);
    	 }
     }
     public void Backspace(int n) throws AWTException
     {
    	 rb=new Robot();
    	 for(int i=1; i<=n; i++)
    	 {
    	 rb.keyPress(KeyEvent.VK_BACK_SPACE);
    	 rb.keyRelease(KeyEvent.VK_BACK_SPACE);
    	 }
     }
     public void mousemorehover(String id,String loc)
     {
    
    	 e=webelementId(id,loc);
    	 action=new Actions(driver);
    	 action.moveToElement(e).build().perform();
   
    	 
    	
     }
     public void dragandDropfunction(String id,String loc,String sid,String dloc)
     { 
    	WebElement s=webelementId(id, loc);
    	WebElement d=webelementId(sid, dloc);
    	    action=new Actions(driver);
    	    sleep(2000);
    	    action.dragAndDrop(s, d).build().perform();
    	    
     }
     public void screenshot( String sspath, String ssname) throws IOException
     {
    	  File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src,new File(sspath+ssname+".png"));
	 }
     public void space(String identifier,String locator,Keys space)
         {
        	 e=webelementId(identifier, locator);
        	 e.sendKeys(space);
        	 
        	  }
     public boolean IsDisplayed(String indentifiers,String locators)
     {
   	  e=webelementId(indentifiers, locators);
	  return e.isDisplayed();
     
   	 
	  }
     public boolean isEnabled(String indentifiers,String locators)
    	     {
      	  e=webelementId(indentifiers, locators);
      	  return e.isEnabled();
    	     }
     public boolean isSelected(String indentifiers,String locators)
    	     {
      	  e=webelementId(indentifiers, locators);
      	  return e.isSelected();
    	     }
     
     
     
}

	

