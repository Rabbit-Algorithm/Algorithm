package 바킹독_과제._4주차_백트래킹.NQueen_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_진은수2 {

    /**
     * N-Queen
     * https://www.acmicpc.net/problem/9663
     * 골드4
     */


    /**
     * 테스트 케이스는 통과하지만 [시간초과!]
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


    private static void dfs(int depth) {

        if (depth == num) {
            checkAttack();
            return;
        }

        for (int i = 0; i < num; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void checkAttack() {
        boolean possible = true;

        for (int y = 0 ; y < num ; y++) {

            int x = arr[y];

            for (int y2 = 0 ; y2 < num ; y2++) {

                if (y == y2) {
                    continue;
                }

                int diff = y - y2;
                int x2Point = arr[y2];

                // 대각선 -> 아래
                if (x-diff == x2Point) {
                    possible = false;
                    break;
                }

                // 대각선 -> 위
                if (x+diff == x2Point) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                break;
            }
        }

        if (possible) {
            count++;
        }

    }

}
