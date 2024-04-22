import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon2251 {

    static Set<Integer> set = new TreeSet<>();
    static int[][][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        v = new int[201][201][201];
        BFS(A, B, C);

        for (int x : set) {
            System.out.print(x + " ");
        }

    }

    private static void BFS(int a, int b, int c) {
        Queue<Water> q = new LinkedList<>();
        q.offer(new Water(0, 0, c));

        while (!q.isEmpty()) {
            Water w = q.poll();

            int wa = w.a;
            int wb = w.b;
            int wc = w.c;
            if (v[wa][wb][wc] == 1) continue;
            v[wa][wb][wc] = 1;

            if (wa == 0) set.add(wc);

            //한 물통이 비거나, 다른 한 물통이 가득 찰 때까지 물을 부을 수 있다.
            // C -> A
            if (wc + wa >= a) q.offer(new Water(a, wb, wc - (a - wa)));
            else q.offer(new Water(wc + wa, wb, 0));
            // C -> B
            if (wc + wb >= b) q.offer(new Water(wa, b, wc - (b - wb)));
            else q.offer(new Water(wa, wc + wb, 0));

            // A -> B
            if (wa + wb >= b) q.offer(new Water(wa - (b - wb), b, wc));
            else q.offer(new Water(0, wa + wb, wc));
            // A -> C
            if (wa + wc >= c) q.offer(new Water(wa - (c - wc), wb, c));
            else q.offer(new Water(0, wb, wa + wc));

            // B -> A
            if (wb + wa >= a) q.offer(new Water(a, wb - (a - wa), wc));
            else q.offer(new Water(wa + wb, 0, wc));
            // B -> C
            if (wb + wc >= c) q.offer(new Water(wa, wb - (c - wc), c));
            else q.offer(new Water(wa, 0, wb + wc));
        }
    }

    public static class Water {
        int a,b,c;
        public Water(int... arr) {
            a = arr[0];
            b = arr[1];
            c = arr[2];
        }


    }



}
