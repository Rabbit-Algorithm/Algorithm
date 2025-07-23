package 바킹독_과제._3주차_백트래킹.N과M5_15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {
    static int N, M;
    static boolean[] VISITED;
    static int[] MAP;
    static int[] LIST;
    static StringBuilder SB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAP = new int[N];
        LIST = new int[M];
        VISITED = new boolean[N];
        SB = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            MAP[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬처리
        Arrays.sort(MAP);

        backtracking(0);
        System.out.println(SB);
    }

    private static void backtracking(int depth) {
        if( depth == M ) {
            for( int num : LIST ) {
                SB.append(num).append(" ");
            }
            SB.append("\n");
            return;
        }

        for( int i = 0; i < N; i++ ) {
            if( !VISITED[i] ) {
                VISITED[i] = true;
                LIST[depth] = MAP[i];
                backtracking(depth + 1);
                VISITED[i] = false;
            }
        }
    }
}
