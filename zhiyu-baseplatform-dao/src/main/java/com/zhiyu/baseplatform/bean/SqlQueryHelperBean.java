package com.zhiyu.baseplatform.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;

/**
 * 
 * @author wdj
 *
 */

public class SqlQueryHelperBean {

	private StringBuffer conditionStr = new StringBuffer(" and 1=1 ");//要拼接的条件语句
	
	private List<Object> params = Lists.newArrayList();//参数
	
	public SqlQueryHelperBean(Map<String, Object> fieldAndValueMap){
		Set<String> keys = fieldAndValueMap.keySet();
		for (String key : keys) {
			conditionStr.append(" and ").append(key).append("=? ");
			params.add(fieldAndValueMap.get(key));
		}
	}

	public StringBuffer getConditionStr() {
		return conditionStr;
	}

	public void setConditionStr(StringBuffer conditionStr) {
		this.conditionStr = conditionStr;
	}

	public List<Object> getParams() {
		return params;
	}

	public void setParams(List<Object> params) {
		this.params = params;
	}
	
	
}
