/*
 * 각 문장마다 해당 문자열이 (), [] 괄호 균형을 갖추고 있으면 "yes" 아니면 "no"를 출력한다.
 * 1\. while 문이 true 일 동안 반복
 * 1-1. 만약 c[i] 가 '(' 혹은 '['와 같다면 스택에 push
 * 1-2. 만약 c[i] 가 ')'일 경우
 * 1-2-1. 만약 스택이 비어있을 경우엔 return false
 * 1-2-2. 만약 스택이 비어있지 않고, stack.peek() == '('과 같다면 stack.pop()
 * 1-2-2. 아니라면 return false
 * 1-3. 만약 c[i] 가 ']'일 경우 -> 동일하게 진행
 * 1-4. for 문이 종료되면, stack.isEmpty() 확인하여 true 면 "yes", false 면 "no" 출력
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            // 각 문장을 string 변수에 저장
            String line = br.readLine();

            // 입력 종료 조건인 온점하나가 들어오면 반복문 종료
            if(line.equals(".")){
                break;
            }

            // 메서드 호출
            if(solve(line)){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }


        }

    }

    public static boolean solve(String line){
        //스택 생성
        Stack<Character> stack = new Stack<>();

        char[] c = line.toCharArray();

        for (char value : c) {
            // 여는 괄호일 경우
            if(value == '(' || value == '['){
                stack.push(value);
            }

            // 닫는 괄호일 경우
            if(value == ')'){
                if(stack.empty()){
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if(value == ']'){
                if(stack.empty()){
                    return false;
                } else if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}