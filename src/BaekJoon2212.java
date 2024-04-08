import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2212 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        int tmp = q.poll();
        while (!q.isEmpty()) {
            int x = q.poll();
            pq.offer(x - tmp);
            tmp = x;
        }

        int answer = 0;
        while (K > 1) {
            pq.poll();
            K--;
        }

        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);


    }

}
