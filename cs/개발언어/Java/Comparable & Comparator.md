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
Comparator 인터페이스는 Comparable 인터페이스와 같이 객체를 정렬하는 데 사용되는 인터페이스입니다.
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

## Comparable & Comparator와 정렬의 관게

### 사용자 정의 정렬 가능
