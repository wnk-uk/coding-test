import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon15903 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        st = new StringTokenizer(br.readLine());
        for (long i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        while (m != 0) {
            long x = pq.poll();
            long y = pq.poll();

//            if (x == y) {
//                ArrayList<Integer> tmpL = new ArrayList<>();
//                while (!pq.isEmpty()) {
//                    int tmp =pq.poll();
//                    if (x != tmp) y = tmp;
//                    else tmpL.add(tmp);
//                }
//                for (int t : tmpL) pq.offer(t);
//            }

            pq.offer(x + y);
            pq.offer(x + y);
            m--;
        }

        long answer = 0;
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}
