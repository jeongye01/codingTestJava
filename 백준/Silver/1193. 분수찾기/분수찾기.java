// 다시 풀 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int X=Integer.parseInt(br.readLine());
		int n=0;
		int top=1;
		int bot=1;
		int cnt=0;
		if(X==1) {
			System.out.println("1/1");
		}else {
			while(cnt<X){
				n++;
				cnt=n*(n+1)/2; //몇번 째 행인지 찾는 코드
			}
			int num=X-(n-1)*n/2;  //행의 몇번 째 값인지 찾는 코드
			if(n%2==0) {  //짝수 행일 시 
				top=num;
				bot=n-num+1;
			}else {
				top=n-num+1;
				bot=num;
			}
			System.out.println(top+"/"+bot);
		}
		
	}
}