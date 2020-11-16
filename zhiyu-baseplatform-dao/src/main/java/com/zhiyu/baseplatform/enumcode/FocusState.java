package com.zhiyu.baseplatform.enumcode;

/**
 * 奖励方式
 * @author wdj
 *
 */
public enum FocusState {

	UNFOCUS(0,"未关注"),
	
	FOCUSED(1, "关注");

	/**
	 * 构造方法
	 *
	 * @param value
	 * @param name
	 */
	private FocusState(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	private Integer value;//枚举的值

	private String name;

	// 获取枚举类
	public static FocusState getType(Integer value) {
		for (FocusState method : FocusState.values()) {
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
