import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        int arr[] = new int[N];
        int nge[] = new int[N];
        nge[N-1]=-1;
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        stk.add(arr[N-1]);
        for(int i=N-2;i>=0;i--){
           while(!stk.isEmpty()){
               if(stk.peek()>arr[i]){
                   nge[i]=stk.peek();
                   break;
               }else{
                   stk.pop();
               }
           }
           stk.add(arr[i]);
           if(nge[i]==0)nge[i]=-1;

        }
        for(int i=0;i<N;i++){
            sb.append(nge[i]).append(' ');
        }
        System.out.println(sb);




    }
}