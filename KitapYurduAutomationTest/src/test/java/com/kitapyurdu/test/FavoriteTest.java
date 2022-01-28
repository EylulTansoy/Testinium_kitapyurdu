package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.page.FavoritePage;
import com.kitapyurdu.page.LoginPage;
import org.junit.Test;

public class FavoriteTest extends BaseTest
{
    @Test
    public void favoriteTest()
    {
        FavoritePage favoritePage = new FavoritePage();
        favoritePage.addProductToFav();
        favoritePage.switchPage();
        favoritePage.assertFavoritePage();
    }
}
