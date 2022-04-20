package selenium.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Testclass {
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
    }


    @Test(priority = 2)
    public static void assignLeave() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='quickLinkText']")).click();// [contains(text(),'val')]
        driver.findElement(By.xpath("//input[@name='assignleave[txtEmployee][empName]']")).sendKeys("Mike Colly");
        driver.findElement(By.xpath("//option[@value='9']")).click();
        driver.findElement(By.xpath("//textarea[@name='assignleave[txtComment]']")).sendKeys("This is a description");
        driver.findElement(By.xpath("//input[@id='assignBtn']")).click();
        Select select = new Select(driver.findElement(By.xpath("//select[@id='assignleave_txtLeaveType']")));
       /* select.selectByIndex(3);
        select.selectByValue("6");*/
        select.selectByVisibleText("US - Bereavement");

        // driver.findElement(By.xpath("//span[@class='quickLinkText']")).click();

        driver.findElement(By.xpath("//input[@id=\"assignleave_txtFromDate\"]//following-sibling::img[@class=\"ui-datepicker-trigger\"]")).click();
        List<WebElement> fromDates = driver.findElements(By.xpath("//a[@class='ui-state-default']"));

        for (int i = 0; i <= fromDates.size() - 1; i++) {

            if (fromDates.get(i).getText().equals("17")) {
                fromDates.get(i).click();
                break;
            }
        }
        driver.findElement(By.xpath("//input[@id='assignleave_txtToDate']//following-sibling::img[@class='ui-datepicker-trigger']")).click();
        List<WebElement> toDates = driver.findElements(By.xpath("//a[@class='ui-state-default']"));

        for (int j = 0; j <= toDates.size() - 1; j++) {
            if (toDates.get(j).getText().equals("21")) {
                toDates.get(j).click();
                break;
            }
        }
        driver.findElement(By.xpath("//input[@id='assignBtn']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
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

    @Test(priority = 6)
    public void buzz() throws AWTException, IOException {
        driver.findElement(By.xpath("//a[@id='menu_buzz_viewBuzz']")).click();
        driver.findElement(By.xpath("//a[@id='images-tab-label']")).click();
        WebElement uploadFile = driver.findElement(By.xpath("//input[@id='image-upload-button']"));
        uploadFile.click();

    }
@Test(priority=4)
    public void projectReport(){
    Actions actionsPR = new Actions(driver);
    actionsPR.moveToElement(driver.findElement(By.xpath("//a[@id = 'menu_time_viewTimeModule']")))
            .moveToElement(driver.findElement(By.xpath("//a[@id='menu_time_Reports']")))
            .click(driver.findElement(By.xpath("//a[@id='menu_time_displayProjectReportCriteria']")))
            .build().perform();

        Select selectPR = new Select(driver.findElement(By.xpath("//select[@id='time_project_name']")));
        selectPR.selectByVisibleText("Apache Software Foundation - ASF - Phase 1");
        driver.findElement(By.xpath("//input[@id='project_date_range_from_date']//following-sibling::img[@class='ui-datepicker-trigger']")).click();
        List<WebElement> fromProjectDates =driver.findElements(By.xpath("//a[@class='ui-state-default']"));
        for (int k=0 ; k<=fromProjectDates.size()-1 ; k++){
            if(fromProjectDates.get(k).getText().equals("14")){
                fromProjectDates.get(k).click();
                break;
            }
        }
        List<WebElement> toProjectDates =driver.findElements(By.xpath("//a[@class='ui-state-default']"));
        for (int m=0 ; m<=toProjectDates.size()-1 ; m++){
            if(toProjectDates.get(m).getText().equals("22")){
                fromProjectDates.get(m).click();
                break;
            }
        }
        driver.findElement(By.xpath("//input[@id='only_include_approved_timesheets']")).click();
        driver.findElement(By.xpath("//input[@id='viewbutton']")).click();
    }
@Test(priority = 5)
    public void Recruitment(){
        driver.findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']")).click();
        driver.findElement(By.xpath("//a[@id='menu_recruitment_viewJobVacancy']")).click();
        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@id='vacancySearch_jobTitle']")));
        jobTitle.selectByVisibleText("BTest");

        Select vacancy = new Select(driver.findElement(By.xpath("//select[@id='vacancySearch_jobVacancy']")));
        vacancy.selectByVisibleText("All");

        Select hiringManager = new Select(driver.findElement(By.xpath("//select[@id='vacancySearch_hiringManager']")));

        Select status= new Select(driver.findElement(By.xpath("//select[@id='vacancySearch_status']")));
        status.selectByVisibleText("Active");

        driver.findElement(By.xpath("//input[@id='btnSrch']")).click();



    }
}
