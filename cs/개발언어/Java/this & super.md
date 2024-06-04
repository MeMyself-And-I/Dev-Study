# this & super

---

## this 참조 변수

- this 참조 변수는 인스턴스가 자기 자신을 참조하는데 사용하는 변수이다.
- this 참조 변수는 해당 인스턴스의 주소를 가리키고 있다.

> Car 클래스의 생성자 예제

```java
class Car {
    private String modelName;
    private int modelYear;
    private String color;
    private int maxSpeed;
    private int currentSpeed;

    Car(String modelName, int modelYear, String color, int maxSpeed) {
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0;
    }
}
```

1. 위 예제처럼 생성자의 매개변수와 인스턴스 변수의 이름이 같은 겨우에는 인스턴스 변수 앞에 this 키워드를 붙여 구분해야한다.
2. this 참조 변수를 사용할 수 있는 영역은 인스턴스 메소드뿐이고, 클래스 메소드(static)에서는 사용할 수 없다.
3. 모든 인스턴스 메소드에는 this 참조 변수가 숨겨져서 존재하고 있다.

## this() 메소드

- this() 메소드는 생성자 내부에서만 사용 가능하며, 같은 클래스의 다른 생성자를 호출할 때 사용
- this() 메소드에 인수를 전달하며, 생성자 중에 메소드 시그니처가 일치하는 다른 생성자를 찾아 호출해준다.

> Car 클래스의 this 참조 변수와 this() 메소드 사용 예제

```java
class Car {

    private String modelName;

    private int modelYear;

    private String color;

    private int maxSpeed;

    private int currentSpeed;

    Car(String modelName, int modelYear, String color, int maxSpeed) {
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0;
    }

    Car() {
        this("소나타", 2012, "검정색", 160); // 다른 생성자를 호출함.
    }

    public String getModel() {
        return this.modelYear + "년식 " + this.modelName + " " + this.color;
    }
}



public class Main {
    public static void main(String[] args) {
        Car tcpCar = new Car();
        System.out.println(tcpCar.getModel());
    }
}
```

1. 위 예제에서 매개변수를 가지는 첫 번째 생성자는 this 참조 변수를 사용하여 인스턴스 변수에 접근
2. 매개변수를 가지지 않는 두 번째 생성자는 생성자 내부에서 this() 메소드를 이용하여 첫 번째 생성자를 호출
3. 단, 한 생성자에서 다른 생성자를 호출할 때는 반드시 해당 생성자의 첫 줄에서만 호출할 수 있다.

## super 키워드

- super 키워드는 부모 클래스로부터 상속받은 필드, 메소드를 자식 클래스에서 참조하는 데 사용하는 참조 변수이다.
- 부모 클래스의 멤버와 자식 클래스의 멤버 이름이 같을 경우 super 키워드를 통해 구분하여 사용할 수 있다.
- this와 마찬가지로 super 참조 변수를 사용할 수 있는 대상도 인스턴스 메소드뿐이며, 클래스 메소드(static)에서는 사용할 수 없다.

> super 키워드 예제

```java
class Parent {
    int a = 10;
}

class Child extends Parent {

    int a = 20;

    void display() {
        System.out.println(a); // 20
        System.out.println(this.a); // 20
        System.out.println(super.a); // 10
    }
}



public class Inheritance03 {
    public static void main(String[] args) {
        Child ch = new Child();
        ch.display();
    }
}
```

1. 위 예제에서 int형 변수 num은 자식 클래스인 Child 클래스에서도 선언되어 있다.
2. 따라서 지역 변수와 this 참조 변수는 자식 클래스에서 대입된 값을 출력, super 참조 변수만 부모 클래스에서 대입된 값을 출력하게 된다.

## super() 메소드

- this() 메소드가 같은 클래스의 다른 생성자 호출이라면, super() 메소드는 부모 클래스의 생성자를 호출할 때 사용한다.
- 자식 클래스의 인스턴스를 생성하면, 해당 인스턴스에는 자식 클래스의 고유 멤버뿐만이 아닌 부모 클래스의 모든 멤버까지도 포함하고 있다.
- 따라서 부모 클래스의 멤버를 초기화하기 위해서는 자식 클래스의 생성자에서 부모 클래스의 생성자를 호출해야 한다.

만약 개발자가 자식 클래스의 생성자에서 부모 클래스의 생성자를 명시적을 호출해주지 않는다면, 모든 자식 클래스의 생성자 첫 줄에 자바 컴파일러가 자동으로 super() 명령문을 추가한다.

또한 자바 컴파일러는 컴파일 시 클래스에 생성자가 하나도 정의되어 있지 않아야만 자동으로 기본 생성자를 추가해준다.
하지만 개발자가 부모 클래스에서 매개변수를 가지는 생성자를 하나라도 선언했고, 매개변수가 없는 기본 생성자를 선언하지 않았다면, 컴파일러는 부모 클래스에 기본 생성자를 자동으로 추가하지 않는다.

따라서 아래 예제는 부모 클래스에 매개변수가 있는 생성자만 있기 때문에 오류가 발생한다

```java
class Parent {
    int a;

    Parent(int n) { a = n; } // 매개변수가 있는 생성자만 존재(이미 생성자가 존재하기 때문에 자바 컴파일러가 자동으로 기본 생성자를 추가해주지 않고, 개발자가 작성한 매개변수가 없는 기본 생성자가 없음)
}

class Child extends Parent {
    int b;

    Child() {
        super();
        b = 20;
    }
}
```

매개변수가 있는 생성자만 존재할 경우 아래와 같이 기본 생성자도 명시적으로 선언해야 한다.

```java
class Parent {
    int a;

    Parent() {a = 10;};
    Parent(int n) { a = n; } // 매개변수가 있는 생성자만 존재(이미 생성자가 존재하기 때문에 자바 컴파일러가 자동으로 기본 생성자를 추가해주지 않고, 개발자가 작성한 매개변수가 없는 기본 생성자가 없음)
}

class Child extends Parent {
    int b;

    Child() {
        super();
        b = 20;
    }
}
```

> super() 메소드 호출 예제

```java
class Parent {
    int a;

    Parent() { a = 10; }
    Parent(int n) { a = n; }
}

class Child extends Parent {
    int b;

    Child() {
        //super(40);
        b = 20;
    }

    void display() {
        System.out.println(a); // 10 출력
        System.out.println(b); // 20 출력
    }
}

public class Main {
    public static void main(String[] args) {
        Child ch = new Child();
        ch.display();
    }
}
```

1. 위 예제를 그냥 실행하면, 주석으로 인해 명시적으로 부모 클래스의 생성자를 호출하지 않기 떄문에 자바 컴파일러가 부모 클래스의 기본 생성자를 호출하여 a는 10으로 초기화된다.
2. 만약 주석 처리된 super(40)를 주석 해제하고 실행한다면, 부모 클래스인 Parent 클래스의 같은 메소드 시그니처를 가진 두 번째 생성자를 호출하여 a는 40으로 초기화된다.
