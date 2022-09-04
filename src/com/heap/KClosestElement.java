package com.heap;

import javafx.util.Pair;

import java.util.*;

public class KClosestElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(findClosestElementsWithHeap(arr, 4, 3));
    }

    public static List<Integer> findClosestElementsWithHeap(int[] arr, int k, int x) {
        int n = arr.length;
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1.getKey() < o2.getKey()) {
                    return 1;
                } else if (o1.getKey() > o2.getKey()) {
                    return -1;
                } else {
                    if (o1.getValue() < o2.getValue()) {
                        return 1;
                    } else if (o1.getValue() > o2.getValue()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        for(int i = 0; i < n; i++) {
            maxHeap.add(new Pair<>(Math.abs(arr[i] - x), i));
            if (maxHeap.size() == k + 1) {
                maxHeap.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            int index = maxHeap.peek().getValue();
            ans.add(arr[index]);
            maxHeap.poll();
        }
        Collections.sort(ans);
        return ans;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int i, j;
        int index = binarySearch(arr, x, 0, arr.length - 1);
        if (index - k - 1 >= 0) {
            i = index - k;
        } else {
            i = 0;
        }
        if (index + k + 1 <= arr.length -1) {
            j = index + k;
        } else {
            j = arr.length - 1;
        }
        for(; j - i + 1 > k;) {
            if (Math.abs(x - arr[i]) <= Math.abs(x - arr[j])) {
                j--;
            } else {
                i++;
            }
        }
        while(i <= j) {
            ans.add(arr[i]);
            i++;
        }
        return ans;
    }

    int binarySearch(int[] arr, int x, int i, int j) {
        int mid;
        while(i < j) {
            mid = (i + j) / 2;
            if (arr[mid] > x) {
                j = mid - 1;
            } else if (arr[mid] < x) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return j;
    }

}
