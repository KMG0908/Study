## 데이터베이스 회복 기법
> Undo: 트랜잭션 로그를 이용하여 오류와 관련된 모든 변경을 취소하여 복구 수행  
> Redo: 트랜잭션 로그를 이용하여 오류가 발생한 트랜잭션을 재실행하여 복구 수행
### 1. 로그 기반 회복 기법
* 지연갱신 회복 기법(Deferred Update)
  * 트랜잭션의 부분 완료 상태에선 변경 내용을 로그 파일에만 저장
  * 커밋이 발생하기 전까진 데이터베이스에 기록하지 않음
  * 중간에 장애가 생기더라도 데이터베이스에 기록되지 않았으므로 UNDO가 필요 없음(미실행 된 로그 폐기)
* 즉시갱신 회복 기법(Immediate Update)
  * 트랜잭션 수행 도중에도 변경 내용을 즉시 데이터베이스에 기록
  * 커밋 발생 이전의 갱신은 원자성이 보장되지 않는 미완료 갱신이므로 장애 발생 시 UNDO 필요
  
### 2. 검사점 회복 기법
Checkpoint Recovery
* 체크포인트(Checkpoint) 회복 기법이라고도 한다.
* 장애 발생 시 검사점(Checkpoint) 이전에 처리된 트랜잭션은 회복에서 제외하고
* 검사점 이후에 처리된 트랜잭션은 회복 작업 수행
  * 검사점 이후, 장애 발생 이전에 commit이 완료된 경우 Undo 수행
  * 장애 발생 시점까지 commit되지 못한 경우 Redo 수행

### 3.  그림자 페이징 회복 기법
Shadow Paging Recovery
* 트랜잭션이 실행되는 메모리상의 Current Page Table과 하드디스크의 Shadow Page Table 이용
* 트랜잭션 시작시점에 Current Page Table과 동일한 Shadow Page Table 생성
* 트랜잭션이 성공적으로 완료될 경우 Shadow Page Table 삭제
* 트랜잭션이 실패할 경우 Shadow Page Table을 Current Page Table로 함

### 4. 미디어 회복 기법
Media Recovery
* 디스크와 같은 비휘발성 저장 장치가 손상되는 장애 발생을 대비한 회복 기법
* 데이터베이스 내용을 백업, 미러링, RAID등을 통해 별도의 물리적 저장장치에 덤프
* 미디어 장애 시 가장 최근 덤프로 복구하고 로그 파일을 참조해 덤프 이후의 작업 Redo
* (Undo는 사용되지 않음)

### 5. ARIES 회복 기법
* REDO 중 Repeating history: 붕괴가 발생했을 때의 데이터베이스 상태를 복구하기 위하여 붕괴 발생 이전에 수행했던 모든 연산을 다시 한번 수행. 붕괴가 발생했을 때 완료되지 않은 상태였던 (진행 트랜잭션)은 UNDO
* UNDO 중 Logging: UNDO를 할 때에도 로깅을 함으로써 회복을 수행하는 도중에 실패하여 회복을 다시 시작할 때에 이미 완료된 UNDO 연산은 반복하지 않음

> 이 글은 https://raisonde.tistory.com/entry/%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%ED%9A%8C%EB%B3%B5-%EA%B8%B0%EB%B2%95-%EC%A0%95%EB%A6%AC 를 바탕으로 작성되었습니다.
