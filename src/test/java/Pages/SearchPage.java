package Pages;


import io.cucumber.java.eo.Se;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    public static WebDriver driver;


  //  @FindBy(xpath = "//input[@name='username']")
    //static WebElement UserName;

  @FindBy(xpath = "//input[@name='password']")
  static WebElement Password;




    @FindBy(xpath = "//button[@type='submit']")
    static WebElement LoginBtn;



    public SearchPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);


    }

    public static void Login(){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement UserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));

        UserName.sendKeys("Admin");
       // UserName.sendKeys("Admin");
       Password.sendKeys("admin123");
      //  ExtentManager.logInfo("User Entered Login Credentials");
        LoginBtn.click();
       // ExtentManager.logPass("Logged in Successfully");



    }
}
