package DataStructure;

import java.util.Collections;

import static java.lang.System.*;
import static java.util.Arrays.copyOf;

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

        linkedList.deleteAt(1);
        linkedList.printAllNodes();

        linkedList.addNode(1, new Node(4));
        linkedList.printAllNodes();

        linkedList.addNode(1, new Node(1));
        linkedList.printAllNodes();

        linkedList.addNode(2, new Node(3));
        linkedList.printAllNodes();

        linkedList.addNode(1, new Node(1));
        linkedList.printAllNodes();

        linkedList.deleteAt(4);
        linkedList.printAllNodes();

        LinkedList addLinkedList = new LinkedList();
        addLinkedList.concat(linkedList);

        linkedList.concat(addLinkedList);
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
        out.println();
    }

    public boolean addNode(int position, Node node) {
        out.println("addNode at position : " + position + ", value : " + node.data);
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
        return true;
    }

    public boolean deleteAt(int position) {
        out.println("deleteNode at position : " + position);
        if (nodeCount <= 0) throw new RuntimeException();

        if (position == 1) { // 삭제하려는 노드가 첫번째 노드일때,
            this.head = head.next;
        } else {
            Node curr = getAt(position);
            Node prev = getAt(position - 1);
            prev.next = curr.next;
        }
        nodeCount -= 1;
        return true;
    }

    public boolean concat(LinkedList addLinkedList) {
        out.println("concat List : " + addLinkedList);
        int addLinkedListCount = addLinkedList.nodeCount;
        for (int i = 0; i < addLinkedListCount; i++) {
            this.addNode(nodeCount + 1, new Node(addLinkedList.getAt(i + 1).data));
        }
        return true;
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

