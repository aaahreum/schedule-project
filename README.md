# schedule-project
## API 명세서

|기능|Method|URL|request|response|상태코드|
|---|---|---|---|---|---|
|일정 생성|`POST`|/api/schedules|요청 body|등록 정보|200:OK, 404:NOT FOUND|
|전체 일정 조회|`GET`|/api/schedules|요청 param|다건 응답 정보|200:OK, 404:NOT FOUND|
|선택 일정 조회|`GET`|/api/schedule/{schedule_id}|요청 param|단건 응답 정보|200:OK, 404:NOT FOUND|
|선택 일정 수정|`PUT`|/api/schedule/{schedule_id}|요청 body|수정 정보|200:OK, 404:NOT FOUND|
|선택 일정 삭제|`DELET`|/api/schedule/{schedule_id}|요청 param|삭제 정보|200:OK, 404:NOT FOUND|

### 일정 등록
- POST
- /api/schedules
- request
  ```
  {
    "user_id" : "abc",
    "title" : "과제 검사",
    "content" : "금요일까지",
    "password" : "1234",
    "created_date" : "2024-10-31 17:00:00",
    "modify_date" : "2024-10-31 17:00:00"
  }  
  ```
- response
- 상태 코드 </br> 200:OK, 404:NOT FOUND
### 전체 일정 조회
- GET
- /api/schedules
- 상태 코드 </br> 200:OK, 404:NOT FOUND
### 선택 일정 조회
- GET
- /api/schedules/{schedule_id}
- 상태 코드 </br> 200:OK, 404:NOT FOUND
### 선택 일정 수정
- PUT
- /api/schedules/{schedule_id}
- request
    ```
  {
    "user_id" : "abc",
    "title" : "과제 검사",
    "content" : "금요일까지 무조건",
    "password" : "1234",
    "created_date" : "2024-10-31 17:00:00",
    "modify_date" : "2024-10-31 17:00:00"
  }  
  ```
- 상태 코드 </br> 200:OK, 404:NOT FOUND
### 선택 일정 삭제
- DELETE
- /api/schedules/{schedule_id}
- 상태 코드 </br> 200:OK, 404:NOT FOUND

--------


## ERD


![Copy of schedule-project (2)](https://github.com/user-attachments/assets/d2552b90-726c-402e-9163-c6375dbd3e4f)



-------


## SQL


- 테이블 생성

- 일정 생성
  
- 전체 일정 조회
  
- 선택 일정 조회
  
- 선택 일정 수정
  
- 선택 일정 삭제



