import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int[] arr = new int[N];
        ArrayList<Integer> perm[] = new ArrayList[N];
        for (int i=0;i<N;i++){
            perm[i] = new ArrayList<>();
        }
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int ansIdx=0;
        int maxLen=1;
        dp[0]=1;
        perm[0].add(arr[0]);
        for(int i=1;i<N;i++){
            int maxIdx=i;
            dp[i]=1;
            for(int j=i-1;j>=0;j--){

                if(arr[i]>arr[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        maxIdx = j;
                    }


                }
            }


            for(int n:perm[maxIdx]){
                perm[i].add(n);
            }

            perm[i].add(arr[i]);
            if(dp[i]>maxLen){
                maxLen=dp[i];
                ansIdx=i;
            }


        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[ansIdx]).append('\n');

        for(int n:perm[ansIdx]){
            sb.append(n).append(' ');
        }
        System.out.println(sb);



    }


}

