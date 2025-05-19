/*
* [스택]
* 잘못된 수를 부를 때마다 0을 외치고 가장 최근 수를 지움
* 남은 수의 합을 구하기
* 정수가 "0"일 경우 가장 최근에 쓴 수를 지움(pop()) 아닐 경우 그대로 push > 지울 경우, 스택에 데이터가 들어있음을 보장
* 첫번째 정수는 테스트 케이스*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        // 데이터 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 스택 생성
        Stack<Integer> stack = new Stack<>();
        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
        // 스택에 남은 수들의 합
        int sum = 0;

        for(int i = 0; i < T; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                stack.push(num);
                sum += num;
            } else {
                sum -= stack.peek();
                stack.pop();
            }
        }

        System.out.println(sum);

    }
}