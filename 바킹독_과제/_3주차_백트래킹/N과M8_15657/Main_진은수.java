package 바킹독_과제._3주차_백트래킹.N과M8_15657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * N과 M(8)
     */

    private static int num;
    private static int size;
    private static int[] answers;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        num = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        arr = new int[num];
        answers = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, -1);

        System.out.println(sb);

    }


    private static void dfs(int depth, int before) {

        if (depth == size) {

            for (int value : answers) {
                sb.append(value).append(" ");
            }
            sb.append("\n");

            return;
        }


        for (int i = 0; i < num; i++) {
            if (arr[i] >= before) {
                answers[depth] = arr[i];
                dfs(depth + 1, arr[i]);
            }

        }
    }


}
