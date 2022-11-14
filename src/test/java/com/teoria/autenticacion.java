package com.teoria;

import com.insumosSpaceLogik.autenticacionBaseSpaceLogik;
import org.junit.jupiter.api.Test;

public class autenticacion extends autenticacionBaseSpaceLogik {

    @Test
    public void auth(){
        //page.navigate("https://space-logic.web.app/react/login");
        //login
        page.click("[class=\"p-0 btn btn-link\"]");
        page.click("text=Michael Walker");


    }
   /* @Test
    public void auth2(){
        page.navigate("https://space-logic.web.app/react/login");
        //deberia verificar que la sesion se mantuvo iniciada
        page.click("[class=\"p-0 btn btn-link\"]");
        page.click("text=Michael Walker");
    }*/
}
