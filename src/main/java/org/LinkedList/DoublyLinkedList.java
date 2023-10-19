package org.LinkedList;

public class DoublyLinkedList {

    public static class Node {
        int data;
        Node prevNode;
        Node nextNode;
        Node(int data) {
            this.data = data;
            this.prevNode = null;
            this.nextNode = null;
        }
    }

        static Node head;

        public static void main(String[] args) {

            Node node = new Node(100);
            head = node;
            head.nextNode = new Node(200);
            head.nextNode.prevNode = head;
            printLinkedList();
            appendNodeAtFirst(new Node(500));
            printLinkedList();
            appendNodeAtEnd(new Node(600));
            printLinkedList();
        }

        private static void printLinkedList(){
            System.out.println("-------------");
            Node node = head;
            while (node!=null){
                System.out.println("val: " + node.data);
                node = node.nextNode;
            }
        }

        private static void appendNodeAtFirst(Node node){
            if(node==null){
                System.out.println("The given node is null");
            }else {
                node.nextNode = head;
                head.prevNode = node;
                node.prevNode = null;
                head = node;
            }
        }

        private static void appendNodeAtEnd(Node node){
            if(node==null){
                System.out.println("The given node is null");
            }else {
                Node n = head;
                while (n.nextNode!=null){
                    n = n.nextNode;
                }
                n.nextNode = node;
                node.prevNode = n;
            }
        }

        private static void appendNodeAtSpecifiedPos(){

        }

}
