import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import models.ChoiceWebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageobjects.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@DisplayName("Incorrect Password Parameterized Test Тест появления ошибки при некорректном вводе пароля")
public class IncorrectPasswordParameterizedTest {

    private WebDriver driver;
    private RegistrationPage regPage;
    private String password;
    private boolean expectedResult;

    public IncorrectPasswordParameterizedTest(String password, boolean expectedResult) {
        this.password = password;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        driver = ChoiceWebDriver.createWebDriver();
        regPage = new RegistrationPage();
        regPage.getUrl(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"1", true},
                {"11", true},
                {"111", true},
                {"1111", true},
                {"11111", true},
                {"111111", false},
        };
    }

    @Test
    @DisplayName("error Message Test (Сообщение об ошибке)")
    @Description("Проверка появления сообщения об ошибке при вводе некорректного пароля")
    public void errorMessageTest(){
        regPage.loadingRegistrationPage(driver);
        regPage.incorrectPassword(driver, password);
        assertEquals(regPage.errorMessageIncorrectPassword(driver), expectedResult);
    }
}
