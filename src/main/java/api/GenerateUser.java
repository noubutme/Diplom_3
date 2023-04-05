package api;
import io.qameta.allure.Allure;

import org.apache.commons.lang3.RandomStringUtils;
public class GenerateUser {
    public static User getRandomUser() {
        String name = RandomStringUtils.randomAlphabetic(6);
        String email = RandomStringUtils.randomAlphabetic(6) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(6);
        return new User(email, password, name);
    }
}