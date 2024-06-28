# Enum 클래스

---

## 열거체(Enumeration type)

JDK 1.5부터 C언어의 열거체보다 더 향상된 성능의 열거체를 정의한 Enum 클래스를 사용할 수 있다.

자바의 열거체는 아래와 같은 장점이 있다.

1. 열거체를 비교할 때 실제 값뿐만 아니라 타입까지도 체크한다.
2. 열거체의 상숫값이 재정의되더라도 다시 컴파일할 필요가 없다.

## Enum의 정의 및 사용

### 정의 방법

> 문법

```java
enum 열거체이름 { 상수1이름, 상수2이름, ... }
```

> 예제

```java
enum Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }
```

### 사용 방법

> 문법

```java
열거체이름.상수이름
```

> 예제

```java
Rainbow.RED
```

## 열거체의 상숫값 정의 및 추가

```java
enum Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }
```

위 예제와 같의 정의돈 열거체의 첫 번째 상숫값은 배열의 인덱스처럼 0부터 설정되며 그 다음부터 1씩 증가되며 설정된다.

불규칙한 값을(사용자 정의 값) 상숫값으로 설정하고 싶다면 상수의 이름 옆에 괄호를 추가하여, 그 안에 원하는 상숫값을 명시할 수 있다.

이 때, 불규칙한 특정 값을 저장할 수 있는 인스턴스 변수와 생성자를 아래 예제와 같이 별도로 추가해야한다.

```java
enum Rainbow {
    RED(3), ORANGE(10), YELLOW(21), GREEN(5), BLUE(1), INDIGO(-1), VIOLET(-11);

    private final int value;
    Rainbow(int value) { this.value = value; }
    public int getValue() { return value; }
}
```

## java.lang.Enum 클래스

- Enum 클래스는 모든 자바 열거체의 조상 클래스이다.
- Enum 클래스에는 열거체를 조작하기 위한 다양한 메소드가 있다.

### value() 메소드

- value() 메소드는 해당 열거체의 모든 상수를 저장한 배열을 반환한다.
- 이 메소드는 자바의 모든 얼거체에 컴파일러가 자동으로 추가해주는 메소드이다.

> value() 메소드 예제

```java
enum Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }

public class Enum01 {
    public static void main(String[] args) {
        Rainbow[] arr = Rainbow.values();

        for (Rainbow rb : arr) {
            System.out.println(rb); // RED ORANGE YELLOW GREEN BLUE INDIGO VIOLET
        }
    }
}
```

### valueOf() 메소드

- valueOf() 메소드는 전달된 문자열과 일치하는 해당 열거체의 상수를 반환한다.

> valueOf() 메소드 예제

```java
enum Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }



public class Enum02 {
    public static void main(String[] args) {

        Rainbow rb = Rainbow.valueOf("GREEN");
        System.out.println(rb); // GREEN
    }
}
```

### ordinal() 메소드

- ordinal() 메소드는 해당 열거체 상수가 정의된 순서를 반환한다(배열 인덱스와 같이 0부터 시작)
- 반환되는 값은 열거체 정의에서 해당 열거체 상수가 정의된 순서이며, 상숫값 자체가 아니다.

> ordinal() 메소드 예제

```java
enum Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }

public class Enum03 {
    public static void main(String[] args) {
        int idx = Rainbow.YELLOW.ordinal();
        System.out.println(idx); // 2
    }
}
```

> 불규칙적인(사용자 정의) 상숫값을 가지는 열거체에서 ordinal() 메소드 예제

```java
enum Rainbow {
    RED(3), ORANGE(10), YELLOW(21), GREEN(5), BLUE(1), INDIGO(-1), VIOLET(-11);

    private final int value;
    Rainbow(int value) { this.value = value; }
    public int getValue() { return value; }
}

public class Enum04 {
    public static void main(String[] args) {
        System.out.println(Rainbow.YELLOW.ordinal()); // 2
    }
}
```
