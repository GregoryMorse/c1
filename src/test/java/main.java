import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class main {
    @Test
    public void reallyFirstTest()
    {
        assertEquals(10, 10);
    }
    private Wait<WebDriver> wait;
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void firstTest() {
        // Your test code here
        //driver.get("http://google.com");

        MainPageWithoutUser mainPageWithoutUser = new MainPageWithoutUser(driver);
        MainPage mainPage = mainPageWithoutUser.login("hudi89@elte.hu", "test");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("to-account"))));
        assertTrue(mainPage.getUsername().equals("Peter"));
    }

    @Test
    public void simplePageTest() {
        driver.get("https://doodle.com/premium");
        assertTrue(driver.findElement(By.xpath("//h1")).getText().equals("Premium Doodle"));
    }
}