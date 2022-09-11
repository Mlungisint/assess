package testCase1;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class shoppingWeb {

    WebDriver driver;

    @Test(priority = 1)
    public void setUp() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("------******Setup test start******------- ");
        System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") +"/Drivers//msedgedriver.exe");
        driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().window().maximize();
        System.out.println("------******Setup test ended******------- ");

    }

    @Test(priority = 2)
    public void login() {
        System.out.println("------******start login to product site******------- ");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("user-name")).sendKeys("problem_user");
//        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
//        Thread.sleep(1000);

        driver.findElement(By.name("login-button")).click();

    }

    @Test(priority = 3)
    public void addTheProduct()  {
        System.out.println("------******start add product to the cart******------- ");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
//        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='shopping_cart_container']/a")).click();

    }

    @Test(priority = 4)
    public void checkoutTheProduct() {
        System.out.println("------******start the checkout ******------- ");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("checkout")).click();

//        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Rose"+ Keys.TAB);
//        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Gumede");
//        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("0152");
//        Thread.sleep(1000);
        driver.findElement(By.id("continue")).click();
        driver.quit();
    }
}
