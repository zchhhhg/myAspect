package com.example.spring.algorithm;

/**
 * @author zhoucheng
 * @description 递归 迷宫回溯问题
 * 0表示没有走过的路，1表示障碍物，2表示通路，3表示走不通的路
 * @date 2022-02-11-10:21
 */
public class Recursion {
    public static void main(String[] args) {
        int[][] array = new int[8][8];
        for(int i=0;i<8;i++){
            array[0][i]=1;
            array[7][i]=1;
        }
        for(int i=0;i<8;i++){
            array[i][0]=1;
            array[i][7]=1;
        }
        array[3][1]=1;
        array[3][2]=1;
        getWay(array,1,1);
        showArray(array);
    }

    /**
     * 递归回溯
     * 按照下右上左的顺序依次寻路
     * @return
     */
    public static boolean getWay(int[][] array,int x,int y){
        if(array[6][6]==2){
            return true;
        }else if(array[x][y]==0){
            array[x][y] = 2;
            if(getWay(array,x+1,y)){
                return true;
            }else if(getWay(array,x,y+1)){
                return true;
            }else if(getWay(array,x-1,y)){
                return true;
            }else if(getWay(array,x,y-1)){
                return true;
            }else { // 各个方向都走不通，将该点标识为不通
                array[x][y]=3;
                return false;
            }
        }else {
            return false;
        }
    }

    // 打印二位数组
    private static void showArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%d ",array[i][j]);
            }
            System.out.println();
        }
    }
}
