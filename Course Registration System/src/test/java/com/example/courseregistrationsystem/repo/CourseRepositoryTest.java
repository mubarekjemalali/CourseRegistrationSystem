package com.example.courseregistrationsystem.repo;

import com.example.courseregistrationsystem.domain.Course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void whenFindById_thenReturnCourse() {
        // given

        Course course = new Course("CS-544", "Enterprise Architecture", "this course is Enterprise Architecture");
        entityManager.persist(course);
        entityManager.flush();

        // when
        Course found = courseRepository.findById(course.getId()).orElse(null);

        // then
        assert found != null;
        assertEquals(found.getCourseName(), course.getCourseName());
    }
}