import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {

    @Test
    public void getData() {
        System.out.println("Hello Guys");

        // ✅ Automatically download and use the correct ChromeDriver version
        WebDriverManager.chromedriver().setup();

        // ✅ Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // ✅ Open the target website
            driver.get("https://vishnuvardhana-fzgedfevcngbcxav.canadacentral-01.azurewebsites.net/webapp");

            // ✅ Fetch and print header text
            String text = driver.findElement(By.cssSelector("h1")).getText();
            System.out.println(text);

            // ✅ Validate the text
            Assert.assertTrue(text.equalsIgnoreCase("vishnuvardhanaReddy M R Learning"));

        } catch (Exception e) {
            e.printStackTrace(); // ✅ Print errors if any
            Assert.fail("Test failed due to an exception: " + e.getMessage());

        } finally {
            // ✅ Ensure the browser closes even if the test fails
            driver.quit();
        }
    }
}
