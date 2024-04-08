import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1374 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arr);

        PriorityQueue<Long> q = new PriorityQueue<>();

        int answer = 1;

        for (int i = 0; i < N; i++) {
            while (!q.isEmpty() && q.peek() <= arr.get(i).s) {
                q.poll();
            }

            q.offer(arr.get(i).e);
            answer = Math.max(answer, q.size());

        }
        System.out.println(answer);
    }

    public static class Lecture implements Comparable<Lecture>{
        long n;
        long s, e;

        public Lecture(long... args) {
            n = args[0];
            s = args[1];
            e = args[2];
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.s != o.s) return (int) (this.s - o.s);
            else return (int) (this.e - o.e);
        }

        @Override
        public String toString() {
            return "Lecture{" +
                    "n=" + n +
                    ", s=" + s +
                    ", e=" + e +
                    '}';
        }
    }

}
