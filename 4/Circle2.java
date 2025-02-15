public class Circle2 {
    int radius;
    void set(int r) { radius = r;}
    public double getArea() {
        return 3.14 * radius * radius;
    }
    public static void main(String[] args) {
        Circle2 pizza = new Circle2();
        pizza.set(5);
        System.out.println(pizza.getArea());
    }
}
