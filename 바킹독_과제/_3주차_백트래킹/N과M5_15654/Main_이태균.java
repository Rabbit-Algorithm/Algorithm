package 바킹독_과제._3주차_백트래킹.N과M5_15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N;
    private static int M;
    private static int[] LIST;
    private static int[] ARR;
    private static boolean[] VISITED;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        LIST = new int[N];
        VISITED = new boolean[N];
        ARR = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            LIST[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(LIST);

        backtracking(0);
        System.out.print(SB);
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                SB.append(ARR[i]).append(" ");
            }
            SB.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                ARR[depth] = LIST[i];
                backtracking(depth + 1);

                VISITED[i] = false;
            }
        }
    }

}
