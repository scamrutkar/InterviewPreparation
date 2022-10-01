package org.javacase.sagar.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) {

        int[] arr = {5,10,15,20,7,8};

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            insertHeap(i);
            sb.append(i);
            System.out.println("Median of stream [ "+sb+" ] is : "+getMedian());
            sb.append(", ");
        }


    }

    //Function to insert heap.
    public static void insertHeap(int x)
    {
        if(maxHeap.isEmpty() || maxHeap.peek() >= x)
            maxHeap.add(x);
        else
            minHeap.add(x);

        balanceHeaps();
    }

    //Function to balance heaps.
    public static void balanceHeaps()
    {
        if(maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if(maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    //Function to return Median.
    public static double getMedian()
    {
        System.out.println("MaxHeap : "+maxHeap);
        System.out.println("MinHeap : "+minHeap);
        if(maxHeap.size() == minHeap.size())
            return maxHeap.peek()/2.0 + minHeap.peek()/2.0;

        return maxHeap.peek();
    }

}
