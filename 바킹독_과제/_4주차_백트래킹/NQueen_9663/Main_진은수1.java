package 바킹독_과제._4주차_백트래킹.NQueen_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_진은수1 {

    /**
     * N-Queen
     * https://www.acmicpc.net/problem/9663
     * 골드4
     */

    /**
     * 문제 못 풀었음!
     *
     * 2차원 배열이 필요 없는 이유.
     * 체스 퀸는 가로,세로,대각선2 방향으로 움직인다.
     * 즉, 서로 공격하지 못하게 하려면 1행에 1개의 체스만 놓을수 있다.
     * 따라서 1차원 배열만 필요
     */

    private static int num;
    private static int count = 0;
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        map = new boolean[num][num];

        dfs(0);

        System.out.println(count);
    }

    private static void dfs(int depth) {

        if (depth == num) {
            count++;
            return;
        }

        for (int y = 0; y < num; y++) {
            for (int x = 0; x < num; x++) {

                if (!map[y][x]) {
                    map[y][x] = true;
                    if (!occupy(x, y)) {
                        dfs(depth + 1);
                    }
                }


            }
        }

    }

    private static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    private static boolean occupy(int x, int y) {

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            while (nx >= 0 && ny >= 0 && nx < num && ny < num ) {
                if (map[ny][nx]) {
                    return true;
                }

                nx += dx[i];
                ny += dy[i];
            }
        }

        return false;
    }



}
