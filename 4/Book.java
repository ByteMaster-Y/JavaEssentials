public class Book {
    String title;
    String auther;

    public Book(String t) {
        title = t; auther = "작자미상";
    }
    public Book(String t, String a) {
        title = t; auther = a;
    }
    // toString() 메소드 오버라이드
    // 객체를 더 직관적인 문자열로 출력하고 싶다면, toString() 메소드를 오버라이드(재정의) 해야 합니다. 
    // 예를 들어, Book 클래스에서 title과 author 값을 포함하는 문자열을 반환하도록 toString() 메소드를 정의할 수 있습니다.
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + auther;
    }
   

    public static void main(String[] args) {
        Book littlePrince = new Book("어린왕자", "셍텍쥐페리");
        Book loveStory = new Book("춘향전");
        
        // 객체를 출력하면 toString() 메소드가 호출됩니다.
        System.out.println(littlePrince); // Title: 어린왕자, Author: 셍텍쥐페리
        System.out.println(loveStory);    // Title: 춘향전, Author: 작자미상
    }
}
