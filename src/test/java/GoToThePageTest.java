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
import static org.junit.Assert.assertTrue;

@DisplayName("Go To The Page Test Тесты переходов страниц")
public class GoToThePageTest {
    private User loginUser;
    private User user;
    private RegistrationPage regPage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private WebDriver driver;
    private FakerUser fakerUser = new FakerUser();
    private UserStep userStep;
    private String token;
    private String mainUrl = "https://stellarburgers.nomoreparties.site/";


    @Before
    public void setUp() {
        driver = ChoiceWebDriver.createWebDriver("chrome");

        loginPage = new LoginPage();
        mainPage = new MainPage();
        regPage = new RegistrationPage();
        regPage.getUrl(driver);
        user = fakerUser.fakerUser();
        userStep = new UserStep();
        userStep.stepCreatUser(user);
        loginUser = new User( user.getEmail(), user.getPassword());
        token = userStep.token(loginUser);
        mainPage.clickLogInToYourAccount(driver);
        loginPage.enterTheDataUser(driver,  user.getEmail(), user.getPassword());
        loginPage.clickButtonEnter(driver);

    }

    @Test
    @DisplayName("going To The Personal Account Test (Переход на страницу \"Личный кабинет\"")
    @Description("Проверка перехода по клику на «Личный кабинет» в личный кабинет пользователя")
    public void goingToThePersonalAccountTest(){
        regPage.clickButtonPersonalAccount(driver);
        assertEquals(loginPage.getNameUserValue(driver), user.getEmail());
    }

    @Test
    @DisplayName("going To The Designer Page (Проверка перехода из личного кабинета в конструктор")
    @Description("Проверка перехода по клику на «Конструктор» в конструктор бургеров из личного кабинета")
    public void goingToTheConstructorPageTest() {
        regPage.clickButtonPersonalAccount(driver);
        mainPage.clickDesignerButton(driver);
        assertTrue(mainPage.findLabelAssembleTheBurger(driver));
    }

    @Test
    @DisplayName("going To The Main Page Test (Переход из личного кабинета на главную страницу сайта")
    @Description("Проверка перехода из личного кабинета по клику на логотип Stellar Burgers на главную страницу")
    public void goingToTheMainPageTest(){
        regPage.clickButtonPersonalAccount(driver);
        mainPage.clickLogoBurger(driver);
        assertEquals(regPage.getUrlPage(driver), mainUrl);
    }

    @After
    public void tearDown() {
        if (token != null) {
            userStep.deleteUserStep(token);
        }
        driver.quit();
    }
}
