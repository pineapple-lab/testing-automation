package SpaceLogik.pw;

;
import insumosSpaceLogik.robotBaseSpaceLogik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CA033myAmenitiesFuncionInfo extends robotBaseSpaceLogik {
    @Test
   public void CA0331validacionInfoMyAmenitiesHealtClub(){
       login();
       page.click("text=MY LOGIK");
       page.click("text = My Amenities");
       page.click(".amenities-table-container tbody tr:nth-of-type(1) td:nth-of-type(1)");
       page.focus(".building-info-column-amenities");
       Assertions.assertTrue(page.isVisible("text=HEALTH CLUB"));
       Assertions.assertTrue(page.isVisible("text=Not all health clubs are considered equal.  Here are some of the more sought after features that differentiate good clubs versus great ones.  The more features a club has, the higher the point ranking."));
       Assertions.assertTrue(page.isVisible("text=FEATURES"));
       Assertions.assertTrue(page.isVisible("text=Lockers"));
       Assertions.assertTrue(page.isVisible("text=Cardio machines"));
       Assertions.assertTrue(page.isVisible("text=Circuit training"));
       Assertions.assertTrue(page.isVisible("text=Showers"));
       Assertions.assertTrue(page.isVisible("text=Free weights"));
       Assertions.assertTrue(page.isVisible("text=Running track"));
       Assertions.assertTrue(page.isVisible("text=Swimming"));
       Assertions.assertTrue(page.isVisible("text=Basketball"));
       Assertions.assertTrue(page.isVisible("text=Yoga classes"));
       Assertions.assertTrue(page.isVisible("text=THIS IS WHY A HEALTH CLUB BENEFITS TENANTS"));
       Assertions.assertTrue(page.isVisible("text=A building fitness center is one of the more valuable tenant amenities, even though the use was somewhat limited during the high point of Covid19.\n" +
               "\n" +
               "Not only does a health club make it more convenient for employees to more easily stay on their fitness routine and still manage their busy schedules, employees that work out regularly are healthier and more productive."));
    }
    @Test
    public void CA0332validacionInfoMyAmenitiesFoodService(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(3) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=FOOD SERVICE / RESTAURANT(S)"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Breakfast"));
        Assertions.assertTrue(page.isVisible("text=Speciality coffee"));
        Assertions.assertTrue(page.isVisible("text=Lunch"));
        Assertions.assertTrue(page.isVisible("text=Multiple lunch options"));
        Assertions.assertTrue(page.isVisible("text=Full service restaurant"));
        Assertions.assertTrue(page.isVisible("text=Bar / lounge"));
        Assertions.assertTrue(page.isVisible("text=Why onsite food service could benefit tenants ..."));
        Assertions.assertTrue(page.isVisible("text=Having an onsite food source gives tenants and their employees the option of eating at a restaurant without leaving the building.  Some employers find that their staff takes shorter lunch breaks with onsite food service, possibly increasing employee productivity.  \n" +
                "\n" +
                "Since employees can quickly tire of the same food every day, having multiple food options becomes even more valuable."));
    }
    @Test
    public void CA0333validacionInfoMyAmenitiesConferenceFacility(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(4) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=CONFERENCE FACILITY"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Single conference room"));
        Assertions.assertTrue(page.isVisible("text=Multiple conference rooms"));
        Assertions.assertTrue(page.isVisible("text=Auditorium"));
        Assertions.assertTrue(page.isVisible("text=Convene or equivalent."));
    }
    @Test
    public void CA0334validacionInfoMyAmenitiesTenantLounge(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(5) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=TENANT LOUNGE"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Indoor seating / meeting area"));
        Assertions.assertTrue(page.isVisible("text=Outside terrace or rooftop"));
        Assertions.assertTrue(page.isVisible("text=Game room"));
        Assertions.assertTrue(page.isVisible("text=Food or coffee service"));
        Assertions.assertTrue(page.isVisible("text=Why tenant lounge areas are important"));
        Assertions.assertTrue(page.isVisible("text=Giving employees other areas to go to during the workday increases their flexibility to get work done, meet colleagues or just get away from the grind of the office for a while."));
    }
    @Test
    public void CA0335validacionInfoMyAmenitiesConvenienceStore(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(6) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=CONVENIENCE STORE"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Sundry / convenience store"));
        Assertions.assertTrue(page.isVisible("text=Attached mall"));
        Assertions.assertTrue(page.isVisible("text=Multiple retail stores"));
    }
    @Test
    public void CA0336validacionInfoMyAmenitiesVendingArea(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(7) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=VENDING AREA"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Traditional vending machines"));
        Assertions.assertTrue(page.isVisible("text=Upscale vending (Farmer's Fridge or equivalent)"));
    }
    @Test
    public void CA0337validacionInfoMyAmenitiesHotelLodging(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(8) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=HOTEL / LODGING"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Attached hotel"));
        Assertions.assertTrue(page.isVisible("text=Hotel within 1 block"));
    }
    @Test
    public void CA0338validacionInfoMyAmenitiesBikeRoom(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(9) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=BIKE ROOM"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Security camera / attendee"));
        Assertions.assertTrue(page.isVisible("text=Climate controlled"));
        Assertions.assertTrue(page.isVisible("text=Showers"));
        Assertions.assertTrue(page.isVisible("text=Lockers"));
    }
    @Test
    public void CA0339validacionInfoMyAmenitiesExecutiveParking(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(10) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=EXECUTIVE PARKING"));
        Assertions.assertTrue(page.isVisible("text=Executive parking refers to secure, climate controlled parking available on a monthly basis, usually for a fee. Sometimes a small number of executive parking spots are provided as a part of lease negotiations."));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Secure"));
        Assertions.assertTrue(page.isVisible("text=Heated"));
        Assertions.assertTrue(page.isVisible("text=Car wash"));
        Assertions.assertTrue(page.isVisible("text=Valet"));
        Assertions.assertTrue(page.isVisible("text=What is executive parking?"));
    }
    @Test
    public void CA0339validacionInfoMyAmenitiesBankingAtm(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(11) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=BANKING / ATM"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Onsite ATM"));
        Assertions.assertTrue(page.isVisible("text=Full service bank"));
    }
    @Test
    public void CA03310validacionInfoMyAmenitiesDryCleaner(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(12) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=DRY CLEANER"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Manned cleaners on site"));
        Assertions.assertTrue(page.isVisible("text=Cleaner lockers (Pressbox or equivalent)"));
    }
    @Test
    public void CA03311validacionInfoMyAmenitiesHairsalonBarber(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(13) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=HAIR SALON / BARBER"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Barber (men)"));
        Assertions.assertTrue(page.isVisible("text=Studio (men & women)"));
        Assertions.assertTrue(page.isVisible("text=Salon with additional services"));
    }
    @Test
    public void CA03312validacionInfoMyAmenitiesConcierge(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(14) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=CONCIERGE"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Concierge - online access"));
        Assertions.assertTrue(page.isVisible("text=Concierge - on-site"));
    }
    @Test
    public void CA03313validacionInfoMyAmenitiesMannedSecurity(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(15) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=MANNED SECURITY"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=24-7 manned security"));
        Assertions.assertTrue(page.isVisible("text=On-line visitor check in app"));
    }
    @Test
    public void CA03314validacionInfoMyAmenitiesDayCare(){
        login();
        page.click("text=MY LOGIK");
        page.click("text = My Amenities");
        page.click(".amenities-table-container tbody tr:nth-of-type(16) td:nth-of-type(1)");
        page.focus(".building-info-column-amenities");
        Assertions.assertTrue(page.isVisible("text=DAY CARE"));
        Assertions.assertTrue(page.isVisible("text=FEATURES"));
        Assertions.assertTrue(page.isVisible("text=Day care on-site"));
        Assertions.assertTrue(page.isVisible("text=Day care within 2 blocks"));
    }
}
