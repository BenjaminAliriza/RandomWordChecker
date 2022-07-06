package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class DictionaryPage {

    private WebDriver driver;
    private By searchInput = By.id("s-term");
    private By searchBtn = By.xpath("//div[@class='nav-search-btn desk-search-btn']");
    private By misspelledWordMsg = By.xpath("//div/h1[@class='mispelled-word']");

    public DictionaryPage (WebDriver driver){
        this.driver = driver;
    }

    public void searchGeneratedString(String randomString){
        driver.findElement(searchInput).sendKeys(randomString);
        driver.findElement(searchBtn).click();
    }

    public Boolean checkFailedText(){
        if(driver.findElement(misspelledWordMsg).isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

    public String randomString(){
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int upperBound = 12;
            Random random = new Random();
            int randomInt = random.nextInt(upperBound);
            int targetStringLength = randomInt;
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            String generatedString = buffer.toString();

            return generatedString;
        }


}
