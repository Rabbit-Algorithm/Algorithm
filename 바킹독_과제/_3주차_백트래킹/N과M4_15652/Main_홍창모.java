package 바킹독_과제._3주차_백트래킹.N과M4_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, M;
    static boolean[] VISITED;
    static int[] MAP;

    static StringBuilder SB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAP = new int[M];
        VISITED = new boolean[N];
        SB = new StringBuilder();

        backtracking(0,0);
        System.out.println(SB);
    }

    private static void backtracking(int curr, int depth) {
        if( depth == M ) {
            for( int num : MAP ) {
                SB.append(num).append(" ");
            }
            SB.append("\n");
            return;
        }

        for( int i = curr; i < N; i++ ) {
            MAP[depth] = i + 1;
            backtracking(i,depth + 1);
        }
    }
}
