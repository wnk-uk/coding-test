import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BaekJoon1715 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {System.out.println(0); return;}

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            int x = pq.poll();
            int y = 0;
            if (pq.size() > 1) {
                y = pq.poll();
                pq.offer(x + y);
            }
            answer += x + y;
        }

        System.out.println(answer);







    }

}
