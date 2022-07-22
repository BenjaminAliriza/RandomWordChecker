package application;

import application.pages.WordCheckingPage;
import org.openqa.selenium.WebDriver;

public class Application {

    private WebDriver driver;
    public WordCheckingPage wordCheckingPage;

    public Application(WebDriver driver){
        wordCheckingPage = new WordCheckingPage(driver);
    }

}
