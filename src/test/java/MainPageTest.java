import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\msedgedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://github.com");
        mainPage = new MainPage(driver);
    }
    @Test
    public void signIn(){
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }
    @Test
    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.register("fhjsjd", "jsjdj", "sfhfsdfd");
        String error = signUpPage.getMainErrorText();

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
