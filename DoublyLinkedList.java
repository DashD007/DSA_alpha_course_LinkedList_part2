package LinkedList_part2;

public class DoublyLinkedList {
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addfirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            size++;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;
    }
    //addlast function
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
        size++;
    }
    //remove from begining..
    public int removeFirst(){
        if(head==null){
            System.out.println("linkedlist is empty");
            return Integer.MIN_VALUE;
        }
        else if(head.next == null){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    //remove from last..
    public int removelast(){
        if(head==null){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        else if(head.next == null){
            int val = head.data;
            head = tail =null;
            size--;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next =null;
        size--;
        return val;
    }

    //print function
    public void Print(){
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        // here we will learn how to implement Doubly LinkedList and its functions..
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addfirst(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.Print();
        System.out.println(dll.removeFirst());
        System.out.println(dll.removelast());
        dll.Print();
    }
}
