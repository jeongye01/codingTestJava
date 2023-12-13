import java.io.*;
import java.util.*;

class Point {
    int y, x;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 좌하우상
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static int[] dx = new int[]{-1, 0, 1, 0};

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 17:52

        int N;
        int[][] arr;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /////////////////////////////////////////////////////////////////////////////

        // 좌하1번 우상2번 좌하3번 우상4번 좌하5번 우상6번 좌6번

        Point cur = new Point(N / 2, N / 2);

        for (int depth = 1; depth < N; depth++) {
            if (depth % 2 == 1) {
                for (int i = 0; i < depth; i++)
                    go(arr, cur, 0);
                for (int i = 0; i < depth; i++)
                    go(arr, cur, 1);
            } else {
                for (int i = 0; i < depth; i++)
                    go(arr, cur, 2);
                for (int i = 0; i < depth; i++)
                    go(arr, cur, 3);
            }
        }
        for (int i = 0; i < N - 1; i++)
            go(arr, cur, 0);

        System.out.println(answer);

    }

    public static void go(int[][] arr, Point cur, int direction) {

        // 좌하우상
        int weight = arr[cur.y + dy[direction]][cur.x + dx[direction]];
        int newY;
        int newX;

        //
        newY = cur.y + dy[direction] * 3;
        newX = cur.x + dx[direction] * 3;
        if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
            answer += weight * 5 / 100;
        } else {
            arr[newY][newX] += weight * 5 / 100;
        }

        // 방향이 0123 좌하우상
        // 좌우면
        if (direction % 2 == 0) {

            newY = cur.y + dy[direction] * 2;
            newX = cur.x + dx[direction] * 2;

            newY = cur.y + dy[(direction + 1) %4];
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 10 / 100;
            } else {
                arr[newY][newX] += weight * 10 / 100;
            }

            newY = cur.y + dy[(direction + 3) % 4];
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 10 / 100;
            } else {
                arr[newY][newX] += weight * 10 / 100;
            }
        } else {
            newY = cur.y + dy[direction] * 2;
            newX = cur.x + dx[direction] * 2;

            newX = cur.x + dx[(direction + 1) % 4];
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 10 / 100;
            } else {
                arr[newY][newX] += weight * 10 / 100;
            }

            newX = cur.x + dx[(direction + 3) % 4];
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 10 / 100;
            } else {
                arr[newY][newX] += weight * 10 / 100;
            }
        }

        // 방향이 0123 좌하우상
        // 좌우면
        if (direction % 2 == 0) {

            newY = cur.y + dy[direction] * 1;
            newX = cur.x + dx[direction] * 1;

            newY = cur.y + dy[(direction + 1) % 4] * 2;
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 2 / 100;
            } else {
                arr[newY][newX] += weight * 2 / 100;
            }

            newY = cur.y + dy[(direction + 3) % 4] * 2;
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 2 / 100;
            } else {
                arr[newY][newX] += weight * 2 / 100;
            }

            newY = cur.y + dy[(direction + 1) % 4] * 1;
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 7 / 100;
            } else {
                arr[newY][newX] += weight * 7 / 100;
            }

            newY = cur.y + dy[(direction + 3) % 4] * 1;
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 7 / 100;
            } else {
                arr[newY][newX] += weight * 7 / 100;
            }

        } else {
            newY = cur.y + dy[direction] * 1;
            newX = cur.x + dx[direction] * 1;

            newX = cur.x + dx[(direction + 1) % 4] * 2;
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 2 / 100;
            } else {
                arr[newY][newX] += weight * 2 / 100;
            }

            newX = cur.x + dx[(direction + 3) % 4] * 2;
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 2 / 100;
            } else {
                arr[newY][newX] += weight * 2 / 100;
            }

            newX = cur.x + dx[(direction + 1) % 4] * 1;
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 7 / 100;
            } else {
                arr[newY][newX] += weight * 7 / 100;
            }

            newX = cur.x + dx[(direction + 3) % 4] * 1;
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 7 / 100;
            } else {
                arr[newY][newX] += weight * 7 / 100;
            }
        }

        // 방향이 0123 좌하우상
        // 좌우면
        if (direction % 2 == 0) {

            newY = cur.y;
            newX = cur.x;

            newY = cur.y + dy[(direction + 1) % 4];
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 1 / 100;
            } else {
                arr[newY][newX] += weight * 1 / 100;
            }

            newY = cur.y + dy[(direction + 3) % 4];
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 1 / 100;
            } else {
                arr[newY][newX] += weight * 1 / 100;
            }
        } else {
            newY = cur.y;
            newX = cur.x;

            newX = cur.x + dx[(direction + 1) % 4];
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 1 / 100;
            } else {
                arr[newY][newX] += weight * 1 / 100;
            }

            newX = cur.x + dx[(direction + 3) % 4];
            if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
                answer += weight * 1 / 100;
            } else {
                arr[newY][newX] += weight * 1 / 100;
            }
        }

        newY = cur.y + dy[direction];
        newX = cur.x + dx[direction];
        arr[newY][newX] = 0;

        newY = cur.y + dy[direction] * 2;
        newX = cur.x + dx[direction] * 2;

        if (newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) {
            answer = answer + weight
                    - weight * 5 / 100
                    - weight * 10 / 100
                    - weight * 10 / 100
                    - weight * 2 / 100
                    - weight * 2 / 100
                    - weight * 7 / 100
                    - weight * 7 / 100
                    - weight * 1 / 100
                    - weight * 1 / 100;
        } else {
            arr[newY][newX] = arr[newY][newX] + weight
                    - weight * 5 / 100
                    - weight * 10 / 100
                    - weight * 10 / 100
                    - weight * 2 / 100
                    - weight * 2 / 100
                    - weight * 7 / 100
                    - weight * 7 / 100
                    - weight * 1 / 100
                    - weight * 1 / 100;
        }

        cur.y = cur.y + dy[direction];
        cur.x = cur.x + dx[direction];
    }
}