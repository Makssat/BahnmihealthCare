package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {
    //We will create our methods related with browser
    //Inside the browserUtils class
    /*
    method that accepts three param- WebElement and value,method name
    SelectbyVisibletext
     */
    public static void selectBy(WebElement element,String value, String methodName){
        //method name can be text , index value
        Select select=new Select(element);
        switch (methodName){
            case "text" :
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available. Use text, value , or index for method name");
        }
    }
    //Method will get webelement and return text
    public static String getText(WebElement element){
        return element.getText().trim();
    }



    //It will switch window by given target title
    public static void switchByTitle(WebDriver driver, String title){
        Set<String > ids=driver.getWindowHandles();
        for (String id:ids
             ) {
            driver.switchTo().window(id);
            if(driver.getTitle().contains(title)){
                break;
            }

        }
    }
    public static void switchByUrl(WebDriver driver, String Url){
        Set<String > ids=driver.getWindowHandles();
        for (String id:ids
        ) {
            driver.switchTo().window(id);
            if(driver.getCurrentUrl().equals(Url)){
                break;
            }

        }
    }
    //it will close all the window if its not equal to given title
    public static void closeWindowByTitle(WebDriver driver, String title){
        Set<String>ids =driver.getWindowHandles();
        for(String id: ids){
            driver.switchTo().window(id);
            if (!driver.getTitle().equals(title)){
                driver.close();
            }
        }
    }
    ///Implement methods switch window by its URL


    //This script will scroll page untill given element
    public static void scrollToView(WebDriver driver, WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }
    public static void getScreenShot(WebDriver driver,String packageName){
       // getScreenShot(); method is taking a screenshot and returning the file of the screen
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location=System.getProperty("user.dir")+"/src/main/java/selenium/screenshot/"+packageName+"/";
        try {
            FileUtils.copyFile(file, new File(location+System.currentTimeMillis()+".png"));
        } catch (IOException e) {
            System.out.println("Screenshot is not stored");
            e.printStackTrace();
        }


    }
}
