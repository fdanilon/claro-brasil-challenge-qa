package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private WebDriver browser;

    public MyAccountPage(WebDriver browser){
        this.browser = browser;
    }

    public String checkLogin (){
        return this.browser.findElement(By.xpath("//p[contains(.,'Hello')]")).getText();
    }
}
