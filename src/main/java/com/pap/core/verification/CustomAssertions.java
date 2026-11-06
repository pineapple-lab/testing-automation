package com.pap.core.verification;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.pap.core.browser.instance.PlaywrightManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.util.List;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CustomAssertions {
    private Page getPage(){
        return PlaywrightManager.getPage();
    }

    @Attachment(value = "Captura de pantalla al fallar", type = "image/png")
    public byte [] takeScreenshot(){
        return getPage().screenshot(new Page.ScreenshotOptions().setFullPage(true));
    }

    @Step("Validar que el elemento '{selector}' sea visible")
    public void assertElementIsVisible(String selector){
        try{
            assertThat(getPage().locator(selector)).isVisible();
        }catch (AssertionError e) {
            takeScreenshot();
            throw e;
        }
    }
    @Step("Validar que el elemento '{selector}' esta oculto o no es visible")
    public void assertElementIsHidden(String selector){
        try{
            assertThat(getPage().locator(selector)).isHidden();
        }catch (AssertionError e){
            takeScreenshot();
            throw e;
        }
    }
    @Step("Validar que el elemento '{selector}' contenga el texto: '{expectedText}'")
    public void assertElementContainsText(String selector, String expectedText){
        try {
            assertThat(getPage().locator(selector)).containsText(expectedText);
        }catch (AssertionError e){
            takeScreenshot();
            throw e;
        }
    }
    @Step("Validar que el elemento '{selector}' tenga exactamente el texto: '{expectedText}'")
    public void assertElementHasText(String selector, String expectedText){
        try {
            assertThat(getPage().locator(selector)).hasText(expectedText);
        }catch (AssertionError e){
            takeScreenshot();
            throw e;
        }
    }
    @Step("Validar que el campo '{selector}' tenga el valor: '{expectedValue}'")
    public void assertElementHasValue(String selector, String expectedValue) {
        try {
            assertThat(getPage().locator(selector)).hasValue(expectedValue);
        } catch (AssertionError e) {
            takeScreenshot();
            throw e;
        }
    }
    @Step("Validar que '{expectedText}' aparezca una sola vez en la lista")
    public void assertTextExistsInList(List<String> titles, String expectedText) {
        try {
            long count = titles.stream()
                    .filter(t -> t.trim().equals(expectedText))
                    .count();
            if (count != 1) {
                throw new AssertionError("Se esperaba 1 coincidencia de '" + expectedText
                        + "' y hubo " + count + ". Lista: " + titles);
            }
        } catch (AssertionError e) {
            takeScreenshot();
            throw e;
        }
    }
    @Step("Validar que el elemento '{selector}' esté habilitado")
    public void assertElementIsEnabled(String selector) {
        try {
            assertThat(getPage().locator(selector)).isEnabled();
        } catch (AssertionError e) {
            takeScreenshot();
            throw e;
        }
    }
    @Step("Validar que el elemento '{selector}' esté deshabilitado")
    public void assertElementIsDisabled(String selector) {
        try {
            assertThat(getPage().locator(selector)).isDisabled();
        } catch (AssertionError e) {
            takeScreenshot();
            throw e;
        }
    }
    @Step("Validar que el checkbox/radio '{selector}' esté marcado")
    public void assertElementIsChecked(String selector) {
        try {
            assertThat(getPage().locator(selector)).isChecked();
        } catch (AssertionError e) {
            takeScreenshot();
            throw e;
        }
    }
    @Step("Validar que el elemento '{selector}' tenga el atributo '{attribute}' con valor '{expectedValue}'")
    public void assertElementHasAttribute(String selector, String attribute, String expectedValue) {
        try {
            assertThat(getPage().locator(selector)).hasAttribute(attribute, expectedValue);
        } catch (AssertionError e) {
            takeScreenshot();
            throw e;
        }
    }
    @Step("Validar que la cantidad de elementos para '{selector}' sea exactamente: {expectedCount}")
    public void assertElementCount(String selector, int expectedCount) {
        try {
            assertThat(getPage().locator(selector)).hasCount(expectedCount);
        } catch (AssertionError e) {
            takeScreenshot();
            throw e;
        }
    }
    @Step("Validar que el título de la página sea: '{expectedTitle}'")
    public void assertPageTitle(String expectedTitle) {
        try {
            assertThat(getPage()).hasTitle(expectedTitle);
        } catch (AssertionError e) {
            takeScreenshot();
            throw e;
        }
    }
    @Step("Validar que la URL actual sea: '{expectedUrl}'")
    public void assertPageUrl(String expectedUrl) {
        try {
            assertThat(getPage()).hasURL(expectedUrl);
        } catch (AssertionError e) {
            takeScreenshot();
            throw e;
        }
    }
}
