package com.meixiaojian.test.sort;

import java.util.Arrays;

import com.meixiaojian.sort.BubbleSort;
import com.meixiaojian.sort.BucketSort;
import com.meixiaojian.sort.CountSort;
import com.meixiaojian.sort.HeapSort;
import com.meixiaojian.sort.InsertSort;
import com.meixiaojian.sort.MergeSort;
import com.meixiaojian.sort.QuickSort;
import com.meixiaojian.sort.SelectSort;
import com.meixiaojian.sort.ShellSort;

public class TestSort {

	public static void main(String[] args) {
		testBubbleSort();//测试冒泡排序
		testSelectSort();//测试选择排序
		testInsertSort();//测试插入排序 
		testQuickSort();//测试快速排序 
		testQuickSortPlus();//测试快速排序-优化
		testHeapSort();//测试堆排序
		testShellSort();//测试希尔排序
		testMergeSort();//测试归并排序
		testCountSort();//测试计数排序
		testBucketSort();//测试计数桶排序
		testBucketSort2();//测试计数桶排序2
	}
	
	private static void testBucketSort2(){//测试计数桶排序2
		int arr[]={49,38,65,97,76,13,27,49};//{1,1,1,4,5};//{49,38,65,97,76,13,27,49};//{5,3,8,6,4};
		BucketSort sort = new BucketSort();
		int[] result = sort.bucketSort2(arr);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试计数桶排序结果2",result);
	}
	
	private static void testBucketSort(){//测试计数桶排序
		int arr[]={49,38,65,97,76,13,27,49};//{1,1,1,4,5};//{49,38,65,97,76,13,27,49};//{5,3,8,6,4};
		BucketSort sort = new BucketSort();
		int[] result = sort.doSort(arr);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试计数桶排序结果",result);
	}
	
	private static void testCountSort(){//测试计数排序
		int arr[]={49,38,65,97,76,13,27,49};//{1,1,1,4,5};//{49,38,65,97,76,13,27,49};//{5,3,8,6,4};
		CountSort sort = new CountSort();
		int[] result = sort.doSort(arr);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试计数排序结果",result);
	}
	
	private static void testMergeSort(){//测试归并排序
		int arr[]={49,38,65,97,76,13,27,49};//{5,3,8,6,4};
		MergeSort sort = new MergeSort();
		@SuppressWarnings("unused")
		int[] result = sort.doSort(arr);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试归并排序结果",arr);
	}
	
	private static void testShellSort(){//测试希尔排序
		int arr[]={49,38,65,97,76,13,27,49};//{5,3,8,6,4};
		ShellSort sort = new ShellSort();
		@SuppressWarnings("unused")
		int[] result = sort.doSort(arr);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试希尔排序结果",arr);
	}
	
	private static void testHeapSort(){//测试堆排序
		int arr[]={49,38,65,97,76,13,27,49};//{5,3,8,6,4};
		HeapSort sort = new HeapSort();
		@SuppressWarnings("unused")
		int[] result = sort.doSort(arr);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试堆排序结果",arr);
	}
	
	private static void testQuickSortPlus(){//测试快速排序-优化
		int arr[]={49,38,65,97,76,13,27,49};//{5,3,8,6,4};
		QuickSort sort = new QuickSort();
		@SuppressWarnings("unused")
		int[] result = sort.doSortPlus(arr,0,arr.length-1);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试快速排序-优化结果",arr);
	}
	
	private static void testQuickSort(){//测试快速排序 
		int arr[]={49,38,65,97,76,13,27,49};//{5,3,8,6,4};
		QuickSort sort = new QuickSort();
		@SuppressWarnings("unused")
		int[] result = sort.doSort(arr,0,arr.length-1);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试快速排序结果",arr);
	}
	
	private static void testInsertSort(){//测试插入排序 
		int arr[]={49,38,65,97,76,13,27,49};//{5,3,8,6,4};
		InsertSort sort = new InsertSort();
		@SuppressWarnings("unused")
		int[] result = sort.doSort(arr);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试插入排序结果",arr);
	}
	
	private static void testSelectSort(){//测试选择排序
		int arr[]={49,38,65,97,76,13,27,49};//{5,3,8,6,4};
		SelectSort sort = new SelectSort();
		@SuppressWarnings("unused")
		int[] result = sort.doSort(arr);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试选择排序结果",arr);
	}
	
	private static void testBubbleSort(){//测试冒泡排序
		int arr[]={49,38,65,97,76,13,27,49};//{5,3,8,6,4};
		BubbleSort sort = new BubbleSort();
		@SuppressWarnings("unused")
		int[] result = sort.doSort(arr);//java中类是指针传递，故此处arr的顺序也被调换
		printArr("测试冒泡排序结果",arr);
	}
	
	private static void printArr(String str,int[] arr){//打印结果
		if(arr == null){
			return;
		}
		System.out.println(Arrays.toString(arr)+"   "+str);
	}
}
