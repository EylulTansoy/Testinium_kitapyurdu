package com.kitapyurdu.methods;

import com.kitapyurdu.driver.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class Methods
{
    WebDriver driver;
    public FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;

    public Methods()
    {
        driver = BaseTest.driver;
        wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by)
    {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by)
    {
        return driver.findElements(by);
    }

    //Tıklama, seçme
    public void click(By by)
    {
        findElement(by).click();
    }

    //bekleme süresi
    public void waitBySecond(long seconds)
    {
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Seçilen element var mı yok mu kontrolü. True-False döner
    public boolean isElementVisible(By by)
    {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isElementClickable(By by)
    {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //input değer girme
    public void sendKey(By by, String text)
    {
        findElement(by).sendKeys(text);
    }

    public void sendKeyEnter(By by)
    {
        findElement(by).sendKeys(Keys.ENTER);
    }

    //Aksiyon ile scroll
    public void scrollWithAction(By by)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public void scrollWithJavaScript(By by)
    {
        jsdriver.executeScript("arguments[0].scrollView();", findElement(by));
    }

    //sıralama butonu için kullanıyoruz.
    public Select getSelect(By by)
    {
        return new Select(findElement(by));
    }

    public void selectByTest(By by, String text)
    {
        getSelect(by).selectByVisibleText(text);
    }

    //input alanını temizleme
    public void clearArea(By by)
    {
        findElement(by).clear();
    }

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }

    public void assertPage(String message, String expectedValue, String actualResult)
    {
        Assert.assertEquals(message, expectedValue, actualResult);
    }

    //Element içinde bulunan değeri alma
    public String getValue(By by)
    {
        return jsdriver.executeScript("return arguments[0].value", findElement(by)).toString();
    }

    //Element içerisinde bulunan text değerini alma
    public String getText(By by)
    {
        return findElement(by).getText();
    }

    public String getAttribute(By by, String attribute)
    {
        return findElement(by).getAttribute(attribute);
    }


    public void selectByText(By by, String text)
    {
        getSelect(by).selectByVisibleText(text);
    }

    //Random ürün seçme
    public void selectRandom()
    {
        Random random = new Random();
        List<WebElement> uruns = findElements(By.xpath("//div[@class='product-cr']//img"));
        int index = random.nextInt(uruns.size());
        uruns.get(index).click();
    }

    public void switchPage(By by)
    {
        driver.findElement(by).click();
    }

    /*
    public void isClickElement(WebElement element)
    {
        wait.until(ExceptedConditions)//???
    }
     */

}
