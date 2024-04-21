import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1068 {

    static ArrayList<ArrayList<Integer>> arr;
    static int R, answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x != -1) arr.get(x).add(i);
            else root = i;
        }
        R = Integer.parseInt(br.readLine());

        if (R == root) {
            System.out.println(0);
            return;
        }

        BFS(root);
        System.out.println(answer);
    }

    private static void BFS(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int j = 0; j < len; j++) {
                int x = q.poll();
                if (x == R) continue;
                if (arr.get(x).size() == 0 || (arr.get(x).size() == 1 && arr.get(x).get(0) == R)) {
                    answer++; //자식 없으면 ++
                    continue;
                }
                for (int k : arr.get(x)) {
                    q.offer(k);
                }
            }
        }
    }
}
