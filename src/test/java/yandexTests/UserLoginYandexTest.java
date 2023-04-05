package yandexTests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import api.GenerateUser;
import api.User;
import PO.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;


public class UserLoginYandexTest extends YandexProperty {

    private User user;
    private HomePage homePage;
    private LoginPage loginPage;

    private RegisterPage registrationPage;
    private AccountPage accountProfile;
    private ForgotPasswordPage forgotPassword;

    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    String password = RandomStringUtils.randomAlphabetic(10);

    @Before

    public void setUp() {
        startYandexBrowser();
        user = GenerateUser.getRandomUser();
        homePage = open(HomePage.URL, HomePage.class);
        homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), user.getPassword())
                .clickRegisterButton(Condition.hidden);
        homePage = null;  }

    @After
    public void clearState() {
        user = null;
        Selenide.clearBrowserLocalStorage();
        closeWebDriver();
    }
    @Test
    @DisplayName("Login user by login button")
    public void loginUserByLoginButton() {
        homePage = open(HomePage.URL, HomePage.class);
        boolean isDisplayed = homePage.clickLoginButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.visible);

        assertTrue(isDisplayed);
    }
    @Test
    @DisplayName("Login user by register page")
    public void loginUserByRegisterPage() {
        homePage = open(HomePage.URL, HomePage.class);
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .clickLoginLink()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.visible);

        assertTrue(isDisplayed);
    }
    @Test
    @DisplayName("Login user by forgot password page")
    public void loginUserByForgotPasswordPage() {
        homePage = open(HomePage.URL, HomePage.class);
        boolean isDisplayed = homePage.clickLoginButton()
                .clickForgotPasswordLink()
                .clickLoginLink()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.visible);

        assertTrue(isDisplayed);
    }

}