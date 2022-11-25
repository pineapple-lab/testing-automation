package SpaceLogik.pw.Listing;

import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class listingFuncionEditAmenitiesInfo extends robotBaseSpaceLogik {
    @Test
    public void validacionEditListingAmenitiesInfo(){
        login();
        navegarListingAmenities();
        editarListingAmenitiesInfo();
        page.focus("#root");
        Assertions.assertTrue(page.isVisible("text=Changes saved successfully"));
    }

    public void navegarListingAmenities(){
        page.click(".my-properties-container .my-properties-building-container:last-child>div>div:nth-of-type(2)");
        page.click(".BuildingInfoHeaderDiv ul li:nth-of-type(5) input");
    }
}
