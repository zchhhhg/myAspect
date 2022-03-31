package com.example.spring.algorithm;

import java.util.Arrays;

/**
 * @author zhoucheng
 * @description 查找算法
 * @date 2022-03-14-16:50
 */
public class Search {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(fibSearch(array,  4));
    }

    /**
     * 二分查找，必须保证数据是有序的 （递归）
     * @param array
     * @param left 数组查找的左边界
     * @param right 数组查找的右边界
     * @param findValue 要查找的数
     */
    public static int binarySearch(int[] array, int left, int right, int findValue){
        if(left>right){ // 找不到也结束递归
            return -1;
        }
        int middle = (left+right)/2;
        int midValue = array[middle];
        if(midValue>findValue){
            return binarySearch(array, left, middle-1, findValue);
        } else if(midValue<findValue){
            return binarySearch(array, middle+1, right, findValue);
        }else {
            return middle;
        }
    }

    /**
     * 二分查找 非递归算法
     * @param array
     * @param findValue
     * @return
     */
    public static int binarySearch2(int[] array, int findValue){
        int left = 0;
        int right = array.length-1;
        while (left <= right){
            int middle = (left+right)/2;
            if(array[middle] == findValue){
                return middle;
            }else if(array[middle] < findValue){
                left = middle+1;
            }else {
                right=middle-1;
            }
        }
        return -1;
    }

    /**
     * 插值查找 对于数据比较连续的有序数据使用
     * int mid = left+(right-left)*(findValue-array[left]/array[right]-array[left])
     */
    public static int InterPolationSearch(int[] array, int left, int right, int findValue) {
        if (left > right) { // 找不到也结束递归
            return -1;
        }
        int middle = left + (right - left) * ((findValue - array[left]) / (array[right] - array[left]));
        int midValue = array[middle];
        if (midValue > findValue) {
            return InterPolationSearch(array, left, middle - 1, findValue);
        } else if (midValue < findValue) {
            return InterPolationSearch(array, middle + 1, right, findValue);
        } else {
            return middle;
        }
    }

    /**
     * 斐波那契数列查找 F(k)=F(k-1)+F(k-2)
     * F(k)=F(k-1)+F(k-2) => F(k)-1=(F(k-1)-1)+(F(k-2)-1)+1 => mid=low+F(k-1)-1
     * 构造一个斐波那契数列以黄金分割点作为中值middle
     * @return
     */
    public static int fibSearch(int[] array, int findValue){
        int low = 0;
        int high = array.length-1;
        int[] fib = getFibArr(20);
        int k = 0;
        // 构造一个总长度大于或等于当前数组长度的斐波那契数列，若大于了则用最后一个数填充后面的
        if(high>fib[k]-1){
            k++;
        }
        int[] temp = Arrays.copyOf(array, k);
        for (int i = high+1; i < temp.length; i++) {
            temp[i] = temp[high];
        }
        if(low<high){
            int middle = low+fib[k-1]-1;
            // 左边占了F(k)的F(k-1)，右边占了F(k)的F(k-2)，所以往左找的时候需要将k替换为k-1,往右找的时候将k替换为k-2
            // F(k)表示当前截取出来的总长符合斐波那契数列的长度 因为斐波那契数列每一项与它的前一项都是黄金比例所以不需要再递归了，直接取前一项循环就行
            if(findValue<temp[middle]){
                high=middle-1;
                k=k-1;
            }else if(findValue>temp[middle]){
                low=middle+1;
                k=k-2;
            }else {
                return temp[middle];
            }
        }
        return -1;
    }

    /**
     * 获取一个定长的斐波那契数列
     * @param arrSize
     * @return
     */
    public static int[] getFibArr(int arrSize){
        int[] fib = new int[arrSize];
        fib[0]=1;
        fib[1]=1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib;
    }
}
