package com.teoria;

import com.microsoft.playwright.Request;
import com.microsoft.playwright.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MasMetodosDeNavegacion extends ScriptBase{

    @Test
    public void responseApiDemo(){
        Response r = page.navigate(home);
        System.out.println(r.status());

        Response r2 = page.navigate("https://app.pluralsight.com/library/");

        System.out.println(r2.url());
        System.out.println(r2.status());
        System.out.println(r2.ok());
        System.out.println(r2.headers());

        System.out.println(r2.body());
        System.out.println("Converted byte array");
        System.out.println(r2.text());
    }
    @Test
    public void requestApiDemo(){
        Response response = page.navigate("https://app.pluralsight.com/library/");
        Request request = response.request();
        System.out.println(request.headers());
        System.out.println(request.postData());
        System.out.println(request.method());
    }
    @Test
    public void monitorHttpTrafficDemo(){
       // page.onRequest(request -> System.out.print(">>" + request.method() + "" + request.url()));
        //System.out.println("------------------------------------------------------------------------------");
        //page.onResponse(response -> System.out.println("<<" + response.status()));
        //System.out.println("------------------------------------------------------------------------------");
        List<Integer> responses = new ArrayList<>();
        page.onResponse(response -> responses.add(response.status()));
        page.navigate("https://app.pluralsight.com/library/");
        System.out.println(responses);

        boolean foundMatch = responses.stream()
                .anyMatch(i -> i < 200 || i >= 300 );
        Assertions.assertFalse(foundMatch);
    }
}
