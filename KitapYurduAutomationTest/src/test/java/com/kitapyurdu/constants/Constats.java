package com.kitapyurdu.constants;

import org.openqa.selenium.By;

public class Constats
{
    public static final By HOME_PAGE_LOCATER = By.cssSelector(".logo-text img");
    public static final By POINT_PAGE_LOCATER = By.xpath("//div[@class='lvl1catalog']/a[.='Puan Kataloğu']");
    public static final By TURK_KLASIKLERI_LOCATER = By.xpath("//div[@id='landing-point']//*[contains(@title, 'Puan Kataloğundaki Türk Klasikleri')]");
    public static final By FAVORITE_PAGE_LOCATER = By.linkText("Favorilerim");
}
