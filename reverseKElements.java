import java.util.*;

public class reverseKElements {
    public static void reverseFirstK(Queue<Integer> queue, int k) {
        if (queue == null || k < 0 || k > queue.size()) {
            throw new IllegalArgumentException("Invalid k or queue.");
        }

        Stack<Integer> stack = new Stack<>();

        //Dequeue first k elements into stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        //Enqueue stack elements back to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        //Move remaining elements to the back
        int remaining = queue.size() - k;
        for (int i = 0; i < remaining; i++) {
            queue.add(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90));

        int k = 4;
        System.out.println("Original Queue: " + queue);

        reverseFirstK(queue, k);

        System.out.println("After reversing first " + k + " elements:");
        System.out.println(queue);
    }
}
