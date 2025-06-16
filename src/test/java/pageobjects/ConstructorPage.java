package pageobjects;

import io.qameta.allure.Step;
import models.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {

    private By constructorTabRolls = By.xpath(".//span[text()='Булки']");
    private By constructorTabSauces = By.xpath(".//span[text()='Соусы']");
    private By constructorTabToppings = By.xpath(".//span[text()='Начинки']");
    private By choiceRolls = By.xpath(".//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Булки']");
    private By choiceSauces = By.xpath(".//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Соусы']");
    private By choiceToppings = By.xpath(".//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Начинки']");

    public By getChoiceRolls(){
        return choiceRolls;
    }
    public By getChoiceSauces(){
        return choiceSauces;
    }
    public By getChoiceToppings(){
        return choiceToppings;
    }

    public void getUrl(WebDriver driver) {
        driver.get(Constants.URL);
    }

    @Step("Нажать вкладку Булки")
    public void clickConstructorTabRolls(WebDriver driver) {
        driver.findElement(constructorTabRolls).click();
    }

    @Step("Нажать вкладку Соусы")
    public void clickConstructorTabSauces(WebDriver driver) {
        driver.findElement(constructorTabSauces).click();
    }

    @Step("Нажать вкладку Начинка")
    public void clickConstructorTabToppings(WebDriver driver) {
        driver.findElement(constructorTabToppings).click();
    }

    @Step("Проверяем выбранную вкладку конструктора")
    public boolean isVisibilityConstructorSelection(WebDriver driver, By constructorTab) {
        try {
            driver.findElement(constructorTab).isDisplayed();
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

}
