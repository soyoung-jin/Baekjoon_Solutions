/*
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
        Stack<Character> stack = new Stack<>();

        // 입력받은 문자열 저장
        String s = br.readLine();

        // 잘린 막대기 수
        int num = 0;

        for(int i = 0; i < s.length(); i++){
            // 여는 괄호일 경우 스택에 추가
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else {
                // 닫는 괄호일 경우 스택에서 pop
                stack.pop();

                // 만약 직전 문자열이 여는 괄호라면, () -> 즉, 레이저라는 의미
                if(s.charAt(i - 1) == '('){
                    // 스택에 여는 괄호가 몇개 남아있는지 센다.(stack.size()) -> 누적 합으로 더해줌
                    num = num + stack.size();
                } else {
                    // 만약 직전 문자열이 닫는 괄호 ')' 라면, 쇠막대기가 끝나는 것임
                    // 막대기를 두번 자르면 3개의 조각이 생김. 즉, 마지막 조각이 잘라져 나오는 것을 +1 해줘야 함
                    // 막대기 시작과 끝에서 레이저의 개수는 = 자르는 횟수 = () 괄호 한쌍의 개수임
                    // 따라서 괄호 한쌍의 개수(레이저 개수) + 1을 해주어야 잘리는 조각의 개수를 구하게 되는 것임
                    num++;
                }
            }
        }

        System.out.println(num);

    }
}