package 바킹독_과제._3주차_백트래킹.N과M2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N;
    private static int M;
    private static int[] LIST;
    private static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        LIST = new int[M];
        VISITED = new boolean[N + 1];

        backtracking(0, 0);
    }

    private static void backtracking(int node, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(LIST[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = node + 1; i <= N; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                LIST[depth] = i;
                backtracking(i, depth + 1);

                VISITED[i] = false;
            }
        }
    }

}
