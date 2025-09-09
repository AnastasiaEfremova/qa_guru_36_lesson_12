package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.components.CalendarComponent;
import tests.components.CheckResultComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    private static final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submit = $("#submit");

    @Step("Открыть /automation-practice-form")
    public RegistrationPage openAutomationPracticeForm() {
        open("/automation-practice-form");
        fixedBan();
        return this;
    }

    public void fixedBan() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
    }

    @Step("Заполнить поле имя")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Заполнить поле фамилия")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Заполнить поле с email")
    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    @Step("Выбрать пол")
    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    @Step("Заполнить поле с номером телефона")
    public RegistrationPage setUserNumber(String phone) {
        userNumberInput.setValue(phone);
        return this;
    }

    @Step("Указать дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Выбрать предмет")
    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбрать хобби")
    public RegistrationPage setHobby(String subject) {
        hobbiesInput.$(byText(subject)).click();
        return this;
    }

    @Step("Загрузить картинку")
    public RegistrationPage uploadPicture(String pathToPicture) {
        uploadPictureInput.uploadFromClasspath(pathToPicture);
        return this;
    }

    @Step("Указать текущий адрес")
    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    @Step("Выбрать штат")
    public RegistrationPage setState(String state) {
        stateInput.setValue(state).pressEnter();
        return this;
    }

    @Step("Выбрать город")
    public RegistrationPage setCity(String city) {
        cityInput.setValue(city).pressEnter();
        return this;
    }

    @Step("Подтвердить")
    public void submit() {
        submit.pressEnter();
    }

    @Step("Проверить результат для {key} и {value}")
    public RegistrationPage checkResult(String key, String value) {
        checkResultComponent.checkTableResult(key, value);
        return this;
    }

    @Step("Окна с результатом не должно быть")
    public RegistrationPage shouldNotHaveTableResult() {
        checkResultComponent.shouldNotHaveTableResult();
        return this;
    }
}
