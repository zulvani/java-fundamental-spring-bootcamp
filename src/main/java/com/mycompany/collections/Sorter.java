package com.mycompany.collections;

import com.mycompany.app.Person;

import java.util.Comparator;

public class Sorter implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int cf = o1.getFirstName().compareTo(o2.getFirstName());
        if (cf == 0){
            return o2.getLastName().compareTo(o1.getLastName());
        }
        return cf;
    }
}
