package com.example.courseregistrationsystem;

import com.example.courseregistrationsystem.domain.Address;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseRegistrationSystemApplication  {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(CourseRegistrationSystemApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Address address = new Address("1000 N 4th st","Fairfield" , "IA",  "10001","USA");
//
//    }
}
