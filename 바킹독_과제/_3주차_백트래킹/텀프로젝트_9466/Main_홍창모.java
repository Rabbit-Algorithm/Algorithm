package 바킹독_과제._3주차_백트래킹.텀프로젝트_9466;
/*
* 1. cycle 개념 확인
* 2. BFS 형식으로도 풀어보기
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int T, COUNT;
    static int[] LIST;
    static boolean[] VISITED, CYCLE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for( int i = 0; i < T; i++ ) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            LIST = new int[n + 1];
            VISITED = new boolean[n + 1];
            CYCLE = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for( int j = 1; j <= n; j++ ) {
                LIST[j] = Integer.parseInt(st.nextToken());
            }


        }
    }
}
