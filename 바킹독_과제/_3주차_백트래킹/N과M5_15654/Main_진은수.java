package 바킹독_과제._3주차_백트래킹.N과M5_15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * N과 M(5)
     */

    private static int num;
    private static int size;
    private static boolean[] visited;
    private static int[] answer;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        num = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        visited = new boolean[num + 1];
        answer = new int[size];

        for (int i = 0 ; i < num ; i++) {
        }


        dfs(0,0);

        System.out.println(sb);

    }


    private static void dfs(int depth, int before) {

        if (depth == size) {

            for (int value : answer) {
                sb.append(value).append(" ");
            }

            sb.append("\n");


            return;
        }


        for (int i = 1; i <= num; i++) {
            if (i >= before) {
                answer[depth] = i;
                dfs(depth + 1, i);
            }

        }

    }

}
