package ReusableMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class PropertyReader {


   /* static {
        loadRunConfigProps("/environment.properties");
    }

    public static void loadRunConfigProps(String configPropertyFileLocation) {
        environmentProps = new Properties();

        try (InputStream inputStream = PropertyReader.class.getResourceAsStream(configPropertyFileLocation)) {
            environmentProps.load(inputStream);
            environmentProps.list(out);
        } catch (IOException e) {
        }
        env = environmentProps.getProperty("env");
    }*/

    static Properties prop = new Properties();

    public PropertyReader() throws IOException {
        try (FileInputStream file = new FileInputStream("C:\\Users\\ragha\\IdeaProjects\\Selenium\\src\\test\\resources\\environments\\uat1.properties")) {
            prop.load(file);
        }
    }

    public static String getProp(String propertyName) {



        return prop.getProperty(propertyName);


    }
}
