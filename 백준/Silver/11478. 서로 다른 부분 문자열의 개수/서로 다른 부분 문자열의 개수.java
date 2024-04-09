import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       Set<String> set = new HashSet<>();
       String str = br.readLine().trim();
       int N=str.length();

           for(int j=1;j<=N;j++){
               for(int i=0;i<N;i++){
               if(i+j>N)break;
               set.add(str.substring(i,i+j));
           }
       }
        
        System.out.println(set.size());

    }


}