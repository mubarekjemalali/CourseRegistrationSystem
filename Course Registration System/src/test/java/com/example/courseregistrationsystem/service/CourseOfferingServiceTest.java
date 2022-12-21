package com.example.courseregistrationsystem.service;

import com.example.courseregistrationsystem.domain.CourseOffering;
import com.example.courseregistrationsystem.repo.CourseOfferingRepository;
import com.example.courseregistrationsystem.service.dto.CourseOfferingDto;
import com.example.courseregistrationsystem.service.impl.CourseOfferingServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CourseOfferingServiceTest {

//    @TestConfiguration
//    static class CourseOfferingServiceImplTestContextConfiguration {
//        @Bean
//        public CourseOfferingService customerService() {
//            return new CourseOfferingServiceImpl();
//        }
//    }


    @Autowired
    private CourseOfferingService courseOfferingService;

    @MockBean
    private CourseOfferingRepository courseOfferingRepository;

    @Before
    public void setUp() {
        CourseOffering courseOffering = new CourseOffering("CS-544", "24", "24");
        Optional<CourseOffering> courseOfferingOptional = Optional.of(courseOffering);
        Mockito.when(courseOfferingRepository.findById(courseOffering.getId()))
                .thenReturn(courseOfferingOptional);

    }
//    @Test
//    public void whenValidId_thenCourseOfferingShouldBeFound() {
//        String id = "CS-544";
//        CourseOfferingDto found = courseOfferingService.getCourseOffering(id);
//        assertEquals(found.getId(), id);
//
//    }

//    @Test
//    public void whenValidAccountNumber_thenAccountShouldBeFound() {
//        String accountNumber = "123456789";
//        AccountDTO found = accountService.getAccount(accountNumber);
//        assertEquals(found.getAccountNumber(), accountNumber);
//
//    }

    @Test
    public void createCourseOffering() {
    }
}