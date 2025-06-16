package models;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;

import static io.restassured.RestAssured.given;

public class UserStep {

    public static RequestSpecification requestSpecification() {
        return given()
                .header("Content-type", "application/json")
                .baseUri(Constants.URL);
    }


    @Step("Создание тестового курьера")
    public ValidatableResponse stepCreatUser(User user) {
        return requestSpecification()
                .body(user)
                .when()
                .post(Constants.API_POST_CREATING_USER)
                .then();
    }

    @Step("Авторизация тестового пользователя")
    public ValidatableResponse authorizationUserStep(User loginUser) {
        return requestSpecification()
                .given()
                .body(loginUser)
                .post(Constants.API_POST_LOGIN_USER)
                .then();
    }

    @Step("получения токена для удаления тестового пользователя")
    public String token(User userLogin) {
        String token = accessTokenStep(userLogin);
        return StringUtils.substringAfter(token, " ");
    }

    @Step("получение accessToken при создании тестового пользователя")
    public String accessTokenStep(User user) {
        UserGetJSON userAccess = requestSpecification()
                .body(user)
                .when()
                .post(Constants.API_POST_LOGIN_USER)
                .body().as(UserGetJSON.class);
        return userAccess.getAccessToken();
    }

    @Step("Удаление тестового пользователя")
    public void deleteUserStep(String accessToken){
        requestSpecification()
                .auth().oauth2(accessToken)
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then();
    }


}
