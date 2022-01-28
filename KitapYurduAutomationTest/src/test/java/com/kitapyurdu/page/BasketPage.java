package com.kitapyurdu.page;

import com.kitapyurdu.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasketPage
{
    WebDriver driver;
    Methods methods;

    public BasketPage()
    {
        methods = new Methods();
    }

    public void switchBasket()
    {
        methods.click(By.id("cart"));
        methods.waitBySecond(5);
        methods.click(By.id("js-cart"));
        methods.waitBySecond(3);
    }

    public void addQuantity(String quantity)
    {
        methods.clearArea(By.name("quantity"));
        methods.sendKey(By.name("quantity"), quantity);
        methods.sendKeyEnter(By.name("quantity"));
    }

    public void clickBuyProduct()
    {
        methods.click(By.id("button-checkout-continue"));

        methods.sendKey(By.id("credit-cart-owner"), "Limitsiz Kart");
        methods.sendKey(By.id("credit_cart_number_1"), "1234");
        methods.sendKey(By.id("credit_cart_number_2"), "1234");
        methods.sendKey(By.id("credit_cart_number_3"), "1234");
        methods.sendKey(By.id("credit_cart_number_4"), "1234");

        methods.selectByTest(By.id("credit-cart-expire-date-month"), "11");
        methods.wait.until(ExpectedConditions.elementToBeClickable(By.id("credit-card-expire-date-year")));
        methods.selectByText(By.id("credit-card-expire-date-year"), "2026");

        methods.sendKey(By.id("credit-card-security-code"), "411");

        methods.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=\"checkbox\"]")));
        WebElement basketCheckBox1 = methods.findElement(By.cssSelector("input[type=\"checkbox\"]"));
        basketCheckBox1.click();

        methods.click(By.id("button-checkout-continue"));
        methods.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=\"checkbox\"]")));
        WebElement basketCheckBox = methods.findElement(By.cssSelector("input[type=\"checkbox\"]"));
        basketCheckBox.click();

        methods.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button']\n")));
        methods.click(By.xpath("//input[@class='button']\n"));
        methods.isElementVisible(By.className("css = .warning\n"));
        String actual = methods.getText(By.className("css = .warning\n"));
        methods.assertPage("Ödeme Başarısız", "Kart bilgileriniz doğrulanamadı, lütfen tekrar deneyiniz.\n", actual);
    }

    public void createAddress() {
        methods.sendKey(By.id("address-firstname-companyname"), "Limitsiz");
        methods.sendKey(By.id("address-lastname-title"), "Kart");
        methods.selectByText(By.id("address-zone-id"), "İstanbul");
        methods.selectByText(By.id("address-county-id"), "Sarıyer");
        methods.sendKey(By.id("address-address-text"), "Tarabya Mah.");
        methods.sendKey(By.id("address-telephone"), "2161234567");
        methods.sendKey(By.id("address-mobile-telephone"), "1234567890");
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySecond(5);
    }
}
