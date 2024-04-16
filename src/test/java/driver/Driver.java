package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private WebDriver driver;

    public WebDriver getDriver() {
        this.driver = new ChromeDriver();
        return driver;
    }
}
