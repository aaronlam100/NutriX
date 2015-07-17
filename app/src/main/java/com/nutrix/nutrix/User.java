package com.nutrix.nutrix;

import java.io.Serializable;

/**
 * Created by Brian on 7/6/2015.
 */
public class User implements Serializable {
    private final double POUNDS_TO_KG = 0.453592;
    private final double INCHES_TO_CM = 2.54;
    private String name, username, password, sex;
    private int age, weight, height, physAct;



    public User(String name, String username, String password, String age, String weight, String height) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = Integer.parseInt(age);
        this.weight = Integer.parseInt(weight);
        this.height = Integer.parseInt(height);
    }

    public User(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getSex(){
        return this.sex;
    }

    public void setPhysAct(int physAct){
        this.physAct = physAct;
    }

    public int getPhysAct(){
        return this.physAct;
    }

    public double getReqCalories(){
        double bmr;
        if(sex.equals("Male")){
            bmr = 88.362 + (13.397 * weight * POUNDS_TO_KG) + (4.799 * height * INCHES_TO_CM) - (5.677 * age);
        }
        else{
            bmr = 447.593 + (9.247 * weight * POUNDS_TO_KG) + (3.098 * height * INCHES_TO_CM) - (4.330 * age);
        }

        double reqCal = -1;
        switch(physAct){
            case 1:
                reqCal = bmr * 1.2;
                break;
            case 2:
                reqCal = bmr * 1.375;
                break;
            case 3:
                reqCal = bmr * 1.55;
                break;
            case 4:
                reqCal = bmr * 1.725;
                break;
            case 5:
                reqCal = bmr * 1.9;
                break;
        }
        return reqCal;
    }

}
