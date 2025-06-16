
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import models.ChoiceWebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.ConstructorPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@DisplayName("Constructor Seсtion Test Тесты выбора вкладок конструктора")
public class ConstructorSeсtionTest {

    private ConstructorPage constructorPage;
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = ChoiceWebDriver.createWebDriver("chrome");

        constructorPage = new ConstructorPage();
        constructorPage.getUrl(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("constructor Sauces ")
    @Description("Проверка перехода в раздел «Соусы»")
    public void constructorSauces() {
        constructorPage.clickConstructorTabSauces(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getChoiceSauces()));
        assertTrue(constructorPage.isVisibilityConstructorSelection(driver, constructorPage.getChoiceSauces()));

    }

    @Test
    @DisplayName("constructor Toppings ")
    @Description("Проверка перехода в раздел  «Начинки»")
    public void constructorToppings() {
        constructorPage.clickConstructorTabToppings(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getChoiceToppings()));
        assertTrue(constructorPage.isVisibilityConstructorSelection(driver, constructorPage.getChoiceToppings()));

    }


    @Test
    @DisplayName("constructor Rolls ")
    @Description("Проверка перехода в раздел «Булки»")
    public void constructorRolls() {
        constructorPage.clickConstructorTabSauces(driver);
        constructorPage.clickConstructorTabRolls(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getChoiceRolls()));
        assertTrue(constructorPage.isVisibilityConstructorSelection(driver, constructorPage.getChoiceRolls()));
    }

    @After
    public void tearDown() {
       driver.quit();
    }
}
