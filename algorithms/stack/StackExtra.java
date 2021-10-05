package s;

public class StackExtra {

    public static int calc(Stack input) {
        Stack<Integer> result = new Stack<>();

        while (input.size() != 0) {
            if (input.peek().getClass().equals(Integer.class))
                result.push((Integer) input.pop());
            else if (input.pop().equals('+'))
                result.push(result.pop() + result.pop());
            else
                result.push(result.pop() * result.pop());
        }

        return result.peek();
    }

    public static boolean isBalanced(String s) {

        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                stack.push(1);

            if (s.charAt(i) == ')')
                if (stack.size() == 0)
                    return false;
                else stack.pop();
        }
        return stack.size() == 0;
    }
}
