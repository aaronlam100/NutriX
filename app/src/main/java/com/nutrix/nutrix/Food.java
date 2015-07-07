package com.nutrix.nutrix;

public class Food {

    private int _id;
    private String _foodName;
    private int _calories;

    public Food(String foodName, int calories) {
        _foodName = foodName;
        _calories = calories;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_foodName() {
        return _foodName;
    }

    public void set_foodName(String _foodName) {
        this._foodName = _foodName;
    }

    public int get_calories() {
        return _calories;
    }

    public void set_calories(int _calories) {
        this._calories = _calories;
    }
}
