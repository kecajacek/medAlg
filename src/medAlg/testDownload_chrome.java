package medAlg;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class testDownload_chrome {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\surykatka\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		
		driver.get("https://www.medicalgorithmics.pl/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollTo(0, 1500)");
		
		// color check 
		//driver.findElement(By.id("mega-menu-item-29")).
		String colorB;
		WebElement kontaktElement = driver.findElement(By.xpath("//*[@class='mega-menu-link' and contains(text(), 'Kontakt')]")); 
		colorB = kontaktElement.getCssValue("color");
		System.out.println(colorB);
		Actions action = new Actions(driver);
		action.moveToElement(kontaktElement).perform();
		
		//wait 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String colorA; 
		colorA = kontaktElement.getCssValue("color");
		System.out.println(colorA);
		if (colorB.compareTo(colorA)==0) { 
			System.out.println("kolor sie nie zmienil!"); 
		}
		else { 
			System.out.println("kolor sie zmieni³ :)"); 
		}
		
		// 
		driver.findElement(By.id("mega-menu-item-29")).click();
		/*
		 * // wait for map try { Thread.sleep(2000); // scroll down
		 * js.executeScript("window.scrollTo(0, 1500)"); } catch (InterruptedException
		 * e) { e.printStackTrace(); }
		 * 
		 */


		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		js.executeScript("window.scrollTo(0, 2500)");
		driver.findElement(By.xpath("//*[contains(@alt, 'ico-circle-media')]")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//download 
		driver.findElement(By.xpath("//*[contains(@href, 'logotypy')]")).click();
		
		// wait 
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//check folder 
		String dpath = System.getProperty("user.home");
		dpath = dpath + "\\Downloads";
		//System.out.println(dpath);
		String fileName = "logotypy"; 
		File plik = new File(dpath + "\\" +fileName); 
		
		//System.out.println(plik.exists());
		
		if (plik.exists()) { 
			System.out.println("plik pobrany z du¿ym prawodpodobieñstwem sukcesu!"); 
		}
		else { 
			System.out.println("czy¿by jakiœ problem?"); 
		}
	}

}
