package com.practise.jaypractise.models.mokitoBook.chapter2.person_project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

// Extra note:
/*
* When use annotation tell the mockito to process them.
* Extention initilize mocks and as a side note "handles strict stubbings"
* that means your tests you can mock only mehtods that your methods under test actually calls.
* */

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    // person repository is the dependency of the class
    // @Mock to mock the person repository [dependency]
    @Mock
    private PersonRepository personRepository;

    // person service is the class under the test.
    // @InjectMocks should be done for the class under the test.
    // so here class under the test is PersonService class.
    @InjectMocks
    private PersonService personService;

    //expected list.
    private final List<Person> people = Arrays.asList(
        new Person(1, "jay","bh",  LocalDate.of(2000, 01, 11)),
        new Person(2, "Ashish","ch",  LocalDate.of(2000, 02, 13)),
        new Person(3, "Thanga","kh",  LocalDate.of(2000, 03, 15)),
        new Person(4, "Bhashit","dh",  LocalDate.of(2000, 04, 17))
    );

    //just added if i replace with expected list with this variable then test cases starts to fail.
    private final List<Person> people_two = Arrays.asList(
            new Person(1, "ja","dkd",  LocalDate.of(2000, 01, 11)),
            new Person(2, "Ash","dke",  LocalDate.of(2000, 02, 13)),
            new Person(3, "Tha","uei",  LocalDate.of(2000, 03, 15)),
            new Person(4, "bha","ipo",  LocalDate.of(2000, 04, 17))
    );

    @Test
    public void getLastNames_usingAnnotations() {

        when(personRepository.findAll()).thenReturn(people); // this is called setting expectation on findall method .
        List<String> l =  people.stream().map(Person::getLast).toList();
        assertEquals(personService.getLastNames(), l);
        verify(personRepository).findAll();
    }


    @Test
    void findByIds_thenReturnWithMultipleArgs() {
        when(personRepository.findById(anyInt())).thenReturn(       //anyInt is argument matcher rather then giving possible integer value better to use anyint.
                Optional.of(people.get(0)),
                Optional.of(people.get(1)),
                Optional.of(people.get(2)),
                Optional.of(people.get(3)),
                Optional.empty()
        );

        List<Person> personList = personService.findByIds(0, 1, 2, 3);

        assertEquals(personList, people);
    }

    //setting expectation on void method.
    @Test
    public void deleteAllWithNulls() {
        //set up findall to return a list containing nulls of type person
        when(personRepository.findAll()).thenReturn(Collections.singletonList((Person) null));
        doThrow(RuntimeException.class).when(personRepository).delete(null);
        assertThrows(RuntimeException.class, () -> personService.deleteAll());
        verify(personRepository).delete(null);
    }


    @Test
    public void findByIdThatDoesNotExist() {

        //set expectations
        when(personRepository.findById(anyInt()))
                .thenReturn(Optional.empty());

        //call method under the test.
        List<Person> personList = personService.findByIds(999);

        //check  the results from method under the test.
        assertTrue(personList.isEmpty());


        //verify stub method has been called.
        verify(personRepository).findById(anyInt());
    }



}