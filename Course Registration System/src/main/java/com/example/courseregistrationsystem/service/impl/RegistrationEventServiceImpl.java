package com.example.courseregistrationsystem.service.impl;

import com.example.courseregistrationsystem.domain.RegistrationEvent;
import com.example.courseregistrationsystem.domain.dto.RegistrationEventDto;
import com.example.courseregistrationsystem.repo.RegistrationEventRepository;
import com.example.courseregistrationsystem.service.RegistrationEventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RegistrationEventServiceImpl implements RegistrationEventService {
    @Autowired
    private RegistrationEventRepository registrationEventRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public RegistrationEventDto createRegistrationEvent(RegistrationEventDto registrationEventDto) {
        RegistrationEvent registrationEvent = modelMapper.map(registrationEventDto, RegistrationEvent.class);
        return modelMapper.map(registrationEventRepository.save(registrationEvent), RegistrationEventDto.class);
    }

    @Override
    public List<RegistrationEventDto> getAllRegistrationEvents() {
        List<RegistrationEvent> registrationEvents = registrationEventRepository.findAll();
        List<RegistrationEventDto> registrationEventDtos =
                registrationEvents.stream().map(registrationEvent -> modelMapper.map(registrationEvent, RegistrationEventDto.class)).toList();
        return registrationEventDtos;

    }

    @Override
    public RegistrationEventDto updateRegistrationEvent(RegistrationEventDto registrationEventDto) {
        RegistrationEvent registrationEvent = registrationEventRepository.save(modelMapper.map(registrationEventDto, RegistrationEvent.class));
        return modelMapper.map(registrationEvent, RegistrationEventDto.class);
    }

    @Override
    public void deleteRegistrationEvent(RegistrationEventDto registrationEventDto) {
        registrationEventRepository.delete(modelMapper.map(registrationEventDto, RegistrationEvent.class));
    }
}
