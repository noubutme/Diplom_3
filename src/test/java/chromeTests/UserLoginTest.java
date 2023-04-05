package chromeTests;
import api.UserStepsApi;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import api.GenerateUser;
import api.User;
import PO.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;
public class UserLoginTest {
    private User user;
    private HomePage homePage;
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPassword;
    private RegisterPage registrationPage;
    private UserStepsApi userStepsApi;


    @Before
    public void setUp() {
        userStepsApi = new UserStepsApi();
        user = GenerateUser.getRandomUser();
        homePage = open(HomePage.URL, HomePage.class);
        homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), user.getPassword())
                .clickRegisterButton(Condition.hidden);
        homePage = null;  }

    @After
    public void clearState() {
        userStepsApi.delite(userStepsApi.userBasicAuth(user));
        user = null;
        Selenide.clearBrowserLocalStorage();
    }
    @Test
    @DisplayName("Login user by login button")
    public void loginUserByLoginButton() {
        homePage = open(HomePage.URL, HomePage.class);
        boolean isDisplayed = homePage.clickLoginButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.hidden);

        assertFalse(isDisplayed);
    }
    @Test
    @DisplayName("Login user by account button")
    public void loginUserByAccountButton() {
        homePage = open(HomePage.URL, HomePage.class);
        boolean isDisplayed = homePage.clickAccountButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.hidden);

        assertFalse(isDisplayed);
    }
    @Test
    @DisplayName("Login user by register page")
    public void loginUserByRegisterPage() {
        homePage = open(HomePage.URL, HomePage.class);
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .clickLoginLink()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.hidden);

        assertFalse(isDisplayed);
    }
    @Test
    @DisplayName("Login user by forgot password page")
    public void loginUserByForgotPasswordPage() {
        homePage = open(HomePage.URL, HomePage.class);
        boolean isDisplayed = homePage.clickLoginButton()
                .clickForgotPasswordLink()
                .clickLoginLink()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.hidden);
        assertFalse(isDisplayed);
    }
}