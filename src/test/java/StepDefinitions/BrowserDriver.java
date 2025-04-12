package StepDefinitions;

import ReusableMethods.PropertyReader;
import ReusableMethods.Reusablecodes;
import ReusableMethods.Screenshots;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;


import static ReusableMethods.Reusablecodes.takesScreenshotAsByte;

public class BrowserDriver {

    public static WebDriver driver;


    static PropertyReader propertyReader;

    static {
        try {
            propertyReader = new PropertyReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BrowserDriver() throws IOException {
    }

    @Before(order=1)

    public static void Clearscreeshots(){
        String projectPath = System.getProperty("user.dir");

        String folderPath = projectPath+"\\target\\Screenshots";

        // Get the folder as a File object
        File folder = new File(folderPath);

        // Check if folder exists
        if (folder.exists() && folder.isDirectory()) {
            // List all files inside the folder
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete(); // Delete each file
                    }
                }
            }
            System.out.println("All screenshots deleted from: " + folderPath);
        } else {
            System.out.println("Folder does not exist: " + folderPath);
        }
    }
    @Before(order =2)
    public static void Webdriverinit(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
       //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        driver.get(PropertyReader.getProp("url"));

        driver.manage().window().maximize();


    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            BrowserDriver.Webdriverinit();  // Create instance only if not already created
        }
        return driver;
    }

    @After(order=1)
    public static void Quitdriver(){
        BrowserDriver.getWebDriver().quit();
    }



    @After(order = 2)
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed()) {
            scenario.attach(takesScreenshotAsByte(), "image/png", scenario.getName());
        }

            }


}
