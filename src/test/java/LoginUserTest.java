
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import models.ChoiceWebDriver;
import models.FakerUser;
import models.User;
import models.UserStep;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.RegistrationPage;


import static org.junit.Assert.assertEquals;

@DisplayName("Login User Test Тест авторизации пользователя")
public class LoginUserTest {
    private User loginUser;
    private User user;
    private RegistrationPage regPage;
    private WebDriver driver;
    private FakerUser fakerUser = new FakerUser();
    private UserStep userStep;
    private String token;
    private LoginPage loginPage;
    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = ChoiceWebDriver.createWebDriver("chrome");

        mainPage = new MainPage();
        mainPage.getUrl(driver);
        loginPage = new LoginPage();
        regPage = new RegistrationPage();
        regPage.getUrl(driver);
        user = fakerUser.fakerUser();
        userStep = new UserStep();
        userStep.stepCreatUser(user);
        loginUser = new User( user.getEmail(), user.getPassword() );
        token = userStep.token(loginUser);
    }

    @Test
    @DisplayName("authorization Account Button (Авторизация через кнопку \"Войти в аккаунт\"")
    @Description("Проверка входа в аккаунт по кнопке «Войти в аккаунт» на главной")
    public void authorizationAccountButtonTest(){
        mainPage.clickLogInToYourAccount(driver);
        loginPage.enterTheDataUser(driver,  user.getEmail(), user.getPassword());
        loginPage.clickButtonEnter(driver);
       assertEquals(loginPage.getNameUserValue(driver), user.getEmail()) ;
    }

    @Test
    @DisplayName("authorization Button Personal Account Test (Авторизация через кнопку \"Личный кабинет\")")
    @Description("Проверка входа в аккаунт через кнопку «Личный кабинет»")
    public void authorizationButtonPersonalAccountTest(){
        regPage.clickButtonPersonalAccount(driver);
        loginPage.enterTheDataUser(driver,  user.getEmail(), user.getPassword());
        loginPage.clickButtonEnter(driver);
        assertEquals(loginPage.getNameUserValue(driver), user.getEmail()) ;
    }

    @Test
    @DisplayName("authorization Button Enter Page Registration (Авторизация через кнопку \"Войти\" на странице регистрации)")
    @Description("Проверка входа в аккаунт через кнопку в форме регистрации")
    public void authorizationButtonEnterPageRegistrationTest(){
        regPage.loadingRegistrationPage(driver);
        regPage.enterClick(driver);
        loginPage.enterTheDataUser(driver,  user.getEmail(), user.getPassword());
        loginPage.clickButtonEnter(driver);
        assertEquals(loginPage.getNameUserValue(driver), user.getEmail()) ;
    }

    @Test
    @DisplayName("authorization Button Password Recovery Test (Авторизация через кнопку \"Восстановить пароль\"")
    @Description("Проверка входа в аккаунт через кнопку в форме восстановления пароля")
    public void authorizationButtonPasswordRecoveryTest(){
        regPage.clickButtonPersonalAccount(driver);
        loginPage.clickButtonPasswordRecovery(driver);
        regPage.enterClick(driver);
        loginPage.enterTheDataUser(driver,  user.getEmail(), user.getPassword());
        loginPage.clickButtonEnter(driver);
        assertEquals(loginPage.getNameUserValue(driver), user.getEmail()) ;
    }


    @After
    public void tearDown() {
        if (token != null) {
            userStep.deleteUserStep(token);
        }
        driver.quit();
    }
}
