package com.example.spring.algorithm;

/**
 * @author zhoucheng
 * @description 稀疏数组
 * 只保留有效值的坐标以达到压缩数组的目的
 * @date 2022-02-08-10:36
 */
public class SparseArray {
    public static void main(String[] args) {
        int originArray[][] = new int[11][11];
        originArray[1][2] = 1;
        originArray[2][3] = 2;
        System.out.println("原始的二维数组：");
        for(int[] row : originArray){
            for (int item : row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
        System.out.println("转换为稀疏数组：");
        int [][] sparseArray = changeSparseArray(originArray);
        for(int[] row : sparseArray){
            for (int item : row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
        System.out.println("还原为二维数组：");
        int [][] restoreArray = restoreSparseArray(sparseArray);
        for(int[] row : restoreArray){
            for (int item : row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }

    private static int[][] changeSparseArray(int[][] array){
        int sum = 0;
        for(int[] row : array){
            for (int item : row){
                if(item!=0){
                    sum++;
                }
            }
        }
        int sparseArray[][] = new int[sum+1][3];
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sum;
        int count=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=array[i][j];
                }
            }
        }
        return sparseArray;
    }

    private static int[][] restoreSparseArray(int [][] sparseArray){
        int [][] originArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
                originArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return originArray;
    }
}
