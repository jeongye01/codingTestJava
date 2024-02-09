import java.util.*;
import java.io.*;

public class Main {
  static int N,M;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    boolean erased[] = new boolean[N+1];
    int cnt=0;
    while(true){
      for(int j=2;j<=N;j++){
         if( !erased[j]){
           erased[j]=true;
           cnt++;
           if(cnt==M){
              System.out.println(j);
              return;
            }
           for(int k=j;k<=N;k+=j){
             if(!erased[k]){
               erased[k]=true;
                cnt++;
                if(cnt==M){
                  System.out.println(k);
                  return;
                }
             }
           }
           
           
         }
       
      }
    }
   
    
  
  }

}