class Person {
    public Person(String name) {}  // 명시적 생성자 추가
}

class Student extends Person {
    public Student() {
        super("default name");  // 부모 생성자 호출 필수
    }
}

class Researcher extends Person {
    public Researcher() {
        super("default name");
    }
}

class Professor extends Researcher {
    public Professor() {
        super();  // Researcher의 기본 생성자 호출
    }
}

public class InstanceOfEx {
    static void print(Person p) {
        if (p instanceof Person) {
            System.out.println("Person");
        }
        if (p instanceof Student) {
            System.out.println("Student");
        }
        if (p instanceof Researcher) {
            System.out.println("Researcher");
        }
        if (p instanceof Professor) {
            System.out.println("Professor");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("new Student() -> ");
        print(new Student());  // ✅ 수정된 생성자 사용
    
        System.out.println("new Researcher() -> ");
        print(new Researcher());  // ✅ 수정된 생성자 사용
    
        System.out.println("new Professor() -> ");
        print(new Professor());  // ✅ 수정된 생성자 사용
    }
}
