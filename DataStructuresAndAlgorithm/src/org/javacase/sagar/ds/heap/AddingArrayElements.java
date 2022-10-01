package org.javacase.sagar.ds.heap;
/*
    Input:
    N = 6, K = 6
    Arr[] = {1, 10, 12, 9, 2, 3}
    Output: 2
    Explanation: First we add (1 + 2), now the
    new list becomes 3 10 12 9 3, then we add
    (3 + 3), now the new list becomes 6 10 12 9,
    Now all the elements in the list are greater
    than 6. Hence the output is 2 i:e 2 operations
    are required to do this.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class AddingArrayElements {

    public static void main(String[] args) {

        int[] arr = {1,10,12,9,2,3};
        System.out.println(minOperations(arr,arr.length,55));
    }

    static int minOperations(int[] arr, int n, int k) {
        int minOps = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(arr).forEach(key -> queue.add(key));
        while(true){
            if(queue.peek() >= k ) break;
            else if(queue.size() ==1) return -1;
            else{
                int currSum = queue.poll() + queue.poll();
                queue.add(currSum);
                minOps++;
            }
        }
        return minOps;
    }
}
