package Pages;

import ReusableMethods.Screenshots;
import org.apache.poi.sl.draw.geom.GuideIf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DirectoryPage {
    public static WebDriver driver;

    @FindBy(xpath="//a[@href='/web/index.php/directory/viewDirectory']")
    static WebElement dirbutton;

    @FindBy(xpath="//div[text()='Chief Financial Officer']")
    static WebElement jtele;

    @FindBy(xpath="//div[text()='Texas R&D']")
    static WebElement locnele;

    @FindBy(xpath="//button[@type='submit']")
    static WebElement Search;

    @FindBy(xpath="//p[text()='QA Engineer']")
    static WebElement Empdetails;

    @FindBy(xpath="//p[text()='rebecca1@osohrm.com']")
    static WebElement workemail;

    @FindBy(xpath="//button[@type='reset']")
    static WebElement reset;

    @FindBy(xpath="(//div/i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]")
    static WebElement jtdropdown;

    @FindBy(xpath="(//div/i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]")
    static WebElement locdropdown;

    public DirectoryPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void SearchEmployee(String jt, String loc) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dirbtn = wait.until(ExpectedConditions.visibilityOf(dirbutton));

        dirbtn.click();

        //Select Jobtitle from the dropdown>

        WebElement dropdown1= wait.until(ExpectedConditions.visibilityOf(jtdropdown));
        dropdown1.click();

        WebElement Option1 = driver.findElement(By.xpath("//div[contains(text(),'Automaton Tester')]"));

        Option1.click();

        WebElement jobtitle = wait.until(ExpectedConditions.visibilityOf(jtele));

        jobtitle.click();

       //Select Location from the dropdown
        WebElement dropdown2= wait.until(ExpectedConditions.visibilityOf(locdropdown));

        Select select2 = new Select(dropdown2);

        WebElement location= wait.until(ExpectedConditions.visibilityOf(locnele));

        select2.selectByVisibleText(loc);

        location.click();

        //Searching Employee after providing Jobtitle & Location

        Search.click();

        WebElement employee= wait.until(ExpectedConditions.visibilityOf(Empdetails));

        String empdetails= employee.getText();

        try {

            if (jt.equalsIgnoreCase(empdetails)) {

                employee.click();

                WebElement workmail = wait.until(ExpectedConditions.visibilityOf(workemail));
                System.out.println(workmail.getText());
                Screenshots.TakeScreenshot();
                employee.click();
                reset.click();

            }

        } catch (Exception e) {
            throw new RuntimeException("Employee details not found"+ e);
        }

        }


    }


