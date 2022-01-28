package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.page.BasketPage;
import com.kitapyurdu.page.HomePage;
import org.junit.Test;

public class BasketTest extends BaseTest
{
    @Test
    public void basketTest()
    {
        BasketPage basketPage = new BasketPage();
        basketPage.switchBasket();
        basketPage.addQuantity("2");
        basketPage.clickBuyProduct();
        basketPage.createAddress();
        basketPage.clickBuyProduct();
    }
}
