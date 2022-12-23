package SpaceLogik.pw.Proposal;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class CA024proposalFuncionPaymentCancelation extends robotBaseSpaceLogik {

    @Test
    public void CA0241PaymentCancelationPequeño() {
        nameProposal = "pruebAutomatizada2-PaymentCancelationPequeño";
        assertions = "text=Changes saved successfully";
        iniciarVariablesPropposalValoresPequeños();
        login();
        llenarProposal();
        page.focus("#root");
        sqlGuardarCasoSiFallaCartelDePaymentCancelationPequeño();
        Assertions.assertTrue(page.isVisible( assertions));
        page.focus(".proposal-calculation-container h3:nth-of-type(2)");
        sqlGuardarCasoSiFallaPaymentCancelationPequeño();
        Assertions.assertTrue(page.isVisible(assertionPenaltyAmount));
    }
    @Test
    public void CA0242PaymentCancelationMediano() {
        nameProposal = "pruebAutomatizada3-PaymentCancelationMediano";
        assertions = "text=Changes saved successfully";
        iniciarVariablesPropposalValoresMedianos();
        login();
        llenarProposal();
        page.focus("#root");
        sqlGuardarCasoSiFallaCartelDePaymentCancelationMediano();
        Assertions.assertTrue(page.isVisible( assertions));
        page.focus(".proposal-calculation-container h3:nth-of-type(2)");
        sqlGuardarCasoSiFallaPaymentCancelationMediano();
        Assertions.assertTrue(page.isVisible( assertionPenaltyAmount));
    }
    @Test
    public void CA0243PaymentCancelationGrande() {
        nameProposal = "pruebAutomatizada4-PaymentCancelationGrande";
        assertions = "text=Changes saved successfully";
        iniciarVariablesPropposalValoresGrandes();
        login();
        llenarProposal();
        page.focus("#root");
        sqlGuardarCasoSiFallaCartelDePaymentCancelationGrande();
        Assertions.assertTrue(page.isVisible( assertions));
        page.focus(".proposal-calculation-container h3:nth-of-type(2)");
        sqlGuardarCasoSiFallaPaymentCancelationGrande();
        Assertions.assertTrue(page.isVisible( assertionPenaltyAmount));
    }
    @Test
    public void CA0245PaymentCancelationMuyGrande() {
        nameProposal = "pruebAutomatizada5-PaymentCancelationMuyGrande";
        assertions = "text=Changes saved successfully";
        iniciarVariablesPropposalValoresMuyGrandes();
        login();
        llenarProposal();
        page.focus("#root");
        sqlGuardarCasoSiFallaCartelDePaymentCancelationMuyGrande();
        Assertions.assertTrue(page.isVisible( assertions));
        page.focus(".proposal-calculation-container h3:nth-of-type(2)");
        sqlGuardarCasoSiFallaPaymentCancelationMuyGrande();
        Assertions.assertTrue(page.isVisible( assertionPenaltyAmount));
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
