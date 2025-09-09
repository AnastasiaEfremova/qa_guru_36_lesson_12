package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class BaseTest {

    @BeforeAll
    static void setupConfig() {

        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion", "127.0");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String remoteUrl = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");


        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
        Configuration.remote = remoteUrl;
        Configuration.timeout = 10000;

        // Настраиваем capabilities для Selenoid
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
}