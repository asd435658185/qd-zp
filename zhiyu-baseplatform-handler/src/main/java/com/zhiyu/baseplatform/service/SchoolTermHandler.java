package com.zhiyu.baseplatform.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.entity.TermBaseInfoEntity;
import com.zhiyu.baseplatform.enumcode.SchoolTermState;

/**
 * 学校学期处理器
 * @author wdj
 *
 */
@Transactional
@Service
public class SchoolTermHandler {

	@Autowired
	private ITermBaseInfoService termService;
	
	/**
	 * 通过学校id获取当前学期对象信息
	 * @param schoolId
	 * @return
	 */
	public TermBaseInfoEntity getCurrentTermInfoBySchoolId(Integer schoolId){
		TermBaseInfoEntity term = new TermBaseInfoEntity();
		term.setSchoolId(schoolId);
		term.setState(SchoolTermState.CURRENT.getValue());
		List<TermBaseInfoEntity> terms = termService.findByEntity(term);
		if(terms!=null && !terms.isEmpty()){
			return terms.get(0);
		}
		return null;
	}
	
	public TermBaseInfoEntity findById(Integer termId){
		return termService.findObjectById(termId);
	}
	
	/**
	 * 通过学校id获取学校的学期信息列表
	 * @param schoolId
	 * @return
	 */
	public List<TermBaseInfoEntity> findBySchoolId(Integer schoolId){
		TermBaseInfoEntity term = new TermBaseInfoEntity();
		term.setSchoolId(schoolId);
		return termService.findByEntity(term);
	}
}
