package com.elvis.spacey.www.Springwithamigos.Student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student esther = new Student(
                    "Esther",
                    "esther@gmail.com",
                    LocalDate.of(2000, Month.APRIL, 3)
            );
            Student kofi = new Student(
                    "Kofi",
                    "kofy23@gmail.com",
                    LocalDate.of(1998, Month.FEBRUARY, 10)
            );


            studentRepository.saveAll(
                    List.of(esther,kofi)
            );
        };
    }
}
