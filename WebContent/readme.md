# DailyT readme.md 파일


# customer 테이블 생성
```sql
CREATE TABLE customer(
	custid number primary key,
    nickname varchar2(100) not null unique,
    password varchar2(100) not null,
    email varchar2(100) not null,
    address varchar2(100) not null,
    cellphone varchar2(200) not null,
    userrole varchar2(100) not null,
    createDate timestamp
) ;
```


