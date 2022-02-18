package com.example.spring.algorithm;

/**
 * @author zhoucheng
 * @description 链表
 * @date 2022-02-08-16:55
 */
public class LinkedList {
    public static void main(String[] args) {
//        SingleLinkedNode singleLinkedNode = new SingleLinkedNode();
//        LinkedNode node1 = new LinkedNode("123");
//        LinkedNode node2 = new LinkedNode("456");
//        LinkedNode node3 = new LinkedNode("789");
//        singleLinkedNode.addNode(node1);
//        singleLinkedNode.addNode(node2);
//        singleLinkedNode.addNode(node3);
//        singleLinkedNode.getList();
        System.out.println(3/2);
    }

    public static class SingleLinkedNode{
        LinkedNode header = new LinkedNode("");

        // 往链表中增加元素
        public void addNode(LinkedNode node){
            LinkedNode tempNode = header;
            while (true){
                if(tempNode.next == null){
                    break;
                }else {
                    tempNode = tempNode.next;
                }
            }
            tempNode.next = node;
        }

        // 遍历打印链表
        public void getList(){
            if(header.next==null){
                System.out.println("当前链表为空");
                return;
            }else {
                LinkedNode tempNode = header;
                while (true){
                    if(tempNode == null){
                        break;
                    }else {
                        System.out.println(tempNode.getValue());
                        tempNode=tempNode.next;
                    }
                }
            }
        }
    }

    public static class LinkedNode{
        private String value;
        private LinkedNode next;

        public String getValue() {
            return value;
        }

        public LinkedNode(String str) {
            value = str;
        }
    }
}
