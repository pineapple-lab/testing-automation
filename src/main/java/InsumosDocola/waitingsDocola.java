package InsumosDocola;

public class waitingsDocola extends contextBaseDocola{

    public void waitingJoinsSelectorStep1(int rol){
        page.waitForSelector("app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > app-form-block-input:nth-of-type(1) mat-form-field input");
        page.waitForSelector("app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > app-form-block-input:nth-of-type(2) mat-form-field input");
        page.waitForSelector("app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > app-form-block-input mat-form-field input");
        page.waitForSelector("app-register mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(3) > mat-card:nth-of-type("+rol+")");
        page.waitForSelector("mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > button");
    }
    public void waitingJoinSelectorStep2(){
        page.waitForSelector("mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > app-form-block-input:nth-of-type(1) input");
        page.waitForSelector("mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(2) > app-form-block-input:nth-of-type(2) input");
    }
    public void waitingJoinSelectorStep3(){
        page.waitForSelector("mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) mat-checkbox input");
        page.waitForSelector("mat-stepper > div > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div:nth-of-type(2) re-captcha > div > div > iframe");
    }
    public void waitingOnboardingSelectorContentProviderStep1(){
        page.waitForSelector(".registration-type-padding app-form-block-input:nth-of-type(1) input");
        page.waitForSelector(".registration-type-padding app-form-block-input:nth-of-type(2) input");
        page.waitForSelector(".registration-type-padding button");
    }
    public void waitingOnboardingSelectorContentProviderStep2(){
        page.waitForSelector(".registration-type-padding > div > div:nth-of-type(2) > div:nth-of-type(2) > span");
    }
}
