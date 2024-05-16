package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    //저장할 DB 임의 생성
    Map<Long, Schedule> scheduleList = new HashMap<>();

    // =====[Create method]=====
    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);

        long createId = scheduleList.size() > 0 ? Collections.max(scheduleList.keySet()) + 1 : 1; //id 값 증가

        schedule.setId(createId);

        scheduleList.put(schedule.getId(), schedule);

        ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);

        return responseDto;
    }
}
