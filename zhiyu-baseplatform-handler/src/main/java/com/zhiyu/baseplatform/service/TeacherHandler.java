package com.zhiyu.baseplatform.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.entity.TeacherBaseInfoEntity;

/**
 * 
 * @author wdj
 *
 */
@Service
public class TeacherHandler {

	@Autowired
	private ITeacherBaseInfoService teacherBaseInfoService;
	
	/**
	 * 带模糊查询的条件查询
	 * @param entity
	 * @return
	 */
	public List<TeacherBaseInfoEntity> findByEntityWithLike(TeacherBaseInfoEntity entity){
		StringBuffer sb = new StringBuffer();
		List<Object> params = Lists.newArrayList();
		if(StringUtils.isNotBlank(entity.getName())){
			sb.append(" and name like ?");
			params.add("%"+entity.getName()+"%");
		}
		return teacherBaseInfoService.findListByConditionWithNoPage(sb.toString(), params.toArray(), null);
	}
}
