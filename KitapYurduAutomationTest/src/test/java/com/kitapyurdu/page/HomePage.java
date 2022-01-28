package com.kitapyurdu.page;

import com.kitapyurdu.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage
{
    Methods methods;
    public HomePage()
    {
        methods = new Methods();
    }

    public void home()
    {
        methods.waitBySecond(6);

        //anasayfada olduğumuzun doğrulaması yapılır.
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='logo-icon']")));
    }


}
