/*
* ::::: 문제 :::::
* - 상근이가 N 개국을 여행하면서 자아를 찾기로 마음먹음.
* - 상근이는 비행기를 무서워해서 최대한 적은 종류의 비행기를 타고 국가를 이동하려 함.
*
* ::::: 입력 :::::
* - 이번 방학 동안의 비행 스케쥴이 주어짐
* - 국가의 수, N, 비행기의 종루 M이 주어짐.
* - 이후 M개의 줄에 a, b 쌍들이 입력된다. (a, b를 왕복하는 비행기가 있다는 것을 의미한다.)
* - 주어지는 빟애 스케줄은 항상 연결 그래프를 이룬다.
*
*
* ::::: 출력 :::::
* - 가장 적은 종류의 비행기를 타고 모든 국가들을 여행할 수 있도록 도와주자.
* - 상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐가도 (이미 방문해도) 된다.
*
* ::::: 구현 :::::
* 1. 모든 국가(노드)를 방문하기 위해 필요한 최소 비행기(간선)의 수는 N - 1이다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력저장
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            // 문자열 자르기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 국가의 수
            int N = Integer.parseInt(st.nextToken());
            // 비행기의 종류
            int M = Integer.parseInt(st.nextToken());

            // N - 1 이므로 사실상 비행기 스케쥴은 필요 없음.
            for(int j = 0; j < M; j++){
                br.readLine();
            }

            // 출력
            sb.append(N -1).append("\n");
        }

        System.out.println(sb);

    }
}