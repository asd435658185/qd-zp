package com.zhiyu.baseplatform.enumcode;

/**
 * 学校学期状态
 * @author wdj
 *
 */
public enum LessionType {

	FIRST(1,"第一节"),
	
	TWO(2,"第二节"),
	
	THREE(3,"第三节"),
	
	FOUR(4,"第四节"),
	
	FIVE(5,"第五节"),
	
	SIX(6,"第六节"),
	
	SEVEN(7,"第七节"),
	
	EIGHT(8,"第八节"),
	
	NINE(9,"第九节"),
	
	TEN(10,"第十节");

	/**
	 * 构造方法
	 *
	 * @param value
	 * @param name
	 */
	private LessionType(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	private Integer value;//枚举的值

	private String name;

	// 获取枚举类
	public static LessionType getType(Integer value) {
		for (LessionType method : LessionType.values()) {
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
