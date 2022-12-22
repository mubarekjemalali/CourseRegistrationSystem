package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.*;
import com.example.courseregistrationsystem.repo.RegistrationGroupRepository;
import com.example.courseregistrationsystem.repo.RegistrationRepository;
import com.example.courseregistrationsystem.service.dto.AcademicBlockDto;
import com.example.courseregistrationsystem.service.dto.RegistrationEventDto;
import com.example.courseregistrationsystem.repo.RegistrationEventRepository;
import com.example.courseregistrationsystem.service.RegistrationEventService;
import com.example.courseregistrationsystem.service.dto.RegistrationEventWOStudentList;
import com.example.courseregistrationsystem.service.dto.RegistrationRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


@Service
public class RegistrationEventServiceImpl implements RegistrationEventService {
    @Autowired
    private RegistrationEventRepository registrationEventRepository;
//    @Autowired
//    private StudentRepository studentRepository;
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private RegistrationGroupRepository registrationGroupRepository;


    @Autowired
    ModelMapper modelMapper;


    // add registration events
    @Override
    public RegistrationEventDto createRegistrationEvent(RegistrationEventDto registrationEventDto) {

        RegistrationEvent registrationEvent = registrationEventRepository.save(modelMapper.map(registrationEventDto, RegistrationEvent.class));
        return modelMapper.map(registrationEvent, RegistrationEventDto.class);
    }


    //     get all registration events
    @Override
    public List<RegistrationEventDto> getAllRegistrationEvents() {
        List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
        List<RegistrationEventDto> registrationEventDtos =
                registrationEvents.stream().map(registrationEvent -> modelMapper.map(registrationEvent, RegistrationEventDto.class)).toList();
        return registrationEventDtos;

    }


    // update registration event
    @Override
    public RegistrationEventDto updateRegistrationEvent(RegistrationEventDto registrationEventDto, long id) {
        System.out.println("update registration event service --------");
        RegistrationEvent registrationEvent = registrationEventRepository.findById(id).orElseThrow(() -> new RuntimeException("Registration event not found"));
        // update registration event and save
        registrationEvent.setStartDate(registrationEventDto.getStartDate());
        registrationEvent.setEndDate(registrationEventDto.getEndDate());
        List<RegistrationGroup> registrationGroup = registrationEventDto.getRegistrationGroups()
                .stream()
                .map(registrationGroupDto -> modelMapper.map(registrationGroupDto, RegistrationGroup.class)).toList();
        System.out.println(registrationEvent.getStartDate() + "---------------------");
        registrationEvent.setRegistrationGroups(registrationGroup);
        return modelMapper.map(registrationEventRepository.save(registrationEvent), RegistrationEventDto.class);

    }

    @Override
    public void deleteRegistrationEvent(long id) {
        registrationEventRepository.deleteById(id);

    }

    @Override

    public RegistrationEventDto getLatestRegistrationEvent() {
        return null;
    }

//    @Transactional
//    public void process(int id) {
//
//        // mubarek's suggestion
//        // get the registration event
//        RegistrationEvent registrationEvent = registrationEventRepository.findById(1l).get();
//
//        // two registration groups in each registration event
//        List<RegistrationGroup> registrationGroups = registrationEvent.getRegistrationGroups();
//
//        // each registration group has a list of students
//
//
//        List<Student> students =
//                studentRepository
//                        .findAllByRegistrationGroup_RegistrationEvents_Id(id);
//
//        students.stream().forEach(s -> System.out.println(s.getFirstName()));
//
//
//
//        for (Student student : students) {
//            for (RegistrationRequest registrationRequest : student.getRegistrationRequests()) {
//                // search in registration for registration request course offering
//                Optional<Registration> registration = null;
//                if (student.getRegistrations() != null) {
//                     registration = student.getRegistrations().stream()
//                            .filter(r ->
//                                    r.getCourseOffering().equals(registrationRequest.getCourseOffering()))
//                            .findFirst();
//                }
//                // search in registration for registration request course offering
//                Optional<Registration> registrationCurrentRequestBlock = null;
//                if (student.getRegistrations() != null) {
//                    registrationCurrentRequestBlock = student.getRegistrations().stream()
//                            .filter(r ->
//                                    r.getCourseOffering().getAcademicBlock().equals(registrationRequest.getCourseOffering().getAcademicBlock()))
//                            .findFirst();
//                }
//                // if the student does not have course in registration
//                // And the student does not have course in block
//                if ((registration == null || !registration.isPresent()) &&
//                        (registrationCurrentRequestBlock == null || !registrationCurrentRequestBlock.isPresent())) {
//                    // if there is available seats
//                    if (registrationRequest.getCourseOffering().getCapacity()
//                            - registrationRequest.getCourseOffering().getRegistrations().size() > 0) {
//                        // register the student for this course
//                        Registration newRegistration = Registration.builder()
//                                .student(student)
//                                .courseOffering(registrationRequest.getCourseOffering())
//                                .build();
//
//                        registrationRepository.save(newRegistration);
//                        registrationRequest.getCourseOffering().getRegistrations().add(newRegistration);
//                    }
//                }
//            }
//        }
//    }

    @Override
    public void addRegistrationGroupToRegistrationEvent(long registration_event_id, long registration_group_id) {
        RegistrationEvent registrationEvent = registrationEventRepository.findById(registration_event_id).orElse(null);
        RegistrationGroup registrationGroup = registrationGroupRepository.findById(registration_group_id).orElse(null);

        if(registrationEvent != null && registrationGroup != null){
            registrationEvent.getRegistrationGroups().add(registrationGroup);
            registrationEventRepository.save(registrationEvent);

        }

    }

    @Override
    public RegistrationEventWOStudentList findLatestByStudentId(long id) {
        List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
       // get the event in which the student belongs to
        List<RegistrationEvent> ListOfStudentsRegistrationEvents = registrationEvents.stream()
                .filter(registrationEvent1 -> registrationEvent1.getRegistrationGroups().stream()
                        .anyMatch(registrationGroup -> registrationGroup.getStudents().stream()
                                .anyMatch(student -> student.getId() == id))).toList();

        // each student has two registration events
        // the first for (FPP and MPP) and the second for the rest of the courses
        // if the student is Mpp track then the first registration event is for MPP only



        LocalDate latestDate = LocalDate.now();

        // compare the latest date with the start date of the registration event
        // then return the registration event that is closer to the current date
        // Create a localdate form string
        //LocalDate localDate = LocalDate.parse(registrationEventList.get(0).getEndDate());


        var differenceToFirstEvent = latestDate.compareTo(ListOfStudentsRegistrationEvents.get(0).getEndDate());
        var differenceToSecondEvent = latestDate.compareTo(ListOfStudentsRegistrationEvents.get(1).getEndDate());


        // compare the difference between the two events
        var registrationEvent = differenceToFirstEvent > differenceToSecondEvent ? ListOfStudentsRegistrationEvents.get(1) : ListOfStudentsRegistrationEvents.get(0);
        String registrationEventStatus = registrationEvent.getStartDate().isBefore(LocalDate.now()) && registrationEvent.getEndDate().isAfter(LocalDate.now()) ? "registration is Open" : "registration is Closed";

        RegistrationEventWOStudentList registrationEventWOStudentList = modelMapper.map(registrationEvent, RegistrationEventWOStudentList.class);
        registrationEventWOStudentList.setStatus(registrationEventStatus);
        return registrationEventWOStudentList;

    }

    @Override
    public void process(long id) {
        // get registration event
        RegistrationEvent registrationEvent = registrationEventRepository.findById(id).orElseThrow(() -> new RuntimeException("Registration Event not found"));

        // get registration groups
        List<RegistrationGroup> registrationGroups = registrationEvent.getRegistrationGroups();

        // for each registration group

        Map<AcademicBlock, List<RegistrationRequest>> registrationRequestDtosPerBlockPerStudent = new HashMap<>() ;

        List<Map<AcademicBlock, List<RegistrationRequest>>> registrationRequestDtosPerBlockPerStudentList = new ArrayList<>();

        registrationGroups.forEach(registrationGroup -> {
            registrationGroup.getStudents().forEach(

                    student -> student.getRegistrationRequests()
                            .forEach(registrationRequest -> {
                                if(registrationRequestDtosPerBlockPerStudent.containsKey(registrationRequest.getCourseOffering().getAcademicBlock())){
                                    List<RegistrationRequest> registrationRequests = registrationRequestDtosPerBlockPerStudent.get(registrationRequest.getCourseOffering().getAcademicBlock());
                                    List<RegistrationRequest> registrationRequestsNew =  new ArrayList<>(registrationRequests);
                                    registrationRequestsNew.add(registrationRequest);
                                    registrationRequestDtosPerBlockPerStudent.put(registrationRequest.getCourseOffering().getAcademicBlock(), registrationRequestsNew);
                                }
                                else
                                    registrationRequestDtosPerBlockPerStudent.put(registrationRequest.getCourseOffering().getAcademicBlock(), List.of(registrationRequest));

                                registrationRequestDtosPerBlockPerStudentList.add(registrationRequestDtosPerBlockPerStudent);

                            })

            );
        });




//        registrationGroups.forEach(registrationGroup -> {
//            registrationGroup.getStudents().forEach(
//
//                    student -> student.getRegistrationRequests()
//
//
//            );
//        });

        // print the map
        registrationRequestDtosPerBlockPerStudent.forEach((k,v) -> System.out.println(k + " " + v));




    }


}
