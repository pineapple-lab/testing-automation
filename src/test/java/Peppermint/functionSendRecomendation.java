package Peppermint;

import insumosPeppermint.testCasesRecommendation;

public class functionSendRecomendation extends testCasesRecommendation {

    public void validationSendRecomendation(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        startExecutionArticle();
        printNumberExecutions();
        startNavigation();
        if (linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
            emailLogin = emailRecomendationSending;
        }
        if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
            emailLogin = emailRecomendationSendingQA;
        }
        login();
        validateRecommendation();

    }
    public void validationSendUserRecommendation(){
        startContext();
        serverStatus();
        System.out.println("Iniciando caso de prueba...");
        printStream.println("Iniciando caso de prueba...");
        startExecutionArticle();
        printNumberExecutions();
        startNavigation();
        if (linkNavigation =="http://localhost:4200/auth/login" || linkNavigation == "https://peppermint-development.web.app/auth/login") {
            emailLogin = "pineappleuser1685718024380@mailinator.com";

        }
        if (linkNavigation=="https://peppermint-qa.web.app/auth/login"){
            emailLogin = "LauraPadilla1693506039635@mailinator.com";
        }

        login();
        validateSendUserRecommendation();
    }
}