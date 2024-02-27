Use Case Diagram

![lv2](https://github.com/Seungmi97/spring-lv2/assets/157124813/33447c3e-f04b-4096-a534-fa06e376d5a1)

API 명세서

| **기능** | **Method** | **URL** | **Request** | **Response** |
| --- | --- | --- | --- | --- |
| 도서 등록 | POST | /api/book | {'title': title, 'writer': writer, 'language':language, 'publisher': publisher } | {'title': title, 'writer': writer, 'language':language, 'publisher': publisher, 'createdAt':createdAt} |
| 회원 등록 | POST | /api/user | {'name':name, 'gender':gender, 'idNumber': idNumber, 'phone': phone, 'address':address} | {'name':name, 'gender':gender, 'phone': phone, 'address':address} |
| 도서 정보 조회 | GET | /api/book/{bookId} |  | {'title': title, 'writer': writer, 'language':language, 'publisher': publisher, 'createdAt':createdAt} |
| 도서 목록 조회 | GET | /api/book |  |  |
| 선택 도서 대출 | POST | /api/book | {도서식별값, 회원식별값} |  |
| 대출 내역 조회 | GET | /api/book/{userId} |  |  |
| 선택 도서 반납 | PUT | /api/book |  |  |

ERD

![image](https://github.com/yuha00e/Algorithm/assets/157124813/98cb7a7a-ca75-408a-ba7e-7544c845922a)
