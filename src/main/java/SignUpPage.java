import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    private  By heading = By.xpath("//span[@class='text-mono text-gray-mktg']");
    private By userNameField = By.xpath(".//*[@id='user_login']");
    private  By emailField = By.xpath("//input[@id='email']");
    private  By signUpButton = By.xpath("(//button[@class='js-continue-button signup-continue-button form-control px-3 width-full width-sm-auto mt-4 mt-sm-0'])[1]");
    private By passwordField = By.xpath(".//*[@id='user_password']");
    private By mainError = By.xpath(".//*[@id='user_login']/ancestor::dl/preceding-sibling::div[contains(@class, 'flash-error')]");
    private By userNameError = By.xpath("//input[@id='user_login']/ancestor::dd/following-sibling::dd");
    private By emailError = By.xpath(".//*[@id='user_email']/ancestor::dd/following-sibling::dd");
    private By passwordError = By.xpath(".//*[@id='user_password']/ancestor::dd/following-sibling::dd");

    public SignUpPage typeEmail(String email){
        driver.findElement(emailField);
        return this;
    }
    public SignUpPage typeUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String email){
        this.typeEmail(email);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText(){
        return driver.findElement(mainError).getText();
    }

    public String getUsernameErrorText(){
        return driver.findElement(userNameError).getText();
    }

    public String getPasswrodErrorText(){
        return driver.findElement(passwordError).getText();
    }

    public String getEmailErrorText(){
        return driver.findElement(emailError).getText();
    }
    public SignUpPage registerWithInvalidCreds(String username, String email, String password){
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }
}
