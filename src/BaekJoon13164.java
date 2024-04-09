import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/***
 * 
 *  행복 유치원
 * 
 * 
 */
public class BaekJoon13164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        long tmp = Long.parseLong(st.nextToken());
        for (int i = 0; i < N - 1; i++) {
            long x = Long.parseLong(st.nextToken());
            pq.offer(x - tmp);
            tmp = x;
        }

        long answer = 0;
        while (pq.size() > K - 1) {
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}
