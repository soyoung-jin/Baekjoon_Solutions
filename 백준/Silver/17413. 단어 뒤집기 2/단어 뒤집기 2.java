/*
* 단어 뒤집기
* - <> 태그 안에 있는 단어는 뒤집지 않고 그대로 출력
* - 그 외의 단어들은 스택에 담았다가 pop() 하여 거꾸로 꺼내기*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        int len = str.length();

        // 태그가 있는지 확인
        boolean tag = false;
        for(int i = 0; i < len; i++){
            if(str.charAt(i) == '<'){
                tag = true;

                while( !stack.isEmpty()){
                    sb.append(stack.pop());
                }

                sb.append(str.charAt(i));

            } else if(str.charAt(i) == '>'){
                tag = false;
                sb.append(str.charAt(i));
            } else if(tag){
                // 태그 안 단어는 그대로 출력
                sb.append(str.charAt(i));
            } else if (!tag) {
                if(str.charAt(i) == ' ') {

                    while( !stack.isEmpty() ) {
                        sb.append(stack.pop());
                    }

                    sb.append(str.charAt(i));
                }
                // 공백이 아닐경우, 공백을 만날 때 까지 stack 에 push
                else {
                    stack.push(str.charAt(i));
                }
            }
        }
        // 마지막 문자열이 남아있는지 체크
        while( !stack.isEmpty() ) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }
}