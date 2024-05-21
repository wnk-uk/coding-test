import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon15988 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[1000001];
        int[] tmp = new int[T];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        long max = 0;
        for (int i = 0; i < T; i++) {
            int x = Integer.parseInt(br.readLine());
            tmp[i] = x;
            max = Math.max(x, max);
        }

        for (int i = 4; i <= max; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]) % 1000000009;
        }

        for (int x : tmp) {
            System.out.println(arr[x]);
        }



    }

}
