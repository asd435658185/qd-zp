package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.zhiyu.baseplatform.dao.ISmileAngelDao;
import com.zhiyu.baseplatform.entity.SmileAngelEntity;
import com.zhiyu.baseplatform.service.ISmileAngelService;
import com.zhiyu.baseplatform.util.RandomUtil;

/**
 * 
 * @author wdj
 *
 */
@Service
public class SmileAngelService implements ISmileAngelService {

	@Autowired
	private ISmileAngelDao dao;
	
	@SuppressWarnings("unchecked")
	public List<SmileAngelEntity> findRandomList(Integer schoolId,Integer size){
		Integer totalAngelsCount = dao.getCount("id", " and schoolId=? ", new Object[]{schoolId});
		if(totalAngelsCount==0 || totalAngelsCount<size){
			SmileAngelEntity e = new SmileAngelEntity();
			e.setSchoolId(schoolId);
			try {
				return dao.findByEntity(e);
			} catch (Exception e1) {
				
			}
		}
		int[] randoms = RandomUtil.randomCommon(1, totalAngelsCount, size);
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for(int i=0;i<size;i++){
			if(i<size-1){
				sb.append(randoms[i]).append(",");
			}else{
				sb.append(randoms[i]).append(")");
			}
		}
		String sql = "SELECT * FROM  smile_angel_info  where school_id="+schoolId+" and sort_value in "+sb.toString();
		List<SmileAngelEntity> angels = Lists.newArrayList();
		List<Map<String, Object>> results = dao.findBySQL(sql);
		for(Map<String, Object> map:results){
			SmileAngelEntity angel = new SmileAngelEntity();
			angel.setId(Long.valueOf(map.get("id").toString()));
			angel.setSchoolId(Integer.valueOf(map.get("school_id").toString()));
			angel.setStudentId(Integer.valueOf(map.get("student_id").toString()));
			angel.setSortValue(Integer.valueOf(map.get("sort_value").toString()));
			angels.add(angel);
		}
		return angels;
	}

	public List<SmileAngelEntity> findByEntity(SmileAngelEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void save(SmileAngelEntity entity){
		dao.save(entity);
	}
}
