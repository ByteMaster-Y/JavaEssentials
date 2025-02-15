import java.io.*;

public class BinaryCopy {
    public static void main(String[] args) {
        // MacOS의 다운로드 폴더에 있는 이미지 파일을 복사하는 예제
        File src = new File(System.getProperty("user.home") + "/Downloads/img.png"); // 사용자의 홈 디렉토리를 가져옴
        File dest = new File(System.getProperty("user.home") + "/Downloads/back.png");

        int c;
        try {
            /*
            src 파일(img.png)을 바이트 단위로 읽기 위한 스트림 생성
            바이너리 파일(이미지, 영상, 음악 파일 등) 처리에 적합
            파일이 존재하지 않으면 FileNotFoundException 예외 발생
            */
            FileInputStream fi = new FileInputStream(src);
            FileOutputStream fo = new FileOutputStream(dest);

            while ((c = fi.read()) != -1) {
                fo.write((byte) c);
            }

            fi.close();
            fo.close();
            System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
        } catch (IOException e) {
            System.out.println("파일 복사 오류: " + e.getMessage());
        }
    }
}
