package 바킹독_과제._4주차_백트래킹.NQueen_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_진은수3 {

    /**
     * N-Queen
     * https://www.acmicpc.net/problem/9663
     * 골드4
     */

    private static int num;
    private static int count = 0;
    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        visited = new boolean[num];
        arr = new int[num];

        dfs(0);

        System.out.println(count);
    }

    /**
     * 2번째 풀이에서는 공격 가능 여부를 각 x좌표 위치를 모두 정해놓고 확인했다.
     * 3번쨰 풀이에서는 해당 depth 1~num 순간 순간 마다 가능 여부를 확인했다.
     */

    private static void dfs(int depth) {

        if (depth == num) {
            count++;
            return;
        }

        for (int x = 0; x < num; x++) {
            if (!visited[x]) {
                visited[x] = true;
                arr[depth] = x;
                if (checkAttack(depth)) {
                    dfs(depth + 1);
                }
                visited[x] = false;
            }
        }
    }

    private static boolean checkAttack(int depth) {

        for (int y2 = 0 ; y2 < depth ; y2++) {

            int x = arr[depth];

            int diff = depth - y2;
            int x2Point = arr[y2];

            // 대각선 -> 아래
            if (x-diff == x2Point) {
                return false;
            }

            // 대각선 -> 위
            if (x+diff == x2Point) {
                return false;
            }

        }

        return true;

    }

}
