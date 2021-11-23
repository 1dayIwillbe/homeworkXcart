package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility extends BaseClass {
    //Click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //Send data to element
    public void sendDataOmElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //Assert Method verification
    public String verifyPage(String expectedMessage, By by, String message) {
        String actualMessage = driver.findElement(by).getText();
        Assert.assertEquals(message,expectedMessage,actualMessage) ;
        return message;
    }

    //Get data from element
    public String getDataFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void selectMenu(String menu){
        driver.findElement(By.linkText(menu)).click();
    }

    public void compareDropDownList(){
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']"));
        List<String> names = new ArrayList<String>();
        for (WebElement e : products) {
            names.add(e.getText());
        }
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        System.out.println(sortedNames.equals(names));
        Assert.assertEquals("Your list is not items" , names, sortedNames);
    }


}
