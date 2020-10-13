## Isolation Level
### 1. READ UNCOMMITTED
* 어떤 트랜잭션의 변경내용이 COMMIT이나 ROLLBACK과 상관없이 다른 트랜잭션에서 보여진다.

### 2. READ COMMITTED
* 어떤 트랜잭션의 변경 내용이 COMMIT 되어야만 다른 트랜잭션에서 조회할 수 있다.

### 3. REPETABLE READ
* 트랜잭션이 시작되기 전에 커밋된 내용에 대해서만 조회할 수 있다.
  *  자신의 트랜잭션 번호보다 낮은 트랜잭션 번호에서 변경된(+커밋된) 것만 보게 되는 것
  
### 4. SERIALIZABLE
* 읽기 작업에도 공유 잠금을 설정하게 되고, 이러면 동시에 다른 트랜잭션에서 이 레코드를 변경하지 못하게 된다.
* 트랜잭션이 완료될 때까지 다른 사용자는 그 영역에 해당되는 데이터에 대한 수정 및 입력이 불가능하다.

> 이 글은 https://joont92.github.io/db/%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EA%B2%A9%EB%A6%AC-%EC%88%98%EC%A4%80-isolation-level/ 를 바탕으로 작성되었습니다,
