import java.util.*;
import java.io.*;

public class Main {
    static class Line implements Comparable<Line> {
        int s;
        int e;
        public Line(int s,int e){
            this.s=s;
            this.e=e;
        }
        public int compareTo(Line o){
            return  this.e-o.e;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine().trim());
        int[] lines = new int[N];
        List<Line> tmp = new ArrayList<>();


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine().trim());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            tmp.add(new Line(s,e));


        }
        Collections.sort(tmp);
        int idx=0;
        for(Line line : tmp){
            lines[idx]=line.s;
            idx++;
        }
        int[] dp= new int[N];
        dp[0]=1;
        int ans=1;
        for(int i=1;i<N;i++){
            int max=0;
            for(int j=i-1;j>=0;j--){
                if(lines[j]<lines[i] && dp[j]>max) {
                    max=dp[j];
                }
            }
            dp[i] = max+1;
            ans = Math.max(ans, max+1);

        }
        System.out.println(N-ans);

    }



}