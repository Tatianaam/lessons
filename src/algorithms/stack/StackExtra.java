package algorithms.stack;

public class StackExtra {

    // only integers and + * = allowed
    public static int calc(Stack input) {
        Stack<Integer> result = new Stack<>();

        while (input.size() != 0) {
            if (input.peek().getClass().equals(Integer.class))
                result.push((Integer) input.pop());
            else
                switch ((Character)input.pop()) {
                    case '+':
                        result.push(result.pop() + result.pop());
                        break;
                    case '*':
                        result.push(result.pop() * result.pop());
                        break;
                    case '=':
                        System.out.println(result.peek());
                        break;
                }
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
