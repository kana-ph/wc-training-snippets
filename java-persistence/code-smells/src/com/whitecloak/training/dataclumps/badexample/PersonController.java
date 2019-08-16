package com.whitecloak.training.dataclumps.badexample;

import java.util.List;

public class PersonController {

    private List<String> personNames;
    private List<String> personStatus;
    private List<Boolean> personEnabled;


    public printPersonInfo(int index) {
        System.out.println("Name: " + personNames.get(index) + ", status: " + personStatus.get(index));
    }
}
