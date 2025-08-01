package 바킹독_과제._4주차_백트래킹.계란으로계란치기_16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Egg라는 클래스를 만들고 구현해보려 했는데 실패함

public class Main_이승환 {

    private static int N;
    private static Egg[] Eggs;
    private static int EGGCOUNT;

    private static class Egg{
        int durAbility;
        int weight;
        public Egg(int durAbility, int weight) {
            this.durAbility = durAbility;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Eggs = new Egg[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Eggs[i] = new Egg(durability, weight);
        }

        BackTracking(0);

        System.out.println(EGGCOUNT);

    }

    private static void BackTracking(int depth) {

        //depth가 N일때 종료
        if(depth ==N){
            int broken = 0;
            for (Egg egg : Eggs) {
                if (egg.durAbility <= 0) {
                    broken++;
                }
            }
            EGGCOUNT = Math.max(broken, EGGCOUNT);
            return;
        }

        //다음 칠 계란이 깨졌을때 넘어감
        if(Eggs[depth].durAbility <=0){
            BackTracking(depth+1);
            return;
        }

        //다른 모든 계란이 깨져있는지 확인
        boolean allOtherBroken = true;
        for(int i=0; i<N; i++){
            if(i== depth) continue;
            if(Eggs[i].durAbility > 0){
                allOtherBroken = false;
                break;
            }
        }

        // 모든 계란이 깨져있으면 더 이상 칠 수 없으므로 다음으로 넘어감
        if (allOtherBroken) {
            BackTracking(depth + 1);
            return;
        }

        // 3. 재귀: 다른 계란을 하나씩 깨보는 모든 경우를 탐색
        for (int target_idx = 0; target_idx < N; target_idx++) {
            // 자기 자신이거나 이미 깨진 계란은 칠 수 없음
            if (depth == target_idx || Eggs[target_idx].durAbility <= 0) {
                continue;
            }

            // 계란을 친다 (상태 변경)
            Eggs[depth].durAbility -= Eggs[target_idx].weight;
            Eggs[target_idx].durAbility -= Eggs[depth].weight;

            // 다음 계란을 들러 간다
            BackTracking(depth + 1);

            // 되돌린다 (상태 복구)
            Eggs[depth].durAbility += Eggs[target_idx].weight;
            Eggs[target_idx].durAbility += Eggs[depth].weight;
        }




    }

}