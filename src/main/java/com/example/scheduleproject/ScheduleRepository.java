package com.example.scheduleproject;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ScheduleRepository {

    Map<Long, Schedule> scheduleList = new HashMap<>();

    public Schedule save(Schedule schedule) {

        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        schedule.setId(scheduleId);

        scheduleList.put(scheduleId, schedule);

        return schedule;
    }

    public Collection<Schedule> findAll() {
        return scheduleList.values();
    }
}
