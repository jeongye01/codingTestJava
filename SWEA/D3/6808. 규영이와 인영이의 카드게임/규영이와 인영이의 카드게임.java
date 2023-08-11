import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 

public class Solution {
    static int win, lose;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++) {
            win = 0;
            lose = 0;
            int[] gyu = new int[9];
            int[] iny = new int[9];
            int[] owner = new int[19];  // 1일경우 규영 0 일 경우 인영
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<9; i++) {
                int idx = Integer.parseInt(st.nextToken());
                gyu[i] = idx;
                owner[idx] = 1; 
            }
            int idx = 0;
            for(int i = 1; i<= 18; i++) {
                if(owner[i] == 0) iny[idx++] = i;
            }
             
            do {
                isWin(gyu, iny);
            }while(NP(iny));
            printAnswer(tc);
             
        }
        System.out.print(sb);
    }
     
    public static boolean NP(int[] p) {
        int N = p.length;
        int i = N - 1;
        while(i > 0 && p[i - 1] >= p[i]) --i;
        if(i == 0) return false;
         
        int j = N - 1;
        while(p[i-1] >= p[j]) --j;
         
        swap(p, i - 1, j);
         
        int k = N - 1;
        while(i < k)
            swap(p, i++, k--);
        return true;
    }
    public static void swap(int[] p, int a, int b) {
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }
     
    public static void isWin(int[] answer, int[] p) {
        int aScore = 0;
        int bScore = 0;
        for(int i = 0; i < 9; i++) {
            if(answer[i] > p[i])
                aScore += answer[i] + p[i];
            else if(answer[i] < p[i])
                bScore += answer[i] + p[i];
        }
        if(aScore > bScore) win++;
        else if(aScore < bScore) lose++;
    }
    public static void printAnswer(int tc) {
        sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
    }
}