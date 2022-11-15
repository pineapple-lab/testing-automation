package com.insumosSpaceLogik;

import com.insumosSpaceLogik.autenticacionBaseSpaceLogik;

public class comportamientoBaseExcepciones extends autenticacionBaseSpaceLogik {
    public void loginExcepcion(){
        page.navigate("https://space-logic.web.app/react/login");
        page.click("'LOG IN'");
    }
    public void nombreVacioProposalExcepcion(){
        page.click(".app-sidebar__inner > div > ul > li:nth-of-type(6)");
        page.click("text=Proposals");
        page.click("[class=\"default-spacelogik-button\"]");
        page.click(".new-proposal-modal-button-container button:nth-of-type(1)");
    }

}
