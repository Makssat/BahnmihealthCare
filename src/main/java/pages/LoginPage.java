package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "username")
    private WebElement userNameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "location")
    private WebElement locationField;
    @FindBy(xpath = "//button[.='Login']")
    private WebElement loginButton;

    public void login(String username,String password, String location){
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        BrowserUtils.selectBy(locationField,location,"text");
        this.loginButton.click();
    }
}
