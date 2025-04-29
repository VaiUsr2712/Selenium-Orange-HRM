package Pages;

import ReusableMethods.Reusablecodes;
import ReusableMethods.Screenshots;
import ReusableMethods.StoredVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {


    public static WebDriver driver;

    Screenshots sp= new Screenshots();


  //  @FindBy(xpath = "//span[text()='PIM']")
    //static WebElement PIM;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    static WebElement Addbtn;

    @FindBy(xpath = "//input[@name='firstName']")
    static WebElement FirstName;

    @FindBy(xpath = " //input[@name='lastName']")
    static WebElement LastName;

    @FindBy(xpath = "//input[@name='middleName']")
    static WebElement MiddleName;

    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    static WebElement EmployeeId;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    static WebElement Savebtn;

    @FindBy(xpath= "//span[text()='PIM']")
    static WebElement PIMbutton;

   @FindBy(xpath="(//*[@class=\"oxd-input oxd-input--active\"])[4]")
            static WebElement Licensenum;


    public PIMPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);



    }


    public void AddCustomer(){


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      WebElement PIM =  wait.until(ExpectedConditions.visibilityOf(PIMbutton));

      PIM.click();

        WebElement Addbtn =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")));

        Addbtn.click();
       // WebElement Addbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));

        WebElement firstname = wait.until(ExpectedConditions.visibilityOf(FirstName));

        FirstName.sendKeys(Reusablecodes.CreateRandonString());
        LastName.sendKeys(Reusablecodes.CreateRandonString());
       // MiddleName.sendKeys(Reusablecodes.CreateRandonString());


        StoredVariables.EID =FirstName.getAttribute("value");

        System.out.println(StoredVariables.EID);

        sp.TakeScreenshot();

        Savebtn.click();



    }

    public void verifyCustCreated(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dln = wait.until(ExpectedConditions.visibilityOf(Licensenum));

        dln.sendKeys(Reusablecodes.CreateRandonInt());

        sp.TakeScreenshot();
    }



}
