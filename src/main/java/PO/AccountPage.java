package PO;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;

public class AccountPage {
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructor;


    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoBurger;

    @Step("Нажание на Конструктор")
    public String clickConstructor() {
        constructor.click();
        return Selenide.switchTo().window(0).getCurrentUrl();
    }

    @Step("Нажатие на логотип")
    public String clickLogoBurger() {
        logoBurger.click();
        return Selenide.switchTo().window(0).getCurrentUrl();
    }

    @Step("Надажие на кнопку выхода")
    public void clickLogout() {
        logoutButton.click();
    }

    public boolean isLogoutDisplayed() {
        logoutButton.shouldBe(exist);
        return logoutButton.isDisplayed();
    }
    public boolean clickLogoutButton(Condition condition) {
        logoutButton.click();
        return logoutButton.shouldBe(condition).isDisplayed();
    }


}