import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];
        int[] dp_desc = new int[N];
        int[] dp_asc = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp_asc[0]=1;
        for(int i=1;i<N;i++){
            int max=0;
           for(int j=i-1;j>=0;j--){
               if(arr[j]<arr[i] && dp_asc[j]>max){
                  max = dp_asc[j];
               }
           }
           dp_asc[i]=max+1;
        }
        dp_desc[N-1]=1;
        for(int i=N-1;i>=0;i--){
            int max=0;
            for(int j=i+1;j<N;j++){
                if(arr[j]<arr[i] && dp_desc[j]>max){
                    max = dp_desc[j];
                }
            }
            dp_desc[i]=max+1;
        }
        int ans=0;
        for(int i=0;i<N;i++){
            ans=Math.max(dp_asc[i]+dp_desc[i],ans);
        }


        ans--;
        System.out.println(ans);

    }
}