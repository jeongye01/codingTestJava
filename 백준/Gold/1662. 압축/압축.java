import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        Stack<String> stk = new Stack<>();  // 문자열의 길이도 스택에 함께 넣는다. 길이는 한자리를 넘어갈 수 있으므로 반드시 String 사용

        for(int i = 0; i < arr.length; i++) {
            if(!arr[i].equals(")")) {
                stk.push(arr[i]);  // ")" 등장할때마다 로직 수행. ")"전까지는 전부 스택에 담는다
            }else {
                int cnt = 0;
                while(!stk.peek().equals("(")) {  // 괄호를 풀기 위해 "(" 나올 때까지 pop 한다
                    String output = stk.pop();
                    if(output.equals("*")) {
                        int len = Integer.parseInt(stk.pop());
                        cnt += len;
                    }else {
                        cnt += 1;
                    }
                }
                stk.pop();  // "(" 제거
                int len = Integer.parseInt(stk.pop());
                cnt *= len;  // 압축 해제
                stk.push(String.valueOf(cnt));
                stk.push("*");  // "*" 밑에 있는 숫자는 문자열이 아니라 숫자의 길이를 나타냄
            }
        }

        int ans = 0;
        while(!stk.isEmpty()) {
            if(stk.peek().equals("*")) {
                stk.pop();
                ans += Integer.parseInt(stk.pop());
            }else {
                stk.pop();
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}