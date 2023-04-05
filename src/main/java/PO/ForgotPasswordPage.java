package PO;
import io.qameta.allure.Step;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginLink;

    @Step("Авторизация")
    public LoginPage clickLoginLink() {
        loginLink.click();
        return page(LoginPage.class);
    }
}