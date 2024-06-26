import java.util.*;
import java.io.*;


public class Main {

    static int H,W;
    static int board[][];
    static int[] dx={0,-1,0,1};
    static int[] dy={-1,0,1,0};
    static int ans,time;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine().trim());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        board = new int[H][W];
        for(int i=0;i<H;i++){
            st= new StringTokenizer(br.readLine().trim());
            for(int j=0;j<W;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        melt();

        System.out.println(time);
        System.out.println(ans);







    }
    private static void air() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[H][W];
        board[0][0] = 9;
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int now[] = q.poll();
            int y = now[0];
            int x = now[1];
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (!(ny >= 0 && ny < H && nx >= 0 && nx < W) || visited[ny][nx] || board[ny][nx] == 1) continue;
                board[ny][nx] = 9;
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});

            }

        }
    }
        private static void melt() {

            while (true) {
                int thisTimeCnt = 0;
                air();
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {

                        if (board[i][j] == 1) {
                            for (int d = 0; d < 4; d++) {
                                int ny = i + dy[d];
                                int nx = j + dx[d];
                                if ((ny >= 0 && ny < H && nx >= 0 && nx < W) && board[ny][nx] == 9) {
                                    board[i][j] = 2;

                                    break;
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (board[i][j] == 2) {
                            board[i][j] = 9;
                            thisTimeCnt++;
                        }
                    }
                }
//                for (int i = 0; i < H; i++) {
//                    System.out.println(Arrays.toString(board[i]));
//                }
//                System.out.println();
                if (thisTimeCnt == 0) {
                    break;
                } else {
                    time++;
                    ans = thisTimeCnt;
                }
            }


        }
    }

