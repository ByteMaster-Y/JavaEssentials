import java.io.*;
import java.net.*;
import java.util.*;

public class CalcServerEx {
    // 문자열로 받은 수식을 계산하는 메서드
    public static String calc(String exp) {
        // 공백(" ")을 기준으로 문자열을 토큰화 (ex: "3 + 5" → "3", "+", "5")
        StringTokenizer st = new StringTokenizer(exp, " "); // 파이썬의 split()
        
        // 입력된 연산식이 피연산자1, 연산자, 피연산자2의 형식이 아니라면 오류 반환
        /* "3 + 5"  →  ["3", "+", "5"]  →  3개의 토큰 (✅ 정상 연산식)
            "3 +"    →  ["3", "+"]      →  2개 (❌ 숫자 하나 빠짐, 에러)
            "3 + 5 2" → ["3", "+", "5", "2"] → 4*/
        if (st.countTokens() != 3) return "error";
        
        String res = ""; // 결과를 저장할 변수
        int op1 = Integer.parseInt(st.nextToken()); // 첫 번째 피연산자
        String opcode = st.nextToken(); // 연산자 (+, -, *)
        int op2 = Integer.parseInt(st.nextToken()); // 두 번째 피연산자
        
        // 연산자에 따른 연산 수행
        switch (opcode) {
            case "+": res = Integer.toString(op1 + op2); // 덧셈
                break;
            case "-": res = Integer.toString(op1 - op2); // 뺄셈
                break;
            case "*": res = Integer.toString(op1 * op2); // 곱셈
                break;
            default: res = "error"; // 정의되지 않은 연산자일 경우 "error" 반환
        }
        return res; // 계산 결과 반환
    } 
    
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter out = null;
        ServerSocket listener = null;
        Socket socket = null;
        
        try {
            // 서버 소켓 생성 (9999번 포트에서 클라이언트 연결 대기)
            listener = new ServerSocket(9999);
            System.out.println("연결을 기다리고 있습니다.....");
            
            // 클라이언트의 연결 요청을 수락
            socket = listener.accept();
            System.out.println("연결되었습니다.");
            
            // 입력 및 출력 스트림 생성
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트에서 데이터를 읽음
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트로 데이터를 보냄
            
            while (true) {
                // 클라이언트로부터 한 줄의 문자열 입력 받기
                String inputMessage = in.readLine();
                
                // 클라이언트가 "bye"를 입력하면 종료
                if (inputMessage.equals("bye")) {
                    System.out.println("클라이언트에서 연결을 종료하였음");
                    break;
                }
                
                // 클라이언트가 보낸 연산식을 출력
                System.out.println("입력된 연산식: " + inputMessage);
                
                // 계산 수행
                String res = calc(inputMessage);
                
                // 결과 전송
                out.write(res + "\n");
                out.flush();
            }
        } catch(IOException e) {
            System.out.println("오류 발생: " + e.getMessage());
        } finally {
            try {
                // 소켓 및 서버 소켓 닫기 (자원 정리)
                if(socket != null) socket.close();
                if(listener != null) listener.close();
            } catch (IOException e) {
                System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
            }
        }
    }
}
