package chromeTests;
import jdk.jfr.Description;
import PO.HomePage;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;
public class HomePageBurgersTests {
    private HomePage homePage;
    @After
    public void tearDown() {
        closeWebDriver();
    }
    @Test
    @Description("Проверка кнопок \"Соусы\" и \"Начинки\"")
    public void checkClickFillingTest() {
        homePage = open(HomePage.URL, HomePage.class);
        homePage.clickFilling();
        assertTrue("Нахождение не в разделе 'Начинки'", homePage.isHeaderFillingVisible());
        homePage.clickSauces();
        assertTrue("Нахождение не в разделе 'Соусы'", homePage.isHeaderSaucesVisible());
    }
    @Test
    @Description("Checking the click on the buns")
    public void checkClickBunsTest() {
        homePage = open(HomePage.URL, HomePage.class);
        assertTrue(homePage.isHeaderBunsVisible());
    }
}