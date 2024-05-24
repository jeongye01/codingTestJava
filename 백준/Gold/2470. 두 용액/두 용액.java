import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine().trim());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int s=0;
        int e=N-1;
        int min=Integer.MAX_VALUE;

        int a=0;
        int b=0;
        while(s<e){
            int abssum = Math.abs(arr[e]+arr[s]);
            if(abssum<min){
                min=abssum;
                a=arr[s];
                b=arr[e];

            }
            int gap1 = Math.abs(arr[e-1]+arr[s]);
            int gap2 = Math.abs(arr[e]+arr[s+1]);
           if(gap1>gap2){
               s++;
           }else{
               e--;
           }

        }
        System.out.println(a+" "+b);

    }



}