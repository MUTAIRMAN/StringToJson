package MuthuMaven.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import junit.framework.Assert;

public class NewTest {

	WebDriver driver;

	@Test
	public void f() throws IOException, InterruptedException {

		File f = new File("C:\\Users\\Muthukumar\\Desktop\\SampleFiles\\MuthuTestBDD.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String st;
		String h[];
		JsonObject js = new JsonObject();

		while ((st = br.readLine()) != null) {
			h = st.split("=");

			js.addProperty(h[0], h[1]);
		}

		System.out.println(js);

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Muthukumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jsonformatter.curiousconcept.com/");
		driver.findElement(By.id("jsondata")).sendKeys(js.toString());

		driver.findElement(By.name("process")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class=\"bottom\"]/div[1][contains(text(),'Valid (RFC 8259)')]"))
						.isDisplayed(),
				true);
		Thread.sleep(10000);
		// driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		driver.quit();

	}
}