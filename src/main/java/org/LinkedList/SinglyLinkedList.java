package org.LinkedList;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SinglyLinkedList {

    private static final Logger log = Logger.getLogger(SinglyLinkedList.class.getName());

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head;

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.printList();
        linkedList.pushAtFront(100);
        linkedList.pushAtFront(200);
        linkedList.pushAtFront(300);
        linkedList.pushAtFront(400);
        linkedList.pushAtEnd(500);
        linkedList.pushAfterGivenNode(null, 10);
        linkedList.printList();
        log.log(Level.INFO, "Total number of nodes present: {0}", linkedList.getNumberOfNodes());
        Node desiredNode = linkedList.getNodeOnPosition(1);
        log.log(Level.INFO, "Node -> data: {0}", desiredNode.data);
        log.log(Level.INFO, "The Node position of head.next.next is: {0}",
                linkedList.getNodePosition(linkedList.head.next.next));
        log.log(Level.INFO, "Is there any loop present : {0}", linkedList.detectLoop(linkedList.head));
        linkedList.deleteNode(linkedList.head.next.next);
        linkedList.printList();
    }

    public void printList() {
        if (head == null) {
            log.log(Level.INFO, "The list is empty.");
        } else {
            Node n = head;
            while (n != null) {
                log.log(Level.INFO, "Data in list : {0}", n.data);
                n = n.next;
            }
        }
    }

    public void pushAtFront(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void pushAtEnd(int data) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        Node node = new Node(data);
        node.next = null;
        n.next = node;
    }

    public void pushAfterGivenNode(Node prevNode, int data) {
        if (prevNode == null) {
            log.log(Level.SEVERE, "The given node is null.");
            return;
        }
        Node node = new Node(data);
        node.next = prevNode.next;
        prevNode.next = node;
    }

    public int getNumberOfNodes() {
        int count = 0;
        Node node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public Node getNodeOnPosition(int index) {
        int count = 1;
        Node node = head;
        while (node != null) {
            if (count == index) {
                return node;
            }
            node = node.next;
            count++;
        }
        return null;
    }

    public int getNodePosition(Node node) {
        int count = 1;
        Node n = head;
        while (n != null) {
            if (n.data == node.data && n.next == node.next) {
                return count;
            }
            n = n.next;
            count++;
        }
        return 0;
    }

    public void deleteNode(Node deleteNode) {
        if (deleteNode == null) {
            log.log(Level.INFO, "The given node is null.");
            return;
        }
        int deleteNodePosition = getNodePosition(deleteNode);
        int totalNodes = getNumberOfNodes();

        if (deleteNodePosition == 1) {
            head = deleteNode.next;
            deleteNode.next = null;
        } else if (deleteNodePosition == totalNodes) {
            Node n = getNodeOnPosition(totalNodes - 1);
            n.next = null;
            deleteNode.next = null;
        } else {
            Node n = getNodeOnPosition(deleteNodePosition - 1);
            n.next = deleteNode.next;
            deleteNode.next = null;
        }
    }

    public boolean detectLoop(Node node) {
        HashSet<Node> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node))
                return true;

            set.add(node);
            node = node.next;
        }
        return false;
    }
}
