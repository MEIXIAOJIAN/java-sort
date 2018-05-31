package com.meixiaojian.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 桶排序 
 * 当要被排序的数组内的数值是均匀分配的时候，桶排序使用线性时间 O(n)
 * 假定：输入是由一个随机过程产生的[0, 1)区间上均匀分布的实数。将区间[0, 1)划分为n个大小相等的子区间（桶），
 * 每桶大小1/n：[0, 1/n)， [1/n, 2/n)， [2/n, 3/n)，…，[k/n, (k+1)/n )，
 * …将n个输入元素分配到这些桶中，对桶中元素进行排序，
 * 然后依次连接桶输入0 ≤A[1..n] <1辅助数组B[0..n-1]是一指针数组，指向桶（链表）。
 * 
 * 将待排序数组的数字，按每个数字的对应位进行比较，从右至左依次比较至最后一个数字。
 * 例如{123，456}，先比较（3和6），再比较（2和5）。。。
 * 
 * 或者，按照某一个函数f，将待排序数组划分到若干个桶内，在分别对每一个桶进行排序，之后按桶的顺序输出即为排序结果
 * @author 梅小贱
 *
 */
public class BucketSort {

	public int[] doSort(int[] arr){
		if(arr==null || arr.length<=1){
			return arr;
		}
		bucketSort(arr);
		return arr;
	}
	
	//桶排序第一种方法，感觉像是基数排序   ，代码来自百度百科
	private void bucketSort(int[] arr){
		int n=arr.length;
		int[][] bask = new int[10][n];//初始化10个桶
		int[] index=new int[10];//初始化后，数组内元素均为0，记录每个同内下一个元素的角标
		int max = Integer.MIN_VALUE;//数组中最大数字的长度
		for(int i=0;i<n;i++)
		{//数组中最大数字的字符串长度
			max = max>(Integer.toString(arr[i]).length())?
					max:(Integer.toString(arr[i]).length());
		}
		String str;
		for(int i=max-1; i>=0; i--)
		{
			for(int j=0; j<n; j++)
			{
				str="";
				if(Integer.toString(arr[j]).length() < max)
				{//待排序元素长度短于最大数字的字符串长度，该元素前边补0
					for(int k=0;k<max-Integer.toString(arr[j]).length();k++)
						str+="0";
				}
				str += Integer.toString(arr[j]);//将待排序元素字符串长度补充到最大元素字符串长度
				//按照元素字符串最前边的数字进行划分桶，index数组记录该桶下一个元素角标
				bask[str.charAt(i)-'0'][index[str.charAt(i)-'0']++] = arr[j];
			}
			//将一次排序后的数列写回原数组
			int pos=0;
			for(int j=0; j<10; j++)
			{
				for(int k=0; k<index[j]; k++)
				{
					arr[pos++] = bask[j][k];
				}
			}
			//恢复角标索引为0
			for(int x=0; x<10; x++)
				index[x] = 0;
		}
	}
	
	//桶排序第二种方法
	public int[] bucketSort2(int[] arr) {
        if(arr == null || arr.length == 0)
            return arr;
        
        int bucketNums = 10; //这里默认为10，规定待排数[0,100)
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(); //桶的索引
        
        for(int i=0; i<bucketNums; i++) {
            buckets.add(new LinkedList<Integer>()); //用链表比较合适
        }
        
        //划分桶
        for(int i=0; i<arr.length; i++) {
            buckets.get(arr[i]/10).add(arr[i]);//函数f：arr[i]/10
        }
        
        //对每个桶进行排序
        for(int i=0; i<buckets.size(); i++) {
            if(!buckets.get(i).isEmpty()) {
                Collections.sort(buckets.get(i)); //对每个桶进行快排
            }
        }
        
        //还原排好序的数组
        int k = 0;
        for(List<Integer> bucket : buckets) {
            for(int ele : bucket) {
                arr[k++] = ele;
            }
        }
        return arr;
    }
}
