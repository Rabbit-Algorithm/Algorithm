package 바킹독_과제._5주차_이분탐색.실버.나무자르기_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 틀림
public class Main_이승환1 {

    static int M,N;

    //나무 길이도 더 길게 해야함. 범위가 20억이 넘어감
    static int[] Trees;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //나무의 수
        M = Integer.parseInt(st.nextToken()); //나무의 길이

        st = new StringTokenizer(br.readLine());
        Trees = new int[N];

        for(int i=0; i<N; i++){
            Trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Trees); //이분 탐색을 위한 정렬

        BinarySearch();

    }

    private static void BinarySearch(){
        int left = Trees[0]; // 절단기의 높이를 구하는 것이므로 0부터 시작하는 것이 가장 올바름
        int right = Trees[N-1];
        int result = 0;

        while(left <= right){

            int mid = (left + right) / 2;

            int treeLength = 0;
            for (int tree : Trees) {
                if(tree > mid){
                    treeLength += tree - mid;
                }
            }

            /*잘라낸 나무의 길이가 목표치와 맞을떄 바로 확정 짓고 끝내려고함
            딱 맞게 잘라내는 것보단 적어도 M 미터의 나무를 집에 가져가기 위해서 설정할 수 있는
            절단기의 최대 높이를 구해야함. 높이가 더 높아도 M 이상을 얻을 수 있는 다른 경우가 있을 수 있음.
             */
            if(treeLength == M){
                result = mid;
                break;
            }

            if(treeLength >= M){
                result = mid;

                //더 긴 길이를 비교하기 위해 left에 중앙값을 넣어준다.
                left = mid +1;
            } else {
                //더 짧은 길이를 비교하기 위해 right에 중앙값을 넣어준다.
                right = mid -1;
            }

        }

        System.out.println(result);

    }


}
