package com.wagic.code.learn;

public class ArrayMinNum {

    /**
     * 关键点：
     * 1. 确保数组不会出现空指针或者长度为空
     * 2. 确保数组有序
     * 3. 考虑数组两个数字的情况
     * 4. 用二分查找法。 先考虑只有三个数字的情况
     * 旋转数组中的第一个数一定是大于最后一个数的，
     * 然后要找的最小的数一定是两个递增序列的分界线（此数的左边递增，右边也递增），
     * 利用二分查找的思想，设置三个指针分别指向数组的开始(begin)，结尾(end)，和中间（mid）
     * @param array
     * @return
     */
    public static int min(int[] array) {

        if (null == array || array.length == 0) {
            throw new RuntimeException("param error!!!");
        }

        int lo = 0;

        int hi = array.length - 1;

        int mi = lo;

        while (array[lo] >= array[hi]) {

            if (hi == lo + 1) {
                return array[hi];
            }

            // 取中间的位置
            mi = lo + (hi - lo) / 2;

            if (array[lo] == array[hi] && array[hi] == array[mi]) {
                return minInOrder(array, lo, hi);
            }

            if (array[mi] >= array[lo]) {
                lo = mi;
            } else if (array[mi] <= array[hi]) {
                hi = mi;
            }

        }

        return array[mi];

    }

    private static int minInOrder(int[] array, int lo, int hi) {
        int min = array[lo];
        for (int i = lo + 1; i <= hi - 1; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {

        // 典型输入，单调升序的数组的一个旋转
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println(min(array1));
        // 有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(min(array2));
        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(min(array3));
        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(min(array4));
        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(min(array5));
        // 数组中只有一个数字
        int[] array6 = {2};
        System.out.println(min(array6));
        // 数组中数字都相同
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(min(array7));
        System.out.println(min(array6));
        // 输入NULL
        System.out.println(min(null));
    }
}
