package com.meixiaojian.sort;

/**
 * 希尔排序(缩小增量排序)  时间复杂度为O(n^2){如果待排序列是正序时，时间复杂度是O(n)} -----不稳定排序
 * 如果序列是基本有序的，使用直接插入排序效率就非常高。
 * 先将整个待排记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录基本有序时再对全体记录进行一次直接插入排序。
 * @author 梅小贱
 *
 */
public class ShellSort {

	public int[] doSort(int[] arr){
		if(arr==null || arr.length<=1){
			return arr;
		}
		shellSort(arr);
		return arr;
	}
	
	private void shellSort(int[] arr){
		//步长，初始为arr的一半长度，每次缩小到gap的一半
		for(int gap=arr.length/2; gap>0; gap/=2){
			for(int i=gap; i<arr.length;i++){//从gap开始，逐个对其所在的组进行插入排序
				int temp = arr[i];//记录带插入数字
				int j = i;
				//对组从后往前进行查询，直到找到待插入数字的适当位置
				while(j-gap>=0 && temp<arr[j-gap]){//将小的数字前移
					arr[j] = arr[j-gap];
					j-=gap;//指针指向该组的前一个元素
				}
				arr[j] = temp;//找到合适的位置，插入待插入数字
			}
		}
	}
}
