package pageobjects;

import io.qameta.allure.Step;
import models.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private By logInToYourAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private By assembleTheBurger = By.xpath(".//h1[text()='Соберите бургер']");
    private By logoBurger = By.xpath(".//header/nav/div[@class='AppHeader_header__logo__2D0X2']");
    private By buttonLogout = By.xpath(".//button[text()='Выход']");
    private By headerLogin = By.xpath(".//h2[text()='Вход']");

    public void getUrl(WebDriver driver) {
        driver.get(Constants.URL);
    }

    @Step("Нажатие кнопки \"Войти в аккаунт\" на главной странице")
    public void clickLogInToYourAccount(WebDriver driver) {
        driver.findElement(logInToYourAccount).click();
    }

    @Step("Нажать кнопку конструктор")
    public void clickDesignerButton(WebDriver driver) {
        driver.findElement(constructorButton).click();
    }

    @Step("Проверка перехода на страницу конструктора")
    public boolean findLabelAssembleTheBurger(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(constructorButton));
        try {driver.findElement(assembleTheBurger).isDisplayed();
            return true;}
        catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    @Step("Нажатие на лого stellar burger")
    public void clickLogoBurger(WebDriver driver) {
        driver.findElement(logoBurger).click();
    }

    @Step("Нажать кнопку \"Выход\"")
    public void clickButtonLogout(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogout));
        driver.findElement(buttonLogout).click();
    }

    @Step("Проверка выхода из системы")
    public boolean checkLogout(WebDriver driver) {
        try {driver.findElement(headerLogin).isDisplayed();
            return true;}
        catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

}
