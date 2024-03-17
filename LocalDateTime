package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        //напишите тут ваш код
        HashSet<LocalDateTime> set = new HashSet<LocalDateTime>();
        for (var pair: sourceMap.entrySet()) {
            LocalDate date = pair.getKey();
            List <LocalTime> timeArray = pair.getValue();
            for (LocalTime time: timeArray) {
               LocalDateTime current = LocalDateTime.of(date, time); 
                // System.out.println(date + " " + time);
               set.add(current);
            }
                
        }

        return set;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}
