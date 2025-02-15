package Object;

public class WrapperEx {
    public static void main(String[] args) {
        System.out.println(Character.toLowerCase('A'));
        char c1 = '4', c2 = 'F';
        if(Character.isDigit(c1)) // 문자 1이 숫자이면 트루 
            System.out.println(c1 + " 는 숫자");
        if(Character.isAlphabetic(c2)) // 문자 2가 영문자이면 트루 
            System.out.println(c2 + " 는 영문자");
        
        // integer 사용
        System.out.println(Integer.parseInt("28")); // 문자열 28을 10진수로 변환
        System.out.println(Integer.toString(28)); // 정수 28일 이진수로
        System.out.println(Integer.toBinaryString(28)); // 28을 16진수 문자열로 변환
        System.out.println(Integer.bitCount(28)); // 28에 대한 2진수의 1의 개수
        Integer i = Integer.valueOf(28);
        System.out.println(i.doubleValue()); // 정수를 더블 값으로 변환

        // double 사용
        Double d = Double.valueOf(3.14);
        System.out.println(d.toString());
        System.out.println(Double.parseDouble("3.14"));

        // boolean 사용
        boolean b = (4>3); // b는 true
        System.out.println(Boolean.toString(b));
        System.out.println(Boolean.parseBoolean("false"));
    }
}
