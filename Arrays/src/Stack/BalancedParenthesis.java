package Stack;

import java.util.ArrayDeque;

public class BalancedParenthesis {
    public static void main(String[] args) {
        //We will push the opening bracket into the stack and as we see closing bracket we need to check whether they are matching. One corner case is when input has
        //only closing bracket. So we have to check size. if it is zero then no opening bracket is present in so return false
        String input = "{}{}{}{}";
        char ch;
        ArrayDeque<Character> parenthesis = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            if(ch == '}' || ch == ']' || ch == ')') {
                if(parenthesis.size() == 0 || !isMatching(ch, parenthesis.pop())) {
                    System.out.println("not matching");
                    return;
                }
            } else {
                parenthesis.push(ch);
            }
        }
        if(parenthesis.size() > 0) {    //There can be a case where we have more opening bracket than closing  one.
            System.out.println("Mot matched");
        } else {
            System.out.println("Matched");
        }
    }

    public static boolean isMatching(char a, char b) {
        return ((a == ')' && b == '(') ||
                (a == ']' && b == '[') ||
                (a == '}' && b == '{')
                );
    }
}
