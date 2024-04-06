import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon11497 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }

            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int k = 0; pq.size() > 0; k++) {
                if (k % 2 == 0) list.addFirst(pq.poll());
                else list.addLast(pq.poll());
            }

            int min = Integer.MIN_VALUE;

            for (int v = 0; v < list.size(); v++) {
                int idx = v + 1;
                if (v == list.size() - 1)  idx = 0;
                min = Math.max(min, Math.abs(list.get(v) - list.get(idx)));
            }

            System.out.println(min);
        }
    }



}
