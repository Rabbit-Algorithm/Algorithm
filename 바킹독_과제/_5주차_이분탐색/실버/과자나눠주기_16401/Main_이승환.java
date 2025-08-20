package 바킹독_과제._5주차_이분탐색.실버.과자나눠주기_16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이승환 {

    static int M,N;

    static int[] SNACKS;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //조카의 수
        N = Integer.parseInt(st.nextToken()); //과자의 수

        st = new StringTokenizer(br.readLine());
        SNACKS = new int[N];

        for(int i=0; i<N; i++){
            SNACKS[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(SNACKS); //이분 탐색을 위한 정렬

        BinarySearch();

    }

    private static void BinarySearch(){
        int left = 1;
        int right = SNACKS[N-1];
        int result = 0;

        while (left <= right){
            int mid = (left+right) / 2;

            int count = 0;
            for (int snack : SNACKS) {
                count += snack/mid; //중앙값으로 나눈 몫을 count에 넣어준다.
            }

            //조카보다 많거나 같으면 값을 저장해준다.
            if(count >= M){
                result = mid;

                //더 긴 길이도 비교하기 위해 left에 중앙값을 넣어준다.
                left = mid +1;
            }else {
                //더 짧은 길이를 비교하기 위해 right에 중앙값을 넣어준다.
                right = mid -1;
            }

        }

        System.out.println(result);

    }


}
