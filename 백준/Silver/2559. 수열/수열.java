import javax.print.Doc;
import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long max=0;
        long sum=0;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine().trim());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<K;i++){
            sum+=arr[i];
        }
        max=sum;
        for(int i=K;i<N;i++){
          sum+=arr[i];
          sum-=arr[i-K];
          if(sum>max){
              max=sum;
          }
        }

        System.out.println(max);
    }



}