package com.meixiaojian.sort;

/**
 * 冒泡排序 时间复杂度为O(n^2)
 * 从数组最后一个数字开始往前找，与自己前面的数字进行比较，如果前面数字比自己大，交换。
 * 每次循环都将待排序列中最小数字提取到前面
 * @author 梅小贱
 *
 */
public class BubbleSort {

	public int[] doSort(int[] arr){//java中类是指针传递，故此处不设置返回值亦可，但由于需要执行成功状态，故写个返回值
		if(arr==null || arr.length<=1){
			return arr;
		}
		for(int i=0;i<arr.length-1;i++){//无需遍历最后一个数字
			for(int j=arr.length-1;j>i;j--){
				if(arr[j] < arr[j-1]){//后面的数组比前面的数字小，进行交换
					swap(arr,j-1,j);
				}
			}
		}
		return arr;
	}
	
	private void swap(int[] arr,int i,int j){//交换两个数字
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
