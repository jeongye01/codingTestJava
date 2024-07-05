import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int[][] arr;
    static class Node implements   Comparable<Node>{
        int y;
        int x;
        int cost;
        public int compareTo(Node o){
            return this.cost - o.cost;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T=0;
        while(true){
            T++;
            N = Integer.parseInt(br.readLine().trim());
            if(N==0)break;
            arr = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine().trim());
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            sb.append("Problem ").append(T).append(": ").append(solve()).append('\n');
        }

        System.out.println(sb);


    }
    private static int solve(){
        int dx[]={0,-1,0,1};
        int dy[]={-1,0,1,0};
        PriorityQueue<Node> q = new PriorityQueue<>();
        int cost[][] = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[0][0] = arr[0][0];
        Node start = new Node();
        start.x=0;
        start.y=0;
        start.cost=arr[0][0];
        q.add(start);
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.y ==N-1 && now.x==N-1){
                return now.cost;
            }
            for(int d=0;d<4;d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(ny<0 || ny>=N || nx<0 || nx>=N )continue;
                int newCost = now.cost+arr[ny][nx];
                if(newCost >= cost[ny][nx]) continue;
                Node newNode = new Node();
                newNode.y = ny;
                newNode.x= nx;
                newNode.cost = newCost;

                q.add(newNode);
                cost[ny][nx] = newCost;

            }


        }



        return -1;
    }



}