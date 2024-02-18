package com.wuw.objectMapperTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        // 原始 ArrayList
        List<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("Alice", 30));
        arrayList.add(new Person("Bob", 25));
        arrayList.add(new Person("Charlie", 40));

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(arrayList);
        System.out.println(s);

        ObjectMapper objectMapper1 = new ObjectMapper();
        List<Person> list = Arrays.asList(objectMapper1.readValue(s, Person[].class));
        System.out.println(list);


    }
}