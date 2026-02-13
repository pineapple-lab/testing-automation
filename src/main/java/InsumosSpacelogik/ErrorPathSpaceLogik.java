package InsumosSpacelogik;

import com.microsoft.playwright.Locator;

public class ErrorPathSpaceLogik extends ContextBaseSpacelogik{
    MethodsSpacelogik methods = new MethodsSpacelogik();
    GeneratorSpaceLogik genereate = new GeneratorSpaceLogik();
    SelectorsSpacelogik selector = new SelectorsSpacelogik();
    //RECOMPANIE VERIFY
    public boolean verifyReCompanieFormStep1EmptyInputs(){
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTINUEBUTTON_STEP1);
        boolean validationPassed = methods.verifyAssertions(
                ()->  methods.verifyInputErrorMessage(SelectorsSpacelogik.RECOMPANIE_ERRORMESSAGE_EMPTYINPUTS,LabelMessage.ERRORMESSAGE_GENERIC_EMPTYINPUTS)
        );
        page.fill(SelectorsSpacelogik.RECOMPANIE_COMPANYNAME_INPUT, "TEST");
        page.locator(SelectorsSpacelogik.RECOMPANIE_COMPANYADRESS_INPUT).type("Dallas North Tollway, Dallas, Texas, EE. UU.", new Locator.TypeOptions().setDelay(10));
        page.click(SelectorsSpacelogik.RECOMPANIE_COMPANYADRESS_OPTIONS);
        page.waitForTimeout(2000);
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTINUEBUTTON_STEP1);
        return validationPassed;
    }
    public boolean verifyReCompanieFormStep2EmptyInputs (){
        boolean validationPassed;
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTINUEBUTTON_STEP2);
        validationPassed = methods.verifyAssertions(
                ()->  methods.verifyInputErrorMessage(SelectorsSpacelogik.RECOMPANIE_ERRORMESSAGE_EMPTYINPUTS,LabelMessage.ERRORMESSAGE_EMPTYINPUTS_EMAIL)
        );
        page.waitForTimeout(990);
        page.fill(SelectorsSpacelogik.RECOMPANIE_EMAIL_INPUT, "test14031202@pineapple-lab.com");
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTINUEBUTTON_STEP2);
        validationPassed &= methods.verifyAssertions(
                ()->  methods.verifyInputErrorMessage(SelectorsSpacelogik.RECOMPANIE_ERRORMESSAGE_EMPTYINPUTS,LabelMessage.ERRORMESSAGE_EMPTYINPUTS_PASSWORD)
        );
        page.fill(SelectorsSpacelogik.RECOMPANIE_PASSWORD_INPUT, "Pickle30");
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTINUEBUTTON_STEP2);
        validationPassed &= methods.verifyAssertions(
                ()->  methods.verifyInputErrorMessage(SelectorsSpacelogik.RECOMPANIE_ERRORMESSAGE_EMPTYINPUTS,LabelMessage.ERRORMESSAGE_EMPTYINPUTS_CPASSWORD)
        );
        page.fill(SelectorsSpacelogik.RECOMPANIE_PASSWORDCONFIRM_INPUT, "Pickle30");
        page.click(SelectorsSpacelogik.RECOMPANIE_CONTINUEBUTTON_STEP2);
        return validationPassed;
    }
    public boolean verifyReCompanieFormStep3EmptyInputs (){
        page.click(SelectorsSpacelogik.RECOMPANIE_SAVE_BUTTON);
        boolean validationPassed = methods.verifyAssertions(
                ()->  methods.verifyInputErrorMessage(SelectorsSpacelogik.RECOMPANIE_ERRORMESSAGE_EMPTYINPUTS,LabelMessage.ERRORMESSAGE_GENERIC_EMPTYINPUTS)
        );
        return validationPassed;
    }

    //NATIONAL ACCOUNT VERIFY
    public boolean verifyNationalAccountFormStep1EmptyInputs(){
        page.click(SelectorsSpacelogik.NACCOUNT_CONTINUE_BUTTON);
        boolean validationPassed = methods.verifyAssertions(
                ()->  methods.verifyInputErrorMessage(SelectorsSpacelogik.NACCOUNT_ERRORMESSAGE_EMPTYINPUTS,LabelMessage.ERRORMESSAGE_EMPTYINPUTS_ADRESS)
        );
        page.fill(SelectorsSpacelogik.NACCOUNT_COMPANY_NAME_INPUT, genereate.generateCompanyName());
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_INDUSTRY_SELECT);
        page.click(selector.IndustryOption(genereate.generateIndustry()));
        page.locator(SelectorsSpacelogik.NACCOUNT_COMPANY_ADDRESS_INPUT).type("Dallas North Tollway, Dallas, Texas, EE. UU.", new Locator.TypeOptions().setDelay(10));
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_ADDRESS_OPTION);
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_STATE_SELECT);
        page.click(selector.StateOption(genereate.generateState()));
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_CITY_SELECT);
        page.click(selector.CityOption(genereate.generateCity()));
        page.click(SelectorsSpacelogik.NACCOUNT_COMPANY_ZIPCODE_SELECT);
        page.click(selector.ZipcodeOption(genereate.generateZipCode()));
        page.click(SelectorsSpacelogik.NACCOUNT_CONTINUE_BUTTON);
        return validationPassed;
    }
    public boolean verifyNationalAccountFormStep2EmptyInputs(){
        page.click(SelectorsSpacelogik.NACCOUNT_TENANT_CONTINUE_BUTTON);
        boolean validationPassed = methods.verifyAssertions(
                ()->  methods.verifyInputErrorMessage(SelectorsSpacelogik.NACCOUNT_ERRORMESSAGE_EMPTYINPUTS,LabelMessage.ERRORMESSAGE_EMPTYINPUTS_EMAIL)
        );
        page.fill(SelectorsSpacelogik.NACCOUNT_TENANT_EMAIL_INPUT, "test11211302@pineapple-lab.com");
        allStepsPassed &= methods.verifyAssertions(
                ()->  methods.verifyInputErrorMessage(SelectorsSpacelogik.NACCOUNT_ERRORMESSAGE_EMPTYINPUTS,LabelMessage.ERRORMESSAGE_EMPTYINPUTS_PASSWORD)
        );
        return validationPassed;
    }
}
