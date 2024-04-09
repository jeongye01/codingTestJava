import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine().trim());
       int[] arr=new int[N];
       StringTokenizer st = new StringTokenizer(br.readLine().trim());
       for(int i=0;i<N;i++){
           arr[i] = Integer.parseInt(st.nextToken());
       }
       int x = Integer.parseInt(br.readLine().trim());
       int cnt=0;
       int s=0;
       int e=N-1;
       Arrays.sort(arr);
       while(s<e){
           int sum = arr[s]+arr[e];
           if(sum==x){
               cnt++;
               s++;
           }else if(sum>x){
               e--;
           }else{
               s++;
           }
       }
        System.out.println(cnt);

    }

}