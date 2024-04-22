import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class BaekJoon2668 {

    static int[] arr;
    static int[] v;
    static int N, s;
    static Set<Integer> set = new TreeSet<>();
    static Set<Integer> answer = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
        }

        for (int i = 1; i <= N; i++) {
            s = i;
            v = new int[101];
            set = new TreeSet<>();
            DFS(i);
        }

        System.out.println(answer.size());
        for (int x : answer) {
            System.out.println(x);
        }

    }

    private static void DFS(int i) {
        v[i] = 1;
        int next = arr[i];
        set.add(i);

        //싸이클
        if (s == next) {
            answer.addAll(set);
            return;
        } else {
            if (v[next] == 0) {
                v[next] = 1;
                DFS(next);
            }
        }


    }

}
