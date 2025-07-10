class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class splitCircularLL {

    Node head;

    // Add node at the end
    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        //for appending new node
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Function to split circular list
    void splitList() {
        if (head == null || head.next == head) {
            System.out.println("Cannot split list");
            return;
        }

        Node slow = head;
        Node fast = head;

        // Find mid using slow and fast pointers
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // For odd nodes, move fast to last node
        if (fast.next.next == head) {
            fast = fast.next;
        }

        // First half head
        Node head1 = head;

        // Second half head
        Node head2 = slow.next;

        // Break the list into two circular halves
        slow.next = head1;
        fast.next = head2;

        System.out.print("First List: ");
        printCircularList(head1);

        System.out.print("Second List: ");
        printCircularList(head2);
    }

    void printCircularList(Node node) {
        if (node == null) return;
        Node temp = node;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != node);
        System.out.println();
    }

    public static void main(String args[]) {
        splitCircularLL circle = new splitCircularLL();
        circle.append(10);
        circle.append(20);
        circle.append(30);
        circle.append(40);
        circle.append(50); // Odd number
        
        circle.splitList();
    }
}
 
    

