package com.basic.algorithm;

/**
 * 反转部分链表
 */
public class ReversePart {
    class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node build() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        return node1;
    }

    public Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1=head;
        Node fPre=null;
        Node tPos=null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        return head;

    }

    public static void main(String[] args) {
        ReversePart reversePart = new ReversePart();
        reversePart.reversePart(reversePart.build(),1,4);
    }
}

