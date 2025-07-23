package 바킹독_과제._3주차_백트래킹.N과M4_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * N과 M(4)
     */

    private static int num;
    private static int size;
    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        num = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        visited = new boolean[num + 1];
        arr = new int[size];


        dfs(0,0);

        System.out.println(sb);

    }


    private static void dfs(int depth, int before) {

        if (depth == size) {

            for (int value : arr) {
                sb.append(value).append(" ");
            }

            sb.append("\n");


            return;
        }


        for (int i = 1; i <= num; i++) {
            if (i >= before) {
                arr[depth] = i;
                dfs(depth + 1, i);
            }

        }

    }

}
