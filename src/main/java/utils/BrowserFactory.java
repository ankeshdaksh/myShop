package utils;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Acer on 10/10/2017.
 */
public class BrowserFactory {
    public static WebDriver driver;


    public static void openBrowser() throws MalformedURLException {
        ChromeDriverManager.getInstance().setup();
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver = new ChromeDriver();
        driver.get(AutomationConstant.URL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // driver.manage().window().maximize();

    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void screenShot(Scenario scenario) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/target/screenshot"+scenario.getName()+".png"));
        } catch (Exception e) {
            System.out.println("Failure to take screenShot"+e);

        }

    }
}

