package 바킹독_과제._5주차_이분탐색.실버.수찾기_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//입력1 N(배열 A의 크기)
//입력2 배열 A의 숫자들
//입력3 M(찾아야 할 숫자의 갯수)
//입력4 찾아야할 숫자들

public class Main_이승환 {

    static int N,M;

    static long[] arrA;
    static long[] findNumbers;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // arrA의 갯수
        arrA = new long[N]; // 가지고 있는 수

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrA[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arrA); //이분 탐색을 위한 정렬


        M = Integer.parseInt(br.readLine());
        findNumbers = new long[M]; // 찾아야하는 수들

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            findNumbers[i] = Long.parseLong(st.nextToken());
        }

        BinarySearch();

    }

    private static void BinarySearch(){
            for(int i=0; i<M; i++){
                int left = 0;
                int right = N-1;
                boolean found = false; // 이걸로 찾았는지 안찾았는지 알려줌

                long findNum = findNumbers[i];

                while (left <= right){
                    int mid = (left+right)/2;

                    if(arrA[mid] == findNum){
                        found = true;
                        break; // 브레이크를 걸어서 찾으면 바로 while문을 벗어나도록 코드 작성
                    }else if(arrA[mid] < findNum){
                        left = mid+1;
                    }else {
                        right = mid-1;
                    }
                }

                if(found){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }


            }

    }


}
