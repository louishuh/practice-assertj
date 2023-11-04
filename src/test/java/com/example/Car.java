package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Car {
    private String name;
    private List<Person> passenger;
}
