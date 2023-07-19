package LinkedList_part2;

public class DoublyLinkedList_2 {
    public static class Node{
        int data;
        Node prev;
        Node next;
        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public void add(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
    }
    public static void Print(Node head){
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void ReverseDoublyLinkedList(){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        // here we will learn how to reverse a doubly linkedlist..
        DoublyLinkedList_2 dll = new DoublyLinkedList_2();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.add(5);
        Print(head);
        dll.ReverseDoublyLinkedList();
        Print(head);
    }
}
