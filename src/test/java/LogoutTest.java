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


import static org.junit.Assert.assertTrue;

@DisplayName("Logout Test Тест выхода из системы")
public class LogoutTest {

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
    @DisplayName("logout Test (Выход из системы)")
    @Description("Проверь выход по кнопке «Выйти» в личном кабинете")
    public void logoutTest() {

        regPage.clickButtonPersonalAccount(driver);
        loginPage.enterTheDataUser(driver,  user.getEmail(), user.getPassword());
        loginPage.clickButtonEnter(driver);
        regPage.clickButtonPersonalAccount(driver);
        mainPage.clickButtonLogout(driver);
        regPage.clickButtonPersonalAccount(driver);
        assertTrue(mainPage.checkLogout(driver));
    }

    @After
    public void tearDown() {
        if (token != null) {
            userStep.deleteUserStep(token);
        }
        driver.quit();
    }
}
