package com.zhiyu.baseplatform.enumcode;

/**
 * 学校学期状态
 * @author wdj
 *
 */
public enum SchoolTermState {

	CURRENT(1,"当前学期"),
	
	NOT_CURRENT(0, "非当前学期");

	/**
	 * 构造方法
	 *
	 * @param value
	 * @param name
	 */
	private SchoolTermState(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	private Integer value;//枚举的值

	private String name;

	// 获取枚举类
	public static SchoolTermState getType(Integer value) {
		for (SchoolTermState method : SchoolTermState.values()) {
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
