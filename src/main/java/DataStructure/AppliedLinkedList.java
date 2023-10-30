package DataStructure;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class AppliedLinkedList {

    private int nodeCount;
    private Node head;
    private Node tail;

    public AppliedLinkedList() {
        this.nodeCount = 0;
        this.head = new Node(null);
        this.tail = null;
        this.head.next = tail;
    }

    public static void main(String[] args) {
        AppliedLinkedList linkedList = new AppliedLinkedList();
        linkedList.insertAt(1, new Node(1));
        linkedList.traverse();

        linkedList.deleteAt(1);
        linkedList.traverse();

        linkedList.insertAt(1, new Node(4));
        linkedList.traverse();

        linkedList.insertAt(1, new Node(1));
        linkedList.traverse();

        linkedList.insertAt(2, new Node(3));
        linkedList.traverse();

        linkedList.insertAt(1, new Node(1));
        linkedList.traverse();

        linkedList.deleteAt(4);
        linkedList.traverse();
    }


    /**
     * 연결 리스트 순회
     */
    public void traverse() {
        List<Integer> result = new ArrayList<>();
        Node curr = this.head;
        while (curr.next != null) {
            result.add(curr.next.data);
            curr = curr.next;
        }
        out.println("traverse LinkedList = " + result);
    }



    public Node getAt(int position) {
        if (position < 0 || position > nodeCount) return null;

        int i = 0;
        Node curr = this.head;
        while (i < position) {
            curr = curr.next;
            i += 1;
        }
        return curr;
    }


    public boolean insertAfter(Node prev, Node newNode) {
        newNode.next = prev.next;
        if (prev.next == null) tail = newNode;
        prev.next = newNode;
        this.nodeCount += 1;
        return true;
    }

    public boolean insertAt(int position, Node newNode) {
        if (position < 1 || position > nodeCount + 1) return false;

        Node prev;
        if (position != 1 && position == nodeCount + 1) prev = tail;
        else                                            prev = getAt(position - 1);
        return insertAfter(prev, newNode);
    }

    /**
     * 해당 노드의 다음 노드를 삭제하는 메소드
     * 앞서 validation 이 적용 됐다고 가정
     * @param prev
     * @return
     */
    public boolean popAfter(Node prev) {
        if (prev.next == null) return false;  // 이전노드가 마지막 노드라고 한다면

        Node curr = prev.next;
        prev.next = curr.next;

        if (curr.next == null) tail = prev;        // 리스트의 가장 끝 노드를 삭제할 때

        nodeCount -= 1;
        return true;
    }

    public boolean popAt(int position) {
        if (position <= 0 || position > nodeCount) throw new RuntimeException();

        Node prev;
        if (position == nodeCount + 1 && position != 1) {
            prev = tail;
        } else {
            prev = getAt(position - 1);
        }
        return popAfter(prev);
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

    public static class Node {
        private Integer data;
        private Node next;

        public Node(Integer data) {
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

