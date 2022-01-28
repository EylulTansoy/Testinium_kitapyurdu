package com.kitapyurdu.page;

import com.kitapyurdu.methods.Methods;
import org.openqa.selenium.By;

public class SearchPage
{
    Methods methods;
    public SearchPage()
    {
        methods = new Methods();
    }
    public void scroll()
    {
        methods.sendKey(By.id("search-input"),"oyuncak");
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySecond(7);
        methods.scrollWithAction(By.xpath("(//div[@class='product-list']//img)[7]"));
    }

}
