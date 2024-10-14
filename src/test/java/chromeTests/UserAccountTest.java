package chromeTests;
import api.UserStepsApi;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import api.GenerateUser;
import api.User;
import PO.HomePage;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

public class UserAccountTest {
    private User user;
    private HomePage homePage;
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
        homePage = null;
    }

    @After
    public void clearState() {
        userStepsApi.delite(userStepsApi.userBasicAuth(user));
        user = null;
        Selenide.clearBrowserLocalStorage();
    }
    @Test
    @DisplayName("Transition user to constructor")
    public void transitionToConstructor() {
        homePage = open(HomePage.URL, HomePage.class);
        String url = homePage.clickAccountButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton()
                .clickConstructor();

        assertEquals(HomePage.URL, url);
    }
    @Test
    @DisplayName("Transition user to logo burger")
    public void transitionToLogoBurger() {
        homePage = open(HomePage.URL, HomePage.class);
        String url = homePage.clickAccountButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton()
                .clickLogoBurger();

        assertEquals(HomePage.URL, url);
    }
}