package com.example.courseregistrationsystem.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.courseregistrationsystem.service.FacultyService;
import com.example.courseregistrationsystem.service.dto.AddressDto;
import com.example.courseregistrationsystem.service.dto.FacultyDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FacultyController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FacultyControllerTest {
    @Autowired
    private FacultyController facultyController;

    @MockBean
    private FacultyService facultyService;

    /**
     * Method under test: {@link FacultyController#getFacultyById(long)}
     */
    @Test
    public void testGetFacultyById() throws Exception {
        when(facultyService.getFacultyById(anyLong())).thenReturn(new FacultyDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/faculties/{id}", 123L);
        MockMvcBuilders.standaloneSetup(facultyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":null,\"firstName\":null,\"lastName\":null,\"email\":null,\"title\":null,\"addressDto\":null}"));
    }

    /**
     * Method under test: {@link FacultyController#getFacultyById(long)}
     */
    @Test
    public void testGetFacultyById2() throws Exception {
        when(facultyService.getAllFaculties()).thenReturn(new ArrayList<>());
        when(facultyService.getFacultyById(anyLong())).thenReturn(new FacultyDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/faculties/{id}", "", "Uri Variables");
        MockMvcBuilders.standaloneSetup(facultyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FacultyController#getAllFaculties()}
     */
    @Test
    public void testGetAllFaculties() throws Exception {
        when(facultyService.getAllFaculties()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/faculties");
        MockMvcBuilders.standaloneSetup(facultyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FacultyController#getAllFaculties()}
     */
    @Test
    public void testGetAllFaculties2() throws Exception {
        when(facultyService.getAllFaculties()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/faculties");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(facultyController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FacultyController#createFaculty(FacultyDto)}
     */
    @Test
    public void testCreateFaculty() throws Exception {
        when(facultyService.addFaculty((FacultyDto) any())).thenReturn(new FacultyDto());

        FacultyDto facultyDto = new FacultyDto();
        facultyDto.setAddressDto(new AddressDto());
        facultyDto.setEmail("jane.doe@example.org");
        facultyDto.setFirstName("Jane");
        facultyDto.setId(123L);
        facultyDto.setLastName("Doe");
        facultyDto.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(facultyDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/faculties")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(facultyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":null,\"firstName\":null,\"lastName\":null,\"email\":null,\"title\":null,\"addressDto\":null}"));
    }

    /**
     * Method under test: {@link FacultyController#deleteFaculty(long)}
     */
    @Test
    public void testDeleteFaculty() throws Exception {
        doNothing().when(facultyService).deleteFaculty(anyLong());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/faculties/{id}", 123L);
        MockMvcBuilders.standaloneSetup(facultyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Faculty deleted successfully"));
    }

    /**
     * Method under test: {@link FacultyController#deleteFaculty(long)}
     */
    @Test
    public void testDeleteFaculty2() throws Exception {
        doNothing().when(facultyService).deleteFaculty(anyLong());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/faculties/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(facultyController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Faculty deleted successfully"));
    }
}

