package com.example.courseregistrationsystem;

import com.example.courseregistrationsystem.domain.Address;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableScheduling
@EnableJms
public class CourseRegistrationSystemApplication  {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    // create a bean for jms template
//    @Bean
//    JmsTemplate jmsTemplate() {
//        return new JmsTemplate();
//    }


    public static void main(String[] args) {
        SpringApplication.run(CourseRegistrationSystemApplication.class, args);
    }


}
