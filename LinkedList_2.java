package LinkedList_part2;

public class LinkedList_2 {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = next;
            size++;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void add(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean flag = false;
        //check cycle
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                flag = true;
                break;
            }
        }
        if(flag==true){
            slow = head;
            Node prev =null;
            while(slow != fast){
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            //fast is at prev node to last node;
            prev.next = null; // now cycle is removed;;
        }
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

    public static void print(){
        Node temp = head;
        int i =0;
        while(temp!=null && i<=size){
            System.out.print(temp.data+"->");
            temp = temp.next;
            i++;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        // here we will learn how to remove cycle from a linkedlist...
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;

        print();
        System.out.println(DetectCycle());
        removeCycle();
        System.out.println(DetectCycle());
        //print();

    }
}
