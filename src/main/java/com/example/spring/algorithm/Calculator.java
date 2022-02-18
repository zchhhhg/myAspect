package com.example.spring.algorithm;

/**
 * @author zhoucheng
 * @description 栈实现计算器(中缀表达式)
 * @date 2022-02-10-11:27
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "30*4/20-1";
        ArrayCharStack operStack = new ArrayCharStack(10);
        ArrayStack valueStack = new ArrayStack(10);
        String tempStr = "";
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(isOperator(ch)){
                if(operStack.isEmpty()){
                    operStack.push(ch);
                }else {
                    if(comparePriority(operStack.getTopOne(), ch)){ // 如果即将要入栈的运算符优先级比当前栈顶的低或优先级一致，则从数值栈取出两个元素运算符栈取出一个元素运算完后把结果如数值栈再把这个运算符入栈
                        int secondNum = valueStack.pop();
                        int firstNum = valueStack.pop();
                        int result = getResult(firstNum, secondNum, operStack.pop());
                        valueStack.push(result);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }
            }else {
                if(i == expression.length()-1){ // 最后一个字符，不需要再判断会不会有多位数字了
                    valueStack.push(ch-48);
                }else {
                    if(!isOperator(expression.charAt(i+1))){ // 后一个字符也是数字
                        tempStr = tempStr+ch;
                        continue;
                    }else {
                        tempStr = tempStr+ch;
                        valueStack.push(Integer.parseInt(tempStr));
                        tempStr = "";
                    }
                }
            }
        }
        while (true){
            if(operStack.isEmpty()){
                break;
            }else {
                int secondNum = valueStack.pop();
                int firstNum = valueStack.pop();
                valueStack.push(getResult(firstNum,secondNum,operStack.pop()));
            }
        }
        System.out.println(valueStack.getTopOne());
    }

    // 某字符是否是运算符
    public static boolean isOperator(char c){
        return c=='+'||c=='-'||c=='*'||c=='/';
    }

    // 两数运算
    public static int getResult(int a,int b, char oper){
        int result = 0;
        switch (oper){
            case  '+':
                result = a+b;
                break;
            case  '-':
                result = a-b;
                break;
            case  '*':
                result = a*b;
                break;
            case  '/':
                result = a/b;
                break;
        }
        return result;
    }

    // 比较运算符优先级
    public static boolean comparePriority(char oper1, char oper2){
        return getPriority(oper1)>=getPriority(oper2);//列举出优先级高的情况，其他都是低
    }

    private static int getPriority(char oper){
        if(oper=='+'||oper=='-'){
            return 0;
        }
        if(oper=='*'||oper=='/'){
            return 2;
        }
        return -1;
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
            if(isFull()){
                System.out.println("栈满，无法继续入栈");
                return;
            }
            top++;
            stack[top] = element;
            System.out.println("元素"+element+"已入栈");
        }
        // 出栈
        public int pop(){
            if(isEmpty()){
                throw new RuntimeException("栈空，无法继续出栈");
            }
            int topOne = stack[top];
            System.out.println("元素"+stack[top]+"已出栈");
            top--;
            return topOne;

        }
        // 栈是否为空
        public boolean isEmpty(){
            return top == -1;
        }
        // 栈是否满了
        public boolean isFull(){
            return top+1 == maxSize;
        }
        // 取出栈顶元素
        public int getTopOne(){
            return stack[top];
        }
    }

    public static class ArrayCharStack {
        private int maxSize;
        private char[] stack;
        private int top = -1;

        public ArrayCharStack(int maxSize) {
            this.maxSize = maxSize;
            stack = new char[maxSize];
        }
        // 入栈
        public void push(char element){
            if(isFull()){
                System.out.println("栈满，无法继续入栈");
                return;
            }
            top++;
            stack[top] = element;
            System.out.println("元素"+element+"已入栈");
        }
        // 出栈
        public char pop(){
            if(isEmpty()){
                throw new RuntimeException("栈空，无法继续出栈");
            }
            char topOne = stack[top];
            System.out.println("元素"+stack[top]+"已出栈");
            top--;
            return topOne;
        }
        // 栈是否为空
        public boolean isEmpty(){
            return top == -1;
        }
        // 栈是否满了
        public boolean isFull(){
            return top+1 == maxSize;
        }
        // 取出栈顶元素
        public char getTopOne(){
            return stack[top];
        }
    }
}
