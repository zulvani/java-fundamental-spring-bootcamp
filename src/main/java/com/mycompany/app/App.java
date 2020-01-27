package com.mycompany.app;

import java.awt.*;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final String APP_VERSION = "1.0.1";


    public App() throws InvalidInputException {
        Person danang = new Person("Danang", "Prakoso");
        Person budi = new Person("Budi", "Setiawan");

        danang.showAppVersion();
        danang.showFullName();

        budi.showAppVersion();
        budi.showFullName();

        Student dandi = new Student("Dandi", "Kurniawan", "ST");
        System.out.println(dandi.getFullName());
    }




    public static void main(String[] args ) {
        try {
            new App();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }


    }
}
