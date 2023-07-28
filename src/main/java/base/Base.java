package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {
    public WebDriver driver;

    public WebDriver initializeBrowser(String browserName) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setPlatform(Platform.WIN11);

        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.merge(dc);
                driver = new RemoteWebDriver(new URL("http://192.168.1.97:5555/wd/hub"), chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.merge(dc);
                driver = new RemoteWebDriver(new URL("http://192.168.1.97:5555/wd/hub"), firefoxOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.merge(dc);
                driver = new RemoteWebDriver(new URL("http://192.168.1.97:5555/wd/hub"), edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }

        return driver;
    }
}