import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        int ans = 0;

        for (int i = 0; i < T; i++) {
            Stack<Character> stk = new Stack<>();
            char[] words = br.readLine().trim().toCharArray();
            for (char c : words) {
                if(!stk.isEmpty() && stk.peek().equals(c)){
                    stk.pop();
                }else{
                    stk.push(c);
                }
            }

           if(stk.isEmpty())ans++;

        }
        System.out.println(ans);

    }


}