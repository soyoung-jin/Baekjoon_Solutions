/*
* :::::: 문제 ::::::
* - 크기가 N인 수열이 존재
* - 각 원소에 대해 오큰수 NGE 구하기
* - 오큰수는 오른쪽에 있으면서 A보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
* - 그런 수가 없으면 -1
*
* :::::: 출력 ::::::
* - 총 N개의 수 NGE(1) ... 을 공백으로 구분하여 출력
*
* :::::: 구현 ::::::
*
* */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<Integer>();

        // 수열의 개수 N개
        int T = Integer.parseInt(br.readLine());
        // T개의 배열 생성
        int[] seq = new int[T];

        // 수열 공백을 기준으로 나누기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 수열의 개수 N 개만큼 반복
        // 이중 for 문을 사용하면 시간초과, 사용 X
        for(int i = 0; i < T; i++){
            // 각 원소를 배열에 저장
            seq[i] = Integer.parseInt(st.nextToken());
        }

        /*
        * 스택이 비어있지 않으면서 AND 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
        * 해당 조건을 만족할 떄까지 stack 의 원소를 pop 하면서
        * 해당 인덱스의 값을 현재 원소로 바꿔준다.*/

        for(int i = 0; i < T; i++){
            while(!stack.isEmpty() && seq[stack.peek()] < seq[i]){
                seq[stack.pop()] = seq[i];
            }

            stack.push(i);
        }

        /*
        * 스택의 모든 원소를 pop 하면서 해당 인덱스의 value 를 -1로 초기화*/
        while(!stack.isEmpty()){
            seq[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            sb.append(seq[i]).append(' ');
        }


        System.out.println(sb);
    }

}