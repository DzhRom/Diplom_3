package models;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChoiceWebDriver {

    public static WebDriver createWebDriver(String browser){
        if (browser == null) {
            return createChromeDriver();
        }
        switch(browser) {
            case "yandex":
                return  createYandexDriver();
            case "chrome":
            default:
                return  createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createYandexDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Dzhaniki\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        return new ChromeDriver(options);
    }
}
