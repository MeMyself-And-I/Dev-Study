## Wrapper Class

자바에는 원시형과 이 원시형을 객체로 만들기 위해 사용(포장)하는 Wrapper Class가 있다.

- 기본 타입 : int, long, float, double, boolean 등
- Wrapper 클래스 : Integer, Long, Float, Double, Boolean 등

## Boxing & UnBoxing

> 박싱 : 기본 타입 데이터에 대응하는 Wrapper 클래스로 만드는 동작 \
> 언박싱 : Wrapper 클래스에서 기본 타입으로 변환하는 동작

```java
// 박싱
int i = 10;
Integer num = new Integer(i);

// 언박싱
Integer num = new Integer(10);
int i = num.intValue();
```

![Wrapper Class](/cs/개발언어/Java/img/wrapperClass.png)

## Auto Boxing & Auto UnBoxing

JDK 1.5부터는 자바 컴파일러가 박싱과 언박싱이 필요한 상황에 자동으로 처리해준다.

```java
// 오토 박싱
int i = 10;
Integer num = i;

// 오토 언박싱
Integer num = new Integer(10);
int i = num;
```

## Wrapper Class 사용 시 주의 사항

Wrapper Class에 대입된 값은 ==, != 연산자를 통한 값 비교가 불가능하다.
인스턴스를 생성하면서 heap 메모리에 값이 저장되고 객체 변수는 참조값을 가지기 때문이다.
따라서 .equals() 메소드를 이용하거나 데이터를 언박싱하여 값을 비교해야 한다.

## 성능

편의성을 위해 오토 박싱과 언박신이 제공되고 있지만, 내부적으로 추가적인 연산 작업을 하게 된다.
따라서, 불필요한 오토 박싱 & 언박싱을 최소화하여 동일한 타입 연산이 이루어지도록 구현하는 것이 좋다.

**_오토 박싱 연산_**

```java
public static void main(String[] args) {
    long t = System.currentTimeMillis();
    Long sum = 0L;
    for (long i = 0; i < 1000000; i++) {
        sum += i;
    }
    System.out.println("실행 시간: " + (System.currentTimeMillis() - t) + " ms");
}

// 실행 시간 : 19 ms
```

**_동일 타입 연산_**

```java
public static void main(String[] args) {
    long t = System.currentTimeMillis();
    long sum = 0L;
    for (long i = 0; i < 1000000; i++) {
        sum += i;
    }
    System.out.println("실행 시간: " + (System.currentTimeMillis() - t) + " ms") ;
}

// 실행 시간 : 4 ms
```
