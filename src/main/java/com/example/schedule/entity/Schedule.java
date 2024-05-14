package com.example.schedule.entity;

import com.example.schedule.dto.ScheduleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter                   // lombok을 통한 get 메서드 추가
@Setter                   // lombok을 통한 set 메서드 추가
@NoArgsConstructor        // lombok을 통한 기본생성자 추가
public class Schedule {
    long id;              // 할일 고유번호
    String title;         // 할일 제목
    String content;       // 할일 내용
    String managerName;    // 담당자 이름
    String password;      // 비밀번호
    Date createdAt;       // 작성일

    public Schedule(ScheduleRequestDto requestDto) { // ScheduleRequestDto로 데이터를 전달 받고 이를 Schedule 클래스에 저장
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.managerName = requestDto.getManagerName();
        this.password = requestDto.getPassword();
        this.createdAt = requestDto.getCreatedAt();
    }
}
