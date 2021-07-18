package examples.playground;


import examples.playground.LinkedListExample.Node;

public class Test {

    public static void main(String[] args) {


        LinkedListExample ll = new LinkedListExample();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.display(ll.head);
        Node ll1 = ll.reverseKgroups(ll.head, 2);
        ll.display(ll1);
    }



}
