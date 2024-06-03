import java.io.*;
import java.util.*;
 
public class Main {
    public static class Lesson implements Comparable<Lesson>{
        int s, e;
        
        public Lesson (int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        // 수업 시작 시간을 오름차순 정렬
        // 수업 시작 시간이 같을 경우, 시작 마감 시간을 오름차순 정렬
        public int compareTo(Lesson o) {
            if (this.s == o.s) {
                return this.e - o.e;
            }
            
            return this.s - o.s;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine()); // 수업 개수
        Lesson[] lesson = new Lesson[N];
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            lesson[i] = new Lesson(S, E);
        }
        
        Arrays.sort(lesson);
        
        // 수업 마감 시간을 입력하기 위한 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lesson[0].e);
                
        for (int i=1; i<N; i++) {
            if (pq.peek() <= lesson[i].s) {
                pq.poll();
            }
            
            pq.add(lesson[i].e);
        }
        
        System.out.println(pq.size());
    }
}
