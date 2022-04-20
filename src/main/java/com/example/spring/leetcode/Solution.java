package com.example.spring.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author zhoucheng
 * @description
 * @date 2022-04-07-17:49
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("([)]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            }else {
                char end = stack.peek();
                if(map.get(end)!=null&&map.get(end)==c){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size()==0;
    }
}
