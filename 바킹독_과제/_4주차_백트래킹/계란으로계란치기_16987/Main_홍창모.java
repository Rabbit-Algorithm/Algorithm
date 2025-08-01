package _4주차_백트래킹.계란으로계란치기_16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_홍창모 {
    static int N, MAX = Integer.MIN_VALUE;
    static List<Egg> EGGS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        EGGS = new ArrayList<>();

        for( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            EGGS.add(new Egg(s, w));
        }


        backtracking(0);

        System.out.print(MAX);
    }

    private static void backtracking(int start) {
        if (start == N) {
            int count = 0;
            for (Egg egg : EGGS) {
                if (egg.durability <= 0) {
                    count++;
                }
            }
            MAX = Math.max(MAX, count);
            return;
        }

        // 현재 계란이 이미 깨졌으면 패스
        if (EGGS.get(start).durability <= 0) {
            backtracking(start + 1);
            return;
        }

        boolean attacked = false;
        for (int i = 0; i < N; i++) {
            if (i == start || EGGS.get(i).durability <= 0) continue;

            attacked = true;
            // 계란 치기
            EGGS.get(start).durability -= EGGS.get(i).weight;
            EGGS.get(i).durability -= EGGS.get(start).weight;
            backtracking(start + 1);
            // 복구
            EGGS.get(start).durability += EGGS.get(i).weight;
            EGGS.get(i).durability += EGGS.get(start).weight;
        }
        // 한 번도 다른 계란을 치지 못했으면 넘어가기
        if (!attacked) {
            backtracking(start + 1);
        }
    }

    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
