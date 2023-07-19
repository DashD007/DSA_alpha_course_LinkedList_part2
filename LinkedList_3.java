package LinkedList_part2;

import java.util.LinkedList;

public class LinkedList_3 {
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

    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
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

    public Node merge(Node head1,Node head2){
        Node mergedll = new Node(-1);
        Node temp = mergedll;
        while(head1!= null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1!=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2!= null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedll.next;
    }
    public Node mergeSort(Node head){
        if(head== null || head.next==null){
            return head;
        }
        //step 1 find middle of the linkedlist..
        Node mid = findMid(head);

        //step 2 find left half and right half of the linked list..
        Node head1 = head;
        Node head2 = mid.next;
        mid.next = null;
        Node left = mergeSort(head1);
        Node right = mergeSort(head2);
        return merge(left,right);
    }

    public static void Print(Node head){
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        //here we will learn about the mergesort for linkedlist..
        LinkedList_3 ll = new LinkedList_3();
        ll.add(5);
        ll.add(9);
        ll.add(11);
        ll.add(3);
        ll.add(8);
        Print(head);
        ll.head = ll.mergeSort(head);
        Print(head);

    }
}
