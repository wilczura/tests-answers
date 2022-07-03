package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import static com.gitlab.rmarzec.framework.utils.Helpers.*;

public class Task3Test {
    DriverFactory driverFactory = new DriverFactory();
    WebDriver webDriver = driverFactory.initDriver();

    @Test
    public void Task3Test() {

        //Otwarcie adresu
        webDriver.get(GOOGLE_URL);

        //Akceptacja ciasteczek
        click(ZAAKCEPTUJ_WSZYSTKO);

        //Wpisanie w polu wyszukiwania
        type(WYSZUKIWARKA,"HTML select tag - W3Schools");

        //Kliknięcie "Szczęśliwy traf"
        click(SZCZĘŚLIWY_TRAF);

        //Zweryfikowanie wymaganego URL
        if (W3SCHOOL_URL.equals(webDriver.getCurrentUrl())) {
            System.out.println("Szczęścliwi traf - prawidłowy url");
        } else {
            System.out.println("Szczęścliwi traf - błędny URL:" + webDriver.getCurrentUrl());
            webDriver.get(W3SCHOOL_URL);
        }
        //Akceptacja ciasteczek
        click(AKCEPTUJĘ_COOKIE);

        //Uruchomienie pierwszego przykładu
        click(TRY_IT_YOURSELF);

        //Przejście do aktywnej karty
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        switchToTab(tabs,0);
        switchToTab(tabs,1);

        //Przejście do iframe
        getWait().until(ExpectedConditions.visibilityOfElementLocated(IFRAME_RESULT));
        WebElement iframeMsg = webDriver.findElement(IFRAME_RESULT);
        webDriver.switchTo().frame(iframeMsg);

        //Pobranie tekstu nagłów i wypisanie nagłówka
        WebElement body = webDriver.findElement(By.cssSelector("h1"));
        System.out.println("Nagłówek: " + body.getText());

        //Wybranie z listy Opel
        click(VALUE_OPEL);
        Assert.assertEquals(webDriver.findElement(VALUE_OPEL).getText(),"Opel");

        //Pobranie i wypisanie tekstu oraz wartości
        WebElement Opel = webDriver.findElement(VALUE_OPEL);
        WebElement opel = webDriver.findElement(VALUE_OPEL);
        System.out.println(Opel.getText() + " ," + opel.getAttribute("value"));

        webDriver.quit();
 }
    private WebDriverWait getWait(){
        return new WebDriverWait(webDriver, Duration.ofMillis(3000));
    }

    private void click(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void type(By locator, String text){
        webDriver.findElement(locator).sendKeys(text);
    }

    private void switchToTab(ArrayList<String> name, int i){
        webDriver.switchTo().window(name.get(i));
    }
}