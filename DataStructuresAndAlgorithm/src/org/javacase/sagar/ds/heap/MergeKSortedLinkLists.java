package org.javacase.sagar.ds.heap;

import java.util.PriorityQueue;

public class MergeKSortedLinkLists {

    static Node head;
    static Node temp;

    public static void main(String[] args) {
        // Number of linked lists
        int k = 3;

        // Number of elements in each list
        int n = 4;

        // an array of pointers storing the
        // head nodes of the linked lists

        Node[] arr = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        // Merge all lists
        head = mergeKList(arr, k - 1);
        while(head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    static class MinHeapNode implements Comparable<MinHeapNode>{

        Node node;

        public MinHeapNode(Node node){
            this.node = node;
        }

        @Override
        public int compareTo(MinHeapNode o) {
            if(this.node.data <= o.node.data) return -1;
            else return 1;
        }
    }

    static Node mergeKList(Node[] arr,int K)
    {
        PriorityQueue<MinHeapNode> queue = new PriorityQueue<>();

        for(int i=0;i<=K;i++){
            queue.add(new MinHeapNode(arr[i]));
        }

        Node head = null, temp = null;

        while(!queue.isEmpty()){
            MinHeapNode root = queue.remove();
            if(temp == null) {
                head = root.node;
                temp = head;
            }
            else {
                temp.next = root.node;
                temp = temp.next;
            }

            if(root.node.next != null){
                queue.add(new MinHeapNode(root.node.next));
            }
        }

        return head;
    }
}
