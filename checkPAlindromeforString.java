import java.util.*;

public class checkPAlindromeforString {
    public static boolean isPalindrome(char[] arr) {
        Stack<Character> stack = new Stack<>();
        int i = 0;

        // Push characters before 'X'
        while (i < arr.length && arr[i] != 'X') {
            stack.push(arr[i]);
            i++;
        }

        //Skip the 'X'
        i++;

        //Compare remaining characters with stack
        while (i < arr.length) {
            if (stack.isEmpty() || arr[i] != stack.pop()) {
                return false;
            }
            i++;
        }

        //If stack is empty → it's a palindrome
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        char[] string = {'a', 'b', 'a', 'b', 'X', 'b', 'a', 'a', 'a'}; // Not a palindrome

        if (isPalindrome(string)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}
