import java.io.File;
import java.text.SimpleDateFormat;

public class FileClassExample {
    public static void listDirectory(File dir) {
        System.out.println("----- " + dir.getPath() + " 의 서브 리스트 입니다. -----");

        File[] subFiles = dir.listFiles();
        if (subFiles != null) {
            for (File f : subFiles) {
                long t = f.lastModified(); // 마지막 수정 시간
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd EEE HH:mm:ss");
                
                System.out.print(f.getName());
                System.out.print("\t파일 크기: " + f.length()); // 파일 크기
                System.out.println("\t수정한 시간: " + sdf.format(t)); // 날짜 포맷 적용
            }
        }

        // 다운로드 폴더 내에 "java_sample" 폴더 만들기
        File f2 = new File(System.getProperty("user.home") + "/Downloads/java_sample");
        if (!f2.exists()) {
            f2.mkdir();
        }

        // 디렉토리 목록 출력
        listDirectory(new File(System.getProperty("user.home") + "/Downloads"));

        // 폴더 이름 변경: "java_sample" → "javasample"
        File renamedFile = new File(System.getProperty("user.home") + "/Downloads/javasample");
        if (f2.renameTo(renamedFile)) {
            System.out.println(f2.getName() + " → " + renamedFile.getName() + " 변경 성공");
        } else {
            System.out.println("이름 변경 실패");
        }

        // 다시 디렉토리 목록 출력
        listDirectory(new File(System.getProperty("user.home") + "/Downloads"));
    }

    public static void main(String[] args) {
        File f1 = new File(System.getProperty("user.home") + "/Downloads/system.ini");
        
        System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());

        String res = "";
        if (f1.isFile()) res = "파일";
        else if (f1.isDirectory()) res = "디렉토리";
        else res = "존재하지 않음";

        System.out.println(f1.getPath() + "은(는) " + res + "입니다.");

        // 다운로드 폴더 정보 출력
        listDirectory(new File(System.getProperty("user.home") + "/Downloads"));
    }
}
