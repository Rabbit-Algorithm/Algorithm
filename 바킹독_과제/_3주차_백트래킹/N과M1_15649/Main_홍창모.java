package 바킹독_과제._3주차_백트래킹.N과M1_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static boolean[] VISITED;

    static int[] MAP;

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAP = new int[M];
        VISITED = new boolean[N];

        backtracking(0);

    }

    private static void backtracking(int depth) {

        if( depth == M ) {
            // 탈출
            for( int num : MAP ) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for( int i = 0; i < N; i++ ) {
            if( !VISITED[i]  ) {
                MAP[depth] = i+1;
                VISITED[i] = true;
                backtracking(depth + 1);
                VISITED[i] = false;
            }
        }
    }
}
