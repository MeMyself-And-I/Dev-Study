### Primitive type & Reference type

자바에서는 원시형(Primitive type)과 참조형(Reference type)의 자료형이 존재한다.

```
Java Data Type
ㄴ Primitive Type
    ㄴ Boolean Type(boolean)
    ㄴ Numeric Type
        ㄴ Integral Type
            ㄴ Integer Type(short, int, long)
            ㄴ Floating Point Type(float, double)
        ㄴ Character Type(char)
ㄴ Reference Type
    ㄴ Class Type
    ㄴ Interface Type
    ㄴ Array Type
    ㄴ Enum Type
    ㄴ etc.
```

## Primitive type(원시형 타입)

- JAVA는 8가지의 원시형을 미리 정의하고 제공한다.
- 기본 자료형은 반드시 사용하기 전에 선언되어야 한다.
- 비객체 타입이므로 null 값을 가질 수 없다.(Null 값을 사용하려면 Wrapper 클래스를 사용해야한다.)
- 스택 메모리에 저장된다.

![Primitive type](/cs/개발언어/Java/img/primitiveType.png)

- boolean

  - true, false를 저장하는 타입, 주로 yes/no, on/off 등과 같은 논리 구현에 사용
  - 실제로 1bit면 충분하지만, 데이터를 다루는 최소 단위가 1byte이므로 메모리 크기가 1byteDLEK.

- byte

  - 주로 이진 데이터를 다루는데 사용되는 타입이다.

- short

  - C언어와의 호환을 위해 사용되는 타입으로 잘 사용되지 않는 타입이다.

- int

  - 자바에서 정수 연산을 하기 위해 자주 사용하는 타입이다.(byte 혹은 short의 연산 결과는 int형이 된다.)

- long

  - 수치가 큰 데이터를 다루는 프로그램에서 주로 사용한다.
  - long 타입의 변수를 초기화 할 때는 알파벳 L을 붙여서 정수 타입임을 알려주어야 한다(붙이지 않을 경우 컴파일 에러 발생)

- float, double

  - 실수를 부동소수점 방식으로 저장한다.
  - double형이 표현 가능 범위가 더 크므로 보다 정밀하게 표현할 수 있다.
  - 자바에서 실수의 기본 타입은 double형이므로 float형을 사용할 경우 알파벳 F를 붙여서 명시해주어야 한다.

## Referencd type(참조형 타입)

- Primitive type을 제외한 모든 타입들이 Reference type이다.
- 제일 상위 클래스인 Object 클래스를 상속하는 모든 클래스를 말한다.
- 빈 객체를 의미하는 null이 존재한다.
- NullPointException과 같이 문법상으로는 문제가 없지만 실행시켰을 때 발생하는 런타임 에러가 발생할 수 있다.

## String Class

String 클래스는 참조형에 속하지만 기본적인 사용은 원시형처럼 사용한다.
불변의 객체로써, String 클래스에서 값을 변경해주는 메소드를 사용하여 데이터를 변경할 경우 기존 객체의 값이 변경되는 것이 아닌 새로운 String 객체를 생성하는 것이다.
일반적으로 기본형 비교는 == 연산자를 사용하지만 String 객체간의 비교는 .equals() 메소드를 사용해야 한다.
