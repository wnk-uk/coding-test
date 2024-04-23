import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon5972 {

    static ArrayList<ArrayList<Road>> arr;
    static int[] v, dy;
    static int N, M, answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new int[N + 1];
        dy = new int[N + 1];

        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.get(a).add(new Road(b, c));
            arr.get(b).add(new Road(a, c));
        }

        answer = Integer.MAX_VALUE;
        BFS();
        System.out.println(answer);

    }

    private static void BFS() {
        PriorityQueue<Road> pq = new PriorityQueue<Road>((o1, o2) -> o1.c - o2.c);
        pq.offer(new Road(1, 0));

        while (!pq.isEmpty()) {
            Road curr = pq.poll();
            int end = curr.e;
            int cost = curr.c;

            if (end == N) answer = Math.min(answer, dy[end]);

            for (Road r : arr.get(end)) {
                if (dy[r.e] > dy[end] + r.c) v[r.e] = 0;
                if (v[r.e] == 0) {
                    v[r.e] = 1;
                    dy[r.e] = dy[end] + r.c;
                    pq.offer(new Road(r.e, dy[r.e]));
                }
            }
        }
    }

    public static class Road {
        int e, c;

        public Road(int e, int c) {
            this.e = e;
            this.c = c;
        }


    }

}
