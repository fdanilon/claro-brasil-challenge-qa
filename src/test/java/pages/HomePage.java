package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver browser;

    public HomePage(WebDriver browser){
        this.browser = browser;
    }

    public SignInPage clickButtonMyAccount(){
        this.browser.findElement(By.linkText("My Account")).click();

        return new SignInPage(browser);
    }
}
