package com.pap.SPACELOGIK.createGuru.data;
import lombok.Builder;
import lombok.Getter;
@Getter
@Builder(toBuilder = true)
public class CreateGuruData {
    private String title;
    private String name;
    private String salutation;
    private String lastName;
    private String email;
    private String mobile;
    private String phone;
    private int office;
    private String skill;
    private String description;
    private String pathAsset;
    String titleSuccessModal = "The Guru has been created successfully";
    String boddySuccessModal = "The Guru will receive an email at null to set their password and begin using SpaceLogik.";
}
