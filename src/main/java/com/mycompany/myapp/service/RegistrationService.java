package com.mycompany.myapp.service;

import com.mycompany.app.Student;

import java.util.ArrayList;
import java.util.List;

public interface RegistrationService {

    /**
     * every class which implement this interface
     * must implement this method
     */
    void register(Student student);

    /**
     * we does not need to override or implement this method
     * but we can if we want
     */
    default List<Student> getRegisteredStudents(){
        System.out.println("Invoke getRegisteredStudents method from RegistrationService");
        return new ArrayList<>();
    }

    /**
     * we can not override this method
     */
    static void cancel(){
        System.out.println("Invoke cancel method from RegistrationService");
    }
}
