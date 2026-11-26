package com.papa.SPACELOGIK.client.task;

import com.papa.SPACELOGIK.client.data.ClientData;
import com.papa.SPACELOGIK.client.pom.ClientPO;

public class ClientTask {
    ClientPO po = new ClientPO();

    public void goCorporateAccountCreateForm(){
        po.clickButtonNewClient();
        po.clickCorporateAccount();
    }
    public void completeStep1FormCreateCorporateAccount(ClientData client){
        po.inputCompanyName(client.getCompanyName());
        po.clickSelectIndustry();
        po.clickOptionIndustry(client.getIndustry());
    }
}
