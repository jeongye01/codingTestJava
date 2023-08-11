import java.io.*;
import java.util.*;

public class Solution {

	static int win = 0, lose = 0;
	static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
        	win = 0; lose = 0;
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cards0 = new int[9];
            int p[] = new int[9];
            int gyus[] =new int[19];
            for (int i = 0; i < 9; i++) {
                cards0[i]=Integer.parseInt(st.nextToken());
                gyus[cards0[i]]=1;
            }
            int k = 0;
            for (int i = 1; i <= 18; i++) {
                if (gyus[i]==0) {
                    p[k++] = i;
                }
 
            }
            do {
                judge(cards0,p);
             
            } while (np(p));
 
            printAnswer(tc);
 
        }
        System.out.println(sb);
 
    }
    public static void judge(int[] cards0,int[] p) {
    	   int user1 = 0, user2 = 0;
           for (int j = 0; j < 9; j++) {
               if (cards0[j] > p[j]) {
                   user1 += (cards0[j] + p[j]);
               }
               else if (cards0[j] < p[j]) {
                   user2 += (cards0[j] + p[j]);
               }

           }
           if (user1 > user2) {
               win++;
           }
           else if (user1 < user2) {
               lose++;
           }

    }
    public static boolean np(int[] p) {
        int N = 9;
        int i = N - 1;
        while (i > 0 && p[i - 1] >=p[i])
            --i;
        if (i == 0)
            return false;
        int j = N - 1;
        while (p[i - 1] >=p[j])
            --j;
        swap(p,i - 1, j);
        int k = N - 1;
        while (i < k) {
            swap(p, i++, k--);
        }
        return true;
    }
 
    public static void swap(int[] p ,int a, int b) {
        int temp = p[b];
        p[b] =p[a];
        p[a] = temp;
    }
    public static void printAnswer(int tc) {
        sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
    }
 
}