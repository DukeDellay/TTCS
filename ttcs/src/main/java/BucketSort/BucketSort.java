/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BucketSort;

/**
 *
 * @author PHUC DUC
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BucketSort {

    public static void bucketSort(float[] arr, int n) {
        if (n <= 0) {
            return;
        }
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] bucket = new ArrayList[n];

        // Tạo các bucket trống
        for (int i = 0; i < n; i++) {
            bucket[i] = new ArrayList<Float>();
        }

        // Thêm phần tử vào trong bucket
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) arr[i] * n;
            bucket[bucketIndex].add(arr[i]);
        }

        // Sắp xếp các phần tử trong mỗi bucket
        for (int i = 0; i < n; i++) {
            Collections.sort((bucket[i]));
        }

        // Lấy mảng đã sắp xếp
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0, size = bucket[i].size(); j < size; j++) {
                arr[index++] = bucket[i].get(j);
            }
        }
    }

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        float [] arr = new float[m];
        for(int i=0;i<m;i++){
            arr[i] = sc.nextFloat();
        }
        
        bucketSort(arr, m);

        System.out.println(Arrays.toString(arr)); 
    }
}
