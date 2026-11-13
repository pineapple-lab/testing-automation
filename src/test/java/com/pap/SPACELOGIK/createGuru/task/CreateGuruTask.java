package com.pap.SPACELOGIK.createGuru.task;

import com.pap.SPACELOGIK.createGuru.data.CreateGuruData;
import com.pap.SPACELOGIK.createGuru.pom.CreateGuruPO;

public class CreateGuruTask {
    CreateGuruPO po = new CreateGuruPO();
    public void goNewGuruForm(){
        po.clickButtonNewGuru();
    }
    public void completeSalutationSelect(String salutation){
        po.clickSelectSalutation();
        po.clickOptionSalutation(salutation);
    }
    public void completeOfficeSelect(int office){
        po.clickSelectOffice();
        po.clickOptionOffice(office);
    }
    public void completeSkillSelect(String skill){
        po.clickSelectSkill();
        po.clickOptionSkill(skill);
    }
    public void fillFormNewGuruStepOne(CreateGuruData guru){
        completeSalutationSelect(guru.getSalutation());
        po.fillInputTitle(guru.getTitle());
        po.filLInputName(guru.getName());
        po.fillInputLName(guru.getLastName());
        po.fillInputEmail(guru.getEmail());
        po.fillInputMobile(guru.getMobile());
        po.fillInputPhone(guru.getPhone());
    }
    public void fillFormNewGuruStepTwo(CreateGuruData guru){
     completeOfficeSelect(guru.getOffice());
     completeSkillSelect(guru.getSkill());
     po.fillInputDescription(guru.getDescription());
    }

    public void fillFormNewGuruStepThree(CreateGuruData guru){
        po.clickButtonOpenModalEditImageProfile();
        uploadImage(guru.getPathAsset());
    }
    public void uploadImage(String pathAsset){
        po.uploadProfileImage(pathAsset);
        po.clickButtonUploadImage();
    }
    public void acceptSuccessModal(){
        po.clickButtonOkSuccessModal();
    }
    public void createNewGuru(CreateGuruData guru){
        goNewGuruForm();
        fillFormNewGuruStepOne(guru);
        po.clickButtonContinueAndSave();
        fillFormNewGuruStepTwo(guru);
        po.clickButtonContinueAndSave();
        fillFormNewGuruStepThree(guru);
        po.clickButtonContinueAndSave();
        acceptSuccessModal();
    }
}
