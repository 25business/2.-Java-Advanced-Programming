package com.example;

import java.util.ArrayList;

public class Person {
    private String first_name;
    private String last_name;
    private int age;
    private boolean is_developer;
    private ArrayList<String> hobbies;
    private Address address;

    public Person() {}

    public Person(String first_name, String last_name, int age, boolean is_developer) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.is_developer = is_developer;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isIs_developer() {
        return is_developer;
    }

    public void setIs_developer(boolean is_developer) {
        this.is_developer = is_developer;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
        String hobbies_string = "";
        for(String hobbie : hobbies) {
            hobbies_string += hobbie + ", ";
        }

        return String.format("""
                First name: %s
                Last name: %s
                Age: %d
                Is developer? %b
                Hobbies: %s
                Address: %s %d
                """, first_name, last_name, age, is_developer,
                hobbies_string, address.street, address.street_no);
    }
}
