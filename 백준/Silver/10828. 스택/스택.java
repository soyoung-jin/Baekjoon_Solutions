import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

/*
* 1. 첫째 줄에는 명령의 수가 주어진다.
* 2. 먼저 문자열을 공백 기준으로 나누고, 처음 문자로 push, pop, size, empty 중 같은 문자열을 찾는다.
* 3. 해당 문자열과 같은 이름을 가진 메서드를 호출하여 수행
* - 단, push 는 스택에 넣은 이후, return 값이 없다.
* - pop 은 가장 위에 있는 정수를 빼고, 그 수를 출력, 정수가 없으면 -1
* - size 는 스택에 들어있는 정수 개수 출력
* - empty 는 스택이 비어있으면 1, 아니면 0을 출력
* - top 는 스택의 가장 위에 있는 정수를 출력한다. 만약 스탹에 들어있는 정수가 없는 경우 -1 출력*/

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력값 읽을 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 스택 생성
        Stack<String> stack = new Stack<>();

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        // 개수만큼 반복
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();

            // push일 경우
            if(s.equals("push")){
                stack.push(st.nextToken());
            } else if(s.equals("pop")) {
                if(stack.isEmpty()){
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if(s.equals("size")){
                System.out.println(stack.size());
            } else if(s.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(s.equals("top")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}