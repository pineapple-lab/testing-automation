package SpaceLogik.pw.Proposal;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class CA024proposalFuncionPaymentCancelation extends robotBaseSpaceLogik {

    @Test
    public void CA0241PaymentCancelationPequeño() {
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesPropposalValoresPequeños();
        System.out.println("El caso CA0241 se va a ejecutar "+ejecutar+" veces");
        for(contador=1; contador<=ejecutar;contador++) {
            nameCase = nameProposal+".2-PaymentCancelationPequeño.Ejecuciones:"+contador;
            login();
            llenarProposal();
            page.focus("#root");
            assertions = "text=Changes saved successfully";
            sqlGuardarCasoSiFallaPaymentCancelationPequeño();
            Assertions.assertTrue(page.isVisible(assertions));
            page.focus(".proposal-calculation-container h3:nth-of-type(2)");
            assertions = "text=$"+ assertionPenaltyAmount;
            sqlGuardarCasoSiFallaPaymentCancelationPequeño();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0241 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0242PaymentCancelationMediano() {
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesPropposalValoresMedianos();
        System.out.println("El caso CA0242 se va ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
            nameCase = nameProposal+".3-PaymentCancelationMediano.Ejecuciones:"+contador;
            login();
            llenarProposal();
            page.focus("#root");
            assertions = "text=Changes saved successfully";
            sqlGuardarCasoSiFallaPaymentCancelationMediano();
            Assertions.assertTrue(page.isVisible(assertions));
            page.focus(".proposal-calculation-container h3:nth-of-type(2)");
            assertions = "text=$"+assertionPenaltyAmount;
            sqlGuardarCasoSiFallaPaymentCancelationMediano();
            Assertions.assertTrue(page.isVisible(assertions));
            System.out.println("El caso CA0242 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0243PaymentCancelationGrande() {
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesPropposalValoresGrandes();
        System.out.println("El caso CA0243 se va ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
        nameCase = nameProposal+".4-PaymentCancelationGrande.Ejecuciones:"+contador;
        login();
        llenarProposal();
        page.focus("#root");
        assertions = "text=Changes saved successfully";
        sqlGuardarCasoSiFallaPaymentCancelationGrande();
        Assertions.assertTrue(page.isVisible( assertions));
        page.focus(".proposal-calculation-container h3:nth-of-type(2)");
        assertions = "text=$"+assertionPenaltyAmount;//
        sqlGuardarCasoSiFallaPaymentCancelationGrande();
        Assertions.assertTrue(page.isVisible(assertions));
        System.out.println("El caso CA0243 se ejecuto "+contador+" veces");
        }
    }
    @Test
    public void CA0245PaymentCancelationMuyGrande() {
        System.out.println("Iniciando caso de prueba...");
        iniciarVariablesPropposalValoresMuyGrandes();
        System.out.println("El caso CA0245 se va ejecutar "+ejecutar+" veces");
        for(contador=1;contador<=ejecutar;contador++) {
        nameCase = nameProposal+".5-PaymentCancelationMuyGrande.Ejecuciones:"+contador;
        login();
        llenarProposal();
        page.focus("#root");
        assertions = "text=Changes saved successfully";
        sqlGuardarCasoSiFallaPaymentCancelationMuyGrande();
        Assertions.assertTrue(page.isVisible( assertions));
        page.focus(".proposal-calculation-container h3:nth-of-type(2)");
        assertions = "text=$"+assertionPenaltyAmount;//
        sqlGuardarCasoSiFallaPaymentCancelationMuyGrande();
        Assertions.assertTrue(page.isVisible(assertions));
        System.out.println("El caso CA0245 se ejecuto "+contador+" veces");
        }
    }
    /*@Test
    public void CA0246ValidacionDeDatosProposalAnalysis() {
        nameProposal = "pruebAutomatizada6-ValidacionDeDatosProposalAnalysis";
        iniciarVariablesPropposalValoresMuyGrandes();
        iniciarVariablesProposalXYZ77M();
        login();
        crearProposal();
        llenarProposal();
        page.click("#root > div.app-main > div.app-main__outer > div > div > div.prospect-proposal-component > div.proposal-general-container > div.transaction-analysis-container > div.transaction-analysis-button-container > button");
        page.focus("#proposal-analysis-wrapper > div.analysis-table-info-container > div:nth-child(1)");
        Assertions.assertTrue(page.isVisible( "text=Term (months):180"));
        //Assertions.assertTrue(page.isVisible( "text=Net rental rate:$30"));
       // Assertions.assertTrue(page.isVisible( "text=Annual increases:70.0%"));
        Assertions.assertTrue(page.isVisible( "text=Base T&O:$21.79"));
        Assertions.assertTrue(page.isVisible( "text=Abated mos (net):300"));
        page.focus("#proposal-analysis-wrapper > div.analysis-table-info-container > div:nth-child(2)");
        Assertions.assertTrue(page.isVisible( "text=TI allowance:$200.00"));
        Assertions.assertTrue(page.isVisible( "text=Commissions:$0.00"));
        Assertions.assertTrue(page.isVisible( "text=Base building:$150.00"));
        Assertions.assertTrue(page.isVisible( "text=Other OOP costs:$217.02"));
        Assertions.assertTrue(page.isVisible( "text=Total OOP costs:$567.02"));
        page.focus("#proposal-analysis-wrapper > div.analysis-table-info-container > div:nth-child(3)");
        Assertions.assertTrue(page.isVisible( "text=Discount rate:0.00%"));
        Assertions.assertTrue(page.isVisible( "text=Gross income:$7,530,296"));
        Assertions.assertTrue(page.isVisible( "text=Net income:$-13,063,650"));
        Assertions.assertTrue(page.isVisible( "text=IRR:N/A"));
        //Assertions.assertTrue(page.isVisible( "text=NER:$0.00"));
    }*/
}
