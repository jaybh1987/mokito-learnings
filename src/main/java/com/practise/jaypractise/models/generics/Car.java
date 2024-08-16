package com.practise.jaypractise.models.generics;

import java.util.List;

public class Car <T, U>{

    T obj1;
    U obj2;
    List<T> list;

    Car(T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }



}
