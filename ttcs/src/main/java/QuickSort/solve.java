/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuickSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author PHUC DUC
 */
public class solve {
    public static <K> void quickSortInPlace(K[] S, Comparator<K> comp, int a, int b) {
        if (a >= b) return;
        int left = a;
        int right = b-1;
        K pivot = S[b];
        K temp;
        while (left <= right) {
            while (left <= right && comp.compare(S[left], pivot) < 0) left++;
            while (left <= right && comp.compare(S[right], pivot) > 0) right--;
            if (left <= right) {
                temp = S[left]; S[left] = S[right]; S[right] = temp;
                left++; right--;
            }
        }
        temp = S[left]; S[left] = S[b]; S[b] = temp;
        quickSortInPlace(S, comp, a, left-1);
        quickSortInPlace(S, comp, left+1, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer [] arr = new Integer[n];
        for(int i=0; i<n ;i++){
            arr[i] = sc.nextInt();
        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return 1;
                else if (o1 == o2)
                    return 0;
                else
                    return -1;
            }
        };
        quickSortInPlace(arr, comparator, 0, n-1);
        System.out.println(Arrays.toString(arr));   
    }
}
