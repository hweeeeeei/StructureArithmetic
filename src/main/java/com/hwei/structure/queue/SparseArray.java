package com.hwei.structure.queue;

/**
 * 稀疏数组
 * 解决五子棋盘问题
 */
public class SparseArray {
    public static void main(String[] args) {

        //1.创建一个稀疏数组的原始的二维数组  11*11的棋盘
        // 0表示满意旗子,1表示黑子, 2表示篮色子
        int[][] chessArr1 = new int[11][11];

        // 声明棋子位置
        chessArr1[0][2] = 1;
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[2][5] = 1;
        chessArr1[10][5] = 2;

        // 遍历行
        for (int[] arr : chessArr1) {

            // 遍历列
            for (int num : arr) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }

        // ---  转成为稀疏数组

        // 1.先遍历原始数组的非0数据, 统计非0数据的个数
        int sum = 0;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("不为0的个数:" + sum);

        // 2. 创建一个稀疏数组
        // 行数等于非0元素个数+1
        int[][] sparseArray = new int[sum + 1][3];
        // 给稀疏数组赋值,
        // 第1行1列数据为长度
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        // 稀疏数组行号
        int row = 1;

        // 遍历原始数组 找到非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {

                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = chessArr1[i][j];
                    row++;
                }
            }
        }

        // 遍历稀疏数组
        System.out.println("遍历稀疏数组");
        // 遍历行
        for (int[] arr : sparseArray) {
            // 遍历列
            for (int num : arr) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }

        // -----稀疏数组转化成原始二维数组
        int[][] toArr = new int[sparseArray[0][0]][sparseArray[0][1]];

        // 遍历稀疏数组
        for (int i = 1; i < sparseArray.length; i++) {
            toArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }


        System.out.println("原始二维数组");
        for (int[] arr : toArr) {
            for (int num : arr) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }

    }
}
