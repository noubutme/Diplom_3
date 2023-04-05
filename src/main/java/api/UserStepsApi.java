package api;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserStepsApi {
    protected static final String BASE_URI = "https://stellarburgers.nomoreparties.site/api/";
    private static final String Auth_URL = BASE_URI + "auth/login";
    private static final String User_URL = BASE_URI + "auth/user";

    protected RequestSpecification getReqSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URI)
                .build();
    }
    private User user;
    @Step("Авторизация по логину и паролю")
    public String userBasicAuth(User user){
        ValidatableResponse response = given()
                .spec(getReqSpec())
                .body(user)
                .when()
                .post(Auth_URL)
                .then();
    return response.extract().path("accessToken").toString();

    }
    @Step("Удаление")
    public ValidatableResponse delite(String accessToken){
        return given()
                .spec(getReqSpec())
                .auth().oauth2(accessToken)
                .when()
                .delete(User_URL)
                .then();
    }
}
