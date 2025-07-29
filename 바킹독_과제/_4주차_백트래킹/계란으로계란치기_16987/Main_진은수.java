package 바킹독_과제._4주차_백트래킹.계란으로계란치기_16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 계란으로 계란치기
     * https://www.acmicpc.net/problem/16987
     * 골드5
     */

    private static int max = 0;
    private static int num;
    private static Egg[] eggs;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        eggs = new Egg[num];
        visited = new boolean[num];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dfs(0);
        System.out.println(max);

    }


    private static void dfs(int start) {

        if (start == num) {
            int count = 0;
            for (Egg egg : eggs) {
                if (egg.durability <= 0) {
                    count++;
                }
            }

            max = Math.max(max, count);
            return;
        }

        if (eggs[start].durability <= 0) {
            dfs(start+1);
            return; // 이부분 return을 하지 않았음, return하지 않으면 밑에 코드들이 동작하면 안되는데 동작함.
        }

        boolean notBroken = true;
        for (int i = 0; i < num; i++) {
            if (i != start && eggs[i].durability > 0) {
                notBroken = false;
                eggs[i].durability -= eggs[start].weight;
                eggs[start].durability -= eggs[i].weight;
                dfs(start+1);
                eggs[i].durability += eggs[start].weight;
                eggs[start].durability += eggs[i].weight;
            }

            // 계란을 칠수 있는게 없는 경우, 아래 코드가 없다면 위에 조건 체크 케이스 들이 동작하지 않음.
            // 따라서 코드가 타도록 올려 줘야 됨.
            if (notBroken) {
                dfs(start+1);
            }
        }

    }

    /**
     * return을 통해 아래 코드들이 동작하지 않도록 하거나,
     * 조건을 타지 않을 경우, 위에 올라가도록 dfs(depth+1) 호출을 해줘야됨. 그렇지 않으면 코드가 빠져 버림.
     */

    private static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }





}
