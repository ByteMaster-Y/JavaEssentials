public class Main {
    public static void main(String[] args) {
        // Circle pizza = new Circle();
        // pizza.radius = 10;
        // pizza.name = "자바피자";
        // double area = pizza.getArea();
        // System.out.println(pizza.name + " 의 면적은 " + area);

        // 두 개으 생성자 서클 클래스
        Circle pizza = new Circle(10, "자바피자");
        double area = pizza.getArea();
        System.out.println(pizza.name+"의 면적은"+area);
    }
}
