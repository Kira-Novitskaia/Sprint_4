package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FaqPage {
    private final WebDriver driver;

    //Верхняя кнопка "Заказать"
    private final By orderButtonUp = By.xpath(".//div[starts-with(@class, 'Header_Nav')]/button[text()='Заказать']");

    //Нижняя кнопка "Заказать"
    private final By orderButtonDown = By.xpath(".//div[starts-with(@class, 'Home_FinishButton')]/button[text()='Заказать']");


    // Локаторы для вопросов и ответов
    private final By[] questionLocators = {
            By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7")
    };

    private final By[] answerLocators = {
            By.id("accordion__panel-0"),
            By.id("accordion__panel-1"),
            By.id("accordion__panel-2"),
            By.id("accordion__panel-3"),
            By.id("accordion__panel-4"),
            By.id("accordion__panel-5"),
            By.id("accordion__panel-6"),
            By.id("accordion__panel-7")
    };

    public FaqPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для клика на вопрос
    public void clickOnQuestion(int index) {
        driver.findElement(questionLocators[index]).click();
    }

    // Метод для получения текста ответа
    public String getAnswerText(int index) {
        return driver.findElement(answerLocators[index]).getText();
    }

    // Метод для клика на верхнюю кнопку "Заказать"
    public OrderPage clickOrderButtonUp() {
        driver.findElement(orderButtonUp).click();
        return new OrderPage(driver);  // Возвращаем объект OrderPage после клика
    }

    // Метод для клика на нижнюю кнопку "Заказать"
    public OrderPage clickOrderButtonDown() {
        driver.findElement(orderButtonDown).click();
        return new OrderPage(driver);  // Возвращаем объект OrderPage после клика
    }


}
