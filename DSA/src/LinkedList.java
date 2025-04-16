class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);

        // Insert at the beginning
        newNode.next = head;
        head = newNode;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void deleteFromList(){

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.printList(); // Output: 30 -> 20 -> 10 -> null
    }
}
