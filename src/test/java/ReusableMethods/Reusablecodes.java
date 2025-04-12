package ReusableMethods;

import StepDefinitions.BrowserDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Reusablecodes {



    public static String CreateRandonString(){


        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String CreateRandonInt(){


        return RandomStringUtils.randomNumeric(10);
    }

    public static byte[] takesScreenshotAsByte() {
        byte[] screenshot = ((TakesScreenshot) BrowserDriver.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public static File takesScreenshotAsFile() {
        File screenshot = ((TakesScreenshot) BrowserDriver.getWebDriver()).getScreenshotAs(OutputType.FILE);
        return screenshot;
    }
}
