import java.io.*;
import java.net.*;
import java.util.*;

public class ServerEx {
    public static void main(String[] args) {
        BufferedReader in = null; // 클라이언트로부터 메시지를 읽는 스트림
        BufferedWriter out = null; // 클라이언트에게 메시지를 보내는 스트림
        ServerSocket listener = null; // 서버가 클라이언트의 연결을 기다릴 때 사용하는 소켓
        Socket socket = null; // 클라이언트가 연결되었을 때 사용되는 소켓
        Scanner scanner = new Scanner(System.in);
        try {
            listener = new ServerSocket(9999);
            System.out.println("연결을 기다리고 있습니다...");
            socket = listener.accept(); // 클라이언트로부터 연결 요청 대기
            System.out.println("연결되었습니다");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            /*
             socket.getInputStream() → 클라이언트가 보낸 데이터를 읽음
             InputStreamReader → 바이트 데이터를 문자(Character) 데이터로 변환
             BufferedReader → 입력을 효율적으로 읽기 위해 버퍼를 사용
             버퍼란? : 데이터를 읽고 쓰는 속도를 높이기 위해 임시 저장 공간을 활용하는 방식
             */
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while(true) {
                String inputMessage = in.readLine(); // 클라이언트로부터 한 행 읽기
                if (inputMessage.equalsIgnoreCase("bye")) {
                    System.out.println("클라이언트에서 bye로 연결을 종료하였음");
                    break;
                }
                System.out.println("클라이언트:" + inputMessage);
                System.out.println("보내기 >>> ");
                String outputMessage = scanner.nextLine();
                out.write(outputMessage + "\n"); 
                out.flush(); // out 스트림 버퍼에 있는 모든 문자열 전송

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                scanner.close();
                socket.close(); // 통신용 소켓 닫기
                listener.close(); // 서버 소켓 닫기
            } catch (IOException e) {
                System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
            }
        }
    }
}