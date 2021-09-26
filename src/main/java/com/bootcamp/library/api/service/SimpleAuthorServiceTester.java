package com.bootcamp.library.api.service;

import com.bootcamp.library.api.dto.SimpleAuthorDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** This is service test driver
 *
 * @author claudio
 * @see SimpleAuthorService
 * create on 2021/09/26
 */
public class SimpleAuthorServiceTester {
    public static void main(String[] args) {
        SimpleAuthorService simpleAuthorService = SimpleAuthorService.getInstance();

        simpleAuthorService.addAuthor(
            new SimpleAuthorDTO(
                "Dale Carnegie",
                "dale_carnegie@gmail.com",
                LocalDate.parse("11/24/1988", DateTimeFormatter.ofPattern("MM/dd/yyyy"))
            )
        );

        simpleAuthorService.addAuthor(
            new SimpleAuthorDTO(
                "Cal Newport",
                "calnewport@gmail.com",
                LocalDate.parse("1982/06/23", DateTimeFormatter.ofPattern("yyyy/MM/dd"))
            )
        );

        simpleAuthorService.getAll().forEach(System.out::println);

        System.out.println(simpleAuthorService.getAuthor("calnewport@gmail.com"));
    }
}
