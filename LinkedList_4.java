package LinkedList_part2;

public class LinkedList_4 {
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
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public static void Print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node zigzag(Node head){
        //step 1 find middle node which is the last node of 1st half..
        Node mid = findMid(head);
        //step 2 ..divide the linked list into two halves..and reverse the second half..
        Node head1 = head;
        Node head2 = mid.next;
        mid.next = null;
        //reversing the second linkedlist..
        Node prev = null;
        Node curr = head2;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head2 = prev;
        //now join both of the linked list in zigzag fashion..
        Node mergell = new Node(-1);
        Node temp = mergell;
        while(head1!= null && head2!=null){
            temp.next= head1;
            temp = temp.next;
            head1 = head1.next;

            temp.next = head2;
            temp = temp.next;
            head2 = head2.next;
        }
        while(head1!=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        return mergell.next;
    }
    public static void main(String[] args) {
        // here we will learn how to convert a normal linkedlist into zigzag linkedlist..
        //1->2->3->4->5
        //1->5->2->4->3
        LinkedList_4 ll = new LinkedList_4();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        Print(head);
        ll.zigzag(head);
        Print(head);
    }
}
