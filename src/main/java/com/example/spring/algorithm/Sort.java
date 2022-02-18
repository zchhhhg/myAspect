package com.example.spring.algorithm;

import com.example.spring.aspect.AroundAdvice;

import java.util.Map;

/**
 * @author zhoucheng
 * @description
 * @date 2022-02-14-17:07
 */
public class Sort {
    public static void main(String[] args) {
//        int array[] = {6,5,4,3,2,1};
//        selectionSort(array);
        int arr[] = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        long t1 = System.currentTimeMillis();
        insertionSort(arr);
        System.out.println(System.currentTimeMillis()-t1);
    }
    // 冒泡排序 两两前后比较把大的往后排，一次循环可以确定一个最大的数放在最后一位，再次循环确定一个最大的数放在倒数第二位
    private static void bubbleSort(int[] array){
        for(int j=array.length;j>1;j--) {
            boolean flag = true;
            for (int i = 0; i < j-1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    flag = false;
                }
            }
            if(flag){ // 只要有任意一次没发生过交换，说明剩下的数据是有序的，无需再冒泡
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    // 选择排序，每次循环找到一个最小的数的坐标与数组首位进行交换
    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int seat = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j]<array[seat]){
                    seat=j;
                }
            }
            if(seat!=i){
                int temp = array[seat];
                array[seat] = array[i];
                array[i] = temp;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    // 插入排序 从第二个元素开始往之前的数组插入，使数组逐渐有序
    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i-1; j >= -1; j--) {
                if(j==-1){
                    array[0]=temp;
                }else {
                    if(array[j]>temp){
                        array[j+1]=array[j];
                    }else {
                        if(j!=i-1){
                            array[j]=temp;
                        }
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    // 希尔排序 按照一定的步长分组分别进行插入排序，逐渐缩小步长直到为1
    public static void shellSort(int[] array){

    }
}
