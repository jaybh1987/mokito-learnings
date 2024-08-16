package com.practise.jaypractise.models.mokitoBook.austroinspace;

import java.util.List;

public class AstroResponse {

    private final int number;
    private final String message;
    private final List<Assignment> people;

    public AstroResponse(int number, String message, List<Assignment> people) {
        this.number = number;
        this.message = message;
        this.people = people;
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }

    public List<Assignment> getPeople() {
        return people;
    }
}
