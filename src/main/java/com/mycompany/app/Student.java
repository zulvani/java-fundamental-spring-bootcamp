package com.mycompany.app;

public class Student extends Person {

    private String nis;
    private String title;
    private int level;

    public int getLevel() {
        return level;
    }

    public void learn(String courseName){
        if(courseName == null){
            return;
        }

        level++;
    }

    public void learn(String courseName, int sks){
        if(courseName == null){
            return;
        }

        level += sks;
    }

    @Override
    public String getFullName() {
        return super.getFullName() + " " + title;
    }

    public Student(String firstName, String lastName, String title) {
        super(firstName, lastName);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }


}
