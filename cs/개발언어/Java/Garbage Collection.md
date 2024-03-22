## GC(Garbage Collection)

---

### GC의 역할

자바는 개발자가 명시적으로 객체를 해제하여 메모리를 확보할 필요가 없다.
사용하지 않는 객체로부터 메모리를 반환하여 확보하는 작업을 GC라고 하며, JVM에서 GC를 수행한다.
JVM의 총 5가지 메모리 영역에서 힙 영역에서만 GC가 발생한다.

> stop-the-world란, GC를 실행하기 위해 JVM이 애플리케이션의 실행을 멈추는 것 \
> 어떤 GC 알고리즘을 사용하더라도 stop-the-world는 발생하며, 대게의 경우 GC 튜닝은 stop-the-world의 시간을 줄이는 것이라고 한다.

### GC의 대상

1. 객체가 NULL인 경우(Ex. String str = null)
2. 블럭 실행 종료 후, 블럭 안에서 생성된 객체
3. 부모 객체가 NULL인 경우, 포함하는 자식 객체

GC는 'Weak Generational Hypothesis'라는 가설에 기반한다.

> Weak Generational Hypothesis \
> 신규로 생성한 객체의 대부분은 금방 사용하지 않는 상태가 되고, 오래된 객체에서 신규 객체로의 참조는 매우 적게 존재한다는 가설이다. \
> 이 가설에 기반하여 자바는 Young 영역과 Old 영역으로 메모리를 분할하고, 신규로 생성되는 객체는 Young 영역에 보관하고, 오랫동안 살아남은 객체는 Old 영역에 보관합니다.

### Generational Garbage Collection

![gc-structure](/cs/개발언어/Java/img/gc-structure.png)

1. Young 영역(Yong Generation 영역)

   - 새롭게 생성된 객체 대부분이 위치
   - 이 영역에서 객체가 사라질 때 Minor GC가 발생

2. Old 영역(Old Generation 영역)

   - Young 영역에서 살아남은(계속 참조된) 객체가 위치
   - 이 영역에서 객체가 사라질 때 Major GC가 발생
   - 대부분 Young 영역보다 크게 할당, 크기가 큰 만큼 Young 영역보다 적게 GC 발생

3. Permanet 영역(MetaSpace 영역)
   - JVM이 클래스들과 메소드들을 설명하기 위해서 필요한 메타데이터들을 포함한다.
   - JDK8부터는 MetaSpace 영역으로 변경됨

### Generational Garbage Collection 과정

1. 새로운 객체가 생성되면 대부분 Eden Space에 할당
2. Eden Space가 가득차면 Minor GC 발생
3. Minor GC: 현재까지도 참조되고 있는 객체들은 S0영역으로 이동, 참조되지 않는 객체들은 Eden 영역에서 삭제
4. 다음 Minor GC가 발생하면 반대로 기존 S0에 있던 객체(S0객체 age 증가)와 Eden 영역에서 현재까지 참조되고 있는 객체가 S1로 이동
5. 4번 과정 반대로 진행
6. Minor GC를 반복하다가 특정 객체들이 age threshold를 넘어가게 되면 Old영역으로 이동
7. Old 영역 또한 할당된 Space가 가득차면 Major GC 발생(Major CG 방식은 JDK 7 기준 하기 5가지 방식이 존재)
   - Serial GC
   - Parallel GC
   - Parallel Old GC(Parallel Compaction GC)
   - Concurrent Mark & Sweep HC
   - G1(Garbage First) GC
