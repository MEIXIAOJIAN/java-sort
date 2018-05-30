package com.meixiaojian.sort;

/**
 * 计数排序  稳定排序
 * 计数排序对输入的数据有附加的限制条件：
 * 1、输入的线性表的元素属于有限偏序集S；
 * 2、设输入的线性表的长度为n，|S|=k（表示集合S中元素的总数目为k），则k=O(n)。
 * 在这两个条件下，计数排序的复杂性为O(n)。
 * 
 * 
 * 假设输入的线性表L的长度为n，L=L1,L2,..,Ln；线性表的元素属于有限偏序集S，|S|=k且k=O(n)，S={S1,S2,..Sk}；则计数排序可以描述如下：
 * 1、扫描整个集合S，对每一个Si∈S，找到在线性表L中小于等于Si的元素的个数T(Si)；
 * 2、扫描整个线性表L，对L中的每一个元素Li，将Li放在输出线性表的第T(Li)个位置上，并将T(Li)减1。
 * 
 * 初始化一个数组(c)，数组大小为待排序数组中的最大值
 * 循环待排序数组，以待排序数组中元素为角标，将c数组中的元素加1，
 * 从前向后累加c数组中元素，则c中元素大小即为c数组角标对应的待排序数组中元素的先后位置
 * c数组中，角标在待排序列中不存在的元素，则无用
 * 
 * @author 梅小贱
 *
 */
public class CountSort {

	public int[] doSort(int[] arr){
		int[] result = countSort(arr);
		return result;
	}
	
	public int[] countSort(int[] arr){
        int[] b = new int[arr.length];
        int max = arr[0],min = arr[0];
        for(int i:arr){//待排序数组中，最大最小值
            if(i>max){
                max=i;
            }
            if(i<min){
                min=i;
            }
        }
        int k=max-min+1;//这里k的大小是要排序的数组中，元素大小的极值差+1
        int[] c=new int[k];
        
        for(int i=0;i<arr.length;i++){//待拍序列中存在的元素对应的c数组位置的元素加1
            c[arr[i]-min]++;//优化过的地方，减小了数组c的大小
        }
        for(int i=1;i<c.length;i++){//从前向后累加c数组，累加结果即为该元素角标在原数组中的排序顺序
            c[i]=c[i]+c[i-1];
        }
        for(int i=arr.length-1;i>=0;i--){
        	//arr[i]-min 待排数组元素在c中角标
        	//--c[arr[i]-min],此处c数组中元素需要先进行--，角标从0开始。
        	//c中元素大于1，说明该数组有多个，此处减1，方便之后的相同元素寻找排序后位置
            b[--c[arr[i]-min]]=arr[i];//按存取的方式取出c的元素
        }
        return b;
    }
}
