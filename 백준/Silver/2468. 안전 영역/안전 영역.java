import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
 static int max=2;

	static int N;
	static int[][] board;
	static int[] dx={-1,0,1,0};
	static int[] dy={0,-1,0,1};
	static int ans;
	public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   N = Integer.parseInt(br.readLine().trim());
	   board = new int[N][N];
	   for(int i=0;i<N;i++){
		   st = new StringTokenizer(br.readLine().trim());
		   for(int j=0;j<N;j++){
			   board[i][j] = Integer.parseInt(st.nextToken());
			   max = Math.max(max,board[i][j]);

		   }
	   }
	   for(int h=0;h<=100;h++){
		   solve(h);
	   }
	   System.out.println(ans);
	}
	private static void solve(int h){

		boolean[][] visited = new boolean[N][N];
		int cnt=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){

				if(!visited[i][j] && board[i][j]>h){

					cnt+=1;
					bfs(h,i,j,visited);
				}
			}
		}

		ans=Math.max(ans,cnt);
	}
	private static void bfs(int h,int i,int j,boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
		visited[i][j]=true;
		q.add(new int[] {i,j});
		while(!q.isEmpty()){
			int[] now = q.poll();
			int y=now[0];
			int x=now[1];
			for(int d=0;d<4;d++){
				int ny=y+dy[d];
				int nx=x+dx[d];
				if(ny<0||ny>=N||nx<0||nx>=N||visited[ny][nx]||board[ny][nx]<=h)continue;
				visited[ny][nx]=true;
				q.add(new int[] {ny,nx});
			}
		}

	}
}