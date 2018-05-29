package com.meixiaojian.sort;

/**
 * 插入排序   时间复杂度也是O(n^2)
 * 直接从待排序列中拿出拿出一个数字，然后再已排序列中找到合适位置插入
 * 插入位置之后的元素向后移动一位
 * @author 梅小贱
 *
 */
public class InsertSort {

	public int[] doSort(int[] arr){
		if(arr==null || arr.length<=1){
			return arr;
		}
		//开始排序时，假定第一个元素已排入适当位置
		for(int i=1; i<arr.length; i++){//假设第一个元素排序正确
			int j = i;//记录已排序列的未角标
			int target = arr[i];//带插入的元素
			while(j>0 && target<arr[j-1]){//从已排序列最后一个元素向前便利，直到找到合适的位置为止
				arr[j] = arr[j-1];
				j--;
			}
			//j即为合适的位置，插入带插入元素
			arr[j] = target;
		}
		return arr;
	}
}
