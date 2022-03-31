package com.example.spring.algorithm;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zhoucheng
 * @description KMP算法 由三个人联名发表，所以命名从三个人的名字中各取了一个字母
 * 部分匹配表，减少暴力匹配法的回溯次数 可跳过的位数=已匹配字符数-对应的部分匹配值
 * @date 2022-03-21-13:57
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String sStr = "abcdefabcbsdfsdfs";
        String tStr = "bsdfsd";
        System.out.println(getStrIndex2(sStr, tStr));
    }
    public static int getStrIndex(String sourceStr, String targetStr){
        int[] partMatchArr = getKMPPartMatchArr(targetStr);
        for (int i=0,j=0;i<sourceStr.length();i++){
            // todo
            while (j>0&&sourceStr.charAt(i)!=targetStr.charAt(j)){
                j=partMatchArr[j-1];
            }
            if(sourceStr.charAt(i)==targetStr.charAt(j)){
                j++;
            }
            if(j==targetStr.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    /**
     * 部分匹配表 部分匹配值为前后缀最长的共有元素长度
     * ABCDAB 前缀【A,AB,ABC,ABCD,ABCDA】后缀【BCDAB,CDAD,DAB,AB,B】共有元素为AB，长度为2 即部分匹配值为2
     */
    public static int[] getKMPPartMatchArr(String dest){
        int[] arr = new int[dest.length()];
        arr[0]=0;
        for (int i = 1,j = 0; i < dest.length(); i++) {
            // ??? todo
            while (j>0 && dest.charAt(i)!=dest.charAt(j)){
                j=arr[j-1];
            }
            if(dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            arr[i]=j;
        }
        return arr;
    }

    public static int getStrIndex2(String sourceStr, String targetStr){
        int i=0;
        int j=0;
        int[] partMatchArr = getKMPPartMatchArr2(targetStr);
        while (i<sourceStr.length()&&j<targetStr.length()){
            char sChar = sourceStr.charAt(i);
            char tChar = targetStr.charAt(j);
            if(sChar==tChar){
                i++;
                j++;
            }else {
                i=i+1-partMatchArr[j];//i-j+1+j-partMatchArr[j]
                j=0;
            }
        }
        if(j==targetStr.length()){
            return i-j;
        }else {
            return -1;
        }
    }

    /**
     * 获取部分匹配表方法2 上面那个暂时无法理解，用正常取前后缀并集最大长度算部分匹配值
     * @param dest
     * @return
     */
    public static int[] getKMPPartMatchArr2(String dest){
        int[] arr = new int[dest.length()];
        arr[0]=0;
        HashSet<String> prefixStr = new HashSet<>();
        HashSet<String> suffixStr = new HashSet<>();
        for (int i = 1; i < dest.length(); i++) {
            String temp = dest.substring(0, i+1);
            prefixStr.clear();
            suffixStr.clear();
            for (int j = 1; j < temp.length(); j++) {
                prefixStr.add(temp.substring(0,j));
                suffixStr.add(temp.substring(j));
            }
            prefixStr.retainAll(suffixStr);
            String value = "";
            for (String str : prefixStr) {
                if(str.length()>value.length()){
                    value = str;
                }
            }
            arr[i] = value.length();
        }
        return arr;
    }
}
