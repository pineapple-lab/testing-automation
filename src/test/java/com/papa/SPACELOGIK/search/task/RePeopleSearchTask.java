package com.papa.SPACELOGIK.search.task;

import com.papa.SPACELOGIK.search.pom.SearchPO;

public class RePeopleSearchTask {
    SearchPO po = new SearchPO();

    public void searchCreateGuru(String text){
        po.inputSearch(text);
        po.hoverInputSearch();
    }
}
