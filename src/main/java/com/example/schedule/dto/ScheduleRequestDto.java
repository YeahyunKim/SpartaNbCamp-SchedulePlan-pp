package com.example.schedule.dto;
import lombok.Getter;
import java.util.Date;

// [[ 해당 클래스를 통해 데이터를 '전달'합니다. ]]
//     -- RequestDto를 만든 이유--
// 1. Schedule로 직접 데이터를 요청/저장 하는 것 보다 간접적인 클래스(RequestDto)를 통해 보안을 높인다.
// 2. 데이터 이외의 로직을 작성하지 않아도 돼서 코드의 가독성을 높일 수 있다.

@Getter
public class ScheduleRequestDto {
    String title;         // 할일 제목
    String content;       // 할일 내용
    String managerName;    // 담당자 이름
    String password;      // 비밀번호
    Date createdAt;       // 작성일
}
