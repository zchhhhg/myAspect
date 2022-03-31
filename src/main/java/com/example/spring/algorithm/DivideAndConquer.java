package com.example.spring.algorithm;

/**
 * @author zhoucheng
 * @description 分治算法 将一个问题分解成相似的多个小问题
 * @date 2022-03-19-15:41
 */
public class DivideAndConquer {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    // 汉诺塔问题 有ABC三个柱子，A柱从小到大堆了n个圆盘，要将所有圆盘移到C柱并保证最终的顺序也是从小到大
    // 分治递归
    public static void hanoiTower(int num, char a, char b,char c){
        if(num==1){
            System.out.println("第1个圆盘从"+a+"移动到"+c);
        }else {
            hanoiTower(num-1, a, c, b);
            System.out.println("第"+num+"个圆盘从"+a+"移动到"+c);
            hanoiTower(num-1, b, a, c);
        }
    }
}
