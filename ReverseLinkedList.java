package Ibm;
public class ReverseLinkedList {
    private Node head;
    private Node tail;
    int size = 0;

    public void first(int val) {
        Node newNode = new Node(val);
        head = newNode;
        newNode.next = null;
        tail = newNode;
        size++;
    }

    public void insertFirst(int val) {
        if (head == null) {
            first(val);
        }
        Node newNode = new Node(val, head);
        head = newNode;
        size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            first(val);
            return;
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        newNode.next = null;
        tail = newNode;
        size++;
    }

    public void insertMiddle(int val, int index) {
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(val, temp.next);
        temp.next = newNode;
        size++;
    }
 public void recRev(){
        reverseRec(head);
 }
    private void reverseRec(Node node) {
        if (node == tail) {
            head=tail;
            return;
        }
        reverseRec(node.next);
        tail.next = node;
        tail=node;
        node.next = null;
    }

    public void itrRev(){
        head=reverseItr(head);
    }

    private Node reverseItr(Node node) {
        Node prev = null;
        Node pres = node;
        Node next = pres.next;
        while (pres != null) {
            pres.next = null;
            prev = pres;
            pres = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public void traversal() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node {
    Node next;
    int val;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.next = next;
        this.val = val;
    }
}

class LinkedList {
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.traversal();
        list.recRev();
        list.traversal();
    }
}
