package com.example.scheduleproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    Map<Long, Schedule> scheduleList = new HashMap<>();

//    @Autowired
    private final ScheduleService scheduleService;

//    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto){
        ScheduleResponseDto scheduleResponseDto = scheduleService.createSchedule(requestDto);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED) ;
    }

    @GetMapping
    public List<ScheduleResponseDto> getSchedules(){
        return scheduleService.getSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getSchedule(
            @PathVariable Long id
    ) {
        Schedule schedule = scheduleList.get(id);
        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }


    // 할일(title, contents), 작성자명만 수정 가능해야됨
    // 비밀번호를 함께 전달해야한다? -> 비밀번호가 일치해야 수정이 가능하다?
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            // @PathVariable - URL 경로에서 값을 가져올 때 사용
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto
    ){
        Schedule schedule = scheduleList.get(id);

        if(schedule == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(!schedule.getPassword().equals(requestDto.getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        if(requestDto.getTitle() == null || requestDto.getContents() == null || requestDto.getName() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        schedule.update(requestDto);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){

        if(scheduleList.containsKey(id)) {

            scheduleList.remove(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

}
