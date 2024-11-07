package com.example.scheduleproject;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ScheduleRequestDto {
    private String title;
    private String contents;
    private String name;
    private String password;
}
