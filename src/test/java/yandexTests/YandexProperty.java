package yandexTests;

public class YandexProperty {
    public void startYandexBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");

    }
}