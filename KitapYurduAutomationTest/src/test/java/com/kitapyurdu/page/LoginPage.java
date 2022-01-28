package com.kitapyurdu.page;

import com.kitapyurdu.methods.Methods;
import org.openqa.selenium.By;

public class LoginPage
{
    Methods methods;
    public LoginPage()
    {
        methods = new Methods();
    }

    public void login()
    {
        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        methods.waitBySecond(7);
        methods.sendKey(By.id("login-email"), "aleynaeylul.tansoy@testinium.com");
        methods.waitBySecond(7);
        methods.sendKey(By.id("login-password"), "1q2w3e4r5t");
        methods.waitBySecond(7);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        methods.waitBySecond(7);
    }

    public void logout()
    {
        methods.selectByText(By.cssSelector(".common-sprite>b"), "Çıkış");
    }
}
