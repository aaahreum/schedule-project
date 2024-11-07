package com.example.scheduleproject;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String name;
    private String password;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.name = schedule.getName();
        this.password = schedule.getPassword();
    }
}
