package medAlg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;





public class testSearch_mozilla {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\surykatka\\Downloads\\mozilladriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(); 
		
		driver.get("https://www.medicalgorithmics.pl/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// animacje... 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// test poprawnoœci za³adowania 
		// czy strona twierdzi, ¿e jest gotowa 
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		if (js.executeScript("return document.readyState").equals("complete")) 
		{
			System.out.println("zdaje siê, ¿e strona jest za³adowana");
		}
		else {
			System.out.println("strona jeszcze nie jest gotowa");
		}
		// sprawdz czy ostatni element na stronie siê za³adowa³ 
		if (ExpectedConditions.presenceOfElementLocated(By.className("footer_bottom")) != null)
		{
			System.out.println("stopka te¿ sie za³adowa³a");
		}else
		{
			System.out.println("ale stopka sie nie zaladowala!");
		}
		

		//test 10 wyników 
		
		driver.findElement(By.xpath("//*[@class='search_button search_slides_from_header_bottom normal']")).click(); 
		driver.findElement(By.className("qode_search_field")).sendKeys("Pocket ECG CRS");
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@class='qode_icon_font_elegant arrow_right qode_icon_element']")).click(); 
		
		// how many 
		List<WebElement> resultsOfSearch = new ArrayList<>(); 
		resultsOfSearch = driver.findElements(By.className("latest_post_custom"));
		//System.out.println(resultsOfSearch.size()); 
		
		if( resultsOfSearch.size() == 10 )
		{
			System.out.println( "tak, jest "+ resultsOfSearch.size() + " wyników wyszkuiwania!"); 
		}
		else {
			System.out.println( "Niestety, znaleziono jedynie "+ resultsOfSearch.size() + " wyników wyszkuiwania!"); 
		}
		
		// ile stron 
		List<WebElement> pages = new ArrayList<>(); 
		pages = driver.findElements(By.xpath("//li/*[@class='inactive']"));
		if (pages.size() == 0) 
		{
			System.out.println( "jest mniej ni¿ 1 strona wynikow"); 
		}
		else if (pages.size()>0)
		{
			System.out.println( "otrzymano: "+ pages.get(pages.size()-1).getText()+ " strony/stron wyników!" ); 
		}
		
		
		// test 1 wyniku 
		driver.get("https://www.medicalgorithmics.pl/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// animacje... 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@class='search_button search_slides_from_header_bottom normal']")).click(); 
		driver.findElement(By.className("qode_search_field")).sendKeys("PocketECG CRS – telerehabilitacja kardiologiczna");
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@class='qode_icon_font_elegant arrow_right qode_icon_element']")).click(); 
		
		// how many 
		List<WebElement> resultsOfSearch2 = new ArrayList<>(); 
		resultsOfSearch2 = driver.findElements(By.className("latest_post_custom"));
		//System.out.println(resultsOfSearch.size()); 
		
		if( resultsOfSearch2.size() == 1 )
		{
			System.out.println( "tak, jest "+ resultsOfSearch2.size() + " wyników wyszkuiwania!"); 
		}
		else {
			System.out.println( "Niestety, znaleziono "+ resultsOfSearch2.size() + " wyników wyszkuiwania!"); 
		}
		
		System.out.println("***koniec***");
		
	}

}
