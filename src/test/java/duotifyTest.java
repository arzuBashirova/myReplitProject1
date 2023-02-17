import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class duotifyTest {





    @Test

    public void navigate() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        Thread.sleep(500);

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, "Welcome to Duotify!");

        Thread.sleep(500);

         driver.findElement(By.id("hideLogin")).click();

        Thread.sleep(500);

        Faker faker = new Faker();

        String userName= faker.name().username();
        driver.findElement(By.id("username")).sendKeys(userName, Keys.ENTER);
        String firstName= faker.name().firstName();
        Thread.sleep(500);
        driver.findElement(By.id("firstName")).sendKeys(firstName, Keys.ENTER);
        Thread.sleep(500);
        String lastName= faker.name().firstName();
        driver.findElement(By.id("lastName")).sendKeys(lastName, Keys.ENTER);
        Thread.sleep(500);
        String email= faker.internet().emailAddress();
        Thread.sleep(500);
        driver.findElement(By.id("email")).sendKeys(email, Keys.ENTER);
        Thread.sleep(500);

        driver.findElement(By.id("email2")).sendKeys(email, Keys.ENTER);
        Thread.sleep(500);
        String password= faker.internet().password();
        driver.findElement(By.id("password")).sendKeys(password, Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.id("password2")).sendKeys(password, Keys.ENTER);
        Thread.sleep(500);


        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?");

        Assert.assertEquals(driver.findElement(By.id("nameFirstAndLast")).getText(),firstName+" "+lastName );

        Thread.sleep(500);
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),firstName+" "+lastName);
        Thread.sleep(500);
        driver.findElement(By.id("rafael")).click();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        driver.findElement(By.id("loginUsername")).sendKeys(userName, Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.id("loginPassword")).sendKeys(password, Keys.ENTER);
        Thread.sleep(500);
        driver.getPageSource().contains("You Might Also Like");
        Thread.sleep(500);
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(500);
        driver.findElement(By.id("rafael")).click();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        Thread.sleep(500);
        driver.quit();

    }


}
