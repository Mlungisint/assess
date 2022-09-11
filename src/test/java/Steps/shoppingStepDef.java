package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class shoppingStepDef {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Given("i logged in to https:\\/\\/www.saucedemo.com")
    public void i_logged_in_to_https_www_saucedemo_com() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("lets print this message ");
        System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") +"Drivers//msedgedriver.exe");
        driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().window().maximize();

    }

    @When("i select the product from the website")
    public void i_select_the_product_from_the_website() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("user-name")).sendKeys("problem_user");
//        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
//        Thread.sleep(1000);
        driver.findElement(By.name("login-button")).click();

    }

    @When("i add the product to the cart")
    public void i_add_the_product_to_the_cart() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
//        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='shopping_cart_container']/a")).click();

    }

    @Then("then i should be able to checkout the product")
    public void then_i_should_be_able_to_checkout_the_product() throws Throwable {
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


    }

}
