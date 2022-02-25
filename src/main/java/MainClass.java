import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\msedgedriver.exe");

//
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
//        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://github.com");

//        MainPage mainPage = new MainPage(driver);
//        mainPage.register("ola", "oljas@fjdjf.com", "dfjjkksd");
//        MainPage mainPage = new MainPage(driver);
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.typeEmail("oljaskks@mail.com");
        mainPage.clickSignUpFormButton();
        driver.quit();
    }
}
