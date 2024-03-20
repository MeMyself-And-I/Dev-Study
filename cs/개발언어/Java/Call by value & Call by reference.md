## Call by value && Call by reference

---

### Call by value

> 값에 의한 호출

call by value 방식은 함수 호출 시 전달되는 변수의 값을 복사해서 함수 인자로 전달함
이 때, 복사된 인자는 함수 안에서 지역적으로 사용되기 때문에 local variable 속성을 가짐(함수 내에서 인자 값이 변경되어도, 원본 즉, 외부 변수 값은 변경되지 않음)

##### Call by value 예시

```java
public class Main {
    public static void main(String[] args) {
        int n = 10;
        changeValue(n);
        System.out.println(n);
    }

    public static void changeValue(int n) {
        n = 20;
    }
}
```

> 출력되는 값은 10이다.

### Call by reference

> 참조에 의한 호출

call by reference 호출 방식은 함수 호출 시 인자로 전달되는 변수의 레퍼런스를 전달함

따라서 함수 안에서 인자 값이 변경되면, 아규먼트로 전달된 객체의 값도 변경됨

##### Call by reference 예시

```c
void func(int *n) {
    *n = 20;
}

void main() {
    int n = 10;
    func(&n);
    printf("%d", n);
}
```

> 출력되는 값은 20이다.

### Java의 함수 호출 방식

- 자바의 경우 항상 call by value 방식으로 값을 넘긴다.
- 참조 자료형을 넘길 때에는 해당 객체의 주소값을 복사하여 이를 가지고 사용한다.
- 원본 객체의 속성(필드 값)은 변경할 수 있지만 원본 객체 자체를 변경할 수는 없다.

> 따라서 Java에서 인자로 넘길 때는 주소값이란 값을 복사해서 넘기는 것이므로 call by value라고 할 수 있다.

### 정리

Call by value의 경우, 데이터 값을 복사해서 함수로 전달하기 때문에 원본의 데이터가 변경될 가능성이 없다. 하지만 인자를 넘겨줄 때마다 메모리 공간을 할당해야해서 메모리 공간을 더 잡아먹는다.

Call by reference의 경우 메모리 공간 할당 문제는 해결했지만, 원본 값이 변경될 수 있다는 위험이 존재한다.
