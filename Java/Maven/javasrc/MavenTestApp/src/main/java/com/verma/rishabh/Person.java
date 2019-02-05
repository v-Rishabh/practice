package com.verma.rishabh;

class Person{
    private String firstName;
    private String secondName;
    Person(String firstName, String secondName){
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFullName(){
        String fullName = firstName +" "+ secondName;
        return fullName;
    }
}