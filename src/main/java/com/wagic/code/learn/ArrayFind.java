package com.wagic.code.learn;


/**
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下的顺序排序。
 *  完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否包含该整数;
 */
public class ArrayFind {

    public static boolean find(int arr[][], int keyNumber) {

        //从二维数组的右上角开始选取与keyNumber比较的整数
        // column 变化： arr[0].length-1 --> 0;
        // row 变化： 0 --> arr.length;
        int column = arr[0].length - 1;
        int row = 0;

        while (column >= 0 && row < arr.length) {
            if (arr[row][column] == keyNumber) {
                return true;
            } else if (arr[row][column] >= keyNumber) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    //测试find函数
    public static void main(String[] args) {
        /*
         * 1  2  8  9
         * 2  4  9  12
         * 4  7  10 13
         * 6  8  11 15
         */
        int array[][]=new int[4][4];
        array[0][0]=1;
        array[0][1]=2;
        array[0][2]=8;
        array[0][3]=9;
        array[1][0]=2;
        array[1][1]=4;
        array[1][2]=9;
        array[1][3]=12;
        array[2][0]=4;
        array[2][1]=7;
        array[2][2]=10;
        array[2][3]=13;
        array[3][0]=6;
        array[3][1]=8;
        array[3][2]=11;
        array[3][3]=15;
        long start = System.currentTimeMillis();
        System.out.println(find(array, 7));
//        System.out.println(find(array, 5));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
