package com.mycompany.collections;

import java.util.*;

public class HashSetTest {

    public HashSetTest() {

        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("Java");
        set.add(null);
        set.add("Golang");

        Set<String> setNew = new HashSet<>();
        setNew.add("Javascript");
        setNew.add("VBScript");
        set.addAll(setNew);

        for(String s : set){
            System.out.println(s);
        }

        // return true if the removed element exists
        set.remove("Golang");

        Set<String> removes = new HashSet<>();
        removes.add("Javaa");
        removes.add(null);
        set.removeAll(removes);

        set.clear();

        System.out.println(set.isEmpty());

        Iterator itr = set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println(set.contains(null)); // return true or false

        // check contain in collections
        // if one element in collections does not exists
        // it will return false
        Set<String> contains = new HashSet<>();
        contains.add("Javaa");
        contains.add(null);
        System.out.println(set.containsAll(contains));

    }

    public static void main(String[] args){
        new HashSetTest();
    }
}
