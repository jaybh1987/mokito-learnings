package com.practise.jaypractise.models.learnmokito;

import java.util.Optional;

public class HelloMockito {

    private String greeting = "hello, %s, from mockito!";


    //Dependencies
    private final PersonRepository personRepository;
    private final TranslationService translationService;

    public HelloMockito(PersonRepository personRepository, TranslationService translationService) {
        this.personRepository = personRepository;
        this.translationService = translationService;
    }

//    public String greet(String name) {
//        return String.format(greeting, name);
//    }

    public String greet(int id, String sourceLang, String targetLang) {
        Optional<Person> person = personRepository.findById(id);
        String name = person.map(Person::getFirst).orElse("World");

        return translationService.translate(
                String.format(greeting, name), sourceLang, targetLang
        );
    }
}
