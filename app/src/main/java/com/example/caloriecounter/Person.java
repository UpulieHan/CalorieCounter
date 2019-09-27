package com.example.caloriecounter;

public class Person {
    String Name;
    int personID;
    int age;
    String gender;
    float weight;
    float dailyWaterIntake;
    float dailyCalorieIntake;
    int sleepTime;
    int wakeupTime;

    public Person() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getDailyWaterIntake() {
        return dailyWaterIntake;
    }

    public void setDailyWaterIntake(float dailyWaterIntake) {
        this.dailyWaterIntake = dailyWaterIntake;
    }

    public float getDailyCalorieIntake() {
        return dailyCalorieIntake;
    }

    public void setDailyCalorieIntake(float dailyCalorieIntake) {
        this.dailyCalorieIntake = dailyCalorieIntake;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public int getWakeupTime() {
        return wakeupTime;
    }

    public void setWakeupTime(int wakeupTime) {
        this.wakeupTime = wakeupTime;
    }
}
