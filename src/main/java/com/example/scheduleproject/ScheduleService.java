package com.example.scheduleproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduleService {

    Map<Long, Schedule> scheduleList = new HashMap<>();

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {

        Schedule schedule = new Schedule(requestDto.getTitle(), requestDto.getContents(), requestDto.getName(), requestDto.getPassword());

        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saveSchedule);
    }

    public List<ScheduleResponseDto> getSchedules() {

        List<ScheduleResponseDto> responseList = new ArrayList<>();

        for (Schedule schedule : scheduleRepository.findAll()) {
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            responseList.add(responseDto);
        }

        return responseList;
    }
}
