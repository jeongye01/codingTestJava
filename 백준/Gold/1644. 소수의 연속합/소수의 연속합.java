import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    //    StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(br.readLine().trim());
        int ans=0;
        int sum=0;
        int n=0;
        Queue<Integer> q = new LinkedList<>();
        while(n<=N) {



            n++;


            if (isPrime(n)) {
                sum += n;
                if (sum == N) ans++;

                q.add(n);
            }
            while(sum>N){
                sum-=q.poll();
                if (sum == N) ans++;
            }

        }
        System.out.println(ans);


    }
    private static boolean isPrime(int n){
        if(n==1)return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)return false;
        }

        return true;
    }


}