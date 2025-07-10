class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class reverseLinkedlist {

    static void print(Node head) {
        if (head == null) 
            return;
        print(head.next);  // recursive call
        System.out.print(head.data + " ");
    }

    public static void main(String args[]) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);

        System.out.print("Reverse Linked List: ");
        print(head);  // Output: 10 8 6 4 2
    }
}
