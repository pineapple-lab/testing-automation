package com.papa.core.action;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.papa.core.browser.instance.PlaywrightManager;

public class KeyboardActions {

    private Page page() {
        return PlaywrightManager.getPage();
    }
    public void press(String key) {
        page().keyboard().press(key);
    }
    public void type(String text) {
        page().keyboard().type(text);
    }
    public void type(String text, double delayMs) {
        page().keyboard().type(text, new com.microsoft.playwright.Keyboard.TypeOptions().setDelay(delayMs));
    }
    public void insertText(String text) {
        page().keyboard().insertText(text);
    }
    public void hold(String key)    { page().keyboard().down(key); }
    public void release(String key) { page().keyboard().up(key); }
    public void press(Locator locator, String key) {
        locator.press(key);
    }
    public void type(Locator locator, String text) {
        locator.pressSequentially(text);
    }
}