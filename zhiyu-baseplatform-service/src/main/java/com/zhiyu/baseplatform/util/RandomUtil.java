package com.zhiyu.baseplatform.util;

/**
 * 
 * @author wdj
 *
 */

public class RandomUtil {

	/**
	 * 随机指定范围内N个不重复的数 最简单最基本的方法
	 * 
	 * @param min
	 *            指定范围最小值
	 * @param max
	 *            指定范围最大值
	 * @param n
	 *            随机数个数
	 */
	public static int[] randomCommon(int min, int max, int n) {
		int[] result = new int[n];
		int count = 0;
		if(n==max){//判断相等的情况
			while(count<n){
				int num = count + min;
				result[count] = num;
				count++;
			}
			return result;
		}
		if (n > (max - min + 1) || max < min) {
			return null;
		}
		while (count < n) {
			int num = (int) (Math.random() * (max - min)) + min;
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if (num == result[j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result[count] = num;
				count++;
			}
		}
		return result;
	}

}
