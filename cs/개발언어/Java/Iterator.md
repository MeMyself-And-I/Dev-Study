# Iterator

---

## Iterator<E\> 인터페이스

자바의 Collection 인터페이스에서는 Iterator 인터페이스를 구현한 클래스의 인스턴스를 반환하는 iterator() 메소드를 정의하여 각 컬렉션 요소에 접근하는 방법을 제공하고 있다.
따라서 Collection 인터페이스를 상속받는 List, Set, Queue와 같은 인터페이스에서도 iterator() 메소드를 사용할 수 있다.

### ArrayList iterator 사용 예제

```java
List<Integer> list = new ArrayList<>();

list.add(4);
list.add(2);
list.add(3);
list.add(1);

Iterator<Integer> iter = list.iterator();
while(iter.hasNext()) {
    System.out.println(iter.next()); // 4 2 3 1
}
```

### Iterator 인터페이스의 메소드

| 메소드                | 설명                                                       |
| --------------------- | ---------------------------------------------------------- |
| boolean hasNext()     | 다음 요소를 가지고 있으면 true, 그렇지 않으면 false를 반환 |
| E next()              | 다음 요소를 반환                                           |
| default void remove() | 반환되는 마지막 요소를 현재 컬렉션에서 제거                |

### Enhanced for문과 Iterator

대부분의 경우 향상된 for문을 통해서 처리하면 Iterator과 같은 성능을 유지하고, 가독성 향상의 효과를 볼 수 있지만.

향상된 for문을 통해 컬렉션 순회 중 특정 요소를 삭제하려 한다면, ***ConcurrentModificationException***이 발생할 수 있다.

#### 만약 컬렉션 순회 중 특정 요소들을 삭제해야하는 상황이 온다면?

##### 1. Iterator를 활용하여 삭제

```java
List<String> list = new ArrayList<>();
list.add("a");
list.add("b");
list.add("c");

Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String item = iterator.next();
    if (item.equals("b")) {
        iterator.remove(); // 안전하게 요소 제거
    }
}
```

##### 2. Map의 경우 동시성을 보장하는 Concurrent Collections 사용

```java
Map<String, String> map = new ConcurrentHashMap<>();
map.put("one", "1");
map.put("two", "2");
map.put("three", "3");

for (String key : map.keySet()) {
    if (key.equals("two")) {
        map.remove(key); // 안전하게 요소 제거
    }
}
```

## ListIterator<E\> 인터페이스

ListIterator 인터페이스는 Iterator 인터페이스를 상속받아 여러 기능을 추가한 인터페이스이다.
Iterator 인터페이스는 컬렉션의 요소에 접근할 때 한 방향으로만 이동할 수 있지만, ListIterator 인터페이스는 요소의 대체, 추가, 양방향 이동을 지원한다.

### ListIterator를 활용한 리스트 요소 순방향, 역방향 출력 예제

```java
List<Integer> list = new ArrayList<Integer>();

list.add(4);
list.add(2);
list.add(3);
list.add(1);

ListIterator<Integer> iter = list.listIterator();
while (iter.hasNext()) {
    System.out.print(iter.next() + " "); // 4 2 3 1
}
System.out.println();

while (iter.hasPrevious()) {
    System.out.print(iter.previous() + " "); // 1 3 2 4
}
```
