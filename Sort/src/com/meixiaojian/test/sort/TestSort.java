package com.meixiaojian.test.sort;

import com.meixiaojian.sort.BubbleSort;
import com.meixiaojian.sort.InsertSort;
import com.meixiaojian.sort.SelectSort;

public class TestSort {

	public static void main(String[] args) {
		testBubbleSort();//测试冒泡排序
		testSelectSort();//测试选择排序
		testInsertSort();//测试插入排序 
	}
	
	private static void testInsertSort(){//测试插入排序 
		int arr[]={5,3,8,6,4};
		InsertSort insertSort = new InsertSort();
		@SuppressWarnings("unused")
		int[] result = insertSort.insertSort(arr);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试插入排序结果：",arr);
	}
	
	private static void testSelectSort(){//测试选择排序
		int arr[]={5,3,8,6,4};
		SelectSort selectSort = new SelectSort();
		@SuppressWarnings("unused")
		int[] result = selectSort.selectSort(arr);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试选择排序结果：",arr);
	}
	
	private static void testBubbleSort(){//测试冒泡排序
		int arr[]={5,3,8,6,4};
		BubbleSort bubbleSort = new BubbleSort();
		@SuppressWarnings("unused")
		int[] result = bubbleSort.bubbleSort(arr);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试冒泡排序结果：",arr);
	}
	
	private static void printArr(String str,int[] arr){//打印结果
		if(arr == null){
			return;
		}
		if(str != null){
			System.out.println(str);
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			if(i<arr.length-1){
				System.out.print(",");
			}
		}
		System.out.println();
	}
}