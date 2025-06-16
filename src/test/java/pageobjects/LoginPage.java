package pageobjects;

import io.qameta.allure.Step;
import models.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private By personalAccountButton = By.xpath(".//*[text()='Личный Кабинет']");
    private By enterButton = By.xpath(".//button[text()='Войти']");
    private By fieldEmailEnterPage = By.xpath(".//input[@name='name']");
    private By fieldPasswordEnterPage = By.xpath(".//input[@name='Пароль']");
    private By buttonPasswordRecovery = By.xpath(".//a[text()='Восстановить пароль']");

    private By getValueLogin = By.xpath(".//main/div/div/div/ul/li[2]/div/div/input[@class='text input__textfield text_type_main-default input__textfield-disabled']");

    public void getUrl(WebDriver driver) {
        driver.get(Constants.URL);
    }

    @Step("Нажать кнопку \"Войти\" ")
    public void clickButtonEnter(WebDriver driver) {
        driver.findElement(enterButton).click();
    }

    @Step("Ввести данные пользователя для авторизации")
    public void enterTheDataUser(WebDriver driver, String email, String password) {
        driver.findElement(fieldEmailEnterPage).sendKeys(email);
        driver.findElement(fieldPasswordEnterPage).sendKeys(password);
    }

    @Step("Нажать кнопку Восстановить пароль")
    public void clickButtonPasswordRecovery(WebDriver driver) {
        driver.findElement(buttonPasswordRecovery).click();
    }

    @Step("Получения атрибута value логина в личном кабинете для проверки авторизации")
    public String getNameUserValue(WebDriver driver) {
        driver.findElement(personalAccountButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getValueLogin));
        String value = driver.findElement(getValueLogin).getAttribute("value");
        return value;
    }
}



