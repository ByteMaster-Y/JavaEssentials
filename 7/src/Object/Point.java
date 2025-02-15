package Object;

public class Point {
    private int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "Point(" + x + "," + y + ")";
    }
    public boolean equals(Object obj) { // 이 Point객체와 객체p가 같은지 비교
        Point p = (Point)obj; // obj를 Point타입으로 다운 캐스팅
        if(x == p.x && y == p.y) return true;
        else return false;
    }
}
