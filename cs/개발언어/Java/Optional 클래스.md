# Optional 클래스

Optional\<T\> 클래스는 Integer, Double 클래스처럼 'T'타입의(모든 타입) 객체를 포장해주는 래퍼 클래스이다.

Optional 객체를 사용하면 예상치 못한 NullPointerException을 쉽게 회피할 수 있다.(Null로 인한 버그를 막을 수 있다.)

## Optional 객체의 생성

of() 메소드나 ofNullable() 메소드를 사용하여 객체를 생성할 수 있다.

- of() 메소드: null이 아닌 명시된 값을 가지는 객체 반환(해당 메소드로 생성된 객체에 Null이 저장되면 NPE 발생)
- ofNullable() 메소드: 명시된 값을 가지는 객체를 반환하며 명시된 값이 Null이면 비어있는 객체 반환

따라서, Optional 객체가 null값을 가지게 되는 상황이 있다면 ofNullable()을 사용해야 한다.

## Optional 객체의 접근

get() 메소드를 통해 객체에 저장된 값에 접근할 수 있다.
만약 Optional 객체에 저장된 값이 null이면, NoSuchElementException 예외가 발생
따라서 get()메소드 호출 전 isPresent() 메소드를 사용해 null 체크 후 get() 메소드를 호출하는 것이 좋다.

```java
Optional<String> opt = Optional.ofNullable("자바 Optional 객체");

if(opt.isPresent()) {
    System.out.println(opt.get()); // 자바 Optional 객체
}
```

또한, 아래 메소드를 활용하여 만약 값이 Null일 경우 대체할 값을 지정할 수 있다.

1. orElse() 메소드 : 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지 않으면 인수로 전달된 값을 반환함.
2. orElseGet() 메소드 : 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지 않으면 인수로 전달된 람다 표현식의 결괏값을 반환함.
3. orElseThrow() 메소드 : 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지 않으면 인수로 전달된 예외를 발생시킴.

```java
Optional<String> opt = Optional.empty(); // Optional를 null로 초기화함.

System.out.println(opt.orElse("빈 Optional 객체")); // 빈 Optional 객체
System.out.println(opt.orElseGet(() -> "빈 Optional 객체 2")); // 빈 Optional 객체 2
```

## 원시형의 Optional 클래스

자바에서는 IntStream, DoubleStream 클래스와 같이 원시형 스트림을 위한 별도의 Optional 클래스를 제공해준다.

또한 Optional 객체에서 값에 접근하기위한 get() 메소드처럼 getAsInt()등과 같은 메소드를 제공한다.

| 클래스         | 메소드        | 반환값 |
| -------------- | ------------- | ------ |
| Optional\<T\>  | get()         | T      |
| OptionalInt    | getAsInt()    | int    |
| OptionalLong   | getAsLong()   | long   |
| OptionalDouble | getAsDouble() | double |

```java
IntStream stream = IntStream.of(4, 2, 1, 3);
OptionalInt result = stream.findFirst();

System.out.println(result.getAsInt()); // 4
```
