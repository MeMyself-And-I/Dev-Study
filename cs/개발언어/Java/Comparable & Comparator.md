# Comparable & Comparator

## Comparable<T> 인터페이스

Comparable 인터페이스는 객체를 비교(정렬)하는데 사용되는 **_compareTo()_** 메소드를 정의하고 있다.
Boolean을 제외한 래퍼 클래스나 String, Time, Date 등등의 인스턴스는 모두 비교가 가능하다.
기본 정렬 순서는 사전 편찬순(오름차순)이 된다.

> Comparable 인터페이스 구현 예제

```java
public class Test {
	public static void main(String[] args)  {

		Student a = new Student(17, 2);	// 17살 2반
		Student b = new Student(18, 1);	// 18살 1반

		int isBig = a.compareTo(b);	// a자기자신과 b객체를 비교한다.

		if(isBig > 0) {
			System.out.println("a객체가 b객체보다 큽니다.");
		}
		else if(isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		}
		else {
			System.out.println("a객체가 b객체보다 작습니다.");
		}
	}
}

class Student implements Comparable<Student> {

	int age;			// 나이
	int classNumber;	// 학급

	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}

	@Override
	public int compareTo(Student o) {

        /**
         * 정석적인 방법(뺄셈 연산 수행 시 int 범위로 인한 overflow(값 반전)이 발생하지 않아 안전)
         *
        **/
        // 자기자신의 age가 o의 age보다 크다면 양수
		if(this.age > o.age) {
			return 1;
		}
		// 자기 자신의 age와 o의 age가 같다면 0
		else if(this.age == o.age) {
			return 0;
		}
		// 자기 자신의 age가 o의 age보다 작다면 음수
		else {
			return -1;
		}

        /**
         * 간편한(위의 조건보다 단축된) 방법(뺄셈 연산 수행 시 int 범위로 인한 overflow(값 반전)이 발생 하여 버그 발생 가능성 있음)
        **/
		// return this.age - o.age;
	}
}
```

## Comparator<T> 인터페이스

Comparator 인터페이스를 구현한 클래스에서는 **_compare()_** 메소드를 재정의하여 사용하게 된다.
Comparator 인터페이스는 Comparable 인터페이스와 같이 객체를 정렬하는 데 사용되는 인터페이스이다.
기본 정렬 순서는 사전 편찬순(오름차순)이 된다.

> Comparator 인터페이스 구현 예제

```java
import java.util.Comparator;

public class Test {
	public static void main(String[] args)  {

		Student a = new Student(17, 2);	// 17살 2반
		Student b = new Student(18, 1);	// 18살 1반
		Student c = new Student(15, 3);	// 15살 3반

		// a객체와는 상관 없이 b와 c객체를 비교한다.
		int isBig = a.compare(b, c);

		if(isBig > 0) {
			System.out.println("b객체가 c객체보다 큽니다.");
		}
		else if(isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		}
		else {
			System.out.println("b객체가 c객체보다 작습니다.");
		}

	}
}

class Student implements Comparator<Student> {

	int age;			// 나이
	int classNumber;	// 학급

	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}

	@Override
	public int compare(Student o1, Student o2) {

        /**
         * 정석적인 방법(뺄셈 연산 수행 시 int 범위로 인한 overflow(값 반전)이 발생하지 않아 안전)
         *
        **/
        // 자기자신의 classNumber o의 classNumber 크다면 양수
		if(this.classNumber > o.classNumber) {
			return 1;
		}
		// 자기 자신의 classNumber o의 classNumber 같다면 0
		else if(this.classNumber == o.classNumber) {
			return 0;
		}
		// 자기 자신의 classNumber o의 classNumber 작다면 음수
		else {
			return -1;
		}

        /**
         * 간편한(위의 조건보다 단축된) 방법(뺄셈 연산 수행 시 int 범위로 인한 overflow(값 반전)이 발생 하여 버그 발생 가능성 있음)
        **/
		// return o1.classNumber - o2.classNumber;
	}
}
```

> 익명 클래스를 활용한 Comparator 인터페이스 구현 예제

```java
import java.util.Comparator;

public class Test {
	public static void main(String[] args)  {

		Student a = new Student(17, 2);	// 17살 2반
		Student b = new Student(18, 1);	// 18살 1반
		Student c = new Student(15, 3);	// 15살 3반

        Comparator<Student> comp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.classNumber - o2.classNumber;
            }
        };

		// comp 익명객체를 통해 b와 c객체를 비교한다.
		int isBig = comp.compare(b, c);

		if(isBig > 0) {
			System.out.println("b객체가 c객체보다 큽니다.");
		}
		else if(isBig == 0) {
			System.out.println("두 객체의 크기가 같습니다.");
		}
		else {
			System.out.println("b객체가 c객체보다 작습니다.");
		}

	}
}

// 외부에서 익명 객체로 Comparator가 생성되기 때문에 클래스에서 Comparator을 구현 할 필요가 없어진다.
class Student {

	int age;			// 나이
	int classNumber;	// 학급

	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}

}
```

## Comparable & Comparator와 Java 정렬의 관계

### 사용자 정의 정렬이 가능하다.

Java에서는 Arrays.sort(), Collections.sort()와 같은 정렬에서의 기본 정렬 값은 오름차순이다.
내림차순을 하기 위해서는 Comparable의 compareTo()나 Comparator의 compare() 메소드를 재정의할 때 로직을 조금만 변경해주면 가능하다.
Comparator를 통한 예제만 확인해보겠다.

#### 오름차순에서의 두 수의 비교 결과에 따른 작동 방식

- 음수일 경우 : 두 원소의 위치를 교환 안함
- 양수일 경우 : 두 원소의 위치를 교환 함

#### 내림차순에서의 두 수의 비교 결과에 따른 작동 방식

- 음수일 경우 : 두 원소의 위치를 교환 함
- 양수일 경우 : 두 원소의 위치를 교환 안함

#### Comparator를 활용한 내림차순 정렬 예제

실제 compare() 메소드 재정의 부분에서 오름차순이였다면 o1 - o2를 해줬겠지만 내림차순 정렬이기때문에 순서를 바꾸어 o2 - o1을 하게되면 내림차순 정렬이 되는 것을 볼 수 있다.

ps. 아래 코드의 리스트는 사용자가 정의한 객체가 아닌 Java에서 사용하는 Integer형으로써 사실 Collections.sort(a, Comparator.reverseOrder());를 해주어도 내림차순 정렬을 할 수 있다!

```java
package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        a.add(1);
        a.add(5);
        a.add(4);
        a.add(7);
        a.add(6);

        Collections.sort(a, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
                // 아래 주석의 리턴 방법도 내림차순 정렬의 똑같은 결과
                // return o2.compareTo(o1);
            }

        });

        for (Integer s : a) {
            System.out.println(s); // 7 6 5 4 3 2 1
        }

    }
}
```

#### Comparator를 활용한 사용자 정의 오름차순 정렬 예제

아래 예제는 짧은 글자들을 우선하여 오름차순 정렬하는 예제이다.

```java
public class Main {
    public static void main(String[] args) {

        List<String> a = new ArrayList<>();
        a.add("bb");
        a.add("aa");
        a.add("f");
        a.add("g");
        a.add("c");
        a.add("d");
        a.add("e");

        Collections.sort(a, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                // 글자수가 다르다면 짧은 글자 우선 오름차순 정렬
                if (o1.length() - o2.length() != 0) {
                    return o1.length() - o2.length();
                } else { // 글자수가 같다면 오름차순 정렬
                    return o1.compareTo(o2);
                }
            }

        });

        for (String s : a) {
            // c d e f g aa bb
            System.out.println(s);
        }

    }
}
```
