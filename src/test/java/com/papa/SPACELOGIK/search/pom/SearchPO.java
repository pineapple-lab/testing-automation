package com.papa.SPACELOGIK.search.pom;

import com.papa.core.action.ElementActions;

public class SearchPO {
    ElementActions action = new ElementActions();
    private static final String INPUT_SEARCH_PEOPLE_TABLE = "[placeholder='Search']";
    private static final String DELETE_INPUT_SEARCH_PEOPLE_TABLE = ".lucide-x";

    public void inputSearch(String text){
        action.type(INPUT_SEARCH_PEOPLE_TABLE, text);
    }
    public void hoverInputSearch(){
        action.hover(INPUT_SEARCH_PEOPLE_TABLE);
    }
    public void clickDeleteInputSearch(){
        action.click(DELETE_INPUT_SEARCH_PEOPLE_TABLE);
    }
}
