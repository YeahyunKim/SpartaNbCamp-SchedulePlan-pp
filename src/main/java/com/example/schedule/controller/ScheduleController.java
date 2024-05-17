package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // =====[Create]===== 1단계 일정 작성
    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createMemo(requestDto);
    }

    // =====[Read]===== 2단계 선택한 일정 조회
    @GetMapping("/schedule/content")
    public Schedule findSchedule(@RequestParam Long id) {
        return scheduleService.getScheduleById(id);
    }

    // =====[Read]===== 3단계 전체 일정 조회
    @GetMapping("/schedule")
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleService.getSchedules();
    }

    // =====[Update]===== 4단계 선택한 일정 수정
    @PutMapping("/schedule/{id}/{password}")
    public ScheduleResponseDto updateSchedule(@PathVariable Long id, @PathVariable String password, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id, requestDto, password);
    }

    // =====[Delete]===== 5단계 선택한 일정 삭제
    @DeleteMapping("/schedule/{id}/{password}")
    public Long deleteSchedule(@PathVariable Long id, @PathVariable String password) {
        return scheduleService.deleteSchedule(id, password);
    }
}
