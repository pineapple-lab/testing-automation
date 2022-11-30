package testEnConstruccionPeppermint;

import insumosPeppermint.robotBasePeppermint;

public class funcionLogin extends robotBasePeppermint {


    public void login(){
        page.click(".bg-primary-contrast > div:nth-of-type(3) button:nth-of-type(1)");
        page.fill(".bg-primary-contrast form > .mat-card-content #mat-input-9", emailLogin);
        page.fill(".bg-primary-contrast form > .mat-card-content #mat-input-10", passwordLogin);
        page.click(".bg-primary-contrast form > div:nth-of-type(3) button");
    }
}
