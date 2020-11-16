package com.zhiyu.baseplatform.bean;

import java.util.Comparator;

import com.zhiyu.baseplatform.entity.ClassLessionDetailEntity;

/**
 * 
 * @author wdj
 *
 */

public class ClassLessonDetailComparatorBean implements Comparator<ClassLessionDetailEntity>{

	public int compare(ClassLessionDetailEntity o1, ClassLessionDetailEntity o2) {
		Integer code1 = (Integer) o1.getCode();
		Integer code2 = (Integer) o2.getCode();
		return code1 - code2;
	}

}
