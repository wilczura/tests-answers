package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.model.YTTile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.gitlab.rmarzec.framework.utils.Helpers.*;


public class Task4Test {
    DriverFactory driverFactory = new DriverFactory();
    WebDriver webDriver = driverFactory.initDriver();

    @Test
    public void Task4Test() {

        //Otwarcie adresu
        webDriver.get(YOUTUBE_URL);

        //Akceptacja ciasteczek
        click(YT_ZAAKCEPTUJ_COOKIE);

        getWait().until(ExpectedConditions.invisibilityOfElementLocated(YT_ZAAKCEPTUJ_COOKIE));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(CZAS_1));

        //Lista kafelkow
        List<YTTile> ytTileList = new ArrayList<YTTile>();
        for (int i = 1; i <= 12; i++) {
            YTTile YTTile = new YTTile();
            YTTile.setTitle(webDriver.findElement(By.xpath("(//a[contains(@id,'video-title-link')])[" + i + "]")).getText());
            YTTile.setChannel(webDriver.findElement(By.xpath("(//yt-formatted-string[contains(@class,'channel')])[" + i + "]")).getText());

            if(webDriver.findElement(By.xpath("(//div[contains(@id,'details')])[" + i + "]")).getText().contains("NA ŻYWO")){
                YTTile.setLength("LIVE");
            }else {
                YTTile.setLength(webDriver.findElement(By.xpath("(//div[contains(@id,'dismissible')])[" + i + "]//span[contains(@class,'time')]")).getText());
            }
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("window.scrollBy(0,250)", "");
            ytTileList.add(YTTile);
        }
        //Wypisanie listy bez LIVE
        ytTileList.forEach(d -> {
            if (d.getLength() != "LIVE"){
            System.out.println("Tytuł: " + d.getTitle());
            //ew. wypisanie kanału
            //System.out.println("Kanał" + d.getChannel());
            System.out.println("Czas trwania: " + d.getLength());
            System.out.println("==============================================");
            }
        });
    }
    private WebDriverWait getWait(){
        return new WebDriverWait(webDriver, Duration.ofMillis(10000));
    }

    private void click(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
