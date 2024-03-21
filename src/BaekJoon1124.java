import java.util.ArrayList;

public class BaekJoon1124 {

    static int answer = 0;

    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        //소수를 포함한 소인수분해된 자연수

        ArrayList<Integer> ch = new ArrayList<>();
        int[] primeArr = new int[b+1];

        for (int i = 2; i <= b; i++) {
            if (isPrime(i)) {
                ch.add(i);
                primeArr[i] = 1;
            }
        }

        for (int i = a; i <= b; i++) {
            int curr = i;
            int tmpCnt = 0;

            if (primeArr[curr] == 1) {
                continue;
            }

            for (int j : ch) {
                if (curr % j == 0) {
                    while (curr % j == 0) {
                        curr /= j;
                        tmpCnt++;
                    }
                }

                if (curr == 1) break;
            }

            if (primeArr[tmpCnt] == 1) {
                answer++;
            }

        }


        System.out.println(answer);

    }

    private static boolean isPrime(int i) {
        if (i == 1) return false;
        for (int j = 2; j < i; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}
