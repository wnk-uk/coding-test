package tree;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  최대점수 구하기
 *
 * 설명
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
 *
 * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
 *
 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
 *
 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 *
 *
 * 입력
 * 첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
 *
 * 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
 *
 *
 * 출력
 * 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
 *
 * */

public class Example2 {

    static int max, n = 0;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        max = sc.nextInt();


        int[] ch = new int[n];
        int[] ch2 = new int[n];


        for (int i = 0; i < n; i++) {
            ch[i] = sc.nextInt();
            ch2[i] = sc.nextInt();
        }

        Example2 example = new Example2();

        example.DFS(0,0,0, ch, ch2);
        System.out.println(answer);

    }

    private void DFS(int L, int sum, int mit, int[] arr, int[] arr2) {
        if (mit > max) return;
        if (L == n) {
            answer=Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L], mit + arr2[L], arr, arr2); //푼다
            DFS(L + 1, sum, mit, arr, arr2); //안푼다
        }

    }


}
