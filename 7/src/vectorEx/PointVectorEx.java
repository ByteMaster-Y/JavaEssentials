package vectorEx;

import Object.Point; // 추가해야 함
import java.util.Vector;

public class PointVectorEx {
    public static void main(String[] args) {
        Vector<Point> v = new Vector<Point>();

        // 3개의 포인트 객체 삽입
        v.add(new Point(2, 3));
        v.add(new Point(-5, 20));
        v.add(new Point(30, -8));

        v.remove(1); // 인덱스 1의 포인트(-5, 20) 삭제
        
        // 벡터에 있는 포인트 객체 모두 검색하여 출력
        for(int i = 0; i<v.size(); i++) {
            Point p = v.get(i);
            System.out.println(p);
        }
    }
}
