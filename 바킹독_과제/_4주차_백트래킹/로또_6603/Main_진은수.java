package 바킹독_과제._4주차_백트래킹.로또_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 로또
     * https://www.acmicpc.net/problem/6603
     * 실버2
     */

    private static int num;
    private static int[] arr;
    private static int[] lottoArr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());

            if (num == 0) break;
            
            arr = new int[num];
            lottoArr = new int[6];
            visited = new boolean[num];
            
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            dfs(0, -1);
            sb.append("\n");

        }

        System.out.println(sb);
    }
    
    private static void dfs(int depth, int before) {
        
        if (depth == 6) {
            for (int i : lottoArr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = before+1; i < num; i++) {
            
            if (!visited[i]) {
                visited[i] = true;
                lottoArr[depth] = arr[i];
                dfs(depth + 1, i);
                visited[i] = false;
                
            }
            
        }
        
        
    }


}
