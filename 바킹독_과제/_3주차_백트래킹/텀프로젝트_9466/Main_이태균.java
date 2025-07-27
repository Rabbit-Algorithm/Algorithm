package 바킹독_과제._3주차_백트래킹.텀프로젝트_9466;

import java.io.*;
import java.util.*;

public class Main_이태균 {
    private static int T;
    private static int N;
    private static int[] ARR;
    private static boolean[] VISITED;
    private static boolean[] CYCLED;
    private static int COUNT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            ARR = new int[N + 1];
            VISITED = new boolean[N + 1];
            CYCLED = new boolean[N + 1];
            COUNT = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                ARR[i] = Integer.parseInt(st.nextToken());
            }

            for (int node = 1; node <= N; node++) {
                if (!VISITED[node]) {
                    dfs(node);
                }
            }

            System.out.println(N - COUNT);
        }
    }

    private static void dfs(int node) {
        VISITED[node] = true;
        int next = ARR[node];

        if (!VISITED[next]) {
            dfs(next);
        }
        
        if (!CYCLED[next]) {
            COUNT++;
            for (int i = next; i != node; i = ARR[i]) {
                COUNT++;
            }
        }

        CYCLED[node] = true;
    }
}
