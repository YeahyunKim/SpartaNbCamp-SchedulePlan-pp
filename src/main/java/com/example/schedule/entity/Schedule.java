package com.example.schedule.entity;

import com.example.schedule.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity                   // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "schedulePlan") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Schedule extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "content", nullable = false, length = 500)
    private String content;
    @Column(name = "managerName", nullable = false, length = 10)
    private String managerName;
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    public Schedule(ScheduleRequestDto requestDto) { // ScheduleRequestDto로 데이터를 전달 받고 이를 Schedule 클래스에 저장
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.managerName = requestDto.getManagerName();
        this.password = requestDto.getPassword();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.managerName = requestDto.getManagerName();
        //일정 수정이기 때문에, password 변경은 제외
    }
}
