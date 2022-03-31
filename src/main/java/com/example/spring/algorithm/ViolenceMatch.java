package com.example.spring.algorithm;

import javax.swing.text.ParagraphView;

/**
 * @author zhoucheng
 * @description 暴力匹配 返回字符串b在字符串a中第一次出现的位置
 * @date 2022-03-21-13:11
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String sStr = "abcdefabcb";
        String tStr = "cb";
        System.out.println(getStrIndex(sStr, tStr));
    }

    public static int getStrIndex(String sourceStr, String targetStr){
        int i=0;
        int j=0;
        while (i<sourceStr.length()&&j<targetStr.length()){
            char sChar = sourceStr.charAt(i);
            char tChar = targetStr.charAt(j);
            if(sChar==tChar){
                i++;
                j++;
            }else {
                i=i-j+1;
                j=0;
            }
        }
        if(j==targetStr.length()){
            return i-j;
        }else {
            return -1;
        }
    }
}
