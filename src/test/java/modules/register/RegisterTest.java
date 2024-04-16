package modules.register;


import dataFactory.UserDataFactory;
import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.time.Duration;

public class RegisterTest {
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
    @DisplayName("Teste Cadastro com Sucesso")
    public void testRegisterSuccess() throws InterruptedException {
        new HomePage(this.browser)
                .clickButtonMyAccount()
                .inputEmailSignUp(UserDataFactory.createUser().getUserLogin())
                .inputPasswordSignUp(UserDataFactory.createUser().getUserPassword())
                .clickButtonRegister()
                .checkLogin();
    }

    @Test
    @DisplayName("Teste Cadastro sem Sucesso")
    public void testResgisterWithAnExistingUser() throws InterruptedException {
        new HomePage(this.browser)
                .clickButtonMyAccount()
                .inputEmailSignUp(UserDataFactory.createUser().getUserLogin())
                .inputPasswordSignUp(UserDataFactory.createUser().getUserPassword())
                .clickButtonRegisterExistingUser()
                .checkRegisterExistingUser();
    }

    @AfterEach
    public void afterEach(){
        this.browser.quit();
    }

}
