## 4-way handshaking
### 개념
* 세션을 종료하기 위해 수행되는 절차
### 과정
![과정](https://t1.daumcdn.net/cfile/tistory/2152353F52F1C02835)
#### 1. 클라이언트가 연결을 종료하겠다는 FIN플래그를 전송한다.
#### 2. 서버는 일단 확인메시지를 보내고 자신의 통신이 끝날때까지 기다리는데 이 상태가 TIME_WAIT상태다.
#### 3. 서버가 통신이 끝났으면 연결이 종료되었다고 클라이언트에게 FIN플래그를 전송한다.
#### 4. 클라이언트는 확인했다는 메시지를 보낸다.

> 이 글은 https://mindnet.tistory.com/entry/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EC%89%BD%EA%B2%8C-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-22%ED%8E%B8-TCP-3-WayHandshake-4-WayHandshake 를 바탕으로 작성되었습니다.
