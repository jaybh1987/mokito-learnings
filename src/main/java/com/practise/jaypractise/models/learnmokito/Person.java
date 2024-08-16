package com.practise.jaypractise.models.learnmokito;

public class Person {
    private int id;
    private String fname ;
    private String lname ;

    public Person(int id, String fname, String lname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }

    public String getFirst() {
            return this.fname;
    }
}
