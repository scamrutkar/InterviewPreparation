package org.javacase.sagar.ds.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{2,2,3,4},
                {5,5,6,6},{7,8,9,9}};
        List<Integer> list = mergeKArrays(arr,arr.length);
        list.forEach(System.out::print);
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K)
    {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();


        for(int[] l : arr){
            for(int j : l){
                queue.add(j);
            }
        }

        while(queue.size() > 0) {
            list.add(queue.remove());
        }
        return list;

    }
}
