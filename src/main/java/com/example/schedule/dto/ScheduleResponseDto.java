package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

import java.util.Date;

// [[ 해당 클래스를 통해 데이터를 '보여'줍니다.]]
//     -- ResponseDto를 만든 이유--
// 1. Schedule Class는 DB에 직접 저장하는데 활용할 클래스 이므로 보안을 위해 Schedule로 데이터를 보여주는게ㅔ 아닌 ResponseDto를 통해 보여준다
// 2. 데이터 이외의 로직을 작성하지 않아도 돼서 코드의 가독성을 높일 수 있다.
@Getter
public class ScheduleResponseDto {
    long id;              // 할일 제목
    String title;         // 할일 제목
    String content;       // 할일 내용
    String managerName;   // 담당자 이름
    String password;      // 비밀번호
    Date createdAt;       // 작성일

    public ScheduleResponseDto(Schedule schedule) { // Schedule 클래스에 저장된 데이터를 ScheduleResponseDto 생성자에 전달
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.managerName = schedule.getManagerName();
        this.password = schedule.getPassword();
        this.createdAt = schedule.getCreatedAt();
    }
}
