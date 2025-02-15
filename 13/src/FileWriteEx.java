import java.io.*;

public class FileWriteEx {
    public static void main(String[] args) {
        // 입력 스트림 생성
        InputStreamReader in = new InputStreamReader(System.in);
        
        // 파일 저장 경로 (맥북의 다운로드 폴더)
        String filePath = System.getProperty("user.home") + "/Downloads/output.txt";
        
        FileWriter fout = null;
        int c;
        
        try {
            fout = new FileWriter(filePath); // 파일 생성
            System.out.println("파일에 저장 중... (입력 후 Ctrl+D로 종료)");

            while ((c = in.read()) != -1) {  // 한 글자씩 읽기
                fout.write(c);
            }

            // 스트림 닫기
            in.close();
            fout.close();
            System.out.println("저장 완료! 파일 위치: " + filePath);

        } catch (IOException e) {
            System.out.println("입출력 오류 발생: " + e.getMessage());
        }
    }
}
