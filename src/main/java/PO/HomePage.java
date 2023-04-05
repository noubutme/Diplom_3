package PO;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement accountButton;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;
    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__list__2A-mT")
    private ElementsCollection menuIngredients;
    @FindBy(how = How.XPATH,using = ".//button[text()='Оформить заказ']")
    private SelenideElement checkoutButton;
    @FindBy(how = How.XPATH,using = ".//span[text()='Начинки']")
    private SelenideElement filling;
    @FindBy(how = How.XPATH,using = ".//h2[text()='Начинки']")
    private SelenideElement headerFilling;
    @FindBy(how = How.XPATH,using = ".//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span")
    private SelenideElement headerFillingVisibleAfterClick;
    @FindBy(how = How.XPATH,using = ".//span[text()='Соусы']")
    private SelenideElement sauces;
    @FindBy(how = How.XPATH,using = ".//h2[text()='Соусы']")
    private SelenideElement headerSauces;
    @FindBy(how = How.XPATH,using = ".//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span")
    private SelenideElement headerSaucesVisibleAfterClick;
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Булки')]")
    private SelenideElement buns;
    @FindBy(how = How.XPATH,using = ".//h2[text()='Булки']")
    private SelenideElement headerBuns;
    @FindBy(how = How.XPATH,using = ".//div[contains(@class, 'tab_tab_type_current__2BEPc')]//span")
    private SelenideElement headerBunsVisibleAfterClick;

    @Step("Нажатие на кнпоку профиля")
    public LoginPage clickAccountButton() {
        accountButton.click();
        return page(LoginPage.class);
    }

    public void clickPersonalAccountButton() {
        accountButton.shouldBe(enabled).click();
    }
    @Step("Аккаунт")
    public AccountPage clickAccountButtonGoAccountPage() {
        accountButton.click();
        return page(AccountPage.class);
    }

    @Step("Авторизация")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step("Последняя булочка")
    public boolean findLastBunIngredient() {
        SelenideElement bun = menuIngredients.get(0).lastChild();
        bun.scrollIntoView(true);
        bun.click();
        return bun.isDisplayed();
    }

    @Step("Последний соус")
    public boolean findLastSauceIngredient() {
        SelenideElement sauce = menuIngredients.get(1).lastChild();
        sauce.scrollIntoView(true);
        sauce.click();
        return sauce.isDisplayed();
    }

    @Step("Последняя начинка")
    public boolean findLastFillingIngredient() {
        SelenideElement filling = menuIngredients.get(2).lastChild();
        filling.scrollIntoView(true);
        filling.click();
        return filling.isDisplayed();
    }
    public boolean isCheckoutButtonDisplayed() {
        checkoutButton.shouldBe(exist);
        return checkoutButton.isDisplayed();
    }
    @Step("Клик по разделу Начинки")
    public void clickFilling() {
        filling.shouldBe(exist);
        filling.click();
    }
    public boolean isHeaderFillingVisible() {
        return headerFillingVisibleAfterClick.getText().contentEquals("Начинки");
    }


    @Step("Клик по разделу Соусы")
    public void clickSauces() {
        sauces.shouldBe(exist);
        sauces.click();
    }
    public boolean isHeaderSaucesVisible() {
        return headerSaucesVisibleAfterClick.getText().contentEquals("Соусы");
    }
    @Step("Клик по разделу Булки")
    public void clickBuns() {
        buns.shouldBe(exist);
        buns.click();
    }
    public boolean isHeaderBunsVisible() {
        return headerBunsVisibleAfterClick.getText().contentEquals("Булки");
    }

}