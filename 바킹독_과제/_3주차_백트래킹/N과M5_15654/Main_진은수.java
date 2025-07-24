package 바킹독_과제._3주차_백트래킹.N과M5_15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * N과 M(5)
     */

    private static int num;
    private static int size;
    private static boolean[] visited;
    private static int[] answers;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        num = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        visited = new boolean[num];
        arr = new int[num];
        answers = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

    }


    private static void dfs(int depth) {

        if (depth == size) {

            for (int value : answers) {
                System.out.print(value + " ");
            }
            System.out.println();

            return;
        }


        for (int i = 0 ; i < num ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answers[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }

    }

}
