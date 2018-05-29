package com.meixiaojian.sort;
/**
 * 快速排序  时间复杂度是O(nlgn)
 * 设置头节点为标兵节点，由后向前找比标兵小的数，由前向后找比标兵大的数，交换
 * 重复之前操作，直到后面指针小于等于前边指针(此时应该只能左右指针相等)
 * 交换标兵和左指针指向的数据
 * 递归分别对左右两组数据做如上操作
 * 稳定性，它只表示两个值相同的元素在排序前后是否有位置变化。如果前后位置变化，则排序算法是不稳定的，否则是稳定的。
 * @author 梅小贱
 *
 */
public class QuickSort {

	public int[] quickSort(int arr[],int left,int right){
		if(arr==null || arr.length<=0 || left>=right){
			return arr;
		}
		int position = partition(arr,left,right);//排序依次，获取标兵位置
		quickSort(arr,left,position-1);//递归排序左边数列
		quickSort(arr,position+1,right);//递归排序右边数列
		return arr;
	}
	
	public int[] quickSortPlus(int arr[],int left,int right){//优化
		if(arr==null || arr.length<=0 || left>=right){
			return arr;
		}
		int position = partitionPlus(arr,left,right);//排序依次，获取标兵位置
		quickSort(arr,left,position-1);//递归排序左边数列
		quickSort(arr,position+1,right);//递归排序右边数列
		return arr;
	}
	
	private int partitionPlus(int[] arr,int left,int right){//完成一次快速排序-优化
		if(arr==null || arr.length<=0 || left>=right){
			return -1;
		}
		int markKey = arr[left];//标兵
		while(left < right){
			while(left < right && arr[right] >= markKey) right--;//从后往前找比标兵小的数
			if(left < right){
				arr[left] = arr[right];
				left++;
			}
			while(left < right && arr[left] <= markKey) left++;//从前往后找比标兵大的数
			if(left < right){
				arr[right] = arr[left];
				right--;
			}
		}
		arr[left] = markKey;
		return left;//将交换后标兵的位置返回，此时标兵左边比标兵小，标兵右边比标兵大
	}
	
	private int partition(int[] arr,int left,int right){//完成一次快速排序
		if(arr==null || arr.length<=0 || left>=right){
			return -1;
		}
		int markKey = arr[left];//标兵
		while(left < right){
			while(left < right && arr[right] >= markKey) right--;//从后往前找比标兵小的数
			if(left < right){//当左右指针相等时不在进行交换，两个指针指向同一个数据
				swap(arr,left,right);//交换两个数
				left++;
			}
			while(left < right && arr[left] <= markKey) left++;//从前往后找比标兵大的数
			if(left < right){//当左右指针相等时不在进行交换，两个指针指向同一个数据
				swap(arr,left,right);//交换两个数
				right--;
			}
		}
		return left;//将交换后标兵的位置返回，此时标兵左边比标兵小，标兵右边比标兵大
	}
	
	private void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
