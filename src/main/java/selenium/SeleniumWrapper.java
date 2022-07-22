package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWrapper {

    WebDriver driver;

    public SeleniumWrapper (WebDriver driver){
        this.driver = driver;
    }
    public WebElement find(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
    public void click(By element){
        find(element).click();
    }
    public String getText(By element){
        return find(element).getText();
    }
    public void sendKeys(By element, String keys){
        find(element).sendKeys(keys);
    }
    public void get(String url){
        driver.get(url);
    }
    public void back(){
        driver.navigate().back();
    }
    public void selectFromDropDown(By by, String text){
        Select dropdown = new Select(find(by));
        dropdown.selectByVisibleText(text);
    }
}
