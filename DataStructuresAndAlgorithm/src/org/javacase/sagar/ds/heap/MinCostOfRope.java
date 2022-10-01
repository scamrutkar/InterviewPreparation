package org.javacase.sagar.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostOfRope {

    public static void main(String[] args) {
        long[] arr = {4, 2, 7, 6, 9};
        System.out.println(minCost(arr,arr.length));
    }

    static long minCost(long arr[], int n)
    {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Arrays.stream(arr).forEach( i -> queue.add(i));
        long totalCost = 0;
        while (queue.size() > 1) {
            long currCost = queue.remove() + queue.remove();
            totalCost += currCost;
            queue.add(currCost);
        }
        return totalCost;
    }
}
