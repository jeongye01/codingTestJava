import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 말은 게임판에 그려진 화살표의 방향대로만 이동할 수 있다.
// 말이 파란색 칸에서 이동을 시작하면 파란색 화살표를 타야 하고, 이동하는 도중이거나 파란색이 아닌 칸에서 이동을 시작하면 빨간색 화살표를 타야 한다.
// 말이 도착 칸으로 이동하면 주사위에 나온 수와 관계 없이 이동을 마친다.

// ans : 얻을 수 있는 점수의 최댓값
public class Main {

    static int ans;
    static int[][] board = {{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40},
            {10, 13, 16, 19, 25, 30, 35, 40},
            {20, 22, 24, 25, 30, 35, 40},
            {30, 28, 27, 26, 25, 30, 35, 40}};
    static int[] dice = new int[10];
    static Horse[] horses;

    static class Horse {
        int y, x;
        boolean goal = false;

        public Horse(int y, int x) {
            this.y = y;
            this.x = x;

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        horses = new Horse[4];
        for (int i = 0; i < 4; i++) {
            horses[i] = new Horse(0, -1);
        }

        solve(0, 0);

        System.out.println(ans);

    }

    public static void solve(int depth, int point) {

        if (depth == 10) {
            // 계산
            ans = Math.max(ans, point);
            return;
        }

//        ans = Math.max(ans, point);

        for (int i = 0; i < 4; i++) {
            if (!horses[i].goal) {

                int nx = horses[i].x + dice[depth];
                int ny = horses[i].y;

                if (nx >= board[ny].length) {
                    horses[i].goal = true; // 도착
                    solve(depth + 1, point);
                    horses[i].goal = false;
                } else {
                    // 10 일 경우
                    if (ny == 0 && nx == 4) {
                        ny = 1;
                        nx = 0;
                    }
                    // 20일 경우
                    else if (ny == 0 && nx == 9) {
                        ny = 2;
                        nx = 0;
                    }
                    // 30일 경우
                    else if (ny == 0 && nx == 14) {
                        ny = 3;
                        nx = 0;
                    }
                    // 40 공유해주기
                    else if (ny == 0 && nx == 19) {
                        ny = 3;
                        nx = 7;
                    } else if (ny == 1 && nx == 7) {
                        ny = 3;
                        nx = 7;
                    } else if (ny == 2 && nx == 6) {
                        ny = 3;
                        nx = 7;
                    }
                    // 35
                    else if (ny == 1 && nx == 6) {
                        ny = 3;
                        nx = 6;
                    } else if (ny == 2 && nx == 5) {
                        ny = 3;
                        nx = 6;
                    }
                    // 30
                    else if (ny == 1 && nx == 5) {
                        ny = 3;
                        nx = 5;
                    } else if (ny == 2 && nx == 4) {
                        ny = 3;
                        nx = 5;
                    }
                    // 25
                    else if (ny == 1 && nx == 4) {
                        ny = 3;
                        nx = 4;
                    } else if (ny == 2 && nx == 3) {
                        ny = 3;
                        nx = 4;
                    }


                    boolean check = true;
                    for (int j = 0; j < 4; j++) {
                        if (!horses[j].goal && i != j && horses[j].y == ny && horses[j].x == nx) {
                            check = false;
                            break;
                        }
                    }
                    if (!check)
                        continue;

                    int tx = horses[i].x;
                    int ty = horses[i].y;
                    horses[i].x = nx;
                    horses[i].y = ny;
                    solve(depth + 1, point + board[ny][nx]);
                    horses[i].x = tx;
                    horses[i].y = ty;

                }

            }
        }

    }

}