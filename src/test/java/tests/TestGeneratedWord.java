package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DictionaryPage;

import java.time.Duration;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestGeneratedWord {

    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.merriam-webster.com/");
        driver.manage().window().maximize();
    }

//    @AfterEach
//    public void tearDown(){
//        driver.quit();
//    }

    @Test
    public void searchRandomWord(){
        DictionaryPage dictionaryPage = new DictionaryPage(driver);
        String word = dictionaryPage.randomString();
        System.out.println(word);
        dictionaryPage.searchGeneratedString(word);
        System.out.println(dictionaryPage.checkFailedText());
    }

}
