package com.wiki;

import org.graphwalker.core.condition.ReachedEdge;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.machine.Context;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestBuilder;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.annotation.Generated;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Generated(value = "src/main/resources/com/Wiki/wiki.json")
@GraphWalker(start = "Start", groups = {"default"})
public class WikiTest extends ExecutionContext implements Wikilogin {


    private static final Path MODEL_PATH = Paths.get("C:\\Selenium-Graphwalker\\Selenium-graphwalker\\src\\main\\resources\\com\\Wiki\\wiki.json");
    static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium-Graphwalker\\Selenium-graphwalker\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        driver.quit();
    }

    @Override
    public void goToLoginPage() {

        System.out.println("E =------------------------>1     goToLoginPage");
        driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");
    }


    @Override
    public void VerifyLoginPage() {

        System.out.println("V ####################1  LoginPage");
        int userNameFieldSize = driver.findElements(By.id("wpName1")).size();
        System.out.println("is username present : " + userNameFieldSize);
        Assert.assertTrue("", userNameFieldSize > 0);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goToHomePageforCustomer() {

        System.out.println("E =------------------------>2     goToHomePageforCustomer");
        driver.findElement(By.id("wpName1")).clear();
        driver.findElement(By.id("wpName1")).sendKeys("Komalgcloverbay");
        driver.findElement(By.id("wpPassword1")).sendKeys("Qaqa@123");
        driver.findElement(By.id("wpLoginAttempt")).click();
    }

    @Override
    public void VerifyHomePageforCustomer() {
        System.out.println("V ####################2  HomePageorCustomer");
        String cUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + cUrl);
        Assert.assertTrue("", cUrl.endsWith("Main_Page"));
        String userName = driver.findElement(By.xpath("//a[@title='Your homepage (page does not exist) [alt-shift-.]']//span")).getText();
        System.out.println("After Login UserName: " + userName);
        Assert.assertTrue(userName.equalsIgnoreCase("Komalgcloverbay"));
    }

    @Override
    public void goToLogoutPage() {
        System.out.println("V ####################3  LogoutPage");
        driver.findElement(By.xpath("//input[@id='vector-user-links-dropdown-checkbox']")).click();
        // Use WebDriverWait to wait for the element to be clickable
        WebElement logoutLink = driver.findElement(By.xpath("//li[@id='pt-logout']//a[@title='Log out']"));
        // Scroll the element into view using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logoutLink);

        // Click the logout link
        logoutLink.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void VerifyLogoutPage() {
        System.out.println("V ####################3  LogoutPage");
        Assert.assertTrue(driver.getCurrentUrl().contains("Special:UserLogout"));
    }

    @Override
    public void goToLoginPagefromLogoutPage() {
        System.out.println("E =------------------------>4     e_goToLoginPageFromLogoutPage");
       // driver.findElement(By.xpath("//*[@id=\"pt-login\"]/a")).click();
        driver.findElement(By.xpath("//p[@id='mw-returnto']/a")).click();
    }

    @Test
    public void runStabilityTest() throws IOException {
        Context context = new WikiTest();
        TestBuilder builder = new TestBuilder().addContext(context, MODEL_PATH,
                new AStarPath(new ReachedEdge("goToLoginPagefromLogoutPage")));
        context.setNextElement(context.getModel().findElements("Start").get(0));
        Result result = builder.execute();
        Assert.assertFalse(result.hasErrors());
    }

}

