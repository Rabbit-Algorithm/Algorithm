package 바킹독_과제._3주차_백트래킹.텀프로젝트_9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수 {

    /**
     * solve 못하고 정답 봤음
     * 텀 프로젝트
     * https://www.acmicpc.net/problem/9466
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int test = Integer.parseInt(br.readLine());

        for (int t = 0; t < test; t++) {
            solve(br);
        }

    }

    private static int num;
    private static int count;
    private static int[] arr;
    private static boolean[] visited;
    private static boolean[] check;


    private static void solve(BufferedReader br) throws IOException {

        num = Integer.parseInt(br.readLine());
        count = 0;

        arr = new int[num+1];
        visited = new boolean[num+1];
        check = new boolean[num+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= num; i++) {
            if (!check[i]) {
                dfs(i);
            }
        }

        System.out.println(num - count);

    }

    // check < 전체 확인 (= 사이클 구성 완료 확인)
    // visit < 사이클 확인 (= 내부에서 방문 확인)
    private static void dfs(int index) {
        if (check[index]) {
            return;
        }

        if (visited[index]) {  // 핵심 : 한번 방문 visit 체크 한 경우 카운트 = 사이클 형성
            count++; // 사이클 노드 visited 배열 총 2번 방문 체크, 사이클 실패 노드는 visited 배열 1번 방문
            check[index] = true;
        }


        visited[index] = true;
        dfs(arr[index]);
        check[index] = true;  // 사이클 실패에 대한 방문 처리 = 사이클 실패한 노드는 절대 다시 사이클 형성이 안 된다.
        visited[index] = false;


    }

    /**
     * [[ 처음 시도한 풀이법 ]]
     * 처음 dfs로 풀려다 사이클 판단 하는 알고리즘 생각 못함
     * union find로 풀려고 했는데 동일한 사유로 못 품
     * union find는 무 방향에서만 사용 가능. 해당 문제는 방향이 있음.
     */

}