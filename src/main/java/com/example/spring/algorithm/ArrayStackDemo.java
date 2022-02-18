package com.example.spring.algorithm;

/**
 * @author zhoucheng
 * @description
 * @date 2022-02-10-10:03
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.pop();
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
    }

    public static class ArrayStack {
        private int maxSize;
        private int[] stack;
        private int top = -1;

        public ArrayStack(int maxSize) {
            this.maxSize = maxSize;
            stack = new int[maxSize];
        }
        // 入栈
        public void push(int element){
            if(top+1 == maxSize){
                System.out.println("栈满，无法继续入栈");
                return;
            }
            top++;
            stack[top] = element;
            System.out.println("元素"+element+"已入栈");
        }
        // 出栈
        public void pop(){
            if(top == -1){
                System.out.println("栈空，无法继续出栈");
                return;
            }
            System.out.println("元素"+stack[top]+"已出栈");
            top--;
        }
    }
}
