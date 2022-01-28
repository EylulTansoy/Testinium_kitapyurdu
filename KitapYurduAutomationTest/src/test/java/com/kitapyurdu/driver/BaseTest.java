package com.kitapyurdu.driver;

import com.kitapyurdu.page.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest
{
    public static WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("disable-plugins");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-extensions");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        chromeOptions.merge(desiredCapabilities);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://www.kitapyurdu.com/");
    }

    @Test
    public void mainTest()
    {
        HomePage homePage = new HomePage();
        homePage.home();

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        SearchPage searchPage = new SearchPage();
        searchPage.scroll();

        FavoritePage favoritePage = new FavoritePage();
        favoritePage.addProductToFav();
        favoritePage.switchPage();
        favoritePage.assertFavoritePage();

        homePage.home();

        ProductPage productPage = new ProductPage();
        productPage.selectFilter();
        productPage.addToBasket();

        favoritePage.switchPage();
        favoritePage.favoriteProductDelete();

        BasketPage basketPage = new BasketPage();
        basketPage.switchBasket();
        basketPage.addQuantity("2");
        basketPage.clickBuyProduct();
        basketPage.createAddress();
        basketPage.clickBuyProduct();

        loginPage.logout();
    }

    @After
    public void tearDown()
    {
        if(driver != null)
        {
            driver.close();
            driver.quit();
        }
    }
}
