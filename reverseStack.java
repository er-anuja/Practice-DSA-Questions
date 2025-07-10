import java.util.Stack;

public class reverseStack {

    // Function to reverse the stack
    static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) 
            return;

        //Pop top element
        int top = stack.pop();

        //Reverse remaining stack
        reverse(stack);

        //Insert at bottom
        insert(stack, top);
    }

    //insert element at the bottom of the stack
    static void insert(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }

        // Pop all elements to reach bottom
        int top = stack.pop();
        insert(stack, item);

        // Push them back in original order
        stack.push(top);
    }

    // Utility to print stack
    static void printStack(Stack<Integer> stack) {
        for (int val : stack) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);

        System.out.println("Original Stack:");
        printStack(s1);  // Top to bottom: 40 30 20 10

        reverse(s1);

        System.out.println("Reversed Stack:");
        printStack(s1);  // Top to bottom: 1 2 3 4
    }
}
