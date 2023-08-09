import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (o1, o2) -> {
                    if (Math.abs(o1) == Math.abs(o2)) {
                        return o1 > o2 ? 1 : -1;
                    } else {
                        return Math.abs(o1) - Math.abs(o2);
                    }
                }
        );

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now == 0) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else queue.add(now);
        }

        System.out.println(sb);

    }
}