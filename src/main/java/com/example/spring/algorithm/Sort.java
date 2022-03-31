package com.example.spring.algorithm;

import java.util.Arrays;

/**
 * @author zhoucheng
 * @description 排序算法
 * @date 2022-02-14-17:07
 */
public class Sort {
    public static void main(String[] args) {
        int arr[] = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100000);
        }
//        int arr[] = {6,5,4,3,2,1};
        long t1 = System.currentTimeMillis();
//        mergeSort(arr,0,arr.length-1,new int[arr.length]);
        radixSort(arr);
        System.out.println(System.currentTimeMillis()-t1);
        System.out.println(Arrays.toString(arr));
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
    // 10条数据，先分成5组，每组两个元素，取05,16,27,38,49，再分成2组，每组10个元素，02468,13579，再分成一组
    public static void shellSort(int[] array){
        for(int gap=array.length/2; gap>0; gap=gap/2){
            // 遍历各组中的所有元素（共gap组，每组有array.length/gap个元素，步长gap）
            for(int i=gap;i<array.length;i++){
                for(int j=i-gap;j>=0;j=j-gap){
                    if(array[j]>array[j+gap]){
                        int temp = array[j+gap];
                        array[j+gap] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    // 快速排序 以某个数为基准，将比其小的放左边，比其大的放在右边，再对左右两个小组分别进行快速排序，知道整个数组有序
    // 并不是说找到的那个为基准的数不会动位置，只是每次排序后要保证pivot左边的都比其小，右边的都比其大
    public static void quickSort(int[] array,int left,int right){
        int l = left;
        int r = right;
        int pivot=array[(left+right)/2];
        while (l<r){
            while ( array[l]<pivot){
                l++;
            }
            while (array[r]>pivot){
                r--;
            }
            if(l>=r){
                break;
            }
            int temp = array[l];
            array[l]=array[r];
            array[r]=temp;
            if(array[l]==pivot){
                r--;
            }
            if(array[r]==pivot){
                l++;
            }
        }
        if(l==r){
            l++;
            r--;
        }
        if(left<r){
            quickSort(array, left, r);
        }
        if(right>l){
            quickSort(array, l, right);
        }
    }
    /** 归并排序 利用一个与arr等长的临时数组tempArr以空间换时间
     *  1)比较的两个数组分别从第一个位置开始，将较小的数据放到tempArr，知道某一个数据被全部遍历完
     *  2)将剩下的这个数组的数据依次拷贝到tempArr
     *  3)将tempArr中的数据整体拷贝回原数组arr
     *  i 数组一当前遍历到的数据索引
     *  j 数组二当前遍历到的数据索引
     *  t tempArr当前遍历到的数据索引
     */
    public static void mergeSort(int[] arr, int left,int right,int [] tempArr){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr, left, mid, tempArr);
            mergeSort(arr, mid+1, right, tempArr);
            sort(arr, left, right, tempArr);
        }
    }
    public static void sort(int[] arr,int left, int right, int [] tempArr){
        int i = left,mid=(left+right)/2,j=mid+1,t=0;
        // 比较的两个数组分别从第一个位置开始，将较小的数据放到tempArr，知道某一个数组被全部遍历完
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                tempArr[t] = arr[i];
                t++;
                i++;
            }else {
                tempArr[t] = arr[j];
                t++;
                j++;
            }
        }
        // 将剩下的这个数组的数据依次拷贝到tempArr
        while (i<=mid){
            tempArr[t] = arr[i];
            t++;
            i++;
        }
        while (j<=right){
            tempArr[t] = arr[j];
            t++;
            j++;
        }
        // 将tempArr中的数据整体拷贝回原数组arr
        t = 0;
        int tempLeft = left;
        while (tempLeft<=right){
            arr[tempLeft]=tempArr[t];
            tempLeft++;
            t++;
        }
    }
    /**
     * 基数排序（桶排序的扩展）
     * 定义10个桶，先按个位数依次放入相应桶中取出，再按十位依次放入桶中并取出...最后的数组就是有序的
     * 以空间换时间，需要一个10行的二位数组作为容器桶，还需要一个用来计数每个桶存了多少个数据的一维数组
     */
    public static void radixSort(int [] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        int maxDigit = (max+"").length();
        for(int i=0,n=1;i<maxDigit;i++,n=n*10) {
            int[][] radixArr = new int[10][arr.length];
            int[] count = new int[10];
            for (int j = 0; j < arr.length; j++) {
                int data = arr[j]/n%10;
                radixArr[data][count[data]] = arr[j];
                count[data]++;
            }
            int index = 0;
            for (int k = 0; k < radixArr.length; k++) {
                if (count[k] != 0) {
                    for (int j = 0; j < count[k]; j++) {
                        arr[index] = radixArr[k][j];
                        index++;
                    }
                    count[k] = 0;//取出后将计数count相应索引下的置清零
                }
            }
        }
    }
}
