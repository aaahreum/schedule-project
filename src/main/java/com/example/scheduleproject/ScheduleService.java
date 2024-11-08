package com.example.scheduleproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ScheduleService {

    Map<Long, Schedule> scheduleList = new HashMap<>();

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {

        Schedule schedule = new Schedule(
                requestDto.getTitle(),
                requestDto.getContents(),
                requestDto.getName(),
                requestDto.getPassword()
        );

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

    public ResponseEntity<ScheduleResponseDto> getSchedule(Long id) {

        Schedule schedule = scheduleRepository.getSchedule(id);

        if(schedule == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }

    public ResponseEntity<ScheduleResponseDto> updateSchedule(Long id, String title, String contents, String name){

        Schedule schedule = scheduleRepository.getSchedule(id);

        if(schedule == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(title == null || contents == null || name == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        schedule.update(title, contents, name);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }

    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.getSchedule(id);

        if(schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        scheduleRepository.deleteSchedule(id);
    }
}
