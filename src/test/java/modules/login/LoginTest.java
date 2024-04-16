package modules.login;

import dataFactory.UserDataFactory;
import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.time.Duration;

public class LoginTest {
    Driver driver;
    private WebDriver browser;

    @BeforeEach
    public void beforeEach(){
        driver = new Driver();
        this.browser = driver.getDriver();
        this.browser.manage().window().maximize();
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.browser.get("https://practice.automationtesting.in/");
    }

    @Test
    @DisplayName("Teste Login com Sucesso")
    public void testLoginSuccess() throws InterruptedException {
        new HomePage(this.browser)
                .clickButtonMyAccount()
                .inputEmailLogin(UserDataFactory.createUser().getUserLogin())
                .inputPasswordLogin(UserDataFactory.createUser().getUserPassword())
                .clickButtonLogin()
                .checkLogin();
    }

    @Test
    @DisplayName("Teste Login com usuário não registrado")
    public void testLoginWithUnregisteredUser() throws InterruptedException {
        new HomePage(this.browser)
                .clickButtonMyAccount()
                .inputEmailLogin(UserDataFactory.creatNotRegisteredUser().getUserLogin())
                .inputPasswordLogin(UserDataFactory.creatNotRegisteredUser().getUserPassword())
                .clickButtonLoginNotExistingUser()
                .checkUserNotExist();
    }

    @AfterEach
    public void afterEach(){
        this.browser.quit();
    }
}
