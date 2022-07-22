package application.pages;

import application.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.SeleniumWrapper;

import java.util.Random;

public class WordCheckingPage {

    private WebDriver driver;
    private SeleniumWrapper selenium;
    private By searchInput = By.xpath("//input[@name='word']");
    private By searchBtn = By.xpath("//button/i/..");
    private By validityResult = By.xpath("//div[@id='check_dict_page']/h3/span");
    private By definition = By.xpath("//div[@id='advancedOptions']/pre");
    private By definitionArea = By.xpath("//div[@id='advancedOptions']");

    public WordCheckingPage(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumWrapper(driver);
    }

    public String getDefinitionArea(){
        return selenium.getText(definitionArea);
    }

    public void loadWordCheckingPage(){
        selenium.get("https://scrabblewordfinder.org/dictionary-checker");
    }

    public void searchGeneratedString(String randomString) {
      // if the random string generated nothing, it will go into the loop and make a new random string
            if (randomString.trim().equals("")) {
                do {
                randomString = randomString();
                }while (randomString.trim().equals(""));
            }
        // once an acceptable random string is generated, it will go through
        selenium.sendKeys(searchInput, randomString);
        selenium.click(searchBtn);
        }

    public String definition(){
        return selenium.getText(definition);
    }

    public void goBack(){
        selenium.back();
    }

    public Boolean checkFailedText() {
        if (selenium.getText(validityResult).equals("Not a valid word.")) {
            return true;
        } else {
            return false;
        }
    }

    public String randomString() {
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
