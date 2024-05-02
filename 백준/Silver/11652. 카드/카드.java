import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Map<Long,Integer> map =  new HashMap<>();

        for(int i=0;i<N;i++){
            long n = Long.parseLong(br.readLine().trim());
            Integer cnt = map.get(n);
            if(cnt!=null){
                map.put(n,cnt+1);

            }else{
                map.put(n,1);
            }

        }
        int ans=0;
        Long ansKey=Long.MAX_VALUE;

        Iterator iter = map.keySet().iterator();
        while (iter.hasNext()) {
           Long key = (Long) iter.next();
           int cnt = map.get(key);
           if(cnt>ans){
               ans = cnt;
               ansKey = key;
           }else if(cnt==ans){
               if(ansKey>key){
                   ansKey=key;
               }
           }
        }
        System.out.println(ansKey);
    }



}