
import java.time.Duration;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloWorld {

	@Test
	public static void chromeSession() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		Scanner sc = new Scanner(System.in);
		try {
			driver.get("https://google.com");
			Thread.sleep(500);

			driver.manage().window().maximize();
			driver.findElement(By.name("q")).sendKeys("youtube" + Keys.ENTER);

			WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(3))
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));

			firstResult.click();
			Thread.sleep(1000);
			// we are in youtube
			driver.findElement(By.name("search_query")).sendKeys("csgo");
			driver.findElement(By.name("search_query")).sendKeys(Keys.ENTER);

//			driver.findElement(By.id("email")).sendKeys(System.getenv("FB_ACC"));
//			driver.findElement(By.id("pass")).sendKeys(System.getenv("FB_PW"));
//			driver.findElement(By.name("login")).click();

		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		chromeSession();
	}
}
