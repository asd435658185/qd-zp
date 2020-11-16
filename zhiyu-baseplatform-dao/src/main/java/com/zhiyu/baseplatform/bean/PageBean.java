package com.zhiyu.baseplatform.bean;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 分页组件
 * @author wdj
 *
 */

public class PageBean<T> {

	private int start;

	private int limit;

	private int pageNo;

	private int pageSize=200;//默认10条

	private List<T> items = Lists.newArrayList();

	private Integer totalNum;//总的记录数

	private Integer totalPage;//总的分页数

	private String typePrimaryKeyName = null;

	private boolean hasFirst = false;

	private boolean hasNext = false;

	public PageBean(int pageNo, String typePrimaryKeyName) {
		super();
		this.typePrimaryKeyName = typePrimaryKeyName;
		this.pageNo = pageNo;
		this.start = (pageNo-1)*pageSize;
		this.limit = pageSize;
	}

	public PageBean(int pageNo, int pageSize,String typePrimaryKeyName) {
		super();
		this.typePrimaryKeyName = typePrimaryKeyName;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.start = (pageNo-1)*pageSize;
		this.limit = pageSize;
	}

	public void processPageState(){

		if(totalNum>0){
			totalPage = totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
			if(totalPage==1){
				hasFirst = false;
				hasNext = false;
			}else{
				if(pageNo>1){
					hasFirst = true;
				}
				if(pageNo<totalPage){
					hasNext = true;
				}
			}
		}

	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		if(totalNum<limit){
			this.limit = totalNum;
		}
		this.totalNum = totalNum;
	}

	public String getTypePrimaryKeyName() {
		return typePrimaryKeyName;
	}

	public void setTypePrimaryKeyName(String typePrimaryKeyName) {
		this.typePrimaryKeyName = typePrimaryKeyName;
	}

	public boolean isHasFirst() {
		return hasFirst;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}



}
