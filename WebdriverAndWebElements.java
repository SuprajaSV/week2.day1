package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverAndWebElements {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String driverpath = System.getProperty("Webdriver.chrome.driver");
		System.out.println(driverpath);
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestCompany");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Supraja");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Venu");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Supraja");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("AT");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Basic automation takes simple");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("yesimsupraja@gmail.com");
		
		WebElement at = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select d = new Select(at);
		d.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		//String title = driver.getTitle();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		Thread.sleep(5000);
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("LeafTest");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		Thread.sleep(5000);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sharmila");

		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		


	}
}
