import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1080 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] price = new int[M];
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(br.readLine());
            price[i] = x;
        }
        Arrays.sort(price);

        long maxPrice = 0;
        long index = Long.MIN_VALUE;
        for (int i = 0; i < price.length; i++) {
            int count = (price.length - i);
            int tmpPrice = price[i] * (count <= N ? count : N);
            if (maxPrice < tmpPrice) {
                index = price[i];
                maxPrice = tmpPrice;
            }
        }

        System.out.println(index + " " + maxPrice);

    }

}
