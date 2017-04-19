import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by morse on 2017. 04. 19..
 */
public class MainPageWithoutUser {
    WebDriver driver;

    By usernameInputLocator = By.id("logisterEmail");
    By passwordInputLocator = By.id("logisterPassword");
    public MainPageWithoutUser(WebDriver driver)
    {
        this.driver = driver;
    }
    public MainPage login(String username, String password)
    {
        driver.get("http://doodle.com");
        WebElement loginMenuClick = driver.findElement(By.className("login-menu"));
        loginMenuClick.click();

        WebElement usernameInput = driver.findElement(usernameInputLocator);
        WebElement passwordInput = driver.findElement(passwordInputLocator);

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        usernameInput.submit();
        return new MainPage(driver);
    }
}
