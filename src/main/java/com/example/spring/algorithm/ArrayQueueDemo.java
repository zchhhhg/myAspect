package com.example.spring.algorithm;

/**
 * @author zhoucheng
 * @description 数组实现队列
 * @date 2022-02-08-11:15
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        CircularArrayQueue arrayQueue = new CircularArrayQueue(4);
        arrayQueue.enQueue(1);
        arrayQueue.enQueue(2);
        arrayQueue.enQueue(3);
        arrayQueue.showArray();
        arrayQueue.deQueue();
        arrayQueue.enQueue(4);
        arrayQueue.deQueue();
        arrayQueue.enQueue(5);
        arrayQueue.showArray();
        arrayQueue.enQueue(6);
    }

    public static class ArrayQueue {
        private int maxSize;
        private int front;
        private int rear;
        private int[] array;

        public ArrayQueue(int size) {
            maxSize = size;
            front = -1; // 指向队列头部的前一个位置
            rear = -1; // 指向队列的尾部（包含队列尾的数据）
            array = new int[size];
        }

        // 判断队列是否满了
        public boolean isFull(){
            return rear == maxSize-1;
        }

        // 判断队列为空
        public boolean isEmpty(){
            return front == rear;
        }

        // 入队
        public void enQueue(int n){
            if(isFull()){
                System.out.println("队满，无法继续添加数据");
                return;
            }else {
                rear++;
                array[rear] = n;
            }
        }

        // 出队
        public int deQueue(){
            if(isEmpty()){
                throw new RuntimeException("队空，无法继续取出数据");
            }else {
                front++;
                return array[front];
            }
        }

        // 显示队列当前的数据
        public void showArray(){
            for (int arr : array) {
                System.out.println(arr);
            }
        }
    }

    // 数组环形队列
    public static class CircularArrayQueue {
        private int maxSize;
        private int front;
        private int rear;
        private int[] array;

        public CircularArrayQueue(int size) {
            maxSize = size;
            front = 0; // 指向队列第一个元素
            rear = 0; // 指向队列最后一个元素的最后一个位置（空出一个位置作为约定）
            array = new int[size];
        }

        // 判断队列是否满了
        public boolean isFull(){
            return (rear+1) % maxSize == front;
        }

        // 判断队列为空
        public boolean isEmpty(){
            return front == rear;
        }

        // 入队
        public void enQueue(int n){
            if(isFull()){
                System.out.println("队满，无法继续添加数据");
                return;
            }else {
                array[rear] = n;
                System.out.println("元素入队："+n);
                if(rear==maxSize-1){
                    rear=0;
                }else{
                    rear++;
                }
            }
        }

        // 出队
        public void deQueue(){
            if(isEmpty()){
                throw new RuntimeException("队空，无法继续取出数据");
            }else {
                System.out.println("元素出队："+array[front]);
                if(front==maxSize-1){
                    front=0;
                }else{
                    front++;
                }
            }
        }

        // 显示队列当前的数据
        public void showArray(){
            for (int i = front; i < front + getNums(); i++) {
                System.out.printf("arr[%d]=%d\n", i%maxSize,array[i%maxSize]);
            }
        }

        // 当前队列包含的元素个数
        public int getNums(){
            return (maxSize-front+rear)%maxSize;
        }
    }
}
