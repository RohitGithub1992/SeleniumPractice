package selenium.packages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Framing {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://freecrm.com/");
        driver.switchTo().frame("intercom-borderless-frame");
        driver.findElement(By.xpath("//button[@class='intercom-81wcu2 e3s5ecz1']")).click();
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//a[text()='Sign Up']")).click();

    }
}
