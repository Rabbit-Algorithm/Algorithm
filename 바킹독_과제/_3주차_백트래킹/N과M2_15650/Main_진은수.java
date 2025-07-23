package 바킹독_과제._3주차_백트래킹.N과M2_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * N과 M(2)
     */

    private static int num;
    private static int size;
    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        num = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        visited = new boolean[num+1];
        arr = new int[size];


        dfs(0, 0);


    }


    private static void dfs(int depth, int beforeValue) {

        if (depth == size) {

            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();

            return;
        }


        for (int i = 1 ; i <= num ; i++) {
            if (!visited[i] && i > beforeValue) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth+1, i);
                visited[i] = false;
            }
        }

    }

}
