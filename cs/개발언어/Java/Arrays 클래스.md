# Arrays 클래스

---

## java.util.Arrays 클래스

Arrays 클래스에는 배열을 다루기 위한 다양한 메소드가 있다.
Arrays 클래스의 메소드는 모두 클래스 메소드(static method) 이므로, 객체 생성없이 사용할 수 있다.

## binarySearch() 메소드

- binarySearch() 메소드는 배열에서 이진 검색 알고리즘을 사용하여 검색한 후 해당 위치를 반환한다.
- 이진 검색 알고리즘을 사용하기때문에 탐색할 배열은 정렬되어 있어야한다.

> binarySearch() 메소드 사용 예제

```java
int[] arr = new int[1000];

for(int i = 0; i < arr.length; i++) {
    arr[i] = i;
}

System.out.println(Arrays.binarySearch(arr, 437)); // 437
```

## copyOf() 메소드

- copyOf() 메소드는 복사할 원본 배열을 첫 번째 매개변수로 전달받고, 새로운 배열로 복사할 요소의 개수를 두 번째 매개변수로 전달받아 새로운 배열을 반환한다.
- 만약 원본 배열의 길이보다 새로운 배열의 길이가 길다면, 나머지 요소는 타입에 맞게 기본값으로 채워진다

| 배열 요소의 타입  |    기본값     |
| :---------------: | :-----------: |
|       char        |   '\u0000'    |
| byte, short, int  |       0       |
|       long        |      0L       |
|       float       |     0.0F      |
|      double       | 0.0 또는 0.0D |
|      boolean      |     false     |
| 배열, 인스턴스 등 |     null      |

> copyOf() 메소드 사용 예제

```java
int[] arr1 = {1, 2, 3, 4, 5};
int[] arr2 = Arrays.copyOf(arr1, 3);

for (int i = 0; i < arr2.length; i++) {
    System.out.print(arr2[i] + " "); // 1 2 3
}

int[] arr3 = Arrays.copyOf(arr1, 10);

for (int i = 0; i < arr3.length; i++) {
    System.out.print(arr3[i] + " "); // 1 2 3 4 5 0 0 0 0 0
}
```

## copyOfRange() 메소드

- copyOfRange() 메소드는 원본 배열을 첫 번째 매개변수로 전달받고, 복사할 시작 인덱스를 두 번째 매개변수, 마지막으로 복사될 배열 요소의 바로 다음 인덱스를 세 번째 매개변수로 전달받아 새로운 배열을 반환한다.
- 즉, 세 번째 매개변수로 전달된 인덱스 바로 전까지의 요소까지만 복사된다.

> copyOfRange() 메소드 사용 예제

```java
int[] arr1 = {1, 2, 3, 4, 5};
int[] arr2 = Arrays.copyOfRange(arr1, 2, 4);

for (int i = 0; i < arr2.length; i++) {
    System.out.print(arr2[i] + " "); // 3 4
}
```

## fill() 메소드

- fill() 메소드는 첫 번째 매개변수로 초기화할 배열을 전달받고, 두 번째 매개변수로 초기값을 전달받는다.
- 즉, 전달받은 원본 배열의 값을 변경한다.

> fill() 메소드 사용 예제

```java
int[] arr = new int[10];

Arrays.fill(arr, 7);

for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + " "); / 7 7 7 7 7 7 7 7 7 7
}
```

## sort() 메소드

- sort() 메소드는 기본적으로 첫 번째 매개변수로 전달받은 배열의 모든 요소를 오름차순으로 정렬한다.
- 만약 원시형이 아닌 경우 Collections 클래스의 reverseOrder() 메소드를 두 번째 매개변수로 전달해 내림차순으로 정렬도 가능하다.
- 즉, 전달받은 원본 배열의 순서를 변경한다.

```java
int[] arr = { 5, 3, 4, 1, 2 };
        Integer[] arr2 = { 5, 3, 4, 1, 2 };

        // 오름차순 정렬
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // 1 2 3 4 5
        }

        System.out.println();

        // 내림차순 정렬
        Arrays.sort(arr2, Collections.reverseOrder());

        for (Integer it : arr2) {
            System.out.print(it + " "); // 5 4 3 2 1
        }
```
