package com.meixiaojian.sort;
/**
 * 堆排序 O(nlogn) 不稳定的排序方法
 *　a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
 *　b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 *　c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
 * @author 梅小贱
 *
 */
public class HeapSort {

	public int[] doSort(int[] arr){
		
		//1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从数组的最右边元素至最左变元素调整结构成大顶堆，即从数组最后一个元素开始构建大顶堆
            adjustHeap(arr,i,arr.length);
        }
        //此时，0地址下是数列中最大的数字，后面符合大顶堆排列
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换，即将最大数字调整到队列最后
            adjustHeap(arr,0,j);//重新对堆进行调整，对剩余的元素进行大顶堆调整
        }
		
		return arr;
	}
	
    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param start
     * @param end，数组的长度，防止数组越界和循环的终止条件
     */
    private void adjustHeap(int[] arr,int start,int end){
    	int temp = arr[start];//先取出当前元素
    	for(int i=start*2+1; i<end; i*=2){//从选取的左子结点开始，也就是2*start+1处开始
    		//左右孩子分别为2*i+1，2*i+1
    		if(i+1<end && arr[i]<arr[i+1]){//如果左子结点小于右子结点，i指向右子结点,选出左右孩子较大的一个
    			i++;
    		}
    		if(arr[i] > temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
    			arr[start] = arr[i];
    			start = i;//新的一轮筛选
    		}else{//已经成为大顶堆，终止循环
    			break;
    		}
    	}
    	arr[start] = temp;//将选取的元素插入适当位置
    }
    
    private void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
