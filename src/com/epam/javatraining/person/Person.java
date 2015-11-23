package com.epam.javatraining.person;

import java.util.*;

public class Person implements Cloneable, Comparable<Person> {

    private final String name;
    private final Date birthday;
    private final int passport;

    public Person(String name, Date birthday, int passport) {
        this.name = name;
        this.birthday = birthday;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getPassport() {
        return passport;
    }    

    public int calculateAge() {
        Calendar dateBirthday = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        dateBirthday.setTime(this.birthday);
        dateBirthday.add(Calendar.DAY_OF_MONTH, -1);
        int age = today.get(Calendar.YEAR) - dateBirthday.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) <= dateBirthday.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;        
    }

    @Override
    public int compareTo(Person secondPerson) {
        if (this.equals(secondPerson)) {
            return 0;
        }
        int comparableValue = this.calculateAge() - secondPerson.calculateAge();
        if (comparableValue == 0) {
            comparableValue = this.passport - secondPerson.passport;
        }
        return (int) comparableValue / Math.abs(comparableValue);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        return this.passport == other.passport;
    }

    @Override
    public String toString() {
        return "Name=" + name + ", birthday=" + birthday + ", passport=" + passport;
    }
}
