package com.example.spring.designPattern.method.VisitorPatten;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-08-11:14
 */
public class ObjectStructure {
    private List<Person> persons = new LinkedList<>();
    public void attach(Person person) {
        persons.add(person);
    }

    public void detach(Person person){
        persons.remove(person);
    }

    public void show(Action action){
        persons.forEach(e->{
            e.accept(action);
        });
    }
}
