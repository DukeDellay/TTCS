/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mergeSort;
import java.util.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author PHUC DUC
 */
public class solve {

    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)) {
                S[i + j] = S1[i++];
            } else {
                S[i + j] = S2[j++];
            }
        }
    }

    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        merge(S1, S2, S, comp);
    }

    static Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return 1;
                else if (o1 == o2)
                    return 0;
                else
                    return -1;
            }
        };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer [] arr = new Integer[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, comparator);
        System.out.println(Arrays.toString(arr));   
    }
}
