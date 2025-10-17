package 문제풀이.DP.자두나무_2240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int T, W;

    static int[][][] DP;
    static int[] TREE_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        TREE_LIST = new int[T+1];
        DP = new int[T+1][W+1][3];

        for (int i = 1; i <= T; i++) {
            TREE_LIST[i] = Integer.parseInt(br.readLine());
        }

        for( int i = 1; i <= T; i++ ) {
            for (int j = 0; j <= W; j++) {
                if( j == 0 ) {
                    // 처음 위치는 1번 나무 아래
                    DP[i][0][1] = DP[i-1][0][1] + (TREE_LIST[i] == 1 ? 1 : 0);
                } else {
                    // 1번 나무 아래
                    DP[i][j][1] = Math.max(DP[i-1][j][1], DP[i-1][j-1][2]) + (TREE_LIST[i] == 1 ? 1 : 0);
                    // 2번 나무 아래
                    DP[i][j][2] = Math.max(DP[i-1][j][2], DP[i-1][j-1][1]) + (TREE_LIST[i] == 2 ? 1 : 0);
                }
            }
        }

        int answer = 0;
        for (int j = 0; j <= W; j++) {
            answer = Math.max(answer, Math.max(DP[T][j][1], DP[T][j][2]));
        }

        System.out.println(answer);
    }
}
