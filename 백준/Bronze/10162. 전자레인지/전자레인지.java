import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int T=Integer.parseInt(br.readLine().trim()); // 굽는 시간
	    int ab=0,bb=0,cc=0; // ab-> a버튼 조작횟수, bb-> b버튼 조작횟수, cb-> c버튼 조작횟수,
	    if(T%10!=0) {// 10으로 나눠떨어지는 경우 굽는 시간을 정확히 맞출 수 없다.
	    	  System.out.println(-1);
	    }
	    else {
	    	ab+=T/300; // 5분 조작횟수
		    T%=300;
		    bb+=T/60; //1분 조작획수
		    T%=60;
		    cc+=T/10; //10초 조작횟수 
		    System.out.println(ab+" "+bb+" "+cc); // 정답 출력
	    }
	    
	    

	}

}