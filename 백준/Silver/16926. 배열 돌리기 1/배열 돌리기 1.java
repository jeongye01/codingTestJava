import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int arr[][];

    private static void rotate() {
        int min = Math.min(N, M) / 2;

        for (int layer = 0; layer < min; layer++) {
            int rst = layer;
            int red = N - 1 - layer;
            int cst = layer;
            int ced = M - 1 - layer;

            int corner = arr[rst][cst];

            // Rotate top edge
            for (int i = cst; i < ced; i++) {
                arr[rst][i] = arr[rst][i + 1];
            }

            // Rotate right edge
            for (int i = rst; i < red; i++) {
                arr[i][ced] = arr[i + 1][ced];
            }

            // Rotate bottom edge
            for (int i = ced; i > cst; i--) {
                arr[red][i] = arr[red][i - 1];
            }

            // Rotate left edge
            for (int i = red; i > rst; i--) {
                arr[i][cst] = arr[i - 1][cst];
            }

            arr[rst + 1][cst] = corner;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            rotate();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}