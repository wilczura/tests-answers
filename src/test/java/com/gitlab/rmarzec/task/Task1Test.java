package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Task1Test {

    @Test
    public void Task1Test(){
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.initDriver();
        webDriver.get("https://www.onet.pl/");
        // wersja z if
        if (webDriver.getCurrentUrl().equals("https://www.onet.pl/")) {
            System.out.println("Znajdujemy się na właściwej stronie");
        } else {
            System.out.println("Strona niepoprawna");
        }
        //wersja z asercją
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.onet.pl/");

        webDriver.quit();
    }
}
