package com.papa.SPACELOGIK.client.task;

import com.microsoft.playwright.Keyboard;
import com.papa.SPACELOGIK.client.data.ClientData;
import com.papa.SPACELOGIK.client.pom.ClientPO;

import java.lang.foreign.PaddingLayout;

public class ClientTask {
    ClientPO po = new ClientPO();

    public void goCorporateAccountCreateForm(){
        po.clickButtonNewClient();
        po.clickCorporateAccount();
    }
    public void uploadImage(String pathAsset){
        po.clickButtonOpenUploadPhotoModal();
        po.inputImage(pathAsset);
        po.clickSavePhoto();
    }
    public void fillStep1FormCreateCorporateAccount(ClientData client, String pathAsset){
        po.inputCompanyName(client.getCompanyName());
        po.clickSelectIndustry();
        po.clickOptionIndustry(client.getIndustry());
        uploadImage(pathAsset);
    }
    public void fillStep2FormCreateCorporateAccount(ClientData client, String password, String adress){
        po.inputNameClient(client.getName());
        po.inputLnameClient(client.getLastName());
        po.clickSelectSalutation();
        po.clickOptionSalutation(client.getSalutation());
        po.inputTitle(client.getTitle());
        po.inputEmail(client.getEmail());
        po.inputPassword(password);
        po.inputConfirmPassword(password);
        po.inputMobile(client.getMobile());
        po.inputPhone(client.getPhone());
        po.inputAdress(adress);
        po.pressDownArrow();
        po.pressEnter();
    }
    public void createClientDrafSucessfully(ClientData client, String pathAsset, String password, String address){
        goCorporateAccountCreateForm();
        fillStep1FormCreateCorporateAccount(client, pathAsset);
        po.clickButtonContinue();
        fillStep2FormCreateCorporateAccount(client, password, address);
        po.clickButtonContinueAndSave();
        po.clickButtonCreateClient();
    }
}
