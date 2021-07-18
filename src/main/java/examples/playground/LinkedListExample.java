package examples.playground;

public class LinkedListExample {

    static class Node {
        int d;
        Node next;

        public Node(int data) {
            this.d =data;
            this.next = null;
        }
    }

    static Node head;

    public void add(int i){
        Node cur = head;
        Node newNode = new Node(i);
        if(cur == null) {
            head = newNode;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void display(Node head) {
        Node cur = head;

        while (cur != null) {
            System.out.println(cur.d);
            cur = cur.next;
        }
    }

    public void reverse(Node head) {

        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public Node reverseKgroups(Node head, int k) {
        Node curr = head;
        Node prv = null;
        Node next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prv;
            prv = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            head.next = reverseKgroups(next, k);
        }
        return prv;
    }



}
