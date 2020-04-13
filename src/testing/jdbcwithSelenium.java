package testing;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcwithSelenium extends jdbcConnection{

	public static void main(String[] args) throws SQLException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String username = "test";
		String pwd = jdbcConnection.connect(username);
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='login']")).click();
	}

}
