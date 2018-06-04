package com.meixiaojian.sort;

/**
 * 鸡尾酒排序(也叫定向冒泡排序)  冒泡排序的改进
 * 先从先向后找出最大的数，放在后面
 * 再从后往前找出最小的数，放在前面
 * @author 梅小贱
 *
 */
public class CocktailSort {

	public int[] doSort(int[] arr){
		if(arr==null || arr.length<1){
			return arr;
		}
		cocktailSort(arr);
		return arr;
	}
	
	private void cocktailSort(int arr[]) {
	    int left = 0;                            // 初始化边界
	    int right = arr.length - 1;
	    while (left <= right)
	    {
	        for (int i = left; i <right;i++) { // 前半轮,将最大元素放到后面
	            if (arr[i] > arr[i + 1]) {
	                swap(arr, i, i + 1);
	            }
	        }
	        right--;
	        for (int i = right; i > left; i--) {   // 后半轮,将最小元素放到前面
	            if (arr[i - 1] > arr[i]) {
	                swap(arr, i - 1, i);
	            }
	        }
	        left++;
	    }
	}
	
	private void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
