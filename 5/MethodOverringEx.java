public class MethodOverringEx {  // ⬅ `public` 유지 (이 파일의 이름이 MethodOverringEx.java여야 함)
    static void paint(Shape p) {
        p.draw(); // p가 가리키는 객체에 오버라이딩 된 draw() 호출 // 동적 바인딩
    }

    public static void main(String[] args) {
        Line line = new Line();
        paint(line);

        paint(new Shape());
        paint(new Line());
        paint(new Rect());
        // paint(new Circle());
    }
}