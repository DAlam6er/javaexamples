package com.specialist.bodrov.oop.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalExample {

    public static void main(String[]args) {
        System.out.println("Current Locale: " + Locale.getDefault());
        ResourceBundle mybundle = ResourceBundle.getBundle("MyLabels");

//        Locale.setDefault(new Locale("ru", "RU"));

        System.out.println("Say how are you in Russian: " + mybundle.getString("how_are_you"));

        Locale.setDefault(Locale.US);

        System.out.println("Current Locale: " + Locale.getDefault());
        mybundle = ResourceBundle.getBundle("MyLabels");
        System.out.println("Say how are you in English: " + mybundle.getString("how_are_you"));
    }

}