package com.meixiaojian.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 基数排序 
 * 将待排序数组的数字，按每个数字的对应位进行比较，从右至左依次比较至最后一个数字。
 * 例如{123，456}，先比较（3和6），再比较（2和5）。。。
 * @author 梅小贱
 *
 */
public class RadixSort {

	public int[] doSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return arr;
        int maxBit = getMaxBit(arr);
        for(int i=1; i<=maxBit; i++) {
	        List<List<Integer>> buf = distribute(arr, i); //分配
	        collecte(arr, buf); //收集
        }
        return arr;
    }
    
    /**
     * 分配
     * @param arr 待分配数组
     * @param iBit 要分配第几位
     * @return
     */
    public List<List<Integer>> distribute(int[] arr, int iBit) {
        List<List<Integer>> buf = new ArrayList<List<Integer>>();
        for(int j=0; j<10; j++) {
            buf.add(new LinkedList<Integer>());
        }
        for(int i=0; i<arr.length; i++) {
            buf.get(getNBit(arr[i], iBit)).add(arr[i]);
        }
        return buf;
    }
    
    /**
     * 收集
     * @param arr 把分配的数据收集到arr中
     * @param buf 
     */
    public void collecte(int[] arr, List<List<Integer>> buf) {
        int k = 0;
        for(List<Integer> bucket : buf) {
            for(int ele : bucket) {
                arr[k++] = ele;
            }
        }
    }
    
    /**
     * 获取最大位数
     * @param x
     * @return
     */
    public int getMaxBit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int ele : arr) {
            int len = (ele+"").length();
            if(len > max)
                max = len;
        }
        return max;
    }
    
    /**
     * 获取x的第n位，如果没有则为0.
     * @param x
     * @param n
     * @return
     */
    public int getNBit(int x, int n) {
        String sx = x + "";
        if(sx.length() < n)
            return 0;
        else
            return sx.charAt(sx.length()-n) - '0';
    }
    
    
    //以下方法来自百度百科
    public int[] radixSort2(int[] number, int d) { //d表示最大的数有多少位
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][] temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[] order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while(m <= d){
            for(int i = 0; i < number.length; i++) {
                int lsd = ((number[i] / n) % 10);//依次求取个位、十位、百位。。。的数字
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for(int i = 0; i < 10; i++) {//将排序一次后的元素写回待排序数组
                if(order[i] != 0) {
                    for(int j = 0; j < order[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
        return number;
    }
}
