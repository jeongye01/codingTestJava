import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int K;
    private static int sizeR, sizeC;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("./res/input03.txt")); // 파일 입출력을 위한 셋팅
        // 입출력을 위한 버퍼 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 출력할 정답을 담을 변수 선언
        StringBuilder answer = new StringBuilder();
        // 입력을 공백 단위로 나눠줄 토크나이저 객체 선언
        StringTokenizer tok;
        //K 입력 받음
        K = Integer.parseInt(br.readLine());
        // 접는 방향을 Kx2만큼 입력받음
        tok = new StringTokenizer(br.readLine());
        String[] fold = new String[2 * K];
        for (int i = 0; i < 2 * K; i++)
            fold[i] = tok.nextToken();
        // 구멍의 위치 를 입력바음
        int punch = Integer.parseInt(br.readLine());
        // 초기 셋팅
        sizeR = 1; 
        sizeC = 1;
        map = new int[1][1];
        map[0][0] = punch;
        // 접은 것의 역순으로 핀다.
        for(int i=2*K-1;i>=0;i--) {
            if(fold[i].equals("U"))
                unfoldUp(); // 위로 접었던것을 아래로 피는 함수
            else if(fold[i].equals("D"))
                unfoldDown(); // 아래로 접었던 것을 위로 피는 함수
            else if(fold[i].equals("R"))
                unfoldRight(); // 오른 쪽으로 접었던 것을 왼쪽으로 피는 함수
            else
                unfoldLeft(); // 왼쪽으로 접었던 것을 오른쪽으로 피는 함수
        }
        // 춮력 내용 생성
        for(int i=0;i<sizeR;i++) {
            for(int j=0;j<sizeC;j++) {
                answer.append(map[i][j]).append(" ");
            }
            answer.append("\n");
        }
        // 출력
        bw.write(answer.toString());
        bw.flush();
        // 입출력 버퍼 닫기
        br.close();
        bw.close();
    }

    private static void unfoldUp() { // 위로 접었던 것을 아래로 핀다.
        sizeR *= 2; // 배열의 크기는 세로가 두배가 된다.
        int[][] tmap = new int[sizeR][sizeC]; // 새로운 배열을 생성한다.
        for(int i=0;i<sizeR/2;i++)for(int j=0;j<sizeC;j++) { // 배열을 채워넣는다.
            tmap[i][j] = map[i][j];
            if(map[i][j] == 0) { // 0번 구멍은 2번 구멍이 된다.
                tmap[sizeR-1-i][j] = 2;
            }else if(map[i][j] == 1) { // 1번 구멍은 3번 구멍이 된다.
                tmap[sizeR-1-i][j] = 3;
            }else if(map[i][j] == 2) { // 2번 구멍은 0번 구멍이 된다.
                tmap[sizeR-1-i][j] = 0;
            }else if(map[i][j] == 3) { // 3번 구멍은 1번 구멍이 된다.
                tmap[sizeR-1-i][j] = 1;
            }
        }
        map = tmap; // 맵을 새 배열로 바꾼다.
    }

    private static void unfoldDown() { // 아래로 접었던 것은 위로 핀다.
        sizeR *= 2;
        int[][] tmap = new int[sizeR][sizeC];
        for(int i=0;i<sizeR/2;i++)for(int j=0;j<sizeC;j++) {
            tmap[i+sizeR/2][j] = map[i][j];
            if(map[i][j] == 0) {
                tmap[sizeR/2-1-i][j] = 2;
            }else if(map[i][j] == 1) {
                tmap[sizeR/2-1-i][j] = 3;
            }else if(map[i][j] == 2) {
                tmap[sizeR/2-1-i][j] = 0;
            }else if(map[i][j] == 3) {
                tmap[sizeR/2-1-i][j] = 1;
            }
        }
        map = tmap;
    }

    private static void unfoldRight() { // 오른쪽으로 접었던 것은 왼쪽으로 핀다.
        sizeC *= 2;
        int[][] tmap = new int[sizeR][sizeC];
        for(int i=0;i<sizeR;i++)for(int j=0;j<sizeC/2;j++) {
            tmap[i][j+sizeC/2] = map[i][j];
            if(map[i][j] == 0) {
                tmap[i][sizeC/2-1-j] = 1;
            }else if(map[i][j] == 1) {
                tmap[i][sizeC/2-1-j] = 0;
            }else if(map[i][j] == 2) {
                tmap[i][sizeC/2-1-j] = 3;
            }else if(map[i][j] == 3) {
                tmap[i][sizeC/2-1-j] = 2;
            }
        }
        
        map = tmap;
    }

    private static void unfoldLeft() { // 왼쪽으로 접었던 것은 오른쪽으로 핀다.
        sizeC *= 2;
        int[][] tmap = new int[sizeR][sizeC];
        for(int i=0;i<sizeR;i++)for(int j=0;j<sizeC/2;j++) {
            tmap[i][j] = map[i][j];
            if(map[i][j] == 0) {
                tmap[i][sizeC-1-j] = 1;
            }else if(map[i][j] == 1) {
                tmap[i][sizeC-1-j] = 0;
            }else if(map[i][j] == 2) {
                tmap[i][sizeC-1-j] = 3;
            }else if(map[i][j] == 3) {
                tmap[i][sizeC-1-j] = 2;
            }
        }
        map = tmap;
    }
}