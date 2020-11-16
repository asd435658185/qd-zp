package com.zhiyu.baseplatform.enumcode;

/**
 * 权限优先级
 * @author wdj
 *
 */
public enum AccessPrivilidgeType {

	SUPER(1,"平台超级管理员"),
	
	SCHOOL_MANAGE(2, "学校管理员");

	/**
	 * 构造方法
	 *
	 * @param value
	 * @param name
	 */
	private AccessPrivilidgeType(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	private Integer value;//枚举的值

	private String name;

	// 获取枚举类
	public static AccessPrivilidgeType getType(Integer value) {
		for (AccessPrivilidgeType method : AccessPrivilidgeType.values()) {
			if (method.getValue() == value) {
				return method;
			}
		}
		return null;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value 要设置的value
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的name
	 */
	public void setName(String name) {
		this.name = name;
	}//显示值

}
