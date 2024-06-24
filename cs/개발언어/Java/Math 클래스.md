# Math 클래스

---

## java.lang.Math 클래스

- Math 클래스는 수학에서 자주 사용하는 상수 또는 함수들을 미리 구현해 놓은 클래스이다.
- Math 클래스는 모두 클래스 메소드(static method)이므로, 객체 생성없이 바로 사용할 수 있다.

## Math.E와 Math.PI

1. Math.E: 오일러의 수라고 불리며, 자연로그의 base값으로 약 2.718을 의미하는 상수
2. Math.PI: 원주율 값으로 약 3.14159를 의미하는 상수

## random() 메소드

- random() 메소드는 0.0 이상 1.0 미만의 범위에서 임의의 double형 값을 하나 반환한다.

> random() 메소드 사용 예제

```java
// 0 ~ 99 범위의 난수를 생성하는 예제
System.out.println((int)(Math.random() * 100)); // 0 ~ 99

Random ran = new Random();
System.out.println(ran.nextInt(100));           // 0 ~ 99

// 난수 생성 범위를 조절할 수도 있다
(int)(Math.random() * 6);       // 0 ~ 5
((int)(Math.random() * 6) + 1); // 1 ~ 6
((int)(Math.random() * 6) + 3); // 3 ~ 8

```

## abs() 메소드

- 전달된 값의 절대값을 반환하는 메소드

> abs() 메소드 사용 예제

```java
System.out.println(Math.abs(10));    // 10
System.out.println(Math.abs(-10));   // 10
System.out.println(Math.abs(-3.14)); // 3.14
```

## floor(), ceil(), round() 메소드

- floor() 메소드는 내림 연산 수행
- ceil() 메소드는 올림 연산 수행
- round() 메소드는 반올림 연산 수행

> floor(), ceil(), round() 메소드 사용 예제

```java
System.out.println(Math.floor(10.0));     // 10.0
System.out.println(Math.floor(10.9));     // 10.0

System.out.println(Math.ceil(10.0));      // 10.0
System.out.println(Math.ceil(10.1));      // 11.0
System.out.println(Math.ceil(10.000001)); // 11.0

System.out.println(Math.round(10.0));     // 10
System.out.println(Math.round(10.4));     // 10
System.out.println(Math.round(10.5));     // 11
```

## max(), min() 메소드

- max() 메소드는 전달된 두 값 중 큰 값을 반환
- min() 메소드는 전달된 두 값 중 작은 값을 반환

> max(), min() 메소드 사용 예제

```java
System.out.println(Math.max(3.14, 3.14159)); // 3.14159
System.out.println(Math.min(3.14, 3.14159)); // 3.14
System.out.println(Math.max(-10, -11));      // -10
System.out.println(Math.min(-10, -11));      // -11
```

## pow(), sqrt() 메소드

- pow() 메소드는 첫 번째 인자로 전달받은 값을 두 번째 전달받은 인자만큼 제곱 연산 수행
- 즉 pow(a, b)는 a의 b승(a^b)를 수행후 반환한다,
- sqrt() 메소드는 전달된 double형 값의 제곱근 값을 반환한다.

> pow(), sqrt() 메소드 사용 예제

```java
System.out.println((int)Math.pow(5, 2)); // 25
System.out.println((int)Math.sqrt(25));  // 5
```
