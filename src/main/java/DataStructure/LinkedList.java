package DataStructure;

import static java.lang.System.*;

public class LinkedList {

    private int nodeCount;
    private Node head;
    private Node tail;

    public LinkedList() {
        this.nodeCount = 0;
        this.head = null;
        this.tail = null;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(1, new Node(1));
        linkedList.printAllNodes();
        out.println();
        linkedList.addNode(2, new Node(4));
        linkedList.printAllNodes();
        out.println();
        linkedList.addNode(1, new Node(1));
        linkedList.printAllNodes();
        out.println();
        linkedList.addNode(3, new Node(3));
        linkedList.printAllNodes();
        out.println();
        linkedList.addNode(1, new Node(1));
        linkedList.printAllNodes();


    }



    public Node getAt(int position) {
        if (position <= 0 || position > nodeCount) {
            return null;
        }

        int i = 1;
        Node curr = this.head;
        while (i < position) {
            i += 1;
            curr = curr.next;
        }
        return curr;
    }

    public void printAllNodes() {
        Node curr = this.head;
        while (curr != null) {
            out.print(curr.data);
            curr = curr.next;
        }
    }

    public void addNode(int position, Node node) {
        if (position == 1) {
            node.next = head;
            head = node;
        } else {
            Node prev = getAt(position - 1);
            node.next = prev.next;
            prev.next = node;
        }

        if (position == (nodeCount + 1)) {
            tail = node;
        }

        this.nodeCount += 1;
    }


    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    '}';
        }
    }
}

