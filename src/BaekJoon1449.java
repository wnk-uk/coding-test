import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1449 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }

        Arrays.sort(arr);

        int answer = 0;
        int position = 0;
        int tape = 0;

        for (int i = 0; i < arr.length; i++) {
            position = arr[i];
            if (position > tape) {
                tape = position + l - 1;
                answer++;
            }
        }
        System.out.println(answer);

    }
}
