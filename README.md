# Diplom_3
**Задание 3: веб-приложение**

В последнем задании тебе нужно протестировать веб-приложение [Stellar Burgers](https://stellarburgers.nomoreparties.site/).

**Что нужно сделать**

Опиши элементы, которые будешь использовать в тестах, с помощью Page Object.

Протестируй функциональность в Google Chrome и Яндекс.Браузере.
Подключи Allure-отчёт.

**_1. Регистрация_**

Проверь:

1.1 [Успешную регистрацию](src/test/java/RegistrationTest.java). 

1.2 [Ошибку для некорректного пароля. Минимальный пароль — шесть символов.](src/test/java/IncorrectPasswordParameterizedTest.java)



**_2. Вход_**

_Проверь:_

2.1 [вход по кнопке «Войти в аккаунт» на главной.](src/test/java/LoginUserTest.java)

2.2 [вход через кнопку «Личный кабинет».](src/test/java/LoginUserTest.java)

2.3 [вход через кнопку в форме регистрации.](src/test/java/LoginUserTest.java)

2.4 [вход через кнопку в форме восстановления пароля.](src/test/java/LoginUserTest.java)

**_3. Переход в личный кабинет_**

[Проверь переход по клику на «Личный кабинет».](src/test/java/GoToThePageTest.java)

**_4. Переход из личного кабинета в конструктор_**

[Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.](src/test/java/GoToThePageTest.java)

**_5. Выход из аккаунта_**

[Проверь выход по кнопке «Выйти» в личном кабинете.](src/test/java/LogoutTest.java)

**_6. Раздел «Конструктор»_**
Проверь, что работают переходы к разделам:

* [«Булки»,](src/test/java/ConstructorSeсtionTest.java)
* [«Соусы»,](src/test/java/ConstructorSeсtionTest.java)
* [«Начинки».](src/test/java/ConstructorSeсtionTest.java)


[Описание локаторов ](src/test/java/models/Locator.java)
[Шаги регистрации](src/test/java/pageobjects/RegistrationPage.java)
[Шаги авторизации](src/test/java/pageobjects/LoginPage.java)
[Шаги Конструктора](src/test/java/pageobjects/ConstructorPage.java)
[Шаги переходов ](src/test/java/pageobjects/MainPage.java)