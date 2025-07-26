package 바킹독_과제._3주차_백트래킹.N과M1_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_황병수 {

        static int N;
        static int M;
        static StringBuilder SB = new StringBuilder();
        static boolean[] VISITED;
        static int[] ARR;  // 선택된 숫자 저장용 배열
        public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        VISITED = new boolean[N + 1];
        ARR = new int[M];

        backtracking(0);
        System.out.println(SB);
    }

    private static void backtracking(int depth) {

        // 브레이크문
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                SB.append(ARR[i]).append(" ");
            }
            SB.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                ARR[depth] = i;
                backtracking(depth + 1);

                VISITED[i] = false;
            }
        }
    }
}
