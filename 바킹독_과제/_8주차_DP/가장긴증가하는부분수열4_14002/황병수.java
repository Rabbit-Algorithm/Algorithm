package _8주차_DP.가장긴증가하는부분수열4_14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 황병수 {

    static int[] numList;
    static int[] dp;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        numList = new int[N + 1];
        dp = new int[N + 1];
        prev = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;
        int maxIndex = 0;

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; j++) {
                if(numList[j] < numList[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if(dp[i] > maxLength) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }

        System.out.println(maxLength);

        // 수열 구하기
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int idx = maxIndex;
        while (idx != -1) {
            stack.push(numList[idx]);
            idx = prev[idx];
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

}
