package core;

import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
 
public class Safari {
 
       public static void main(String[] args) throws InterruptedException {
			WebDriver driver;
			driver = new SafariDriver(); 
			driver.manage().window().maximize();
 
            System.out.println("Browser is: Safari");
            driver.get("http://facebook.com/");

            Thread.sleep(1000); // Pause in milliseconds (1000 – 1 sec)
 
            System.out.println("Title: " + driver.getTitle());
            String copyright = driver.findElement(By.xpath("//*[@id=\"pageFooter\"]/div[3]/div/span")).getText();
            System.out.println("Copyright: " + copyright);
            driver.findElement(By.id("email")).sendKeys("email");

            driver.findElement(By.id("pass")).sendKeys("password");
            driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();
            
            Thread.sleep(10000); // Pause in milliseconds (10000 – 10 sec)
            
            String contacts = driver.findElement(By.xpath("//*[@id=\"u_0_20\"]/div/div/div[3]/div/div")).getText();
            System.out.println("Logged in was successfull Contacts is: " + contacts);
            
            
            //driver.findElement(By.xpath("//aria-label[text()=\"Search\"]/../input")).sendKeys("Elena");
 
            //driver.findElement(By.xpath("//*[@id=\"profile_pic_header_100009347579231\"/span")).click();
 
            //String friends = driver.findElement(By.xpath("//*[@id=\"u_fetchstream_2_a\"]/li[3]/a/span[1]")).getText();
            //System.out.println("You have " + friends + " friends");
			//driver.findElement(By.xpath("//*[@id=\"userNavigationLabel\"]")).click();
			//driver.findElement(By.xpath("//*[@id=\"js_e6\"]/div/div/ul/li[14]/a/span/span")).click(); 
			driver.quit();
       }
}
