class Shape {  // ⬅ `public` 제거
    public void draw() {
        System.out.println("Shape");
    }
}

class Line extends Shape {
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    public void draw() {
        System.out.println("Rect");
    }
}

// class Circle extends Shape {
//     public void draw() {
//         System.out.println("Circle");
//     }
// }
// 이미 Circle 파일이 있어서 안됨!