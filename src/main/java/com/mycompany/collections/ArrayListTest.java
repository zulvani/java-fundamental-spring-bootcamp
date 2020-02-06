package com.mycompany.collections;

import com.mycompany.app.Person;
import sun.tools.jconsole.inspector.IconManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

    public ArrayListTest() {

        List<String> list = new ArrayList<>();

        list.add("RabbitMQ");
        list.add("Kafka");
        list.add(0, "ActiveMQ");

        List<String> newList = new ArrayList<>();
        newList.add("Java");
        newList.add("Golang");

        list.addAll(newList);

        list.add(0, "Java");

//        list.remove(1);
//        list.remove("Java");
//        list.removeAll(newList);

        for(String s : list){
            System.out.printf("%s \n", s);
        }

        System.out.println("------------------");
        List<String> copy = list;
        copy.remove("Java");
        copy.add("Python");
        for(String s : copy){
            System.out.printf("%s \n", s);
        }

//        Collections.sort(list);
//        Collections.sort(list, Collections.reverseOrder());
//
//        System.out.println("Sorting");
//        Iterator it = list.iterator();
//        while(it.hasNext()){
//            System.out.printf("%s \n", it.next());
//        }

//        System.out.println(list.indexOf("Java"));
//        System.out.println(list.lastIndexOf("Java"));
//        int index = Collections.binarySearch(list, "Java");
////
//        List<Person> personList = new ArrayList<>();
//        personList.add(new Person("Mattew", "Bush"));
//        personList.add(new Person("Justin", "Graham"));
//        personList.add(new Person("Glenn", "Tyler"));
//        personList.add(new Person("Jarrod", "Mc"));
//        personList.add(new Person("Mattew", "Cachil"));
//
//        Person person = new Person("Jarrod", "Mc");
//        personList.remove(person);
//
//        Collections.sort(personList, new Sorter());
//
//        for(Person p : personList){
//            System.out.printf("%s \n", p.getFullName());
//        }
    }

    public static void main(String[] args){
        new ArrayListTest();
    }
}
