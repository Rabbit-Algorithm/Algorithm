package 바킹독_과제._4주차_백트래킹.암호만들기_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 암호 만들기
     * https://www.acmicpc.net/problem/1759
     * 골드5
     */

    private static int num;
    private static int size;

    private static char[] arr;
    private static char[] tmp;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());


        tmp = new char[num];
        arr = new char[size];
        visited = new boolean[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        dfs(0, 0, 0, '`');
        System.out.println(sb);


    }


    private static void dfs(int depth, int consonant, int gather, char before) {

        if (depth == num) {

            if (consonant >= 2 && gather >= 1) {
                for (char c : tmp) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < size; i++) {

            if (!visited[i] && arr[i] > before) {
                visited[i] = true;
                tmp[depth] = arr[i];
                if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                    dfs(depth + 1, consonant, gather + 1, arr[i]);
                } else {
                    dfs(depth + 1, consonant + 1, gather, arr[i]);
                }
                visited[i] = false;
            }
        }
    }


}
