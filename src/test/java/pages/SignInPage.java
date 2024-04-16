package pages;

import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SignInPage {
    private WebDriver browser;

    public SignInPage(WebDriver browser){
        this.browser = browser;
    }

    public SignInPage inputEmailSignUp (String email){
        this.browser.findElement(By.id("reg_email")).sendKeys(email);

        return this;
    }

    public SignInPage inputPasswordSignUp (String password){
        this.browser.findElement(By.id("reg_password")).click();
        this.browser.findElement(By.id("reg_password")).sendKeys(password);

        return this;
    }

    public SignInPage inputEmailLogin (String email){
        this.browser.findElement(By.id("username")).sendKeys(email);

        return this;
    }

    public SignInPage inputPasswordLogin (String password){
        this.browser.findElement(By.id("password")).click();
        this.browser.findElement(By.id("password")).sendKeys(password);

        return this;
    }

    public MyAccountPage clickButtonRegister() throws InterruptedException {
        Thread.sleep(5000);
        this.browser.findElement(By.id("content")).click();
        this.browser.findElement(By.xpath("//input[@value='Register']")).click();

        return new MyAccountPage(browser);
    }

    public SignInPage clickButtonRegisterExistingUser() throws InterruptedException {
        Thread.sleep(5000);
        this.browser.findElement(By.id("content")).click();
        this.browser.findElement(By.xpath("//input[@value='Register']")).click();

        return this;
    }

    public MyAccountPage clickButtonLogin() throws InterruptedException {
        this.browser.findElement(By.xpath("//input[@value='Login']")).click();

        return new MyAccountPage(browser);
    }

    public SignInPage clickButtonLoginNotExistingUser() throws InterruptedException {
        this.browser.findElement(By.xpath("//input[@value='Login']")).click();

        return this;
    }

    public String checkRegisterExistingUser (){
        return this.browser.findElement(By.xpath("//li[contains(.,'Error: An account is already registered with your email address. Please login.')]")).getText();
    }

    public String checkUserNotExist (){
        return this.browser.findElement(By.xpath("//li[contains(.,'Error: A user could not be found with this email address.')]")).getText();
    }
}
