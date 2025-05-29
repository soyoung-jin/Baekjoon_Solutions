/*
* 주어진 1~N 까지의 정수를 push 와 pop 을 통해 임의의 수열을 만들 수 있는지 판별해야함
* 만들 수 있으면, push (+), pop (-) 의 과정을 + 와 - 로 출력
* 만들 수 없다면 NO 를 출력한다.
* 1. start 부터 수열의 입력값까지의 정수를 스택에 push ex.(1~4까지 push)
* 2. 단, 이때 숫자를 push 할 때, 오름차순이어야 하기 때문에 어디까지 push 했는지 기억하기 위한 start 변수를 value 값으로 초기화해야함
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // 출력할 결과물 저장
        StringBuilder sb = new StringBuilder();

        // 테스트 개수
        int T = Integer.parseInt(br.readLine());

        int start = 0;

        // T번 반복
        while(T > 0){
            // pop 해야하는 숫자
            int value = Integer.parseInt(br.readLine());

            if(value > start){
                // start + 1 부터 value 까지를 스택에 push
                for(int i = start + 1; i <= value; i++){
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                // 몇번째 정수까지 스택에 push 했는지 기억하기 위한 변수 초기화
                start = value;
            }

            // 가장 위에 있는 원소가 value 와 같다면 pop()
            if(!stack.isEmpty() && stack.peek() == value){
                stack.pop();
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                return; // 종료
            }

            T--;
        }

        System.out.println(sb);

    }
}