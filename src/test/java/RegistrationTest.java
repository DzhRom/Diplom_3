
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import models.ChoiceWebDriver;
import models.FakerUser;
import models.User;
import models.UserStep;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.RegistrationPage;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;


@DisplayName("Registration Test Тест регистрации пользователя")
public class RegistrationTest {

    private WebDriver driver;
    private RegistrationPage regPage;
    private FakerUser fakerUser = new FakerUser();
    private User user;
    private User loginUser;
    private UserStep userStep;
    private ValidatableResponse response;
    private String token;

    @Before
    public void setUp() {
        driver = ChoiceWebDriver.createWebDriver("chrome");

        regPage = new RegistrationPage();
        regPage.getUrl(driver);
        user = fakerUser.fakerUser();
        userStep = new UserStep();
        loginUser = new User(user.getEmail(), user.getPassword());
    }


    @Test
    @DisplayName("registration User Test (тест регистрации пользователя)")
    @Description("Проверка регистрации пользователя")
    public void registrationUserTest(){
        regPage.loadingRegistrationPage(driver);
        regPage.setDataNewUser(driver, user.getEmail(), user.getPassword(), user.getName());
        response = userStep.authorizationUserStep(loginUser);
        token = userStep.token(loginUser);
        response.assertThat().statusCode(200)
                .and()
                .body("success", equalTo(true))
                .body("accessToken", notNullValue())
                .body("user.name", equalTo(user.getName()))
                .body("user.email", equalTo(loginUser.getEmail().toLowerCase()));
    }


    @Step("Закрытие браузера")
    @After
    public void tearDown() {
        if (token != null) {
            userStep.deleteUserStep(token);
        }
        driver.quit();
    }
}
