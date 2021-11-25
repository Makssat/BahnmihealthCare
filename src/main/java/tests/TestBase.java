package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.Driver;

public class TestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= Driver.getDriver();
        driver.get(ConfigReader.readProperty("loginUrl"));
    }
}
