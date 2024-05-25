import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekJoonB {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = 0;

            if (x != 3) {
                y = Integer.parseInt(st.nextToken());
            }

            if (x == 1) {
                arr[y] = 1;
            } else if (x == 2) {
                arr[y] = 0;
            } else if (x == 3){
                bw.write((N - Arrays.stream(arr).sum()) + "\n");
            }
        }
        bw.flush();
    }
}
