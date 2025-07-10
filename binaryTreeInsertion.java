class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class binaryTreeInsertion {
    Node root;

    // Main insert method
    void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        for (int level = 1; ; level++) {
            if (insertAtLevel(root, newNode, level)) {
                break;
            }
        }
    }

    // Tries to insert newNode at a given level. Returns true if inserted.
    boolean insertAtLevel(Node current, Node newNode, int level) {
        if (current == null) return false;

        if (level == 1) {
            if (current.left == null) {
                current.left = newNode;
                return true;
            } else if (current.right == null) {
                current.right = newNode;
                return true;
            } else {
                return false;
            }
        }

        // Try inserting in left or right subtree at the next level
        return insertAtLevel(current.left, newNode, level - 1)
            || insertAtLevel(current.right, newNode, level - 1);
    }

    // Inorder traversal
    void inorderTraversal(Node node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        binaryTreeInsertion tree = new binaryTreeInsertion();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal(tree.root);
    }
}
