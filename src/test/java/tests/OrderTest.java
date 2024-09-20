package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObjects.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTestChrome {
   
    private OrderPage orderPage;

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;
    private final String comment;

    public OrderTest(String name, String surname, String address, String metro, String phone, String date, String period, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.comment = comment;
    }

    @Parameterized.Parameters // Тестовые данные
    public static Object[][] orderButton() {
        return new Object[][]{
                {"Катя", "Пушкарева", "Ленина", "Динамо", "89567418596", "28.06.2023", "сутки", "оставить у двери"},
                {"Миша", "Потапов", "Маркса дом 5", "Цветной бульвар", "+79137789635", "22.08.2023", "пятеро суток", "Привет!"}
        };
    }

    @Test
    public void checkOrderByUpButton() {
        orderPage = faqPage.clickOrderButtonUp();
        ordering(orderPage);
    }

    @Test
    public void checkOrderByDownButton() {
        orderPage = faqPage.clickOrderButtonDown();
        ordering(orderPage);
    }

    private void ordering(OrderPage orderPage) {
        assertTrue(orderPage.isStepOne()); // На первом этапе заказа

        // Заполняем поля
        orderPage.setNameField(name);
        orderPage.setSurnameField(surname);
        orderPage.setAddressField(address);
        orderPage.setMetroField(metro);
        orderPage.setPhoneField(phone);

        // Переходим на следующий этап
        orderPage.clickNextButton();
        assertTrue(orderPage.isStepTwo()); // На втором этапе заказа
        orderPage.setDateField(date);
        orderPage.choiceRentPeriod(period);
        orderPage.selectBlackCheckbox();
        orderPage.setCommentField(comment);
        orderPage.clickOrderButtonDown();
        assertTrue(orderPage.isModalOrderVisible()); // Подтверждение заказа
        orderPage.clickYesButton();
        assertTrue(orderPage.isOrderCompleted()); // Заказ успешно завершен
    }
}

