import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] cycle;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        N = Integer.parseInt(st.nextToken());  // 배열의 행 개수
        M = Integer.parseInt(st.nextToken());  // 배열의 열 개수
        K = Integer.parseInt(st.nextToken());  // 회전 연산 개수

        map = new int[N][M];

        // 초기 배열 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cycle = new int[K][3];

        // 회전 연산 입력 받기
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            cycle[k][0] = Integer.parseInt(st.nextToken()) - 1;  // 회전 중심 행 인덱스
            cycle[k][1] = Integer.parseInt(st.nextToken()) - 1;  // 회전 중심 열 인덱스
            cycle[k][2] = Integer.parseInt(st.nextToken());       // 회전 반경
        }

        permutation(0, new int[K], new boolean[K]);

        System.out.printf("%d", min);
    }

    public static void permutation(int cnt, int[] arr, boolean[] visited) {
        if (cnt == K) {
            doCycle(arr);  // 순열을 통해 구한 회전 연산 순서대로 회전 수행
            return;
        }
        for (int i = 0; i < K; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i;
            permutation(cnt + 1, arr, visited);
            visited[i] = false;
        }
    }

    public static void doCycle(int[] arr) {
        int[][] tmp = copyMap();  // 현재 배열 복사하여 작업 수행

        // 각 회전 연산 수행
        for (int k = 0; k < K; k++) {
            int r = cycle[arr[k]][0];
            int c = cycle[arr[k]][1];
            int S = cycle[arr[k]][2];

            for (int s = 1; s <= S; s++) {
                // 위
                int upTmp = tmp[r - s][c + s];
                for (int y = c + s; y > c - s; y--) {
                    tmp[r - s][y] = tmp[r - s][y - 1];
                }
                // 오른쪽
                int rightTmp = tmp[r + s][c + s];
                for (int x = r + s; x > r - s; x--) {
                    tmp[x][c + s] = tmp[x - 1][c + s];
                }
                tmp[r - s + 1][c + s] = upTmp;
                // 아래
                int leftTmp = tmp[r + s][c - s];
                for (int y = c - s; y < c + s; y++) {
                    tmp[r + s][y] = tmp[r + s][y + 1];
                }
                tmp[r + s][c + s - 1] = rightTmp;
                // 왼쪽
                for (int x = r - s; x < r + s; x++) {
                    tmp[x][c - s] = tmp[x + 1][c - s];
                }
                tmp[r + s - 1][c - s] = leftTmp;
            }
        }

        getAnswer(tmp);  // 회전을 마친 배열의 합을 계산하여 결과 업데이트
    }

    public static int[][] copyMap() {
        int[][] tmp = new int[N][M];

        // 기존 배열을 복사하여 새로운 배열 생성
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        return tmp;
    }

    public static void getAnswer(int[][] tmp) {
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += tmp[i][j];  // 각 행의 합을 계산하여 최소값을 업데이트
            }
            if (min > sum) min = sum;
        }
    }
}