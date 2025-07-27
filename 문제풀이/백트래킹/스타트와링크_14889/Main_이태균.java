package 문제풀이.백트래킹.스타트와링크_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N;
    private static int[][] S;
    private static int[][] ABILITY;
    private static boolean[] VISITED;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        VISITED = new boolean[N];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                S[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        ABILITY = new int[N][N];
        for (int row = 0; row < N; row++) {
            for (int col = row + 1; col < N; col++) {
                int one = S[row][col];
                int two = S[col][row];
                ABILITY[row][col] = one + two;
            }
        }

        combo(0, 0);
        System.out.println(MIN);
    }

    private static void combo(int node, int depth) {
        if (depth == N / 2) {
            solve();
            return;
        }

        for (int i = node; i < N; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                combo(i + 1, depth + 1);
                VISITED[i] = false;
            }
        }
    }

    private static void solve() {
        int start_team = 0;
        int link_team = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (VISITED[i] && VISITED[j]) {
                    start_team += S[i][j];
                    start_team += S[j][i];
                } else if (!VISITED[i] && !VISITED[j]) {
                    link_team += S[i][j];
                    link_team += S[j][i];
                }
            }
        }

        int abs = Math.abs(start_team - link_team);

        MIN = Math.min(abs, MIN);
    }

}
