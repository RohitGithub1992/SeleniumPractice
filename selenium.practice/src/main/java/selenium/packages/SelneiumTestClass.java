package selenium.packages;

import autoitx4java.AutoItX;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.test.JevanKarna;
import selenium.test.Kitchen;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
    }


    @Test(priority = 2)
    public static void assignLeave() {
        System.out.println(driver);
        driver.findElement(By.xpath("//span[@class='quickLinkText']")).click();// [contains(text(),'val')]
        driver.findElement(By.xpath("//input[@name='assignleave[txtEmployee][empName]']")).sendKeys("trees Collings");
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

            if (fromDates.get(i).getText().equals("16")) {
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
        driver.findElement(By.xpath("//input[@id='assignBtn']")).click();
    }

    @Test(priority = 2)
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

    @Test(priority = 3)
    public void buzz() throws AWTException, IOException {
        driver.findElement(By.xpath("//a[@id='menu_buzz_viewBuzz']")).click();
        driver.findElement(By.xpath("//a[@id='images-tab-label']")).click();
        WebElement uploadFile = driver.findElement(By.xpath("//input[@id='image-upload-button']"));
        uploadFile.click();
      /*  uploadFile.sendKeys("D://Logo_Elexsa.PNG");
        driver.findElement(By.xpath("//*[@id=\"imageUploadBtn\"]")).click();*/
        //Runtime.getRuntime().exec("D://Logo_Elexsa.PNG");

    }


//    @Test(priority = -1)
//    public void heroku(){
//        driver.get("https://testpages.herokuapp.com/styled/index.html");
//      /*  WebElement clickk=driver.findElement(By.xpath("//a[@id=\"alerttestjs\"]"));
//        JavascriptExecutor javascriptExecutor=((JavascriptExecutor) driver);
//        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",clickk);
//        clickk.click();
//        driver.findElement(By.xpath("//input[@id=\"confirmexample\"]")).click();
//        driver.switchTo().alert().dismiss();*/
//    }
//
//    @Test(priority = 1)
//    public void second(){
//        WebElement clickk=driver.findElement(By.xpath("//a[@id=\"windowstest\"]"));
//        JavascriptExecutor javascriptExecutor=((JavascriptExecutor) driver);
//        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",clickk);
//        String oldwin=driver.getWindowHandle();
//        System.out.println(oldwin);
//       clickk.click();
//       driver.findElement(By.xpath("//a[@id=\"gobasicajax\"]")).click();
//        Set<String> windows=driver.getWindowHandles();
//        for (String multiple:windows) {
//            if (!multiple.equals(oldwin)){
//                driver.switchTo().window(multiple);
//            }
//
//        }
//
//driver.switchTo().window(oldwin);
//       Select select= new Select(driver.findElement(By.xpath("//select[@name=\"id\"]")));
//       select.selectByValue("2");
//
//    }
//
//    /**
//     * frames - done
//     * testng
//     * junit
//     * jenkins
//     * methods
//     * window handle -- done
//     * file download/upload -- done
//     * dropdown - done
//     * actions - done
//     * alert - done
//     * findElements -- done
//     * scroll- done
//     * collection: set -- done
//     * exception - done
//     *
//     */
//
  /*  public static void main(String[] args) {
        Set<Integer> set= new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
      //  System.out.print(set);
        Set<Integer> set1= new HashSet<>();
        set1.add(9);
        set1.add(8);
        set1.add(37);
        set1.add(6);
        set1.add(566);
        set.addAll(set1);
        set.retainAll(set1);
        for (Integer a:set) {
            System.out.println(a);
        }
       // System.out.println(set);
    }
*/
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(0, 1);
        list.add(1, 2);
        list.add(4);

        System.out.println(list);

        List<Integer> l2 = new ArrayList<>();
        l2.add(5);
        l2.add(6);
        l2.add(7);

        list.addAll(1, l2);
        System.out.println(list);

        //list.addAll(l2);

        list.remove(1);
        System.out.println(list);

        System.out.println(list.retainAll(l2));

       System.out.println(list.get(3));

        list.set(0, 5);
        System.out.println(list);

        for (Integer a:list) {
           System.out.println(a);
        }
        String [] a= new String[7];
        ArrayList<String> arrayList= new ArrayList<>();
        arrayList.forEach(c-> System.out.println(c));
        arrayList.iterator().forEachRemaining(b-> System.out.println(b));


    }
}


























































































































