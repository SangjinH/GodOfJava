package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static DataStructure.AppliedLinkedList.*;

public class DoublyLinkedList {

    private int nodeCount;
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.nodeCount = 0;
        this.head = new Node(null);
        this.tail = new Node(null);
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }

    public List<Integer> traverse() {
        List<Integer> result = new ArrayList<>();
        Node curr = head;
        while (curr.next.next != null) { // Doubly LinkedList 이기에,  head(null) - tail(null) 일 경우 고려
            curr = curr.next;
            result.add(curr.data);
        }
        return result;
    }

    public List<Integer> reverse() {
        List<Integer> result = new ArrayList<>();
        Node curr = tail;
        while (curr.prev.prev != null) { // Doubly LinkedList 이기에,  head(null) - tail(null) 일 경우 고려
            curr = curr.prev;
            result.add(curr.data);
        }
        return result;
    }

    public boolean insertAfter(Node prev, Node newNode) {
        Node next = prev.next;

        newNode.prev = prev;
        newNode.next = next;

        prev.next = newNode;
        next.prev = newNode;

        nodeCount += 1;
        return true;
    }

    public Node getAt(int position) {
        if (position < 1 || position > nodeCount) return null;

        if (position > Math.floorDiv(nodeCount, 2)) {
            int i = 0;
            Node curr = this.tail;
            while (i < nodeCount - position + 1) {
                curr = curr.prev;
                i += 1;
            }
        }
        Node curr = this.head;
        int i = 0;
        while (i < position) {
            curr = curr.next;
            i += 1;
        }
        return curr;
    }

    public boolean insertAt(int position, Node newNode) {
        if (position < 1 || position > nodeCount + 1) return false;

        Node prev = getAt(position - 1);
        return insertAfter(prev, newNode);
    }

    public class Node {
        private Node prev;
        private Node next;
        private Integer data;

        public Node(Integer data) {
            this.prev = null;
            this.next = null;
            this.data = data;
        }
    }
}
