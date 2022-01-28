package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.page.SearchPage;
import org.junit.Test;

public class SearchTest extends BaseTest
{
    @Test
    public void searchTest()
    {
        SearchPage searchPage = new SearchPage();
        searchPage.scroll();
    }
}
