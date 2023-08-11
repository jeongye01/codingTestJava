import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int ans=0;
		while(N>2) {
			if(N%5==0) {
				ans+=N/5;
				N=0;
				break;
			}else{
				N-=3;
				ans++;
			}
		}
		System.out.println(N==0?ans:-1);
		

	}

}
