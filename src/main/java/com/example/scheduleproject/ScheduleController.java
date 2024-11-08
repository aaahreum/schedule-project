package com.example.scheduleproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedFormContentFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    /**
     * 생성자 주입
     * @param scheduleService
     */
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    /**
     * 메모 생성 API
     * @param : {@link ScheduleRequestDto} 매모 생성 요청 객체
     * @return: {@link ScheduleResponseDto} 객체와 함께 HTTP 상태 코드 반환
     */
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto){
        ScheduleResponseDto scheduleResponseDto = scheduleService.createSchedule(requestDto);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED) ;
    }

    /**
     * 메모 전체 조회 API
     * @return : {@link List<ScheduleResponseDto>}
     */
    @GetMapping
    public List<ScheduleResponseDto> getSchedules(){
        return scheduleService.getSchedules();
    }

    /**
     * 메모 단건 조회 API
     * @param id 식별자
     * @return : {@link ResponseEntity<ScheduleResponseDto>}
     */
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getSchedule(
            @PathVariable Long id
    ) {
        return scheduleService.getSchedule(id);
    }


    /**
     * 메모 수정 API
     * @param id 식별자
     * @param : {@link ScheduleRequestDto} 메모 수정 요청 객체
     * @return : 수정된 일정 정보가 담긴 {@link ResponseEntity} 객체를 반환
     */
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            // @PathVariable - URL 경로에서 값을 가져올 때 사용
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto
    ){
        return scheduleService.updateSchedule( id,
                requestDto.getTitle(),
                requestDto.getContents(),
                requestDto.getName());
    }

    /**
     * 메모 삭제 API
     * @param id 식별자
     * @return 삭제 성공 후 HTTP 상태 코드 200(OK) 반환
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
