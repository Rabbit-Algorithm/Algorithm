package 바킹독_과제._3주차_백트래킹.N과M3_15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N;
    private static int M;
    private static int[] LIST;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        LIST = new int[M];

        backtracking(0);
        System.out.print(SB);
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                SB.append(LIST[i]).append(" ");
            }
            SB.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            LIST[depth] = i;
            backtracking(depth + 1);
        }
    }

}
