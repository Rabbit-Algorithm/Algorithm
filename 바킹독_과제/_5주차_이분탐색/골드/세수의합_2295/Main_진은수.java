package 바킹독_과제._5주차_이분탐색.골드.세수의합_2295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 세 수의 합
     * https://www.acmicpc.net/problem/2295
     * 골드4
     */

    private static int num;
    private static long max = 0;
    private static long[] arr;
    private static boolean[] visited;
    private static Set<Long> set = new HashSet<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        arr = new long[num];
        visited = new boolean[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(br.readLine());
            set.add(arr[i]);
        }

        dfs(0, -1, 0);

        System.out.println(max);

    }

    private static void dfs(int depth, int before, long sum) {

        if (depth == 3) {

            if (set.contains(sum)) {
                max = Math.max(max, sum);
            }
            return;
        }

        for (int i = before + 1; i < num; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i, sum + arr[i]);
                visited[i] = false;
            }
        }


    }


}
