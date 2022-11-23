package testEnConstruccionSpaceLogik;

import com.microsoft.playwright.Keyboard;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Test;

public class listingFuncionEdit extends robotBaseSpaceLogik {

     @Test
    public void validacionEditGeneralLocationInformation(){
         login();
         editarListiningGeneralLocationInformation();

    }
    public void editarListiningGeneralLocationInformation(){
        //page.click(".app-sidebar__inner > div > ul > li:nth-of-type(5)");
        //page.click("text=Listing");
        Keyboard kb = page.keyboard();
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.focus("");
        kb.insertText(yearBuiltListingLocationInformation);
        page.focus("");
        kb.insertText(totalBuildingRsfListingLocationInformation);
        page.focus("");
        kb.insertText(numberOfStoriesListingLocationInformation);
        page.click("");
        page.click("");
        page.click("");
        page.click("");
        page.click("");
        page.click("");
        page.click("");
        page.click("");
        page.click("");
        page.click("");
        page.click("");
        page.click("");
        page.click("");
        page.click("");
        page.click("");
        page.click("");
     }

}
