import java.util.Scanner;
 
public class Main {
    public static final int MAX = 100000;
    
    public static String str;
    public static int[] numCountArr;
    public static long strLen;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str= sc.nextLine();
        
        strLen = str.length();
        numCountArr = new int[10];
        long total = 0;
        for(int i=0; i < strLen; i++) {
            int tNum = Integer.parseInt(str.substring(i, i+1));
            numCountArr[tNum] += 1;
            total+=tNum;
        }
        
        // 0이 존재하지 않으면 30 배수 조차도 될 수 없다.
        // 각 자리수의 총 합이 3의 배수가 아니면 종료해야한다.
        if(!str.contains("0") || total % 3 != 0) {
            System.out.println("-1");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            while(numCountArr[i] > 0) {
                sb.append(i);
                numCountArr[i]--;
            }
        }
        System.out.println(sb.toString());
    }
}
 