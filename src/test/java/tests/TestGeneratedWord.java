package tests;

import heart.Heart;
import org.junit.jupiter.api.*;

public class TestGeneratedWord extends Heart {


    @Test
    public void searchRandomWord(){
        boolean aRealWord;
        String word;
        String definitionArea;
        do {
            application.wordCheckingPage.loadWordCheckingPage();
            word = application.wordCheckingPage.randomString();
            System.out.println(word);
            application.wordCheckingPage.searchGeneratedString(word);
            aRealWord = application.wordCheckingPage.checkFailedText();
            definitionArea = application.wordCheckingPage.getDefinitionArea();
            application.wordCheckingPage.goBack();
        }while (aRealWord);
        System.out.println("\n\nCongratulations! '" + word + "' is a word!\n" + definitionArea);
    }

    @Test
    public void printDefinitionTest(){
    application.wordCheckingPage.loadWordCheckingPage();
    application.wordCheckingPage.searchGeneratedString("Yes");
        System.out.println(application.wordCheckingPage.getDefinitionArea());;
    }
}


