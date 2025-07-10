class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class checkPalindrome {

    Node head;

    // Function to check if the list is palindrome
    boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalfStart = reverseList(slow.next);

        // Step 3: Compare halves
        Node firstHalf = head;
        Node secondHalf = secondHalfStart;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Step 4: (Optional) Restore list
        slow.next = reverseList(secondHalfStart);

        return true;
    }

    // Utility to reverse a linked list
    Node reverseList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // Utility to add node at end
    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public static void main(String args[]) {
        checkPalindrome list = new checkPalindrome();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(1);

        if (list.isPalindrome())
            System.out.println("List is Palindrome");
        else
            System.out.println("List is Not a palindrome");
    }
}
