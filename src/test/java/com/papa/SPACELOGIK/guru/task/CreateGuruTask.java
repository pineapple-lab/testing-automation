package com.papa.SPACELOGIK.guru.task;

import com.papa.SPACELOGIK.guru.data.CreateGuruData;
import com.papa.SPACELOGIK.guru.pom.CreateGuruPO;

import java.util.List;
import java.util.Objects;

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
    public void uploadImage(String pathAsset){
        po.uploadProfileImage(pathAsset);
        po.clickButtonUploadImage();
        po.waitForRemoveImageButton();
    }
    public void acceptSuccessModal(){
        po.clickButtonOkSuccessModal();
    }
    public List<String> getTextModalSuccess(){
        return po.getTextModalSuccess();
    }
    public String getGuruSkill(String email){
        return po.getGuruSkill(email);
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
        if(!Objects.equals(guru.getSkill(), "Assistant")) {
            po.fillInputDescription(guru.getDescription());
        }
    }
    public void fillFormNewGuruStepThree(String pathAsset){
        po.clickButtonOpenModalEditImageProfile();
        uploadImage(pathAsset);
    }
    public void createNewGuru(CreateGuruData guru, String pathAsset){
        goNewGuruForm();
        fillFormNewGuruStepOne(guru);
        po.clickButtonContinueAndSave();
        fillFormNewGuruStepTwo(guru);
        po.clickButtonContinueAndSave();
        if(!Objects.equals(guru.getSkill(),"Assistant")) {
            fillFormNewGuruStepThree(pathAsset);
            po.clickButtonContinueAndSave();
        }
    }
}
