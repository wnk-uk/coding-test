import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon11000 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Assignment> arr = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Assignment(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }
        Collections.sort(arr);
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            while (!pq.isEmpty() && pq.peek() <= arr.get(i).s) {
                pq.poll();
            }
            pq.offer(arr.get(i).t);
            answer = Math.max(answer, pq.size());
        }
        System.out.println(answer);
    }

    public static class Assignment implements Comparable<Assignment> {
        long s, t;

        public Assignment (long s, long t) {
            this.s = s;
            this.t = t;
        }


        @Override
        public int compareTo(Assignment o) {
            return (int) (this.s - o.s);
        }
    }
}
