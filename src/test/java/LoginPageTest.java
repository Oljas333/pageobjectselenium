import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
            public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\msedgedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCredsTest(){
        LoginPage newLoginPage =  loginPage.loginWithInvalidCreds("","");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithIncorrectCredsTest(){
        LoginPage newLoginPage =  loginPage.loginWithInvalidCreds("qweqewqwe","qweqweweqwe");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void createAccTest(){
        SignUpPage signUpPage = loginPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("We", heading);
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
