package com.meixiaojian.sort;

/**
 * 二分插入排序  
 * 最差时间复杂度 ---- O(n^2)
 * 最优时间复杂度 ---- O(nlogn)
 * 平均时间复杂度 ---- O(n^2)
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 稳定
 * 
 * 待插入元素跟已排序的序列中间数进行对比
 * 如果小于中间数，则再次跟中间数左边序列的中间数进行对比
 * 直到找到合适的插入位置
 * @author 梅小贱
 *
 */
public class InsertionSortDichotomy {

	public int[] doSort(int[] arr){
		if(arr==null || arr.length<1){
			return arr;
		}
		insertionSortDichotomy(arr);
		return arr;
	}
	
	private void insertionSortDichotomy(int[] arr){
		for (int i = 1; i<arr.length;i++ ) {
	        int get = arr[i];                    // 右手抓到一张扑克牌
	        int left = 0;                    // 拿在左手上的牌总是排序好的，所以可以用二分法
	        int right = i - 1;                // 手牌左右边界进行初始化
	        while (left <= right ) { // 采用二分法定位新牌的位置
	            int mid = (left + right) / 2;
	            if (arr[mid] > get)
	                right = mid - 1;
	            else
	                left = mid + 1;
	        }
	        for (int j = i - 1; j >= left; j--) {    // 将欲插入新牌位置右边的牌整体向右移动一个单位
	        	arr[j + 1] = arr[j];
	        }
	        arr[left] = get;                    // 将抓到的牌插入手牌
	    }
	}
}
