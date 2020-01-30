package com.mycompany.myapp.service;

import com.mycompany.app.Person;
import com.mycompany.app.Student;

import java.util.List;

public class RegistrationImpl implements RegistrationService, PersonService {
    @Override
    public void register(Student student) {
        System.out.println("Invoke register method from RegistrationImpl");
    }

    @Override
    public List<Student> getRegisteredStudents() {
        System.out.println("Invoke getRegisteredStudents method from RegistrationImpl");
        return null;
    }

    @Override
    public List<Person> getPersonByFirstName() {
        System.out.println("Invoke getPersonByFirstName method from RegistrationImpl");
        return null;
    }
}
