package Object;

public class MathEx {
    public static void main(String[] args) {
        System.out.println(Math.abs(-3.14));
        System.out.println(Math.sqrt(9.0));
        System.out.println(Math.exp(2)); // 자연상수 e의 제곱
        System.out.println(Math.round(3.14));

        // 1,45 사이의 정수형 난수 5개 발생
        System.out.println("이번주 행운의 번호는"); 
        for (int i = 0; i < 5; i++) {
            System.out.println((int)(Math.random()*45 + 1) + " ");
        }
    }
}
