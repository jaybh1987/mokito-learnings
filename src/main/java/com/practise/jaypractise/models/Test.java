package com.practise.jaypractise.models;

public class Test<T> {
    public T obj;

    public Test(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        return this.obj;
    }
}
