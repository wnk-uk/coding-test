import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9461 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long arr[] = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i < 101; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(arr[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb.toString());



    }


}
