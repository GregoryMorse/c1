import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by morse on 2017. 04. 19..
 */
public class MainPage {
    WebDriver driver;
    MainPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public String getUsername()
    {
        return driver.findElement(By.className("to-account")).getText();
    }

}
