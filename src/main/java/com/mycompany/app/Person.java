package com.mycompany.app;

public class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public void showAppVersion(){
        System.out.println(App.APP_VERSION);
    }

    public void showFullName(){
        System.out.println(this.firstName + " " + this.lastName);
    }

    public Person() {
    }

    private double weight;
    private double height;
    private double bmi;
    private String bmiDescription;

    public void eat(String foodName) throws InvalidInputException{
        if(foodName == null){
            throw new InvalidInputException("Please input the footname");
        }

        if(foodName.length() > 20){
            throw new InvalidInputException("Food name too long");
        }
    }

    public void drink(String drinkName) throws EmptyException{
        if(drinkName == null || (drinkName != null && drinkName.isEmpty())){
            throw new EmptyException("Please fill the drink name");
        }
    }

    private void calculateBmi(){
        if(this.weight <= 0.0 || this.height <= 0.0){
            return;
        }

        this.bmi = this.weight / this.height;
        if(this.bmi < 18.5){
            this.bmiDescription = "Berat badan kurang";
        }
        else if(this.bmi >= 18.5 && this.bmi <= 22.9){
            this.bmiDescription = "Berat badan normal";
        }
        else if(this.bmi >= 23 && this.bmi <= 29.9){
            this.bmiDescription = "Berat badan berlebih (kecenderungan obesitas)";
        }
        else if(this.bmi >= 30){
            this.bmiDescription = "Obesitas";
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public String getBmiDescription() {
        return bmiDescription;
    }
}
