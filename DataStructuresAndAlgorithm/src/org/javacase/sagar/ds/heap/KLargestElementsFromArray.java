package org.javacase.sagar.ds.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElementsFromArray {

    public static void main(String[] args) {

        int[] arr = {5,2,6,10,1};
        int[] result = kLargest(arr,arr.length,3);
        Arrays.stream(result).forEach(System.out::print);

    }

    static int[] kLargest(int[] arr, int n, int k) {

        int[] result = new int[k];

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            queue.add(i);
        }
        int i=0;
        while(k-- > 0){
            result[i++] = queue.remove();
        }

        return result;
    }
}
