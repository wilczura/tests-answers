package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static com.gitlab.rmarzec.framework.utils.Helpers.ALL_LANGUAGES;


public class Task2Test {
    @Test
    public void Task2Test() {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();
        //1.Otwarcie adresu
        webDriver.get("https://pl.wikipedia.org/wiki/Wiki");

        //Pobranie listy dostępnych języków
        List<WebElement> allLanguages = webDriver.findElements(ALL_LANGUAGES);

        //Wypisanie wszystkich języków. Dla English dopisanie URL
        for (WebElement language : allLanguages){
            if (language.getText().equals("English")) {
                System.out.println(language.getText() + " " + language.getAttribute("href"));
            }
            else{
                System.out.println(language.getText());
            }
        }
      webDriver.quit();
    }
}
