package InsumosDocola;
public class WaitingsDocola extends ContextBaseDocola{
    private final SelectorsDocola selectors = new SelectorsDocola();
    public void waitingLoginSelectors(){
        waitForSelectors(
                SelectorsDocola.LOGIN_EMAIL,
                SelectorsDocola.LOGIN_PASSWORD,
                SelectorsDocola.LOGIN_BUTTON
        );
    }
    public void waitingLoginSelectorIncorrectCredentials(){
        waitForSelectors(SelectorsDocola.LOGIN_INCORRECT_CREDENTIALS);
    }
    public void waitingJoinsSelectorStep1(int rol){
        waitForSelectors(
                SelectorsDocola.REGISTER_FIRST_NAME,
                SelectorsDocola.REGISTER_LAST_NAME,
                SelectorsDocola.EMAIL,
                selectors.rolRegister(rol)
        );
    }
    public void waitingJoinSelectorStep2(){
        waitForSelectors(
                SelectorsDocola.REGISTER_PASSWORD,
                SelectorsDocola.REGISTER_PASSWORD_CONFIRMATION
        );
    }
    public void waitingJoinSelectorStep3(){
        waitForSelectors(
                SelectorsDocola.REGISTER_TERMS_AND_CONDITIONS,
                SelectorsDocola.REGISTER_CAPTCHAT
        );
    }
    public void waitingOnboardingSelectorContentProviderStep1(){
        waitForSelectors(
                SelectorsDocola.ONBOARDING_CONTENT_PROVIDER_COMPANY_NAME,
                SelectorsDocola.ONBOARDING_CONTENT_PROVIDER_WEB_SITE,
                SelectorsDocola.ONBOARDING_CONTENT_PROVIDER_NEXT_BUTTON_STEP_1
        );
    }
    public void waitingOnboardingSelectorContentProviderStep2(){
        waitForSelectors(
                SelectorsDocola.VERIFY_PHONE_SKIP_FOR_NOW
        );
    }
    public void waitingCreateUploadFileSelectorsStep1(){
        waitForSelectors(
                SelectorsDocola.CONTENT_TITLE,
                SelectorsDocola.CONTENT_DESCRIPTION,
                SelectorsDocola.CONTENT_BUTTON_CONTINUE
        );
    }
    public void waitingConfigurationStepSelector() {
        waitForSelectors(
                SelectorsDocola.CONTENT_TAG_ICD_10_TYPE
        );
        //page.waitForSelector(SelectorsDocola.contentConfigurationMarketPlace);
        //page.waitForSelector(SelectorsDocola.contentButtonContinue);
    }
    public void waitingPricingStepSelector(){
        waitForSelectors(
                SelectorsDocola.CONTENT_PRICING_MONTHLY_PRICE,
                SelectorsDocola.CONTENT_BUTTON_CONTINUE
        );
        //page.waitForSelector(SelectorsDocola.contentPricingYearlyPrice);

    }
    public void waitingMatDialogContainer(){
        waitForSelectors(
                SelectorsDocola.MAT_DIALOG_CONTAINER,
                SelectorsDocola.CLASS_MAT_DIALOG_CONTAINER,
                SelectorsDocola.CLASS_MAT_MDC_DIALOG_SURFACE
        );
    }
    public void waitingThumbnailStepSelector(){
        waitForSelectors(
                SelectorsDocola.CONTENT_THUMBNAIL_UNSPLASH,
                SelectorsDocola.CONTENT_THUMBNAIL_UPLOAD_FILE
        );
    }
    public void waitingUnshplashPopUpSelectors (){
        waitForSelectors(
                SelectorsDocola.WAIT_CATEGORY_UNPLASH
        );
        //page.waitForSelector(SelectorsDocola.contentUnsplashSelectButton);
    }
    public void waitingUnsplashPhotos(){
        waitForSelectors(SelectorsDocola.WAITING_UNPLASH);
    }
    // Método auxiliar para esperar varios selectores
    private void waitForSelectors(String... selectors) {
        for (String SelectorsDocola : selectors) {
            page.waitForSelector(SelectorsDocola);
        }
    }
}
