# schedule-project
## API 명세서

|기능|Method|URL|request|response|상태코드|
|---|---|---|---|---|---|
|일정 생성|`POST`|/api/schedules|요청 body|등록 정보|200:OK, 404:NOT FOUND|
|전체 일정 조회|`GET`|/api/schedules|요청 param|다건 응답 정보|200:OK, 404:NOT FOUND|
|선택 일정 조회|`GET`|/api/schedules/{schedule_id}|요청 param|단건 응답 정보|200:OK, 404:NOT FOUND|
|선택 일정 수정|`PUT`|/api/schedules/{schedule_id}|요청 body|수정 정보|200:OK, 404:NOT FOUND|
|선택 일정 삭제|`DELET`|/api/schedules/{schedule_id}|요청 param|삭제 정보|200:OK, 404:NOT FOUND|

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


![Copy of schedule-project (3)](https://github.com/user-attachments/assets/749bbb93-725f-46b7-8fef-ee1b7bc39507)



-------


## SQL


- 테이블 생성
```
CREATE TABLE Schedule (
  schedule_id	int	NOT NULL PRIMARY KEY AUTO_INCREMENT
	user_id	varchar(45)	NOT NULL,
	title	varchar(45)	NULL,
	content	varchar(200)	NULL,
	password	varchar(45)	NOT NULL,
	created_date	datetime	NULL,
	modify_date	datetime	NULL
);
```
- 일정 생성
```
INSERT INTO Schedule (user_id, title, content, password, created_date, modify_date)
VALUES ("abc", "과제 검사", "금요일까지", "1234", current_timestamp(), current_timestamp());
``` 
- 전체 일정 조회
```
SELECT * FROM Schedule;
```  
- 선택 일정 조회
```
SELECT * FROM Schedule WHERE id = 1;
```    
- 선택 일정 수정
```
UPDATE Schedule SET content = "금요일까지 무조건", update_date = current_timestamp() WHERE id = 2;
```  
- 선택 일정 삭제
```
DELETE FROM Schedule WHERE id = 1;
```
