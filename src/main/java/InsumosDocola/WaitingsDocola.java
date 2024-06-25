package InsumosDocola;
public class WaitingsDocola extends ContextBaseDocola{
    private final SelectorsDocola selector = new SelectorsDocola();
    public void waitingLoginSelectors(){
        waitForSelectors(
                selector.LOGIN_EMAIL,
                selector.LOGIN_PASSWORD,
                selector.LOGIN_BUTTON
        );
    }
    public void waitingLoginSelectorIncorrectCredentials(){
        waitForSelectors(selector.LOGIN_INCORRECT_CREDENTIALS);
    }
    public void waitingJoinsSelectorStep1(int rol){
        waitForSelectors(
                selector.REGISTER_FIRST_NAME,
                selector.REGISTER_LAST_NAME,
                selector.EMAIL,
                selector.rolRegister(rol)
        );
    }
    public void waitingJoinSelectorStep2(){
        waitForSelectors(
                selector.REGISTER_PASSWORD,
                selector.REGISTER_PASSWORD_CONFIRMATION
        );
    }
    public void waitingJoinSelectorStep3(){
        waitForSelectors(
                selector.REGISTER_TERMS_AND_CONDITIONS,
                selector.REGISTER_CAPTCHAT
        );
    }
    public void waitingOnboardingSelectorContentProviderStep1(){
        waitForSelectors(
                selector.ONBOARDING_CONTENT_PROVIDER_COMPANY_NAME,
                selector.ONBOARDING_CONTENT_PROVIDER_WEB_SITE,
                selector.ONBOARDING_CONTENT_PROVIDER_NEXT_BUTTON_STEP_1
        );
    }
    public void waitingOnboardingSelectorContentProviderStep2(){
        waitForSelectors(
                selector.VERIFY_PHONE_SKIP_FOR_NOW
        );
    }
    public void waitingCreateUploadFileSelectorsStep1(){
        waitForSelectors(
                selector.CONTENT_TITLE,
                selector.CONTENT_DESCRIPTION,
                selector.CONTENT_BUTTON_CONTINUE
        );
    }
    public void waitingConfigurationStepSelector() {
        waitForSelectors(
                selector.CONTENT_TAG_ICD_10_TYPE
        );
        //page.waitForSelector(selector.contentConfigurationMarketPlace);
        //page.waitForSelector(selector.contentButtonContinue);
    }
    public void waitingPricingStepSelector(){
        waitForSelectors(
                selector.CONTENT_PRICING_MONTHLY_PRICE,
                selector.CONTENT_BUTTON_CONTINUE
        );
        //page.waitForSelector(selector.contentPricingYearlyPrice);

    }
    public void waitingMatDialogContainer(){
        waitForSelectors(
                selector.MAT_DIALOG_CONTAINER,
                selector.CLASS_MAT_DIALOG_CONTAINER,
                selector.CLASS_MAT_MDC_DIALOG_SURFACE
        );
    }
    public void waitingThumbnailStepSelector(){
        waitForSelectors(
                selector.CONTENT_THUMBNAIL_UNSPLASH,
                selector.CONTENT_THUMBNAIL_UPLOAD_FILE
        );
    }
    public void waitingUnshplashPopUpSelectors (){
        waitForSelectors(
                selector.WAIT_CATEGORY_UNPLASH
        );
        //page.waitForSelector(selector.contentUnsplashSelectButton);
    }
    public void waitingUnsplashPhotos(){
        waitForSelectors(selector.WAITING_UNPLASH);
    }
    // Método auxiliar para esperar varios selectores
    private void waitForSelectors(String... selectors) {
        for (String selector : selectors) {
            page.waitForSelector(selector);
        }
    }
}
