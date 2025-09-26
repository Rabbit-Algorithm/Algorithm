package 문제풀이.DFS.알파벳_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int[] DX = {-1, 1, 0, 0};
    static int[] DY = {0, 0, -1, 1};

    static int R, C, ANSWER = Integer.MIN_VALUE;
    static char[][] MAP;
    static boolean[][] VISITED;
    static HashSet<Character> HISTORY = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        MAP = new char[R][C];
        VISITED = new boolean[R][C];

        for( int i = 0; i < R; i++ ) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                MAP[i][j] = str.charAt(j);
            }
        }

        HISTORY.add(MAP[0][0]);
        dfs(0,0, 1);

        System.out.println( ANSWER );
    }

    private static void dfs(int row, int col, int depth) {
        ANSWER = Math.max(ANSWER, depth);

        for (int i = 0; i < 4; i++) {
            int nextRow = row + DX[i];
            int nextCol = col + DY[i];

            if (nextRow >= 0 && nextCol >= 0 && nextRow < R && nextCol < C) {
                char nextChar = MAP[nextRow][nextCol];

                if (!HISTORY.contains(nextChar)) {
                    HISTORY.add(nextChar);
                    dfs(nextRow, nextCol, depth + 1);
                    // 백트래킹: 상태 복원
                    HISTORY.remove(nextChar);
                }
            }
        }
    }
}
