package vectorEx;

import java.util.*;


public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 4; i++) {
            System.out.println("이름을 입력하세요 >>");
            String s = scanner.next(); // 키보드로부터 이름 입력
            a.add(s);
        }
        for(int i = 0; i < a.size(); i++) {
            String name = a.get(i);
            System.out.println(name + " ");
        }
    }
}
