package com.mycompany.collections;

import java.util.*;

public class HashMapTest {

    public HashMapTest() {

        Map<String, Integer> grades = new HashMap<>();

        grades.put("Jaja", 100);
        grades.put("Lukas", 90);
        grades.put("Sinta", 75);
        grades.put("Dede", 95);

        Integer val = grades.get("Jaja");

        // return true if exist, false otherwise
        grades.containsKey("Jaja");
        grades.containsValue(50);

        grades.remove("Jaja");
        grades.remove("Jaja", 100);

        Map<String, Integer> g = new HashMap<>();
        g.put("Jaja", 100);
        g.put("Dede", 100);
        grades.remove(g);
        grades.clear();

        for(String key : grades.keySet()){
            System.out.printf("%s : %s \n", key, grades.get(key));
        }

        for(Map.Entry<String, Integer> entry : grades.entrySet()){
            System.out.printf("%s : %s \n", entry.getKey(), entry.getValue());
        }

    }

    public static void main(String[] args){
        new HashMapTest();
    }
}
