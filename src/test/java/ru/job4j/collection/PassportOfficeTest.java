package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void doubleAdd() {
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen3 = new Citizen("2f44a34", "Alex Golovin");
        Citizen citizen4 = new Citizen("2f44a34", "Alex Golovin");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        office.add(citizen3);
        assertFalse(office.add(citizen2));
        assertFalse(office.add(citizen4));
    }
}