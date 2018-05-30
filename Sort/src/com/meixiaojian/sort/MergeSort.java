package com.meixiaojian.sort;

/**
 * 归并排序   空间复杂度为O(n)，时间复杂度为O(nlogn)  稳定排序
 * 基本思路，将原数组拆分成左右两个子数组，在分别对最有两个子数组做相同拆分，指导拆分成最简数组为止
 * 对左右两个最简子数组进行排序、合并，然后是递归上一层的两个左右子数组做相同操作。
 * @author 梅小贱
 *
 */
public class MergeSort {

	public int[] doSort(int[] arr){
		int[] temp = new int[arr.length];//初始化一个临时数组，避免递归时候重复生成临时数组
		mergeSort(arr,0,arr.length-1,temp);
		return arr;
	}
	
	/**
	 * 递归调用，进行排序
	 * @param arr，待排序数组
	 * @param left，数组左起角标
	 * @param right，数组最后元素角标
	 * @param temp，临时数组，长度等于待排序数组
	 */
	private void mergeSort(int[] arr,int left,int right,int[] temp){
		if(left < right){
			int mid = (left + right) / 2;
			mergeSort(arr,left,mid,temp);//递归排序左边元素
			mergeSort(arr,mid+1,right,temp);//递归排序右边元素
			singleSort(arr,left,mid,right,temp);//排序并合并两个子数组
		}
	}
	
	private void singleSort(int[] arr,int left,int mid,int right,int[] temp){//单次排序，递归调用此方法进行排序
		int i = left;//左侧子数组的起始位置
		int j = mid + 1;//右侧子数组起始位置
		int tempIndex = 0;//临时变量数组的角标
		while(i<=mid && j<=right){
			if(arr[i] < arr[j]){//左侧子数组元素小于右侧子数组元素,将较小的元素填入临时数组
				temp[tempIndex++] = arr[i++];
			}else{
				temp[tempIndex++] = arr[j++];
			}
		}
		while(i<=mid && tempIndex<temp.length){//如果左侧字数组还有元素，剩余元素填入临时数组
			temp[tempIndex++] = arr[i++];
		}
		while(j<=right && tempIndex<temp.length){//如果右侧字数组还有元素，剩余元素填入临时数组
			temp[tempIndex++] = arr[j++];
		}
		//将临时数组中数据写回原数组
		tempIndex = 0;
		while(left <= right){
			arr[left++] = temp[tempIndex++];
		}
	}
}
