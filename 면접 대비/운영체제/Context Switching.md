## Context Switching
### 개념
멀티프로세스 환경에서 CPU가 **어떤 하나의 프로세스를 실행하고 있는 상태**에서 **인터럽트 요청에 의해 다음 우선 순위의 프로세스가 실행되어야 할 때** 
기존의 프로세스의 상태 또는 레지스터 값(Context)을 저장하고 CPU가 다음 프로세스를 수행하도록 새로운 프로세스의 **상태 또는 레지스터 값(Context)를 교체**하는 작업

### 어떻게 진행되는가?
* Task의 대부분 정보는 Register에 저장되고 PCB(Process Control Block)로 관리되고 있다.
* 현재 실행하고 있는 Task의 PCB 정보를 저장하게 된다. (Process Stack, Ready Queue)
* 다음 실행할 Task의 PCB 정보를 읽어 Register에 적재하고 CPU가 이전에 진행했던 과정을 연속적으로 수행을 할 수 있다.

### 언제 발생하는가?
1. I/O request (입출력 요청할 때)
2. time slice expired (CPU 사용시간이 만료 되었을 때)
3. fork a child (자식 프로세스를 만들 때)
4. wait for an interrupt (인터럽트 처리를 기다릴 때)   
* 컨텍스트 스위칭이 일어날 때 다음번 프로세스는 스케줄러가 결정하게 된다. 즉, 컨텍스트 스위칭을 하는 **주체**는 **스케줄러**이다.

### 단점
PCB를 저장하고 가져올 때 해당 CPU는 아무런 일을 하지 못한다. 따라서 컨텍스트 스위칭이 잦아지면 오히려 오버헤드가 발생해 효율(성능)이 떨어진다.

> 이 글은 https://nesoy.github.io/articles/2018-11/Context-Switching 와 https://jeong-pro.tistory.com/93 를 바탕으로 작성되었습니다.
