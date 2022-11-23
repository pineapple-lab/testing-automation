package SpaceLogik.pw.Proposal;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class proposalFuncionPaymentCancelation extends robotBaseSpaceLogik {

    @Test
    public void PaymentCancelationPequeño() {
        nameProposal = "pruebAutomatizada2-PaymentCancelationPequeño";
        iniciarVariablesPropposalValoresPequeños();
        iniciarVariablesProposalXYZ77M();
        login();
        crearProposal();
        llenarProposal();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible( "text=Changes saved successfully"));
        page.focus(".proposal-calculation-container h3:nth-of-type(2)");
        Assertions.assertTrue(page.isVisible( "text=$23,817"));
    }
    @Test
    public void PaymentCancelationMediano() {
        nameProposal = "pruebAutomatizada3-PaymentCancelationMediano";
        iniciarVariablesPropposalValoresMedianos();
        iniciarVariablesProposalXYZ77M();
        login();
        crearProposal();
        llenarProposal();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible( "text=Changes saved successfully"));
        page.focus(".proposal-calculation-container h3:nth-of-type(2)");
        Assertions.assertTrue(page.isVisible( "text=$952,578"));
    }
    @Test
    public void PaymentCancelationGrande() {
        nameProposal = "pruebAutomatizada4-PaymentCancelationGrande";
        iniciarVariablesPropposalValoresGrandes();
        iniciarVariablesProposalXYZ77M();
        login();
        crearProposal();
        llenarProposal();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible( "text=Changes saved successfully"));
        page.focus(".proposal-calculation-container h3:nth-of-type(2)");
        Assertions.assertTrue(page.isVisible( "text=$6,838,824"));
    }
    @Test
    public void PaymentCancelationMuyGrande() {
        nameProposal = "pruebAutomatizada5-PaymentCancelationMuyGrande";
        iniciarVariablesPropposalValoresMuyGrandes();
        iniciarVariablesProposalXYZ77M();
        login();
        crearProposal();
        llenarProposal();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible( "text=Changes saved successfully"));
        page.focus(".proposal-calculation-container h3:nth-of-type(2)");
        Assertions.assertTrue(page.isVisible( "text=$32,931,060"));
    }
    @Test
    public void ValidacionDeDatosProposalAnalysis() {
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
    }
}
