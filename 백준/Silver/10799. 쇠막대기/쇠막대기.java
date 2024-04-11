import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       int ans=0;
       char[] chs = br.readLine().trim().toCharArray();
       int N =chs.length;
       Stack<Integer> stk = new Stack<>();
       for(int i=0;i<N;i++){
           if(chs[i]=='('){
               if(chs[i+1]==')'){
                   if(!stk.isEmpty()){
                   int cnt = stk.pop()+1; // 레이저 수
                   stk.push(cnt);
                   }
                   i++;
               }else{
                   stk.add(0);

               }
           }else{ // chs[i]==')'
               int cnt = stk.pop();
               ans+=(cnt+1); // 조각 개수


               if(!stk.isEmpty()){

                   stk.push(stk.pop()+cnt);
               }
           }

       }

        System.out.println(ans);
    }
}