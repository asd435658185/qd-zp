package com.zhiyu.baseplatform.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyu.baseplatform.dao.ISchoolNoticeDao;
import com.zhiyu.baseplatform.bean.PageBean;
import com.zhiyu.baseplatform.entity.SchoolNoticeEntity;
import com.zhiyu.baseplatform.service.ISchoolNoticeService;
/**
 *
 * @author csk
 *
 */
@Service
public class SchoolNoticeServiceImpl implements ISchoolNoticeService{

	@Autowired
	private ISchoolNoticeDao dao;

	public SchoolNoticeEntity findObjectById(Integer id) {
		SchoolNoticeEntity entity = dao.findObjectById(id);
		if(entity!=null){
			dao.evict(entity);
		}
		return entity;
	}

	public List<SchoolNoticeEntity> findByEntity(SchoolNoticeEntity entity) {
		try {
			return dao.findByEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SchoolNoticeEntity> findAll() {
		return dao.findAll();
	}

	public void update(SchoolNoticeEntity entity) {
		dao.update(entity);
	}

	public void save(SchoolNoticeEntity entity) {
		dao.save(entity);
	}

	public void del(Integer schoolNoticeId) {
		dao.deleteObjectByIds(schoolNoticeId);
	}

	public List<SchoolNoticeEntity> findListByConditionWithNoPage(String condition, Object[] params,
			Map<String, String> orderby) {
		return dao.findListByConditionWithNoPage(condition, params, orderby);
	}

	public PageBean<SchoolNoticeEntity> findPage(String condition, Object[] params, PageBean<SchoolNoticeEntity> page,
			Map<String, String> orderby) {
		return dao.findPage(condition, params, page, orderby);
	}

	public PageBean<SchoolNoticeEntity> findPageByEntity(SchoolNoticeEntity entity, PageBean<SchoolNoticeEntity> page)
			throws Exception {
		return dao.findPageByEntity(entity, page);
	}

	/**
	 * 根据分页条件获取信息
	 * @param entity
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public PageBean<SchoolNoticeEntity> findPageByEntityWithSort(SchoolNoticeEntity entity,PageBean<SchoolNoticeEntity> page,Map<String, String> sortMap) throws Exception {
		return dao.findPageByEntityWithSort(entity, page, sortMap);
	}

}
