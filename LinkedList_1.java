package LinkedList_part2;

public class LinkedList_1 {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;


    public void add(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail= newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static boolean DetectCycle(){
        if(head==null){
            return false;
        }
        else if(head.next == head){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // here we will learn how to write code to detect the cycle in the linked list..
        LinkedList_1 ll = new LinkedList_1();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;

        //1->2->3->1
        System.out.println(DetectCycle());
    }
}
