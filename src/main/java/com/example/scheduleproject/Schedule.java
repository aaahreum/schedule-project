package com.example.scheduleproject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Schedule {
    @Setter
    private Long id;
    private String title;
    private String contents;
    private String name;
    private String password;

    public Schedule(String title, String contents, String name, String password) {

        this.title = title;
        this.contents = contents;
        this.name = name;
        this.password = password;

    }

    public void update(String title, String contents, String name) {
        this.title = title;
        this.contents = contents;
        this.name = name;
    }


}
