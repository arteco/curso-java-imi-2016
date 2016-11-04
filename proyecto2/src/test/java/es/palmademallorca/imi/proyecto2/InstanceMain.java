package es.palmademallorca.imi.proyecto2;

import es.palmademallorca.imi.proyecto2.dto.PersonDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Arteco Consulting Sl.
 * Author rarnau on 4/11/16.
 */
public class InstanceMain {
    public static void main(String[] args) {
        List<PersonDto> persons = new ArrayList<>();

        persons.add(new PersonDto(1l, "Ramón", "Arnau"));

        PersonDto newperson = new PersonDto(1l, "Ramón", "Arnau");

        System.out.println(persons.contains(newperson));

        persons.remove(newperson);

        System.out.println(persons.size());

        // -----

        persons = new ArrayList<>();
        persons.add(newperson);

        newperson.setSurname("Arrecio");
        persons.get(0).setName("José");

        System.out.println("newperson=" + newperson + "\n persons=" + persons);
    }
}
