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

        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("https://vishnuvardhana-fzgedfevcngbcxav.canadacentral-01.azurewebsites.net/webapp");

            String text = driver.findElement(By.cssSelector("h1")).getText();
            System.out.println(text);

            Assert.assertTrue(text.equalsIgnoreCase("vishnuvardhanaReddy M R Learning"));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
