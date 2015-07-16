package com.nutrix.nutrix;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;

/**
 * Created by Brian on 7/6/2015.
 */
public class User implements Serializable {
    private String name, username, password;
    private int age, weight, height;
    private int physAct;


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

}
