package com.gitlab.rmarzec.framework.utils;
import org.openqa.selenium.By;

public class Helpers {
  protected static By byId(String name) {
    return By.id(name);
  }
  protected static By byXpath(String name) {
    return By.xpath(name);
  }


//  Task 2
  public static By ALL_LANGUAGES = byXpath("//li[contains(@class, 'interlanguage-link')]/a");

//  Task 3
  public static String GOOGLE_URL = "https://www.google.com/";
  public static String W3SCHOOL_URL = "https://www.w3schools.com/tags/tag_select.asp";
  public static By ZAAKCEPTUJ_WSZYSTKO =byXpath("//button/div[contains(text(), 'Zaakceptuj wszystko')]");
  public static By WYSZUKIWARKA =byXpath("//input[contains(@title,'Szukaj')]");
  public static By SZCZĘŚLIWY_TRAF =byXpath("(//input[contains(@value, 'Szczęśliwy traf')])[2]");
  public static By AKCEPTUJĘ_COOKIE = byId("accept-choices");
  public static By TRY_IT_YOURSELF = byXpath("(//a[contains(text(), 'Try it Yourself')])[1]");
  public static By IFRAME_RESULT = byXpath("//iframe[contains(@id,'iframeResult')]");
  public static By VALUE_OPEL = byXpath("//option[contains(@value, 'opel')]");

  // Task 4
  public static String YOUTUBE_URL = "https://www.youtube.com/";
  public static By YT_ZAAKCEPTUJ_COOKIE = byXpath("//a//*[contains(text(), 'Zaakceptuj wszystko')]");
  public static By CZAS_1 = byXpath("(//span[contains(@class,'time-status')])[1]");
}
