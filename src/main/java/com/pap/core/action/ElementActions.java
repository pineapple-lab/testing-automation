package com.pap.core.action;
import com.microsoft.playwright.Page;
import com.pap.core.browser.instance.PlaywrightManager;
import io.qameta.allure.Step;

public class ElementActions {

    private Page getPage(){
        return PlaywrightManager.getPage();
    }

    @Step("Hacer click en el elemento:'{selector}'")
    public void click(String selector){
        getPage().locator(selector).click();
    }
    @Step("Escribir '{text}' en el elemento: '{selector}'")
    public void type(String selector, String text){
        getPage().locator(selector).fill(text);
    }
    @Step("Obtener texto del elemento: '{selector}'")
    public String getText(String selector){
        return getPage().locator(selector).textContent();
    }
    @Step("Hacer doble click en el elemento: '{selector}'")
    public void dobuleClick(String selector){
        getPage().locator(selector).dblclick();
    }
    @Step("Pasar el cursor sobre el elemento: '{selector}'")
    public void hover(String selector){
        getPage().locator(selector).hover();
    }
    @Step("Seleccionando la opcion '{value}' del elemento: '{selector}'")
    public void selectByValue(String selector, String value){
        getPage().locator(selector).selectOption(value);
    }
    @Step("Marcando checkbox/radio: '{selector}'")
    public void check(String selector){
        getPage().locator(selector).check();
    }
    @Step("Desmarcando checkbox: '{selector}'")
    public void uncheck(String selector){
        System.out.println("Desmarcando checkbox: " + selector);
        getPage().locator(selector).uncheck();
    }
    @Step("Comprobando si es visible el elemento: '{selector}'")
    public boolean isVisible(String selector){
        return getPage().locator(selector).isVisible();
    }
}
