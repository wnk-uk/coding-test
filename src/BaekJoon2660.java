import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2660 {
    static ArrayList<ArrayList<Integer>> arr;
    static Integer[] dy;
    static int[] v;
    static int sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        dy = new Integer[N + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            v = new int[N + 1];
            BFS(i);
        }

        int min = Collections.min(Arrays.asList(dy));
        int answer = 0;
        PriorityQueue pq = new PriorityQueue();
        for (int i = 1; i < dy.length; i++) {
            if (dy[i] == min) {
                answer++;
                pq.offer(i);
            }
        }

        System.out.println(min + " " + answer);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

    }

    private static void BFS(int i) {
        Queue<Integer> q = new LinkedList<>();
        v[i] = 1;
        q.offer(i);
        int L = 1;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int k = 0; k < len; k++) {
                int p = q.poll();
                for (int x : arr.get(p)) {
                    if (v[x] == 0) {
                        v[x] = 1;
                        dy[i] = L;
                        q.offer(x);
                    }
                }
            }
            L++;
        }
    }
}
