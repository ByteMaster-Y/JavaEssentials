public class Circle {
    int radius; // 원의 반지름 필드
    String name; // 원의 이름을 필드

    // 두 개의 생성자를 가진 서클 클래스를 만들자
    public Circle() {
        radius = 1; name = "";
    }
    public Circle(int r, String n) {
        radius = r; name = n;
    }
    public double getArea() {
        return 3.14 * radius * radius;
    }
}
