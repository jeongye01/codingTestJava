import java.util.*;
import java.io.*;

// 행성계의 경계가 맞닿거나 서로 교차하는 경우는 없다.
// ans : 거쳐야 할 최소의 행성계 진입/이탈 횟수
public class Main {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for(int t=0;t<T;t++) {

            st = new StringTokenizer(br.readLine().trim());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(br.readLine().trim());

            int ans=0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(st.nextToken());
                int y =Integer.parseInt(st.nextToken());
                int r=Integer.parseInt(st.nextToken());
                boolean cod1 = (Math.pow((sx-x),2)+Math.pow((sy-y),2))<=r*r;
                boolean cod2 = (Math.pow((ex-x),2)+Math.pow((ey-y),2))<=r*r;
                if(!(cod1 && cod2)){
                    if(cod1 || cod2){
                        ans++;
                    }
                }
            }
            sb.append(ans).append('\n');


        }
        System.out.println(sb);
    }
}