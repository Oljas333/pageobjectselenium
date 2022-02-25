import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;


     public MainPage(WebDriver driver) {

         this.driver = driver;
    }

//
//     @FindBy(xpath = "//a[@class='HeaderMenu-link flex-shrink-0 no-underline']")
//     private WebElement signInButton;
//
//     @FindBy(xpath = "//a[@class='HeaderMenu-link flex-shrink-0 d-inline-block no-underline border color-border-default rounded px-2 py-1']")
//     private WebElement signUpButton;
//
//     @FindBy(xpath = "//input[@id='user_email']")
//     private WebElement emailField;
//
//     @FindBy(xpath = "//input[@id='user_name']")
//     private WebElement userNameField;
//
//     @FindBy(xpath = "//input[@id='password']")
//     private WebElement passwordField;
//
//     @FindBy(xpath = "//button[@class='btn-mktg width-full width-sm-auto btn-signup-mktg']")
//     private WebElement signUpFormButton;
//
//    public LoginPage clickSignIn(){
//        signInButton.click();
//        return new LoginPage(driver);
//    }
//
//    public SignUpPage clickSignUp(){
//        signUpButton.click();
//        return new SignUpPage(driver);
//    }
//
//    public SignUpPage clickSignUpFormButton(){
//        signUpFormButton.click();
//        return new SignUpPage(driver);
//    }
//
//    public MainPage typeEmail(String email){
//        emailField.sendKeys(email);
//        return this;
//    }
//    public MainPage typeUserName(String username){
//        userNameField.sendKeys(username);
//        return this;
//    }
//    public MainPage typePassword(String password){
//        passwordField.sendKeys(password);
//        return this;
//    }
//    public SignUpPage register(String username, String email, String password){
//        this.typeUserName(username);
//        this.typeEmail(email);
//        this.typePassword(password);
//        this.clickSignUpFormButton();
//        return new SignUpPage(driver);
//    }



     private By signInButton = By.xpath("//a[@class='HeaderMenu-link flex-shrink-0 no-underline']");
     private By signUpButton = By.xpath("//a[@class='HeaderMenu-link flex-shrink-0 d-inline-block no-underline border color-border-default rounded px-2 py-1']");
     private By emailField = By.xpath("//input[@id='user_email']");
     private By userNameField = By.xpath("  ");
     private By passwordField = By.xpath("//input[@id='password']");
     private By signUpFormButton = By.xpath("//button[@class='btn-mktg width-full width-sm-auto btn-signup-mktg']");

     public LoginPage clickSignIn(){
         driver.findElement(signInButton).click();
         return new LoginPage(driver);
     }

    public SignUpPage clickSignUp(){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton(){
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeEmail(String email){
         driver.findElement(emailField).sendKeys(email);
         return this;
    }
    public MainPage typeUserName(String username){
         driver.findElement(userNameField).sendKeys(username);
         return this;
    }
    public MainPage typePassword(String password){
         driver.findElement(passwordField).sendKeys(password);
         return this;
    }
    public SignUpPage register(String username, String email, String password){
         this.typeUserName(username);
         this.typeEmail(email);
         this.typePassword(password);
         this.clickSignUpFormButton();
         return new SignUpPage(driver);
    }

}
