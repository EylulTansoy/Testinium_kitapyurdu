package com.kitapyurdu.page;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage
{
    WebDriver driver;
    Methods methods;
    public ProductPage()
    {
        driver = BaseTest.driver;
        methods = new Methods();
    }

    public void selectFilter()
    {
        //methods.switchPage(POINT_PAGE_LOCATER);
        methods.waitBySecond(5);
        //methods.switchPage(TURK_KLASIKLERI_LOCATER);
        methods.waitBySecond(5);
        methods.selectByText(By.cssSelector(".sort > select"), "Yüksek Oylama");
        methods.waitBySecond(5);
        WebElement element = methods.findElement(By.cssSelector(".js-bookCt > li:nth-of-type(3) > .mn-strong"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        methods.click(By.linkText("Hobi"));
    }

    public void addToBasket()
    {
        methods.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-cr']//img")));
        methods.selectRandom();
        methods.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Sepete Ekle']")));
        methods.click(By.xpath("//span[.='Sepete Ekle']"));
    }
}
