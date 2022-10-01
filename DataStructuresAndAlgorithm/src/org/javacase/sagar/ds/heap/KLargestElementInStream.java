package org.javacase.sagar.ds.heap;

/*
Input:
k = 4, n = 6
arr[] = {1, 2, 3, 4, 5, 6}
Output:
-1 -1 -1 1 2 3
Explanation:
k = 4
For 1, the 4th largest element doesn't
exist so we print -1.
For 2, the 4th largest element doesn't
exist so we print -1.
For 3, the 4th largest element doesn't
exist so we print -1.
For 4, the 4th largest element is 1.
For 5, the 4th largest element is 2.
for 6, the 4th largest element is 3.
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElementInStream {

    public static void main(String[] args) {
        int[] arr = {3,4,6,7,1,2,6};
        int[] result = kthLargest(4,arr,arr.length);
        Arrays.stream(result).forEach(System.out::println);

    }

    static int[] kthLargest(int k, int[] arr, int n) {
        int[] result = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        for (int val : arr) {

            if (queue.size() < k)
                queue.add(val);

            else {
                if (val > queue.peek()) {
                    queue.poll();
                    queue.add(val);
                }
            }

            if (queue.size() >= k) result[count++] = queue.peek();
            else result[count++] = -1;
        }
        return result;
    }
}
