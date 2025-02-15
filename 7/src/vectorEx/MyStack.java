package vectorEx;

public class MyStack {
    public static void main(String[] args) {
        GStack<String> stirngStack = new GStack<String>();
        stirngStack.push("seoul");
        stirngStack.push("busan");
        stirngStack.push("LA");

        for(int n = 0; n < 3; n++) {
            System.out.println(stirngStack.pop());
        }
        GStack<Integer> intStack = new GStack<Integer>();
        intStack.push(1);
        intStack.push(3);
        intStack.push(5);

        for(int n = 0; n < 3; n++) {
            System.out.println(intStack.pop());
        }

    }
}
