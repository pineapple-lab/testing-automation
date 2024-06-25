package Peppermint;

import insumosPeppermint.testCasesRecommendation;

public class functionSendRecomendation extends testCasesRecommendation {

    public void validationSendRecomendation(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        outputStream.println("Iniciando caso de prueba...");
        startExecutionArticle();
        printNumberExecutions();
        startNavigation();
        if (navigationLink =="http://localhost:4200/auth/login" || navigationLink == "https://peppermint-development.web.app/auth/login") {
            emailLogin = emailRecomendationSending;
        }
        if (navigationLink=="https://peppermint-qa.web.app/auth/login"){
            emailLogin = emailRecomendationSendingQA;
        }
        login();
        validateRecommendation();

    }
    public void validationSendUserRecommendation(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        outputStream.println("Iniciando caso de prueba...");
        startExecutionArticle();
        printNumberExecutions();
        startNavigation();
        if (navigationLink =="http://localhost:4200/auth/login" || navigationLink == "https://peppermint-development.web.app/auth/login") {
            emailLogin = "pineappleuser1685718024380@mailinator.com";

        }
        if (navigationLink=="https://peppermint-qa.web.app/auth/login"){
            emailLogin = "LauraPadilla1693506039635@mailinator.com";
        }

        login();
        validateSendUserRecommendation();
    }
}