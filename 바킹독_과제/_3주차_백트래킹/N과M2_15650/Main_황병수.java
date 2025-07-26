package 바킹독_과제._3주차_백트래킹.N과M2_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int N,M;
    static int[] AList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        AList = new int[N];

        Backtracking(1, 0);
        System.out.println(sb);
    }

    private static void Backtracking(int now, int depth) {

        // 탈출 조건
        if (depth == M) {
            for (int i = 0; i < M ; i++) {
                sb.append(AList[i]).append(" ");
            }
            sb.append("\n");
            return;
        }


        // 루프
        for (int i = now; i <= N; i++) {
            AList[depth] = i;
            Backtracking(i + 1,depth + 1);
        }

    }
}
