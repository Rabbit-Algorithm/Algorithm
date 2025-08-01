package 바킹독_과제._4주차_백트래킹.부분수열의합_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수 {

    /**
     * 부분수열의 합
     * https://www.acmicpc.net/problem/1182
     * 실버2
     */

    private static int target;
    private static int count = 0;
    private static int num;
    private static int[] arr;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[num];
        visited = new boolean[num];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, -1);

        System.out.println(count);


    }


    private static void dfs(int depth, int sum, int before) {

        if (depth > 0 && sum == target) {
            count++;
        }

        if (depth == num) {
            return;
        }

        for (int i = before + 1; i < num; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, sum + arr[i], i);
                visited[i] = false;
            }

        }


    }


}
