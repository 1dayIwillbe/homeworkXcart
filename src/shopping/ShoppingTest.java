package shopping;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ShoppingTest extends Utility {
    @Before
    public void openWeb(){
        openBrowser("https://mobile.x-cart.com/");
    }
    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Hot deals')]"))).perform();
        action.moveToElement(driver.findElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"))).click().perform();
        verifyPage("Sale", By.id("page-title"), "you are not on sale page");
        action.moveToElement(driver.findElement(By.xpath("//span[@class='sort-by-value']"))).perform();
        action.moveToElement(driver.findElement(By.xpath("(//a[normalize-space()='Name A - Z'])[1]"))).click().perform();
        action.moveToElement(driver.findElement(By.xpath("(//li[contains(@class,'product-price-base')])[1]"))).perform();
        driver.findElement(By.xpath("(//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')])[1]")).click();
//        verifyPage("Product has been added to your cart",By.xpath("(//li[@class='info' and text()='Product has been added to your cart'])"),"Your product is not added");
       Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@title='Your cart'])[1]")).click();
        driver.findElement(By.xpath("(//span[normalize-space()='View cart'])[1]")).click();
        verifyPage("1",By.id("amount16"),"You have more then one itme in cart");
    }
}
