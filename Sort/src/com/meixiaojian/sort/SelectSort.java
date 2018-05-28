package com.meixiaojian.sort;
/**
 * 选择排序  时间复杂度为O(n^2)
 * 从前向后遍历，每次找到最小的那个数，和待排序队列最前面数字进行交换
 * 待排序列中首个元素称为标兵
 * @author 梅小贱
 *
 */
public class SelectSort {

	public int[] selectSort(int[] arr){
		if(arr==null || arr.length<=1){
			return arr;
		}
		int minNumIndex = 0;
		for(int i=0;i<arr.length-1;i++){//只需要循环arr.length-1次，最后一个数字不需要进行任何交换了
			minNumIndex = i;//每次循环都将待排序列中首个元素当作最小元素
			for(int j=i+1;j<arr.length;j++){//需要遍历待排序列所有成员
				if(arr[j]<arr[minNumIndex]){//当前元素比当前最小元素大，交换
					minNumIndex = j;
				}
			}
			if(minNumIndex != i){//如果最小数不是标兵，进行交换
				swap(arr,i,minNumIndex);
			}
		}
		return arr;
	}
	
	private void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
