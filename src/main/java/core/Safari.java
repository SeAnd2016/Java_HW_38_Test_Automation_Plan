package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
 
public class Safari {
	
		static WebDriver driver;
 
        public static void main(String[] args) throws InterruptedException {
    	   
	    	// Disable the logs
	   		Logger logger = Logger.getLogger("");
	   		logger.setLevel(Level.OFF);
    	    
    	    // We are checking, if system is Mac
    		if (!System.getProperty("os.name").toUpperCase().contains("MAC"))
    			throw new IllegalArgumentException("Safari is available only on Mac");
    	    
			driver = new SafariDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
 
            System.out.println("Browser is: Safari");
            driver.get("http://facebook.com/");

            //Thread.sleep(1000); // Pause in milliseconds (1000 – 1 sec)
 
            System.out.println("Title: " + driver.getTitle());
            String copyright = driver.findElement(By.xpath("//*[@id=\"pageFooter\"]/div[3]/div/span")).getText();
            System.out.println("Copyright: " + copyright);
            
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys("email");

            driver.findElement(By.id("pass")).clear();
            driver.findElement(By.id("pass")).sendKeys("***");
            
            driver.findElement(By.xpath("//*[@id=\"loginbutton\"]/input")).click();
            
            Thread.sleep(3000); // Pause in milliseconds (10000 – 10 sec)         
            
            driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).click();
            
            Thread.sleep(3000); // Pause in milliseconds (10000 – 10 sec)                
            
            String friends = driver.findElement(By.xpath("//span[@class=\"_gs6\"]")).getText();
            
            System.out.println("You have " + friends + " friends");
            
            driver.findElement(By.xpath("//div[@id=\"logoutMenu\"]/a[1]")).click();   
                    
            driver.findElement(By.xpath("//span[@class=\"_54nh\"][text()=\"Log Out\"]"));
            
			driver.quit();
       }
}
