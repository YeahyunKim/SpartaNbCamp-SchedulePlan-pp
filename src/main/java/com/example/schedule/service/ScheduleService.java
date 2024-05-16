package com.example.schedule.service;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // =====[Create]===== 1단계 일정 작성
    public ScheduleResponseDto createMemo(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);

        Schedule saveSchedule = scheduleRepository.save(schedule);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    // =====[Read]===== 2단계 선택한 일정 조회
    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("선택한 스케쥴을 존재하지 않습니다.")
        );
    }

    // =====[Read]===== 3단계 전체 일정 조회
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleRepository.findAllByOrderByCreatedAtDesc().stream().map(ScheduleResponseDto::new).toList();
    }

    // =====[Update]===== 4단계 선택한 일정 수정
    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto, String password) {
        // 해당 메모가 DB에 존재하는지 확인
        Schedule schedule = getScheduleById(id);

        // 비밀번호 확인 로직 추가
        if (schedule.getPassword().equals(password)) {
            schedule.update(requestDto);
            ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
            return scheduleResponseDto;
        } else {
            // 비밀번호가 일치하지 않을 경우 예외 처리
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

}
