import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *
 * 최소 회의실 개수
 *
 * */
public class BaekJoon17828 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Meet> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr.add(new Meet(s, e));
        }

        Collections.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int i = 0; i < arr.size(); i++) {
            while (!pq.isEmpty() && pq.peek() <= arr.get(i).s) {
                pq.poll();
            }
            pq.offer(arr.get(i).e);
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }

    public static class Meet implements Comparable<Meet> {
        int s, e;

        public Meet(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Meet o) {
            return this.s - o.s;
        }
    }
}
