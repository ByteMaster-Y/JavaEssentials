import java.io.*;
import java.net.*;
import java.util.*;

public class ClientEx {
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter out = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            socket = new Socket("localhost", 9999); // 서버에 연결
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true) {
                System.out.print("보내기 >>> ");
                String outputMessage = scanner.nextLine();
                out.write(outputMessage + System.lineSeparator()); // OS에 맞는 줄바꿈 사용
                out.flush();

                if (outputMessage.equalsIgnoreCase("bye")) {
                    break;
                }

                String inputMessage = in.readLine(); // 서버에서 한 줄 읽기
                System.out.println("서버: " + inputMessage);
            }
        } catch (IOException e) {
            System.out.println("오류 발생: " + e.getMessage());
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
                scanner.close();
            } catch (IOException e) {
                System.out.println("서버와 채팅 중 오류가 발생했습니다.");
            }
        }
    }
}
