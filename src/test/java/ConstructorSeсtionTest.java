
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import models.ChoiceWebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.ConstructorPage;

import static org.junit.Assert.assertTrue;

@DisplayName("Constructor Seсtion Test Тесты выбора вкладок конструктора")
public class ConstructorSeсtionTest {

    private ConstructorPage constructorPage;
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = ChoiceWebDriver.createWebDriver();
        constructorPage = new ConstructorPage();
        constructorPage.getUrl(driver);
    }

    @Test
    @DisplayName("constructor Sauces ")
    @Description("Проверка перехода в раздел «Соусы»")
    public void constructorSauces() throws InterruptedException {
        constructorPage.clickConstructorTabSauces(driver);
        assertTrue(constructorPage.isVisibilityConstructorSelection(driver, constructorPage.selectedSauces()));
    }

    @Test
    @DisplayName("constructor Toppings ")
    @Description("Проверка перехода в раздел  «Начинки»")
    public void constructorToppings() throws InterruptedException {
        constructorPage.clickConstructorTabToppings(driver);
        assertTrue(constructorPage.isVisibilityConstructorSelection(driver, constructorPage.selectedToppings()));
    }


    @Test
    @DisplayName("constructor Rolls ")
    @Description("Проверка перехода в раздел «Булки»")
    public void constructorRolls()  throws InterruptedException{
        constructorPage.clickConstructorTabSauces(driver);
        constructorPage.clickConstructorTabRolls(driver);
        assertTrue(constructorPage.isVisibilityConstructorSelection(driver, constructorPage.selectedRolls()));
    }

    @After
    public void tearDown() {
       driver.quit();
    }
}
