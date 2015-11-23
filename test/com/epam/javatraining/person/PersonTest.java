package com.epam.javatraining.person;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    
    @Test
    public void testGetName() {
        System.out.println("getName");
        Person somebody = new Person("Alex", createDate(3, 15, 1993), 156);
        assertEquals("Alex", somebody.getName());
        somebody = new Person("Murzik Kot", createDate(3, 15, 1990), 157);
        assertEquals("Murzik Kot", somebody.getName());
    }

    @Test
    public void testGetBirthday() {
        System.out.println("getBirthday");
        Person somebody = new Person("Alex", createDate(3, 15, 1993), 156);
        assertEquals(createDate(3, 15, 1993).toString(), somebody.getBirthday().toString());
        somebody = new Person("Murzik Kot", createDate(1, 10, 1990), 157);
        assertEquals(createDate(1, 10, 1990).toString(), somebody.getBirthday().toString());
    }

    @Test
    public void testGetPassport() {
        System.out.println("getPassport");
        Person somebody = new Person("Alex", createDate(3, 15, 1993), 156);
        assertEquals(156, somebody.getPassport());
    }    

    @Test
    public void testCalculateAge() {
        System.out.println("calculateAge");
        Person somebody = new Person("Alexx", createDate(3, 15, 1993), 156);
        assertEquals(22, somebody.calculateAge());
        somebody = new Person("Alex", createDate(12, 15, 1993), 156);
        assertEquals(21, somebody.calculateAge());
    }

    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Person somebody = new Person("Alex", createDate(3, 15, 1993), 156);
        Person somebodySecond = new Person("Murzik Kot", createDate(3, 15, 1990), 157);
        int result = somebody.compareTo(somebodySecond);
        assertEquals(-1, result);
        
        somebody = new Person("Alexey", createDate(3, 15, 1983), 156);
        somebodySecond = new Person("Murzik Kot", createDate(3, 15, 1990), 157);
        result = somebody.compareTo(somebodySecond);
        assertEquals(1, result);
    }
    
    private static Date createDate(int month, int day, int year) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }
}
