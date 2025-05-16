import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 테스트 케이스 읽을 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        // 개수만큼 반복
        for(int i = 0; i < T; i++){
            // ture일 경우
            if(isVPS(br.readLine())){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


    }

    // 올바른 괄호인지 판단하는 메서드
    public static boolean isVPS(String s){
        // 스택 생성
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            // c가 열린 괄호라면
            if(c == '('){
                stack.push(c);
            } else {
                // 닫힌 괄호라면
                // 우선 스택이 비어있는지 확인
                if(stack.isEmpty()){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}