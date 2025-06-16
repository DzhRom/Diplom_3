package pageobjects;

import io.qameta.allure.Step;
import models.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegistrationPage {

    private By personalAccountButton = By.xpath(".//*[text()='Личный Кабинет']");
    private By registerButton = By.xpath(".//*[text()='Зарегистрироваться']");
    private By fieldNameRegister = By.xpath(".//fieldset[1]//input[@name='name']");
    private By fieldEmailRegister = By.xpath(".//fieldset[2]//input[@name='name']");
    private By fieldPasswordRegister = By.xpath(".//fieldset[3]//input[@name='Пароль']");
    private By messageErrorInputPassword = By.xpath(".//p[text() = 'Некорректный пароль']");
    private By labelEnterPageRegistration = By.xpath(".//a[text()='Войти']");
    private By buttonEnter = By.xpath(".//button[text()='Войти']");

    public void getUrl(WebDriver driver) {
        driver.get(Constants.URL);
    }

    @Step("Переход на страницу регистрации нового пользователя")
    public void loadingRegistrationPage(WebDriver driver) {
        driver.findElement(personalAccountButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(registerButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));
    }

    @Step("Ввод данных нового пользователя")
    public void setDataNewUser(WebDriver driver, String email, String password, String name) {
        driver.findElement(fieldNameRegister).sendKeys(name);
        driver.findElement(fieldEmailRegister).sendKeys(email);
        driver.findElement(fieldPasswordRegister).sendKeys(password);
        driver.findElement(registerButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonEnter));
    }

    @Step("Ввод некорректного пароля (минимальный пароль — шесть символов)")
    public void incorrectPassword(WebDriver driver, String password) {
        driver.findElement(fieldPasswordRegister).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    @Step("Ожидание появления сообщения об ошибке \'Некорректный пароль\', при вводе пароля длинной менее 6 символов")
    public boolean errorMessageIncorrectPassword(WebDriver driver) {
       try { driver.findElement(messageErrorInputPassword).isDisplayed() ;
            return true;
       }
         catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    @Step("Нажать кнопку Личный кабинет на главной странице")
    public void clickButtonPersonalAccount(WebDriver driver) {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажать кнопку Войти")
    public void enterClick(WebDriver driver) {
        driver.findElement(labelEnterPageRegistration).click();
    }

    @Step("Получение URL страницы")
    public String getUrlPage(WebDriver driver) {
        return driver.getCurrentUrl();
    }
}
