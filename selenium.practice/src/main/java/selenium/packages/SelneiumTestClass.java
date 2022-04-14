package selenium.packages;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.test.JevanKarna;
import selenium.test.Kitchen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*      frame concepts
        driver.findElement(By.xpath("//input[@id='searchBtn']"));
        driver.switchTo().frame("myFrame");
        driver.switchTo().defaultContent()
*/

public class SelneiumTestClass {

    public static WebDriver driver;

    @BeforeClass
    public void takeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void login() {
        /*ChromeOptions chromeOptions= new ChromeOptions();    // for  headless mode
        chromeOptions.setHeadless(true);
        chromeOptions.*/

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
    }


    @Test(priority = 3)
    public static void assignLeave() {
        System.out.println(driver);
        driver.findElement(By.xpath("//span[@class='quickLinkText']")).click();// [contains(text(),'val')]
        driver.findElement(By.xpath("//input[@name='assignleave[txtEmployee][empName]']")).sendKeys("trees Collings");
        driver.findElement(By.xpath("//option[@value='9']")).click();
        driver.findElement(By.xpath("//textarea[@name='assignleave[txtComment]']")).sendKeys("This is a description");
        driver.findElement(By.xpath("//input[@id='assignBtn']")).click();
        Select select = new Select(driver.findElement(By.xpath("//select[@id='assignleave_txtLeaveType']")));
        select.selectByIndex(3);
        select.selectByValue("6");
        select.selectByVisibleText("US - Bereavement");

        driver.findElement(By.xpath("//span[@class='quickLinkText']")).click();// [contains(text(),'val')]

        driver.findElement(By.xpath("//input[@id=\"assignleave_txtFromDate\"]//following-sibling::img[@class=\"ui-datepicker-trigger\"]")).click();
        List<WebElement> fromDates = driver.findElements(By.xpath("//a[@class='ui-state-default']"));

        for (int i = 0; i <= fromDates.size() - 1; i++) {

            if (fromDates.get(i).getText().equals("15")) {
                fromDates.get(i).click();
                break;
            }
        }
        driver.findElement(By.xpath("//input[@id='assignleave_txtToDate']//following-sibling::img[@class='ui-datepicker-trigger']")).click();
        List<WebElement> toDates = driver.findElements(By.xpath("//a[@class='ui-state-default']"));

        for (int j = 0; j <= toDates.size() - 1; j++) {
            if (toDates.get(j).getText().equals("20")) {
                toDates.get(j).click();
                break;
            }
        }
    }

@Test(priority=2)
    public void users() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@id = 'menu_admin_viewAdminModule']")))
                .moveToElement(driver.findElement(By.xpath("//a[@id = 'menu_admin_UserManagement']")))
                .click(driver.findElement(By.xpath("//a[@id = 'menu_admin_viewSystemUsers']")))
                .build().perform();

        driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("Praveen");

        Select userRole = new Select(driver.findElement(By.xpath("//select[@id='searchSystemUser_userType']")));
        userRole.selectByVisibleText("Admin");
        driver.findElement(By.xpath("//input[@id='searchSystemUser_employeeName_empName']")).sendKeys("John Smith");

        Select status = new Select(driver.findElement(By.xpath("//select[@id='searchSystemUser_status']")));
        status.selectByVisibleText("Enabled");

        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();


    }

    /**
     * frames
     * testng
     * junit
     * methods
     * window handle
     * file download/upload
     *
     */
}

























































































































