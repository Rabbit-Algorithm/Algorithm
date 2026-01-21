package 문제풀이.DFS.단지번호붙이기_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_홍창모 {

    static int[] DX = {-1, 0, 1, 0};
    static int[] DY = {0, -1, 0, 1};

    static int N;
    static int[][] MAP;
    static boolean[][] VISITED;
    static List<Integer> ANSWER;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ANSWER = new ArrayList<>();
        VISITED = new boolean[N][N];
        MAP = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                MAP[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (MAP[i][j] == 1 && !VISITED[i][j]) {
                    int result = dfs(i, j);
                    ANSWER.add(result);
                }
            }
        }

        // 오름차순 정렬
        ANSWER.sort(null);

        System.out.println(ANSWER.size());

        for (int count : ANSWER) {
            System.out.println(count);
        }

    }

    private static int dfs(int row, int col) {
        VISITED[row][col] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + DX[i];
            int nextCol = col + DY[i];

            if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N) {
                if (MAP[nextRow][nextCol] == 1 && !VISITED[nextRow][nextCol]) {
                    count += dfs(nextRow, nextCol);
                }
            }
        }

        return count;
    }
}
