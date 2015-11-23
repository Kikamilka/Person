package com.epam.javatraining.person.app;

import com.epam.javatraining.person.NamePersonComparator;
import com.epam.javatraining.person.Person;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) throws CloneNotSupportedException {

        Person[] arrayOfPerson = new Person[5];
        String[] arrayOfNames = {"Alex", "Olga", "Totoshka", "Abc", "Vasya"};
        System.out.println("Input array of persons:");
        for (int i = 0; i < 5; i++) {
            Date date = createDate(i + 2, i + 5, 1980 + (4 * i / 3));
            int passport = 100 + i;
            arrayOfPerson[i] = new Person(arrayOfNames[i], date, passport);
            System.out.println(arrayOfPerson[i].toString());
        }        
        
        System.out.println('\n'+"Sort in age:");
        Arrays.sort(arrayOfPerson);
        for (Person numberPerson : arrayOfPerson) {
            System.out.println(numberPerson.getName() + ". Age = " + numberPerson.calculateAge());
        }

        System.out.println("");
        System.out.println("Sort in name:");
        Arrays.sort(arrayOfPerson, new NamePersonComparator());
        for (Person numberPerson : arrayOfPerson) {
            System.out.println(numberPerson.getName());
        }
    }

    private static Date createDate(int month, int day, int year) {
        checkValueForDate(month, day, year);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

    private static void checkValueForDate(int month, int day, int year) throws IllegalArgumentException {
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("Invalid value of month!");
        }
        if (day > 31 || day < 1) {
            throw new IllegalArgumentException("Invalid value of day!");
        }
        if (year > 2013 || year < 1) {
            throw new IllegalArgumentException("Invalid value of year!");
        }
    }
}
