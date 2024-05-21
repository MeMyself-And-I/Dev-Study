# Java Stream API

> Java SE 8버전 이상부터는 Stream API를 지원한다.

## Java 스트림 도입 이유

자바에서는 많은 양의 데이터를 저장하기 위해 배열이나 컬렉션을 사용하는데,
이렇게 저장된 데이터에 접근하기 위해서는 반복문이나 iterator를 사용하여 매번 새로운 코드를 작성해야 했고 작성된 코드들은 길이가 길고, 가독성도 떨어진다는 단점이 있었다.

이런 문제점을 극복하기 위해 스트림 API를 도입했다.
스트림 API는 데이터를 추상화하여 다루므로, 다양한 방식으로 저장된 데이터를 읽고 쓰기 위해 공통된 방법을 제공한다.

## 스트림 API의 특징

1. 스트림은 내부 반복, 컬렉션은 외부 반복을 통해 작업한다.
2. 스트림은 재사용이 가능한 컬렉션과는 달리 단 한 번만 사용할 수 있다.
3. 스트림의 연산은 필터-맵 기반의 API를 사용하여 지연 연산을 통해 성능을 최적화 한다.
4. 스트림은 parallelStream() 메소드를 통한 손쉬운 병렬 처리를 지원합니다.

## 스트림 API의 동작 흐름

스트림 API는 세 가지 단계에 걸쳐서 동작하게 된다.

1. 스트림의 생성
2. 스트림의 중개 연산(스트림 변환)
3. 스트림의 최종 연산(스트림 사용)

![stream-flow](/cs/개발언어/Java/img/stream-flow.png)

## 스트림의 생성

스트림 API는 다양한 데이터 소스에서 생성할 수 있다.

### 1. 컬렉션

자바에서 컬렉션의 상위 조상인 Collection 인터페이스에는 stream() 메소드가 정의되어 있어 Collection을 구현한 모든 List, Set 클래스에서도 stream() 메소드로 스트림을 생성할 수 있다.

```java
ArrayList<Integer> list = new ArrayList<Integer>();

list.add(4);
list.add(2);
list.add(3);
list.add(1);

// 컬렉션에서 스트림 생성

Stream<Integer> stream = list.stream();
```

### 2. 배열

자바의 Arrays 클래스에서 다양한 형태의 stream() 메소드가 정의되어 있다.
또한 원시형인 int, long, double 형을 저장할 수 있는 배열에 관한 스트림은
java.util.stream 패키지의 IntStream, LongStream, DoubleStream 인터페이스로 제공된다.

```java
String[] arr = new String[]{"넷", "둘", "셋", "하나"};



// 배열에서 스트림 생성
Stream<String> stream1 = Arrays.stream(arr); // 넷 둘 셋 하나

// 배열의 특정 부분만을 이용한 스트림 생성
Stream<String> stream2 = Arrays.stream(arr, 1, 3); // 둘 셋
```

### 3. 가변 매개변수

Stream 클래스의 of() 메소드를 사용하여 가변 매개변수를 전달받아 스트림을 생성할 수 있다.

```java
// 가변 매개변수에서 스트림 생성
Stream<Double> stream = Stream.of(4.2, 2.5, 3.1, 1.9);
```

### 4. 지정된 범위의 연속된 정수

IntStream, LongStream 인터페이스에서 range() rangeClosed() 메소드를 통해 지정된 범위의 연속된 정수를 스트림으로 생성할 수 있다.

```java
// 지정된 범위의 연속된 정수에서 스트림 생성

IntStream stream1 = IntStream.range(1, 4); // 1 2 3

IntStream stream2 = IntStream.rangeClosed(1, 4); // 1 2 3 4
```

### 5. 빈 스트림

Stream 클래스의 empty() 메소드를 사용하여 빈 스트림을 생성할 수 있다.

```java
// 빈 스트림 생성
Stream<Object> stream = Stream.empty();
```

이 밖에 특정 타입의 난수, 람다 표현식, 파일등의 스트림도 생성할 수 있다.

## 스트림의 중개 연산

생성된 스트림들은 중개 연산을 통해 또 다른 스트림으로 변환된다.
이러한 중개 연산은 스트림을 전달받아 또 다른 스트림을 반환하므로 연속으로 연결해서 사용할 수 있다(중개연산끼리 파이프라이닝 가능).

### 대표적인 중개 연산 및 메소드

#### 1. 스트림 필터링: filter(), distinct()

distinct() 메소드는 내부적으로 Object 클래스의 equals() 메소드를 사용하여 요소의 중복을 비교한다.

```java
IntStream stream1 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
IntStream stream2 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

// 스트림에서 중복된 요소를 제거함.
stream1.distinct().forEach(e -> System.out.print(e + " ")); // 7 5 2 1 3 4 6

// 스트림에서 홀수만을 골라냄.
stream2.filter(n -> n % 2 != 0).forEach(e -> System.out.print(e + " ")); // 7 5 5 1 3 5
```

#### 2. 스트림 변환: map(), flatMap()

```java
Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
stream.map(s -> s.length()).forEach(System.out::println); // 4 3 4 10
```

#### 3. 스트림 제한: limit(), skip()

limit() 메소드는 해당 스트림의 첫 번째 요소부터 전달된 개수만큼의 요소만으로 이루어진 새로운 스트림을 반환한다.

skip() 메소드는 해당 스트림의 첫 번째 요소부터 전달된 개수만큼의 요소를 제외한 나머지 요소만으로 이루어진 새로운 스트림을 반환한다.

```java
IntStream stream1 = IntStream.range(0, 10);
IntStream stream2 = IntStream.range(0, 10);
IntStream stream3 = IntStream.range(0, 10);

stream1.skip(4).forEach(n -> System.out.print(n + " ")); // 4 5 6 7 8 9

stream2.limit(5).forEach(n -> System.out.print(n + " ")); // 0 1 2 3 4

stream3.skip(3).limit(5).forEach(n -> System.out.print(n + " ")); // 3 4 5 6 7
```

#### 4. 스트림 정렬: sorted()

```java
Stream<String> stream1 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
Stream<String> stream2 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");

// sorted() 메소드에 비교자가 전달되지 않으면 사전 편찬 순(오름차순)으로 정렬됨
stream1.sorted().forEach(s -> System.out.print(s + " ")); // CSS HTML JAVA JAVASCRIPT

// 사전 편찬 반대순(내림차순)으로 정렬됨
stream2.sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " ")); // JAVASCRIPT JAVA HTML CSS
```

#### 5. 스트림 연산 결과 확인: peek()

peek() 메소드는 원본 스트림에서 요소를 소모하지 않아, 주로 연산과 연산 사이에 중간 중간 결과를 확인하고 싶을 때 사용한다.(보통 디버깅 용으로 많이 사용)

## 스트림의 최종 연산

중개 연산을 통해 변환된 스트림은 최종 연산을 통해 각 요소를 소모하여 결과를 표시한다.
즉, 지연되였던 모든 중개 연산들이 최종 연산시에 수행된다.

### 대표적인 최종 연산 및 메소드

#### 1. 요소의 출력(동작 수행): forEach()

```java
Stream<String> stream = Stream.of("넷", "둘", "셋", "하나");
stream.forEach(System.out::println); // 넷 둘 셋 하나
```

#### 2. 요소의 소모: reduce()

reduce() 메소드는 첫 번째 요소와 두 번째 요소를 가지고 연산을 수행한 뒤 그 결과와 세 번째 요소를 가지고 또다시 연산을 수행하는 과정을 마지막 요소까지 반복하고 그 결과를 반환한다.
또한 인수로 초깃값을 전달하면 초깃값과 첫 번째 요소와 연산을 시작한다.

```java
Stream<String> stream1 = Stream.of("넷", "둘", "셋", "하나");
Stream<String> stream2 = Stream.of("넷", "둘", "셋", "하나");

Optional<String> result1 = stream1.reduce((s1, s2) -> s1 + "++" + s2);
result1.ifPresent(System.out::println); // 넷++둘++셋++하나

String result2 = stream2.reduce("시작", (s1, s2) -> s1 + "++" + s2);
System.out.println(result2); // 시작++넷++둘++셋++하나
```

#### 3. 요소의 검색: findFirst(), findAny()

findFirst()와 findAny() 메소드는 해당 스트림에서 첫 번째 요소를 참조하는 Optional 객체를 반환한다.

두 메소드 모두 비어 있는 스트림에서는 비어있는 Optional 객체를 반환한다.
병렬 스트림인 경우에는 findAny()를 사용해야햐만 정확한 연산 결과를 얻을 수 있다

```java
IntStream stream1 = IntStream.of(4, 2, 7, 3, 5, 1, 6);
IntStream stream2 = IntStream.of(4, 2, 7, 3, 5, 1, 6);

OptionalInt result1 = stream1.sorted().findFirst();
System.out.println(result1.getAsInt()); // 1

OptionalInt result2 = stream2.sorted().findAny();
System.out.println(result2.getAsInt()); // 1
```

#### 4. 요소의 검사: anyMatch(), allMatch(), noneMatch()

- anyMatch() : 해당 스트림의 일부 요소가 특정 조건을 만족할 경우에 true를 반환함
- allMatch() : 해당 스트림의 모든 요소가 특정 조건을 만족할 경우에 true를 반환함
- noneMatch() : 해당 스트림의 모든 요소가 특정 조건을 만족하지 않을 경우에 true를 반환함

```java
IntStream stream1 = IntStream.of(30, 90, 70, 10);
IntStream stream2 = IntStream.of(30, 90, 70, 10);

System.out.println(stream1.anyMatch(n -> n > 80)); // true
System.out.println(stream2.allMatch(n -> n > 80)); // false
```

#### 5. 요소의 통계: count(), min(), max()

count() 메소드는 해당 스트림의 요소의 총 개수를 long 타입의 값으로 반환한다.
max()와 min() 메소드를 사용하면 해당 스트림의 요소 중에서 가장 큰 값과 가장 작은 값을 가지는 요소를 참조하는 Optional 객체를 얻을 수 있다.

```java
IntStream stream1 = IntStream.of(30, 90, 70, 10);
IntStream stream2 = IntStream.of(30, 90, 70, 10);

System.out.println(stream1.count()); // 4
System.out.println(stream2.max().getAsInt()); // 90
```

#### 6. 요소의 연산: sum(), average()

IntStream이나 DoubleStream과 같은 기본 타입 스트림에는 해당 스트림의 모든 요소에 대해 합과 평균을 구할 수 있는 sum()과 average() 메소드가 각각 정의되어 있다.
이때 average() 메소드는 각 기본 타입으로 래핑 된 Optional 객체를 반환한다.

```java
IntStream stream1 = IntStream.of(30, 90, 70, 10);
DoubleStream stream2 = DoubleStream.of(30.3, 90.9, 70.7, 10.1);

System.out.println(stream1.sum()); // 200
System.out.println(stream2.average().getAsDouble()); // 50.5
```

#### 7. 요소의 수집: collect()

collect() 메소드는 인수로 전달되는 Collectors 객체에 구현된 방법대로 스트림의 요소를 수집합니다.
Collectors 클래스에는 미리 정의된 다양한 방법이 클래스 메소드로 정의되어 있고 사용자가 직접 Collector 인터페이스를 구현하여 자신만의 수집 방법을 정의할 수도 있다.

1. 스트림을 배열이나 컬렉션으로 변환 : toArray(), toCollection(), toList(), toSet(), toMap()
2. 요소의 통계와 연산 메소드와 같은 동작을 수행 : counting(), maxBy(), minBy(), summingInt(), averagingInt() 등
3. 요소의 소모와 같은 동작을 수행 : reducing(), joining()
4. 요소의 그룹화와 분할 : groupingBy(), partitioningBy()

> 스트림 -> 리스트 변환 예제

```java
Stream<String> stream = Stream.of("넷", "둘", "하나", "셋");

List<String> list = stream.collect(Collectors.toList());
```

> partitioningBy() 메소드를 이용하여 해당 스트림의 각 요소별 글자 수에 따라 홀수와 짝수로 나누어 저장하는 예제

```java
Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "PHP");

Map<Boolean, List<String>> patition = stream.collect(Collectors.partitioningBy(s -> (s.length() % 2) == 0));

List<String> oddLengthList = patition.get(false);
System.out.println(oddLengthList); // [CSS, PHP]

List<String> evenLengthList = patition.get(true);
System.out.println(evenLengthList); // [HTML, JAVA]
```
