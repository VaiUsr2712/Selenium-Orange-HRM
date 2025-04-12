package ReusableMethods;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static StepDefinitions.BrowserDriver.driver;

public class Screenshots {

    public static void TakeScreenshot() {
        try {

            // Take Screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);


            // Save the screenshot to the desired location
            String projectPath = System.getProperty("user.dir");

            String folderPath = projectPath+"\\target\\Screenshots";

            // Ensure the folder exists
            Files.createDirectories(Paths.get(folderPath));

            // Generate a unique filename with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filename = "screenshot_" + timestamp + ".png";

            File destFile = new File(folderPath + "\\" + filename);

            Files.copy(srcFile.toPath(), destFile.toPath());

            System.out.println("Screenshot saved successfully!"+filename);

        } catch (IOException e) {
            System.out.println("Error while saving screenshot: " + e.getMessage());
        }
    }
}
